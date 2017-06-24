package nl.bsoft.bg;

/**
 * Created by bvpelt on 6/24/17.
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class VerblijftIn {

    @XmlElement(name = "gerelateerde", required = true)
    private Gerelateerde gerelateerde;

}
