package nl.bsoft.woz;

import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * Created by bvpelt on 6/23/17.
 */

@XmlRegistry
public class ObjectFactory {
    private final static QName _OWOZDi01_QNAME = new QName("http://www.waarderingskamer.nl/StUF/0312", "OWOZ_Di01", "WOZ");

    public ObjectFactory() {
    }

    public OWOZDi01 createOWOZDi01() {
        return new OWOZDi01();
    }

   /*
    public Stuurgegevens createStuurgegevens() {

        return new Stuurgegevens();
    }
    */
}