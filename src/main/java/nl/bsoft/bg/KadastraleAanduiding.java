package nl.bsoft.bg;

import nl.bsoft.woz.MeegetaxeerdeOppervlakte;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by bvpelt on 6/24/17.
 * <BG:kadastraleGemeentecode>XXX01</BG:kadastraleGemeentecode>
 <BG:kadastraleSectie>A</BG:kadastraleSectie>
 <BG:kadastraalPerceelnummer>101</BG:kadastraalPerceelnummer>
 <BG:kdp.deelperceelNummer StUF:noValue="geenWaarde" xsi:nil="true"/>
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class KadastraleAanduiding {

    @XmlElement(name = "kadastraleGemeentecode", required = true)
    private KadastraleGemeentecode kadastraleGemeentecode;

    @XmlElement(name = "kadastraleSectie", required = true)
    private KadastraleSectie kadastraleSectie;

    @XmlElement(name = "kadastraalPerceelnummer", required = true)
    private KadastraalPerceelnummer kadastraalPerceelnummer;

    @XmlElement(name = "kdp.deelperceelNummer", required = true)
    private DeelperceelNummer deelperceelNummer;

}
