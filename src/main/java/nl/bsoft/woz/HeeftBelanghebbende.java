package nl.bsoft.woz;

import nl.bsoft.stuf.TijdstipRegistratie;
import nl.bsoft.stuf.TijdvakRelatie;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by bvpelt on 6/24/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class HeeftBelanghebbende {

    @XmlAttribute(name = "entiteittype", namespace = "http://www.egem.nl/StUF/StUF0301")
    private String entiteittype;

    @XmlAttribute(name = "verwerkingssoort", namespace = "http://www.egem.nl/StUF/StUF0301")
    private String verwerkingssoort;

    @XmlElement(name = "gerelateerde", required = true)
    private GerelateerdeNPS gerelateerde;

    @XmlElement(name = "aanduidingEigenaarGebruiker", required = true)
    private AanduidingEigenaarGebruiker aanduidingEigenaarGebruiker;

    @XmlElement(name = "statusBelang", required = true)
    private StatusBelang statusBelang;

    @XmlElement(name = "avr.aard", required = true)
    private Aard aard;

    @XmlElement(name = "tijdvakRelatie", namespace = "http://www.egem.nl/StUF/StUF0301", required = true)
    private TijdvakRelatie tijdvakRelatie;

    @XmlElement(name = "tijdvakGeldigheid", namespace = "http://www.egem.nl/StUF/StUF0301", required = true)
    private EinddatumObject einddatumObject;

    @XmlElement(name = "tijdstipRegistratie", namespace = "http://www.egem.nl/StUF/StUF0301", required = true)
    private TijdstipRegistratie tijdstipRegistratie;

}
