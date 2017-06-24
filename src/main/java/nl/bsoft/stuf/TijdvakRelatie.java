package nl.bsoft.stuf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by bvpelt on 6/24/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class TijdvakRelatie {

    @XmlElement(name = "beginRelatie", required = true)
    private BeginRelatie beginRelatie;

    @XmlElement(name = "eindRelatie", required = true)
    private EindRelatie eindRelatie;
}
