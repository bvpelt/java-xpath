package nl.bsoft.woz;

import nl.bsoft.bg.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by bvpelt on 6/24/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AanduidingWOZobject {

    @XmlElement(name = "aoa.identificatie", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = true)
    private Identificatie identificatie;

    @XmlElement(name = "wpl.woonplaatsNaam", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = true)
    private WoonplaatsNaam woonplaatsNaam;

    @XmlElement(name = "aoa.postcode", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = true)
    private Postcode postcode;

    @XmlElement(name = "gor.openbareRuimteNaam", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = true)
    private OpenbareRuimteNaam openbareRuimteNaam;

    @XmlElement(name = "gor.straatnaam", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = true)
    private Straatnaam straatnaam;

    @XmlElement(name = "aoa.huisnummer", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = true)
    private Huisnummer huisnummer;

    @XmlElement(name = "aoa.huisletter", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = true)
    private Huisletter huisletter;

    @XmlElement(name = "aoa.huisnummertoevoeging", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = true)
    private Huisnummertoevoeging huisnummertoevoeging;

    @XmlElement(name = "locatieOmschrijving", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = true)
    private LocatieOmschrijving locatieOmschrijving;

}
