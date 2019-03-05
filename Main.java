package defaultpackage;
/*
import com.ibm.xmi.framework.XMIFile;
import com.ibm.xmi.framework.XMIContainer;
import org.eclipse;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.ibm.xmi.job.Job;
import java.util.Collection;
import java.util.Iterator;
 */


import java.io.File;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import java.lang.String;

public class Main {
	/*
	public static void test1() {
		Collection objects = Job.readObjects("file.xmi");
		Iterator objs = objects.iterator();
		while (objs.hasNext()) {
		System.out.println(objs.next());
		}
	}

	public static void test() {
		if (args.length != 1) {
			System.out.println("Enter the name of an XMI document.");
			return;
			}
			XMIFile file = XMIFile.load(args[0], XMIFile.DEFAULT, false);
			XMIContainer c = new XMIContainer(file.getObjects().iterator());
			System.out.println(c);
	}
	 */

	final static String ATTRIBUTES = "ownedAttribute";

	final static String CLASSES = "UML:Class"; 

	final static String FILE_ADDRESS = "C:/Users/Ilyess/Desktop/Ilyess/ESILVCours/Projet/PII/MyWork/file.xmi";

	public static void function() {
		NodeList listClass;
		NodeList listAttributes;
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File(FILE_ADDRESS));

			doc.getDocumentElement().normalize();
			System.out.println("==============================");
			listClass = doc.getElementsByTagName(CLASSES);

			int totalClass = listClass.getLength();
			System.out.println("Total Class : " + totalClass);

			for (int i = 0; i < listClass.getLength(); i++) {

				Element link = (Element) listClass.item(i);

				System.out.println("Class= "+ link.getAttribute("name"));

			}

			listAttributes = doc.getElementsByTagName(ATTRIBUTES);
			int totalAttributes = listAttributes.getLength();
			System.out.println("Attribute:"+totalAttributes);


			NodeList linksAtributesHiding = doc.getElementsByTagName(ATTRIBUTES);
			for (int i = 0; i < linksAtributesHiding.getLength(); i++) {

				Element link = (Element) linksAtributesHiding.item(i);

				System.out.println("Attribute= " + link.getAttribute("name"));

			}


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
