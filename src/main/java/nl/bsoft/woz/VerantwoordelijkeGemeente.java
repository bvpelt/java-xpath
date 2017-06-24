package nl.bsoft.woz;

import nl.bsoft.bg.GemeenteCode;
import nl.bsoft.stuf.StufVeld;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by bvpelt on 6/23/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class VerantwoordelijkeGemeente extends StufVeld {

    @XmlElement(name = "gemeenteCode", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = true)
    private GemeenteCode gemeenteCode;
}
