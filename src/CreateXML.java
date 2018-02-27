import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class CreateXML {
    static Element generateCdEntry(Document doc,String Title, String Artist,String Year,String Country,String Price,String id,String Company){
        Element cd = doc.createElement("CD");
        //creating attribute for CD element
        Attr attr_cd = doc.createAttribute("id");
        attr_cd.setValue(id);
        cd.setAttributeNode(attr_cd);
        //creating Title element
        Element title = doc.createElement("TITLE");
        title.appendChild(doc.createTextNode(Title));
        cd.appendChild(title);
        //creating artist element
        Element artist = doc.createElement("ARTIST");
        artist.appendChild(doc.createTextNode(Artist));
        cd.appendChild(artist);
        //creating Country element
        Element country = doc.createElement("COUNTRY");
        country.appendChild(doc.createTextNode(Country));
        cd.appendChild(country);
        //creating Company element
        Element company = doc.createElement("COMPANY");
        company.appendChild(doc.createTextNode(Company));
        cd.appendChild(company);
        //creating Price element
        Element price = doc.createElement("PRICE");
        price.appendChild(doc.createTextNode(Price));
        cd.appendChild(price);
        //creating Year element
        Element year = doc.createElement("YEAR");
        year.appendChild(doc.createTextNode(Year));
        cd.appendChild(year);
        return cd;
    }
    public static void main(String[] args){

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            // creating root element
            Element rootElement = doc.createElement("CATALOG");
            doc.appendChild(rootElement);

            rootElement.appendChild(generateCdEntry(doc,"Nevermind","Nirvana","1991","USA","10.90","88","Butch Vig"));
            rootElement.appendChild(generateCdEntry(doc,"No Need to Argue","The Cranberries","1994","UK","9.99","77","CBS Records"));

            //writing into file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("music.xml"));
            transformer.transform(source, result);


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}
