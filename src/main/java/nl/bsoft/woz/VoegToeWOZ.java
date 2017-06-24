package nl.bsoft.woz;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by bvpelt on 6/23/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class VoegToeWOZ {

    @XmlAttribute(name = "entiteittype", namespace = "http://www.egem.nl/StUF/StUF0301")
    private String entiteittype;

    @XmlAttribute(name = "functie", namespace = "http://www.egem.nl/StUF/StUF0301")
    private String functie;

    @XmlElement(name = "parameters", required = true)
    private Parameters parameters;

    @XmlElement(name = "object", required = true)
    private Object object;

}
