import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class QueryXML {

    public static void main(String[] args){
        try {
            File my_xmlFile = new File("D:\\Git projects\\XML_DOM\\music.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            //Defines the API to obtain DOM Document instances from an XML document. Using this class, an application programmer can obtain a Document from XML
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
            //Document provides the primary access to the document's data.
            Document doc = docBuilder.parse(my_xmlFile);
            doc.getDocumentElement().normalize();

            System.out.println(doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("CD");


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
