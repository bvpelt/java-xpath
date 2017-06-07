package nl.bsoft;

import com.jcabi.xml.XMLDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.*;

import javax.xml.xpath.*;
import java.util.HashMap;

/**
 * Created by bvpelt on 6/2/17.
 */
public class Filter {
    private final Logger log = LoggerFactory.getLogger(Filter.class);

    private final String WOZNamespace = "http://www.waarderingskamer.nl/StUF/0312";
    private final String StUFNamespace = "http://www.egem.nl/StUF/StUF0301";
    private final String BGNamespace = "http://www.egem.nl/StUF/sector/bg/0310";
    private final String xsiNamespace = "http://www.w3.org/2001/XMLSchema-instance";

    private HashMap<String, String> prefMap = new HashMap<String, String>() {{
        put("WOZ", WOZNamespace);
        put("StUF", StUFNamespace);
        put("BG", BGNamespace);
        put("xsi", xsiNamespace);
    }};

    private MyNamespaceContext namespaces = new MyNamespaceContext(prefMap);

    public Filter() {

    }

    Document filterDocument(Document doc, String[] roles) {
        Document newdoc = null;

        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        final String ex01 = "//WOZ:*[@StUF:entiteittype=\"SWO\"]//WOZ:ligtIn";
        final String ex02 = "//WOZ:object[@StUF:entiteittype=\"WOZ\"]";
        final String ex03 = "//WOZ:object[@StUF:entiteittype=\"SWO\"]"; // test
        final String ex04 = "//WOZ:object[@StUF:entiteittype=\"WOZ\"]/WOZ:bevatKadastraleObjecten";

        final String ex10 = "//WOZ:heeftBelanghebbende//WOZ:avr.aard";
        final String ex20 = "//WOZ:*[@StUF:entiteittype=\"SWO\"]";
        final String ex30 = "//WOZ:object[@StUF:entiteittype=\"WRD\"]";

        XPathExpression expr = null;
        NodeList nodes = null;

        try {
            log.info("Evaluate expression: {}", ex04);
            xpath.setNamespaceContext(namespaces);
            expr = xpath.compile(ex04);

            nodes = (NodeList) expr.evaluate(doc.getDocumentElement(), XPathConstants.NODESET);
            int nlen = nodes.getLength();
            if (nlen > 0) {
                log.info("Proces expression: {} found {} elements", ex04, nlen);
                checkWozEntWozKadobjects(doc, nodes);
            }

            log.info("Evaluate expression: {}", ex10);
            xpath.reset();
            xpath.setNamespaceContext(namespaces);
            expr = xpath.compile(ex10);

            nodes = (NodeList) expr.evaluate(doc.getDocumentElement(), XPathConstants.NODESET);
            nlen = nodes.getLength();
            if (nlen > 0) {
                log.info("Proces expression: {} found {} elements", ex10, nlen);
                checkWozBelangHebbendeAard(doc, nodes);
            }

            log.info("Evaluate expression: {}", ex20);
            xpath.reset();
            xpath.setNamespaceContext(namespaces);
            expr = xpath.compile(ex20);

            nodes = (NodeList) expr.evaluate(doc.getDocumentElement(), XPathConstants.NODESET);
            nlen = nodes.getLength();
            if (nlen > 0) {
                log.info("Proces expression: {} found {} elements", ex20, nlen);
                checkWozSWO(doc, nodes);
            }

            log.info("Evaluate expression: {}", ex30);
            xpath.reset();
            xpath.setNamespaceContext(namespaces);
            expr = xpath.compile(ex30);

            nodes = (NodeList) expr.evaluate(doc.getDocumentElement(), XPathConstants.NODESET);
            nlen = nodes.getLength();
            if (nlen > 0) {
                log.info("Proces expression: {} found {} elements", ex30, nlen);
                checkWozWRD(doc, nodes);
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return newdoc;
    }

    private void checkWozEntSwoNodes(NodeList nodes) {
        final String ex01 = "//stuf:tijdstipRegistratie";
        final String ex02 = "//woz:inOnderzoek";
        final String ex03 = "/stuf:tijdvakGeldigheid//stuf:beginGeldigheid";
        final String ex04 = "/stuf:tijdvakGeldigheid//stuf:eindGeldigheid";

        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr = null;
        NodeList curNodes = null;

        try {
            expr = xpath.compile(ex01);
            for (int i = 0; i < nodes.getLength(); i++) {
                Node n = nodes.item(i);
                curNodes = (NodeList) expr.evaluate(n, XPathConstants.NODESET);
            }

            expr = xpath.compile(ex02);
            for (int i = 0; i < nodes.getLength(); i++) {
                Node n = nodes.item(i);
                curNodes = (NodeList) expr.evaluate(n, XPathConstants.NODESET);
            }

            expr = xpath.compile(ex03);
            for (int i = 0; i < nodes.getLength(); i++) {
                Node n = nodes.item(i);
                curNodes = (NodeList) expr.evaluate(n, XPathConstants.NODESET);
            }

            expr = xpath.compile(ex04);
            for (int i = 0; i < nodes.getLength(); i++) {
                Node n = nodes.item(i);
                curNodes = (NodeList) expr.evaluate(n, XPathConstants.NODESET);
            }
        } catch (XPathExpressionException e) {
            log.error("Error during XPath expression", e);
        }
    }

    private void checkWozEntWoz(Document doc, NodeList nodes) {

        final String ex01 = "//woz:bevatKadastraleObjecten";
        final String ex02 = "//woz:codeGebouwdOngebouwd";
        final String ex03 = "//woz:grondoppervlakte";
        final String ex04 = "//woz:heeftSluimerendObject";
        final String ex05 = "//woz:meegetaxeerdeOppervlakteGebouwd";

        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr = null;
        NodeList curNodes = null;

        try {
            expr = xpath.compile(ex01);
            for (int i = 0; i < nodes.getLength(); i++) {
                Node n = nodes.item(i);
                curNodes = (NodeList) expr.evaluate(n, XPathConstants.NODESET);
                int j = curNodes.getLength();
                log.info("Found number nodes: {}", j);
                checkWozEntWozKadobjects(doc, curNodes);
            }

            expr = xpath.compile(ex02);
            for (int i = 0; i < nodes.getLength(); i++) {
                Node n = nodes.item(i);
                curNodes = (NodeList) expr.evaluate(n, XPathConstants.NODESET);
                for (int j = 0; j < nodes.getLength(); j++) {
                    Node m = nodes.item(j);
                    log.info("Node: {} value: {}", m.getNodeName(), m.getNodeValue());
                }
            }

            expr = xpath.compile(ex03);
            for (int i = 0; i < nodes.getLength(); i++) {
                Node n = nodes.item(i);
                curNodes = (NodeList) expr.evaluate(n, XPathConstants.NODESET);
            }

            expr = xpath.compile(ex04);
            for (int i = 0; i < nodes.getLength(); i++) {
                Node n = nodes.item(i);
                curNodes = (NodeList) expr.evaluate(n, XPathConstants.NODESET);
            }

            expr = xpath.compile(ex05);
            for (int i = 0; i < nodes.getLength(); i++) {
                Node n = nodes.item(i);
                curNodes = (NodeList) expr.evaluate(n, XPathConstants.NODESET);
            }

        } catch (XPathExpressionException e) {
            log.error("Error during XPath expression", e);
        }
    }

    private void checkWozEntWozKadobjectsNode(Document doc, Node node, String xpathExpression) {
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr = null;
        NodeList curNodes = null;

        try {
            xpath.setNamespaceContext(namespaces);
            expr = xpath.compile(xpathExpression);
            log.info("Evaluating: {}", xpathExpression);
            curNodes = (NodeList) expr.evaluate(node, XPathConstants.NODESET);
            int nlen = curNodes.getLength();
            log.info("-- 01 expressie: {}, Number of nodes to proces: {}", xpathExpression, nlen);
            for (int j = 0; j < nlen; j++) {
                Node n1 = curNodes.item(j);

                if (null != n1) {
                    String nodeContent1 = new XMLDocument(n1).toString();
                    log.info("-- 01 before change current sub node n[{}]: \n{}", j, nodeContent1);
                    // clear node content
                    Node child = n1.getFirstChild();
                    if (child != null) {
                        child.setTextContent("");
                    }
                    // add node attributes StUF:noValue="geenWaarde" xsi:nil="true"
                    Attr noval = doc.createAttributeNS(
                            StUFNamespace, "noValue");
                    noval.setPrefix("StUF");
                    noval.setNodeValue("geenWaarde");
                    ((Element) n1).setAttributeNode(noval);

                    Attr nillval = doc.createAttributeNS(
                            xsiNamespace, "nil");
                    nillval.setPrefix("xsi");
                    nillval.setNodeValue("true");
                    ((Element) n1).setAttributeNode(nillval);

                    String nodeContent2 = new XMLDocument(n1).toString();
                    log.info("-- 01 after  change current sub node n[{}]: \n{}", j, nodeContent2);
                }
            }
        } catch (XPathExpressionException e) {
            log.error("Error during XPath expression", e);
        }
    }

    private void checkWozEntWozKadobjects(Document doc, NodeList nodes) {

        final String ex01 = "StUF:tijdstipRegistratie";
        final String ex02 = "//WOZ:inOnderzoek";
        final String ex03 = "//WOZ:meegetaxeerdeOppervlakte";
        final String ex04 = "//WOZ:toegekendeOppervlakte";
        final String ex05 = "/StUF:tijdvakGeldigheid//StUF:beginGeldigheid";
        final String ex06 = "/StUF:tijdvakGeldigheid//StUF:eindGeldigheid";

        int nlen = nodes.getLength();
        log.info("Number of nodes to proces: {}", nlen);

        // for each node in the list
        for (int i = 0; i < nlen; i++) {
            Node n = nodes.item(i);
            checkWozEntWozKadobjectsNode(doc, n, ex01);
            checkWozEntWozKadobjectsNode(doc, n, ex02);
            checkWozEntWozKadobjectsNode(doc, n, ex03);
            checkWozEntWozKadobjectsNode(doc, n, ex04);
            checkWozEntWozKadobjectsNode(doc, n, ex05);
            checkWozEntWozKadobjectsNode(doc, n, ex06);
        }
    }

    private void checkWozWRD(Document doc, NodeList nodes) {
        int nlen = nodes.getLength();
        log.info("-- 30 Number of nodes to proces: {}", nlen);
        for (int j = 0; j < nlen; j++) {
            Node n1 = nodes.item(j);
            String nodeContent1 = new XMLDocument(n1).toString();
            log.info("-- 01 current sub node n[{}]: \n{}", j, nodeContent1);
        }
    }

    private void checkWozSWO(Document doc, NodeList nodes) {
        int nlen = nodes.getLength();
        log.info("-- 20 Number of nodes to proces: {}", nlen);
        for (int j = 0; j < nlen; j++) {
            Node n1 = nodes.item(j);
            String nodeContent1 = new XMLDocument(n1).toString();
            log.info("-- 01 current sub node n[{}]: \n{}", j, nodeContent1);
        }
    }

    private void checkWozBelangHebbendeAard(Document doc, NodeList nodes) {

            int nlen = nodes.getLength();
            log.info("-- 01 Number of nodes to proces: {}", nlen);
            for (int j = 0; j < nlen; j++) {
                Node n1 = nodes.item(j);

                String nodeContent1 = new XMLDocument(n1).toString();
                log.info("-- 01 current sub node n[{}]: \n{}", j, nodeContent1);

                if (null != n1) {
                    // clear node content
                    Node child = n1.getFirstChild();
                    if (child != null) {
                        child.setTextContent("");
                    }
                    // add node attributes StUF:noValue="geenWaarde" xsi:nil="true"
                    Attr noval = doc.createAttributeNS(
                            StUFNamespace, "noValue");
                    noval.setPrefix("StUF");
                    noval.setNodeValue("geenWaarde");
                    ((Element) n1).setAttributeNode(noval);

                    Attr nillval = doc.createAttributeNS(
                            xsiNamespace, "nil");
                    nillval.setPrefix("xsi");
                    nillval.setNodeValue("true");
                    ((Element) n1).setAttributeNode(nillval);

                    String nodeContent2 = new XMLDocument(n1).toString();
                    log.info("-- 01 current sub node n[{}]: \n{}", j, nodeContent2);
                }
            }

    }

    Document filterTestDocument(Document doc, String[] roles) {
        Document newdoc = null;

        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        final String ex01 = "/Employees/Employee[gender='Female']";

        XPathExpression expr = null;
        NodeList nodes = null;

        try {
            expr = xpath.compile(ex01);
            nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            if (nodes.getLength() > 0) {
                log.info("00 - Nodes number: {}", nodes.getLength());
                checkEmp(nodes);
            }

        } catch (XPathExpressionException e) {
            log.error("Cannot parse xml", e);
        }

        final String ex02 = "/Employees/Employee";
        try {
            expr = xpath.compile(ex02);
            nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            int nlen = nodes.getLength();
            if (nlen > 0) {
                log.info("03 - Nodes number: {}", nodes.getLength());
                for (int i = 0; i < nlen; i++) {
                    Node n = nodes.item(i);
                    NodeList childs = n.getChildNodes();
                    if (null != childs) {
                        int clen = childs.getLength();
                        for (int j = 0; j < clen; j++) {
                            Node c = childs.item(j);
                            if(c.getNodeType() == Node.ELEMENT_NODE) {
                                if (!c.hasChildNodes()) {
                                    log.info("node: {} value: {}", c.getNodeName(), c.getFirstChild().getNodeValue());
                                } else {
                                    log.info("node: {} value is a tree", c.getNodeName());
                                    NodeList ccnodes = c.getChildNodes();
                                    if (null != ccnodes) {
                                        int cclen = ccnodes.getLength();
                                        for (int x = 0; x < cclen; x++) {
                                            Node ccNode = ccnodes.item(x);
                                            if(ccNode.getNodeType() == Node.ELEMENT_NODE) {
                                                log.info("-- node: {} value: {}", ccNode.getNodeName(), ccNode.getFirstChild().getNodeValue());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    NamedNodeMap attributes = n.getAttributes();
                    if (null != attributes) {
                        int alen = attributes.getLength();
                        for (int k = 0; k < alen; k++) {
                            Node atNode = attributes.item(k);
                            if(atNode.getNodeType() == Node.ATTRIBUTE_NODE) {
                                log.info("attribute node: {} value: {}", atNode.getNodeName(), atNode.getFirstChild().getNodeValue());
                            }
                        }
                    }
                }
            }

        } catch (XPathExpressionException e) {
            log.error("Cannot parse xml", e);
        }
        return newdoc;
    }

    private void checkEmp(NodeList nodes) {

        final String ex01 = "name";

        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr = null;

        try {
            int nlen = nodes.getLength();
            log.info("0A - Number of nodes: {}", nlen);
            for (int i = 0; i < nlen; i++) {
                log.info("Content of node: {}", i);
                Node n = nodes.item(i);

                NodeList nodeList = n.getChildNodes();
                for (int j = 0; null != nodeList && j < nodeList.getLength(); j++) {
                    Node nod = nodeList.item(j);
                    if(nod.getNodeType() == Node.ELEMENT_NODE) {
                        log.info("node: {} value: {}", nod.getNodeName(), nod.getFirstChild().getNodeValue());
                    }
                }
            }

            log.info("0B - Number of nodes: {}", nlen);
            expr = xpath.compile(ex01);
            for (int i = 0; i < nlen; i++) {
                log.info("Content of node: {}", i);
                Node n = nodes.item(i);

                Node node = (Node) expr.evaluate(n, XPathConstants.NODE);
                if (null != node) {
                    if(node.getNodeType() == Node.ELEMENT_NODE) {
                        log.info("node: {} value: {}", node.getNodeName(), node.getFirstChild().getNodeValue());
                        node.getFirstChild().setNodeValue("NoValue");
                    }
                }
            }
        } catch (XPathExpressionException e) {
            log.error("Error during XPath expression", e);
        }
    }
}
