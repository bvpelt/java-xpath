package nl.bsoft.woz;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by bvpelt on 6/23/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "", propOrder = {"stuurgegevens"})
@XmlRootElement(name = "OWOZ_Di01")
public class OWOZDi01 {

    @XmlElement(name = "stuurgegevens", required = true)
    private Stuurgegevens stuurgegevens;

    @XmlElement(name = "routering", required = true)
    private Routering routering;

    @XmlElement(name = "voegToeNPS", required = true)
    private VoegToeNPS voegToeNPS;

    @XmlElement(name = "voegToeWOZ", required = true)
    private VoegToeWOZ voegToeWOZ;
}
