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

    public static void main(String[] args){

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            // creating root element
            Element rootElement = doc.createElement("CATALOG");
            doc.appendChild(rootElement);
            //creating CD element
            Element cd = doc.createElement("CD");
            rootElement.appendChild(cd);
            //creating attribute for CD element
            Attr attr_cd = doc.createAttribute("id");
            attr_cd.setValue("88");
            cd.setAttributeNode(attr_cd);

            //creating Title element
            Element title = doc.createElement("TITLE");
            title.appendChild(doc.createTextNode("Nevermind"));
            cd.appendChild(title);
            //creating artist element
            Element artist = doc.createElement("ARTIST");
            artist.appendChild(doc.createTextNode("Nirvana"));
            cd.appendChild(artist);
            //creating Country element
            Element country = doc.createElement("COUNTRY");
            country.appendChild(doc.createTextNode("USA"));
            cd.appendChild(country);

            //creating Company element
            Element company = doc.createElement("COMPANY");
            company.appendChild(doc.createTextNode("Butch Vig"));
            cd.appendChild(company);

            //creating Price element
            Element price = doc.createElement("PRICE");
            price.appendChild(doc.createTextNode("10.90"));
            cd.appendChild(price);
            //creating Year element
            Element year = doc.createElement("YEAR");
            year.appendChild(doc.createTextNode("1991"));
            cd.appendChild(year);

            //cretaing the 2nd CD element
            rootElement.appendChild(cd);
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
