package nl.bsoft.woz;

import nl.bsoft.bg.KadastraleAanduiding;
import nl.bsoft.bg.KadastraleIdentificatie;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by bvpelt on 6/23/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Gerelateerde {

    @XmlAttribute(name = "entiteittype", namespace = "http://www.egem.nl/StUF/StUF0301", required = false)
    private String entiteittype;

    @XmlElement(name = "betrokkenWaterschap", required = false)
    private BetrokkenWaterschap betrokkenWaterschap;

    @XmlElement(name = "kadastraleIdentificatie", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = false)
    private KadastraleIdentificatie kadastraleIdentificatie;

    @XmlElement(name = "kadastraleAanduiding", namespace = "http://www.egem.nl/StUF/sector/bg/0310", required = false)
    private KadastraleAanduiding kadastraleAanduiding;
}
