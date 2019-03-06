package defaultpackage;

import java.io.File;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import java.lang.String;

public class Main {

	final static String CLASSES = "packagedElement";
	final static String ATTRIBUTES = "ownedAttribute";
	final static String OPERATIONS = "ownedOperation"; 

	final static String FILE_ADDRESS = "C:/Users/Ilyess/Desktop/Ilyess/ESILVCours/Projet/PII/MyWork/file.xmi";

	public static void function() {
		NodeList listClass;
		NodeList listAttributes;
		NodeList listOperations;
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File(FILE_ADDRESS));

			doc.getDocumentElement().normalize();
			System.out.println("==============================");
			listClass = doc.getElementsByTagName(CLASSES);

			// int totalClass = listClass.getLength();
			// System.out.println("Total Class : " + totalClass);
			// For each class.
			for (int i = 0; i < listClass.getLength(); i++) {

				Element link = (Element) listClass.item(i);

				if(link.getAttribute("xmi:type").contains( "uml:Class")/* && link.getAttribute("name").contains("DssSupplier")*/) {
					System.out.println("Class: "+ link.getAttribute("name"));

					String bodyClass = link.getElementsByTagName("ownedComment").item(0).getTextContent();

					if(!(bodyClass.indexOf("(name") == -1 || bodyClass.contains("fetch"))) {
						//System.out.println(body);
						//System.out.println("\t nameIndex: "+body.indexOf("(name"));
						int beginClass = bodyClass.indexOf('"',bodyClass.indexOf("(name"));
						int endClass = bodyClass.indexOf('"',beginClass+1);
						String className = bodyClass.substring(beginClass+1,endClass);
						System.out.println("    Table Name: "+className);
					}

					listAttributes = link.getElementsByTagName(ATTRIBUTES);
					listOperations = link.getElementsByTagName(OPERATIONS);
					int totalAttributes = listAttributes.getLength();
					System.out.println("Attribute:"+totalAttributes);

					// For each attribute.
					for (int j = 0; j < listAttributes.getLength(); j++) {

						Element linkAttribute = (Element) listAttributes.item(j);
						String attributeName = linkAttribute.getAttribute("name");
						if(attributeName != "") {
							System.out.println("\t"+j+"- " + attributeName);

							for (int k = 0; k < listOperations.getLength(); k++) {

								Element linkOperation = (Element) listOperations.item(k);

								if(linkOperation.getAttribute("name").toLowerCase().contains("get"+(attributeName.toLowerCase()))) {
									String body = linkOperation.getElementsByTagName("ownedComment").item(0).getTextContent();

									if(body.indexOf("(name") == -1) break; // Not column name but fetch rows.
									if(body.contains("fetch")) break;
									//System.out.println(body);
									//System.out.println("\t nameIndex: "+body.indexOf("(name"));
									int begin = body.indexOf('"',body.indexOf("(name"));
									int end = body.indexOf('"',begin+1);
									String columnName = body.substring(begin+1,end);
									System.out.println("\t\t Column Name: "+columnName);
								}
							}
						}
					}
				}

			}
			/*
			listAttributes = doc.getElementsByTagName(ATTRIBUTES);
			int totalAttributes = listAttributes.getLength();
			System.out.println("Attribute:"+totalAttributes);


			NodeList linksAtributesHiding = doc.getElementsByTagName(ATTRIBUTES);
			for (int i = 0; i < linksAtributesHiding.getLength(); i++) {

				Element link = (Element) linksAtributesHiding.item(i);

				System.out.println("Attribute= " + link.getAttribute("name"));

			}
			 */

		} catch (SAXParseException err) {
			System.out.println("** Parsing error" + ", line "
					+ err.getLineNumber() + ", uri " + err.getSystemId());
			System.out.println(" " + err.getMessage());

		} catch (SAXException e) {
			Exception x = e.getException();
			((x == null) ? e : x).printStackTrace();

		} catch (Throwable t) {
			t.printStackTrace();
		}

	}

	public static void main(String[] args) {
		//test();
		//test1();
		function();
	}

}
