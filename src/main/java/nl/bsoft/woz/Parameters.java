package nl.bsoft.woz;

import nl.bsoft.stuf.IndicatorOvername;
import nl.bsoft.stuf.Mutatiesoort;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by bvpelt on 6/24/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Parameters {

    @XmlElement(name = "mutatiesoort", namespace = "http://www.egem.nl/StUF/StUF0301", required = true)
    private Mutatiesoort mutatiesoort;

    @XmlElement(name = "indicatorOvername", namespace = "http://www.egem.nl/StUF/StUF0301", required = true)
    private IndicatorOvername indicatorOvername;

}
