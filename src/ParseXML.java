import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class ParseXML {

    public static void main(String[] args)
    {

        try {
            File my_xmlFile = new File("D:\\Git projects\\XML_DOM\\music.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(my_xmlFile);
            ///normalize for reduction of redundancies (spaces)
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("CD");

            for(int i=0;i<nodeList.getLength();i++){
                Node node = nodeList.item(i);
                System.out.println("We are in :"+node.getNodeName());
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
