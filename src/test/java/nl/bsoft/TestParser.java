package nl.bsoft;

import nl.bsoft.woz.OWOZDi01;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URL;

/**
 * Created by bvpelt on 6/23/17.
 */
public class TestParser {
    private final Logger log = LoggerFactory.getLogger(TestParser.class);


    @Test
    public void parser() {
        try {
            //JAXBContext jc = JAXBContext.newInstance(OWOZDi01.class);
            JAXBContext jc = JAXBContext.newInstance("nl.bsoft.woz");
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            Marshaller marshaller = jc.createMarshaller();

            URL resource = getClass().getClassLoader().getResource("scenario_1_9/Scenario_1_stap_1_OWOZ.xml");
            File input = new File(resource.getFile());

            OWOZDi01 root = (OWOZDi01)unmarshaller.unmarshal(input);

            marshaller.marshal(root, System.out);
        } catch (JAXBException e) {
            log.error("Error setup parser", e);
        }
    }
}
