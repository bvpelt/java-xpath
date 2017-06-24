package nl.bsoft.bg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created by bvpelt on 6/23/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class GemeenteCode {

    @XmlValue
    private String gemeenteCode;
}
