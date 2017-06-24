package nl.bsoft.woz;

import nl.bsoft.stuf.TijdstipRegistratie;
import nl.bsoft.stuf.TijdvakGeldigheid;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by bvpelt on 6/24/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Object {

    @XmlAttribute(name = "entiteittype", namespace = "http://www.egem.nl/StUF/StUF0301", required = true)
    private String entiteittype;

    @XmlAttribute(name = "verwerkingssoort", namespace = "http://www.egem.nl/StUF/StUF0301", required = true)
    private String verwerkingssoort;

    @XmlElement(name = "isEen", required = true)
    private IsEen iseen;

    @XmlElement(name = "soFiNummer", required = true)
    private SofiNummer sofiNummer;

    @XmlElement(name = "aanvullingSoFiNummer", required = true)
    private AanvullingSofiNummer aanvullingSofiNummer;

    @XmlElement(name = "datumEindeSynchronisatie", required = true)
    private DatumEindeSynchronisatie datumEindeSynchronisatie;

    @XmlElement(name = "wozObjectNummer", required = true)
    private WozObjectNummer wozObjectNummer;

    @XmlElement(name = "aanduidingWOZobject", required = true)
    private AanduidingWOZobject aanduidingWOZobject;

    @XmlElement(name = "statusWozObject", required = true)
    private StatusWozObject statusWozObject;

    @XmlElement(name = "grondoppervlakte", required = true)
    private Grondoppervlakte grondoppervlakte;

    @XmlElement(name = "gebruikscode", required = true)
    private Gebruikscode gebruikscode;

    @XmlElement(name = "codeGebouwdOngebouwd", required = true)
    private CodeGebouwdOngebouwd codeGebouwdOngebouwd;

    @XmlElement(name = "meegetaxeerdeOppervlakteGebouwd", required = true)
    private MeegetaxeerdeOppervlakteGebouwd meegetaxeerdeOppervlakteGebouwd;

    @XmlElement(name = "ozbVrijstelling", required = true)
    private OzbVrijstelling ozbVrijstelling;

    @XmlElement(name = "verantwoordelijkeGemeente", required = true)
    private VerantwoordelijkeGemeente verantwoordelijkeGemeente;

    /*
    <WOZ:wozObjectGeometrie  StUF:noValue="waardeOnbekend" xsi:nil="true"/>
			<WOZ:ingangsdatumObject>20100413</WOZ:ingangsdatumObject>
			<WOZ:einddatumObject StUF:noValue="geenWaarde" xsi:nil="true"/>
			<StUF:tijdvakGeldigheid>
				<StUF:beginGeldigheid>20100413</StUF:beginGeldigheid>
				<StUF:eindGeldigheid StUF:noValue="geenWaarde" xsi:nil="true"/>
			</StUF:tijdvakGeldigheid>
			<StUF:tijdstipRegistratie>20100501000000000</StUF:tijdstipRegistratie>
			<WOZ:bevatKadastraleObjecten StUF:entiteittype="WOZKOZ" StUF:verwerkingssoort="T">

			</WOZ:bevatKadastraleObjecten>
			<WOZ:heeftBelanghebbende StUF:entiteittype="WOZSUB" StUF:verwerkingssoort="T">

			</WOZ:heeftBelanghebbende>
			<WOZ:ligtIn StUF:entiteittype="WOZWSP" StUF:verwerkingssoort="T">

			</WOZ:ligtIn>
     */
    @XmlElement(name = "wozObjectGeometrie", required = true)
    private WozObjectGeometrie wozObjectGeometrie;

    @XmlElement(name = "ingangsdatumObject", required = true)
    private IngangsdatumObject ingangsdatumObject;

    @XmlElement(name = "einddatumObject", required = true)
    private EinddatumObject einddatumObject;

    @XmlElement(name = "tijdvakGeldigheid", namespace = "http://www.egem.nl/StUF/StUF0301", required = true)
    private TijdvakGeldigheid tijdvakGeldigheid;

    @XmlElement(name = "tijdstipRegistratie", namespace = "http://www.egem.nl/StUF/StUF0301", required = true)
    private TijdstipRegistratie tijdstipRegistratie;

    @XmlElement(name = "bevatKadastraleObjecten", required = true)
    private BevatKadastraleObjecten bevatKadastraleObjecten;

    @XmlElement(name = "heeftBelanghebbende", required = true)
    private HeeftBelanghebbende heeftBelanghebbende;

    @XmlElement(name = "ligtIn", required = true)
    private LigtIn ligtIn;


}
