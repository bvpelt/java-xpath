package nl.bsoft;

import com.codahale.metrics.*;
import com.jcabi.xml.XMLDocument;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by bvpelt on 6/2/17.
 */
public class TestFilter {
    private final Logger log = LoggerFactory.getLogger(TestFilter.class);

    static final MetricRegistry metrics = new MetricRegistry();
    private final Meter tests = metrics.meter("tests");
    private static Slf4jReporter reporterSlf4j = null;


    @BeforeClass
    public static void doYourOneTimeSetup()
    {
        reporterSlf4j = Slf4jReporter.forRegistry(metrics)
                .outputTo(LoggerFactory.getLogger("nl.bsoft.TestFilter"))
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();

        reporterSlf4j.start(1, TimeUnit.SECONDS);
    }

    @Test
    public void doTest01() {
        tests.mark();
        // read xml input file
        // convert to document
        // create filter class
        // execute filter
        // show result

        Document doc = null;
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        try {
            docBuilder = docBuilderFactory.newDocumentBuilder();

            doc = docBuilder.parse(new File("src/test/resources/mkoz_di01.xml"));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // normalize text representation
        doc.getDocumentElement().normalize();
        log.info("00 - Root element of the doc is: {} ", doc.getDocumentElement().getNodeName());

        Filter f = new Filter();
        String[] roles = {"0000001325"};
        f.filterDocument(doc, roles);
    }

    @Test
    public void doTest02() {
        tests.mark();
        // read xml input file
        // convert to document
        // create filter class
        // execute filter
        // show result

        Document doc = null;
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        try {
            docBuilder = docBuilderFactory.newDocumentBuilder();

            doc = docBuilder.parse(new File("src/test/resources/simple.xml"));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // normalize text representation
        doc.getDocumentElement().normalize();
        log.info("01 - Root element of the doc is: {} ", doc.getDocumentElement().getNodeName());

        Filter f = new Filter();
        String[] roles = {"0000001325"};

        String xmlin = new XMLDocument(doc).toString();
        log.info("converted document\n{}", xmlin);

        f.filterTestDocument(doc, roles);

        String xmlout = new XMLDocument(doc).toString();
        log.info("converted document\n{}", xmlout);
    }

    @Test
    public void doTest03() {
        tests.mark();
        // read xml input file
        // convert to document
        // create filter class
        // execute filter
        // show result

        Document doc = null;
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        try {
            docBuilder = docBuilderFactory.newDocumentBuilder();

            doc = docBuilder.parse(new File("src/test/resources/simple01.xml"));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // normalize text representation
        doc.getDocumentElement().normalize();
        log.info("01 - Root element of the doc is: {} ", doc.getDocumentElement().getNodeName());

        Filter f = new Filter();
        String[] roles = {"0000001325"};

        String xmlin = new XMLDocument(doc).toString();
        log.info("converted document\n{}", xmlin);

        f.filterTestDocument(doc, roles);

        String xmlout = new XMLDocument(doc).toString();
        log.info("converted document\n{}", xmlout);
    }

    @AfterClass
    public static void doYourOneTimeTeardown() {
        reporterSlf4j.report();
    }
}
