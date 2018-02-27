import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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

            //System.out.println(doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("CD");

            for(int i=0;i<nList.getLength();i++){
                Node node = nList.item(i);
              //  System.out.println(node.getNodeName());

                if(node.getNodeType()==Node.ELEMENT_NODE){
                    Element nNode = (Element) node;
                   // System.out.println(nNode.getAttribute("id"));
                    NodeList artists = nNode.getElementsByTagName("ARTIST");

                    for(int j=0;j<artists.getLength();j++){
                        Node n = artists.item(j);

                        if(n.getNodeType()==n.ELEMENT_NODE){
                            Element artist = (Element) n;
                            System.out.println("artist name: "+artist.getTextContent());
                        }
                    }

                }
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
