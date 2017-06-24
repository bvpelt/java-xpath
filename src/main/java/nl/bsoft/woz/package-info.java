@XmlSchema(
        namespace = "http://www.waarderingskamer.nl/StUF/0312",
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {
            @XmlNs(prefix="WOZ", namespaceURI="http://www.waarderingskamer.nl/StUF/0312"),
                @XmlNs(prefix="StUF", namespaceURI="http://www.egem.nl/StUF/StUF0301"),
                @XmlNs(prefix="BG", namespaceURI="http://www.egem.nl/StUF/sector/bg/0310"),
                @XmlNs(prefix="gml", namespaceURI="http://www.opengis.net/gml/3.2"),
                @XmlNs(prefix="xlink", namespaceURI="http://www.w3.org/1999/xlink"),
                @XmlNs(prefix="xsi", namespaceURI="http://www.w3.org/2001/XMLSchema-instance")
        }
)

package nl.bsoft.woz;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;