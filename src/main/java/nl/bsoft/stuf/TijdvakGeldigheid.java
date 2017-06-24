package nl.bsoft.stuf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by bvpelt on 6/24/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class TijdvakGeldigheid {
    /*
    <StUF:beginGeldigheid>20100413</StUF:beginGeldigheid>
				<StUF:eindGeldigheid StUF:noValue="geenWaarde" xsi:nil="true"/>
     */
    @XmlElement(name = "beginGeldigheid", required = true)
    private BeginGeldigheid beginGeldigheid;

    @XmlElement(name = "eindGeldigheid", required = true)
    private EindGeldigheid eindGeldigheid;

}
