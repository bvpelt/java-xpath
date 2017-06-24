package nl.bsoft.stuf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by bvpelt on 6/23/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Zender {

    @XmlElement(name = "organisatie", required = true)
    private Organisatie organisatie;

    @XmlElement(name = "applicatie", required = true)
    private Applicatie applicatie;

    @XmlElement(name = "administratie", required = true)
    private Administratie administratie;

    @XmlElement(name = "gebruiker", required = true)
    private Gebruiker gebruiker;
}
