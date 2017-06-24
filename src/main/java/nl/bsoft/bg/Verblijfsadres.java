package nl.bsoft.bg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by bvpelt on 6/24/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Verblijfsadres {
    /*
    <BG:aoa.identificatie>0513200000000111</BG:aoa.identificatie>
					    <BG:wpl.woonplaatsNaam>'s-Gravenhage</BG:wpl.woonplaatsNaam>
						<BG:gor.openbareRuimteNaam>Eerste straat</BG:gor.openbareRuimteNaam>
						<BG:gor.straatnaam>Eerste straat</BG:gor.straatnaam>
						<BG:aoa.postcode>2500AA</BG:aoa.postcode>
						<BG:aoa.huisnummer>25</BG:aoa.huisnummer>
						<BG:aoa.huisletter StUF:noValue="geenWaarde" xsi:nil="true"/>
						<BG:aoa.huisnummertoevoeging StUF:noValue="geenWaarde" xsi:nil="true"/>
						<BG:inp.locatiebeschrijving StUF:noValue="geenWaarde" xsi:nil="true"/>
     */

    @XmlElement(name = "aoa.identificatie", required = true)
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

    @XmlElement(name = "inp.locatiebeschrijving", required = true)
    private Locatiebeschrijving locatiebeschrijving;

}
