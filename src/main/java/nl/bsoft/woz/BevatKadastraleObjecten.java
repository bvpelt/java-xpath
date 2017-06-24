package nl.bsoft.woz;

import nl.bsoft.stuf.TijdstipRegistratie;
import nl.bsoft.stuf.TijdvakGeldigheid;
import nl.bsoft.stuf.TijdvakRelatie;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by bvpelt on 6/24/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class BevatKadastraleObjecten {

    @XmlAttribute(name = "entiteittype", namespace = "http://www.egem.nl/StUF/StUF0301")
    private String entiteittype;

    @XmlAttribute(name = "verwerkingssoort", namespace = "http://www.egem.nl/StUF/StUF0301")
    private String verwerkingssoort;

    @XmlElement(name = "gerelateerde", required = true)
    private Gerelateerde gerelateerde;

    @XmlElement(name = "toegekendeOppervlakte", required = true)
    private ToegekendeOppervlakte toegekendeOppervlakte;

    @XmlElement(name = "meegetaxeerdeOppervlakte", required = true)
    private MeegetaxeerdeOppervlakte meegetaxeerdeOppervlakte;

    @XmlElement(name = "tijdvakRelatie", namespace = "http://www.egem.nl/StUF/StUF0301", required = true)
    private TijdvakRelatie tijdvakRelatie;

    @XmlElement(name = "tijdvakGeldigheid", namespace = "http://www.egem.nl/StUF/StUF0301", required = true)
    private TijdvakGeldigheid tijdvakGeldigheid;

    @XmlElement(name = "tijdstipRegistratie", namespace = "http://www.egem.nl/StUF/StUF0301", required = true)
    private TijdstipRegistratie tijdstipRegistratie;


}
