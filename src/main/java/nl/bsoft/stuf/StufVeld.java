package nl.bsoft.stuf;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created by bvpelt on 6/23/17.
 * <p>
 * StUF:noValue="geenWaarde" xsi:nil="true"/>
 */
public class StufVeld {

    @XmlValue
    public String value = null;
    @XmlAttribute(name = "noValue", namespace = "http://www.egem.nl/StUF/StUF0301", required = false)
    private String noValue;
    @XmlAttribute(name = "nil", namespace = "http://www.w3.org/2001/XMLSchema-instance", required = false)
    private boolean nill;

    public String getValue() {
        return value;
    }
}
