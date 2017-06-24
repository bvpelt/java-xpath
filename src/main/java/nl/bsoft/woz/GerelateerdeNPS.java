package nl.bsoft.woz;

import nl.bsoft.bg.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by bvpelt on 6/24/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class GerelateerdeNPS {

    @XmlAttribute(name = "entiteittype", namespace = "http://www.egem.nl/StUF/StUF0301", required = false)
    private String entiteittype;

    @XmlAttribute(name = "verwerkingssoort", namespace = "http://www.egem.nl/StUF/StUF0301", required = false)
    private String verwerkingssoort;

    @XmlElement(name = "inp.bsn", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = true)
    private Bsn bsn;

    @XmlElement(name = "geslachtsnaam", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = true)
    private Geslachtsnaam geslachtsnaam;

    @XmlElement(name = "voorvoegselGeslachtsnaam", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = true)
    private VoorvoegselGeslachtsnaam voorvoegselGeslachtsnaam;

    @XmlElement(name = "voorletters", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = true)
    private Voorletters voorletters;

    @XmlElement(name = "aanduidingNaamgebruik", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = true)
    private AanduidingNaamgebruik aanduidingNaamgebruik;

    @XmlElement(name = "geslachtsnaamPartner", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = true)
    private GeslachtsnaamPartner geslachtsnaamPartner;

    @XmlElement(name = "voorvoegselGeslachtsnaamPartner", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = true)
    private VoorvoegselGeslachtsnaamPartner voorvoegselGeslachtsnaamPartner;

    @XmlElement(name = "aanhefAanschrijving", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = true)
    private AanhefAanschrijving aanhefAanschrijving;

    @XmlElement(name = "geslachtsnaamAanschrijving", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = true)
    private GeslachtsnaamAanschrijving geslachtsnaamAanschrijving;

    @XmlElement(name = "geslachtsaanduiding", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = true)
    private Geslachtsaanduiding geslachtsaanduiding;

    @XmlElement(name = "geboortedatum", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = true)
    private Geboortedatum geboortedatum;

    @XmlElement(name = "inp.verblijftIn", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = true)
    private VerblijftIn verblijftIn;

    @XmlElement(name = "verblijfsadres", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = true)
    private Verblijfsadres verblijfsadres;

    @XmlElement(name = "inp.indicatieGeheim", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = true)
    private IndicatieGeheim indicatieGeheim;
}
