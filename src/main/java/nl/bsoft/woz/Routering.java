package nl.bsoft.woz;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by bvpelt on 6/23/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Routering {

    @XmlAttribute(name = "entiteittype", namespace = "http://www.egem.nl/StUF/StUF0301", required = true)
    private String entiteittype;

    @XmlAttribute(name = "functie", namespace = "http://www.egem.nl/StUF/StUF0301", required = true)
    private String functie;

    @XmlElement(name = "verantwoordelijkeGemeente", required = true)
    private VerantwoordelijkeGemeente verantwoordelijkeGemeente;

    @XmlElement(name = "ligtIn", required = true)
    private Ligtin ligtin;

}
