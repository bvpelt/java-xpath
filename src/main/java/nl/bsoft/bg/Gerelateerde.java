package nl.bsoft.bg;

import nl.bsoft.stuf.StufVeld;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by bvpelt on 6/24/17.
 * <BG:gerelateerde StUF:entiteittype="TGO" StUF:verwerkingssoort="T">
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Gerelateerde  {

    @XmlAttribute(name = "entiteittype", namespace = "http://www.egem.nl/StUF/StUF0301", required = true)
    private String entiteittype;

    @XmlAttribute(name = "verwerkingssoort", namespace = "http://www.egem.nl/StUF/StUF0301", required = true)
    private String verwerkingssoort;

    @XmlElement(name = "identificatie", required = true)
    private Identificatie identificatie;

    @XmlElement(name = "adresAanduidingGrp", required = true)
    private AdresAanduidingGrp adresAanduidingGrp;

}
