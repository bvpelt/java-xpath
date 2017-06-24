package nl.bsoft.woz;

import nl.bsoft.stuf.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by bvpelt on 6/23/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Stuurgegevens {


    @XmlElement(name = "berichtcode", namespace = "http://www.egem.nl/StUF/StUF0301", required = true)
    private Berichtcode berichtcode;

    @XmlElement(name = "zender", namespace = "http://www.egem.nl/StUF/StUF0301", required = true)
    private Zender zender;

    @XmlElement(name = "ontvanger", namespace = "http://www.egem.nl/StUF/StUF0301", required = true)
    private Ontvanger ontvanger;

    @XmlElement(name = "referentienummer", namespace = "http://www.egem.nl/StUF/StUF0301", required = true)
    private Referentienummer referentienummer;

    @XmlElement(name = "tijdstipBericht", namespace = "http://www.egem.nl/StUF/StUF0301", required = true)
    private TijdstipBericht tijdstipBericht;

    @XmlElement(name = "functie", namespace = "http://www.egem.nl/StUF/StUF0301", required = true)
    private Functie functie;
}
