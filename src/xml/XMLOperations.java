package xml;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLOperations {

	public void writeXML(String title,DefaultTableModel model ,String description, String waitTime, String invalidNumbers ) {

		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("file");
			doc.appendChild(rootElement);

			// problem elements
			Element problem = doc.createElement("problem");
			rootElement.appendChild(problem);

			// set attribute 
//			Attr attr = doc.createAttribute("name");
//			attr.setValue(title);
//			problem.setAttributeNode(attr);
			
			Element nameElement = doc.createElement("name");
			nameElement.appendChild(doc.createTextNode(title));
			problem.appendChild(nameElement);

			Element descriptionElement = doc.createElement("description");
			descriptionElement.appendChild(doc.createTextNode(description));
			problem.appendChild(descriptionElement);

			Element waitTimeElement = doc.createElement("waitTime");
			waitTimeElement.appendChild(doc.createTextNode(waitTime));
			problem.appendChild(waitTimeElement);
			
			for(int i =0; i < model.getRowCount(); i++) {
				
				Element variableElement = doc.createElement("variable");
				problem.appendChild(variableElement);
				
				Element variableName = doc.createElement("name");
				variableName.appendChild(doc.createTextNode(model.getValueAt(i, 0).toString()));
				
				Element variableType = doc.createElement("type");
				variableType.appendChild(doc.createTextNode(model.getValueAt(i, 1).toString()));
				
				Element variableMinValue = doc.createElement("minimumValue");
				variableMinValue.appendChild(doc.createTextNode(model.getValueAt(i, 2).toString()));
				
				Element variableMaxValue = doc.createElement("maximumValue");
				variableMaxValue.appendChild(doc.createTextNode(model.getValueAt(i, 3).toString()));
				
				
				
				variableElement.appendChild(variableName); //adicionar elemento ao parent
				variableElement.appendChild(variableType);
				variableElement.appendChild(variableMinValue);
				variableElement.appendChild(variableMaxValue);
			}			

			Element invalidValues = doc.createElement("invalidValues");
			invalidValues.appendChild(doc.createTextNode(invalidNumbers));
			problem.appendChild(invalidValues);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);

			Date dNow = new Date();
			SimpleDateFormat df = new SimpleDateFormat("(yyy-MM-dd) (hh-mm-ss)");
			String guardaData = df.format(dNow);
			StreamResult result = new StreamResult(new File(title+guardaData+".xml"));

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}

	}

	public Node[] readXML (File xmlFile) {

		Node[] xmlContent = new Node[30];

		try {

			//File fXmlFile = new File("a(2018-03-12) (11-40-36).xml");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			doc.getDocumentElement().normalize();

			//System.out.println("\nRoot element : " + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("problem");

			//System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp); //aqui digo que estou no problema 0 para o caso de haver mais problemas

				//System.out.println("\nCurrent Element :" + nNode.getNodeName()); //aviso que estou no elemento "problem"

				//System.out.println("Name: " +nNode.getAttributes().item(temp).getTextContent() );

				for (int i =0 ; i < nNode.getChildNodes().getLength(); i++) {
			//		System.out.println(" "+ nNode.getChildNodes().item(i).getTextContent());	
					xmlContent[i] = nNode.getChildNodes().item(i);
				//	System.out.println(xmlContent[i].getNodeName());
				}

				//System.out.println("Aqui" +xmlContent[0]);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return xmlContent;
	}

}
