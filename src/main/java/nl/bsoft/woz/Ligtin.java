package nl.bsoft.woz;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by bvpelt on 6/23/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Ligtin {

    @XmlAttribute(name = "entiteittype")
    private String entiteittype;

    @XmlElement(name = "gerelateerde", required = true)
    private Gerelateerde gerelateerde;
}
