package nl.bsoft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.*;

import javax.xml.xpath.*;

/**
 * Created by bvpelt on 6/2/17.
 */
public class Filter {
    private final Logger log = LoggerFactory.getLogger(Filter.class);

    public Filter() {

    }

    Document filterDocument(Document doc, String[] roles) {
        Document newdoc = null;

        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        final String ex01 = "//woz:*[@stuf:entiteittype=\"SWO\"]//woz:ligtIn";
        final String ex02 = "//woz:object[@stuf:entiteittype=\"WOZ\"]";
        final String ex03 = "//WOZ:object[@StUF:entiteittype=\"SWO\"]"; // test

        XPathExpression expr = null;
        NodeList nodes = null;

        try {
            expr = xpath.compile(ex01);
            nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            if (nodes.getLength() > 0) {
                checkWozEntSwoNodes(nodes);
            }

            expr = xpath.compile(ex02);
            nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            if (nodes.getLength() > 0) {
                checkWozEntWoz(nodes);
            }

            expr = xpath.compile(ex03);
            nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            if (nodes.getLength() > 0) {
                checkWozEntWoz(nodes);
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

    private void checkWozEntWoz(NodeList nodes) {

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
                checkWozEntWozKadobjects(curNodes);
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

    private void checkWozEntWozKadobjects(NodeList nodes) {

        final String ex01 = "//stuf:tijdstipRegistratie";
        final String ex02 = "//woz:inOnderzoek";
        final String ex03 = "//woz:meegetaxeerdeOppervlakte";
        final String ex04 = "//woz:toegekendeOppervlakte";
        final String ex05 = "/stuf:tijdvakGeldigheid//stuf:beginGeldigheid";
        final String ex06 = "/stuf:tijdvakGeldigheid//stuf:eindGeldigheid";

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

            expr = xpath.compile(ex05);
            for (int i = 0; i < nodes.getLength(); i++) {
                Node n = nodes.item(i);
                curNodes = (NodeList) expr.evaluate(n, XPathConstants.NODESET);
            }

            expr = xpath.compile(ex06);
            for (int i = 0; i < nodes.getLength(); i++) {
                Node n = nodes.item(i);
                curNodes = (NodeList) expr.evaluate(n, XPathConstants.NODESET);
            }
        } catch (XPathExpressionException e) {
            log.error("Error during XPath expression", e);
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
