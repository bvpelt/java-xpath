package nl.bsoft.bg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by bvpelt on 6/24/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AdresAanduidingGrp {

    @XmlElement(name = "num.identificatie", required = true)
    private Identificatie identificatie;

    @XmlElement(name = "wpl.woonplaatsNaam", required = true)
    private WoonplaatsNaam woonplaatsNaam;

    @XmlElement(name = "gor.openbareRuimteNaam", required = true)
    private OpenbareRuimteNaam openbareRuimteNaam;

    @XmlElement(name = "gor.straatnaam", required = true)
    private Straatnaam straatnaam;

    @XmlElement(name = "aoa.postcode", required = true)
    private Postcode postcode;

    @XmlElement(name = "aoa.huisnummer", required = true)
    private Huisnummer huisnummer;

    @XmlElement(name = "aoa.huisletter", required = true)
    private Huisletter huisletter;

    @XmlElement(name = "aoa.huisnummertoevoeging", required = true)
    private Huisnummertoevoeging huisnummertoevoeging;

}
