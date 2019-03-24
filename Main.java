package defaultpackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.*;

import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {

	final static String CLASSES = "packagedElement";
	final static String ATTRIBUTES = "ownedAttribute";
	final static String OPERATIONS = "ownedOperation"; 

	final static String FILE_ADDRESS = "C:/Users/Ilyess/Desktop/Ilyess/ESILVCours/Projet/PII/MyWork/file.xmi";

	public static void function() {
		NodeList listClass;
		NodeList listAttributes;
		NodeList listOperations;
		String SQLtable;
		List<String> SQLattributes;
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
				SQLtable = "";
				SQLattributes = new ArrayList<String>(); 

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
						SQLtable = className;
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

							Element linkType = (Element) linkAttribute.getElementsByTagName("type").item(0);
							if(linkType != null) {
								String attributeType = linkType.getAttribute("href");
								attributeType = attributeType.substring(attributeType.indexOf("#")+1);
								System.out.println("\t\t Type: " + attributeType);
							}

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
									SQLattributes.add(columnName);
									System.out.println("\t\t Column Name: "+columnName);
								}
							}
						}
					}


					// JSON creation

					String url = "jdbc:mysql://relational.fit.cvut.cz:3306/tpcd";
					String username = "guest";
					String password = "relational";
					String columns = "";
					Connection myConn=null;
					Statement myStmt = null;
					ResultSet myRs= null;
					for(String column : SQLattributes) {
						if(SQLattributes.indexOf(column) == SQLattributes.size()-1) columns += column;
						else columns += column + ",";
					}

					try
					{
						System.out.println("Fetching data from SQL for " + SQLtable + " table (this might take some time).");
						myConn = DriverManager.getConnection(url, username, password);
						myStmt= myConn.createStatement();
						String sql= "Select " + columns + " from " + SQLtable;
						myRs = myStmt.executeQuery(sql);
						JSONArray jArray = new JSONArray();
						while (myRs.next())
						{
							JSONObject jObj = new JSONObject();
							for(String column : SQLattributes) {
								String key_json = myRs.getString(column);
								jObj.put(column, key_json);
							}
							jArray.put(jObj);
						}
						System.out.println("Starting file creation.");
						try (FileWriter file = new FileWriter("C:/Users/Ilyess/Desktop/Ilyess/ESILVCours/Projet/PII/MyWork/filesCreated/"+SQLtable+".json")) {

							file.write(jArray.toString());
							file.flush();

						} catch (IOException e) {
							e.printStackTrace();
						}
						System.out.println("File creation ended.");

					}
					catch(Exception e)
					{
						System.out.println(e);
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

	public static void test() {
		String url = "jdbc:mysql://relational.fit.cvut.cz:3306/tpcd";
		String username = "guest";
		String password = "relational";
		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs= null;
		try
		{
			myConn = DriverManager.getConnection(url, username, password);
			myStmt= myConn.createStatement();
			String sql= "Select n_nationkey,n_name,n_comment from dss_nation";
			myRs = myStmt.executeQuery(sql);
			JSONArray jArray = new JSONArray();
			while (myRs.next())
			{
				String key_json = myRs.getString("n_nationkey");
				String  name_json = myRs.getString("n_name");
				String comment_json = myRs.getString("n_comment");
				//String id_json=result.getString("demo");
				JSONObject jObj = new JSONObject();
				jObj.put("id", key_json);
				jObj.put("name", name_json);
				jObj.put("comment", comment_json);
				//jObj.put("name", name_json);
				jArray.put(jObj);
			}
			System.out.println("============ Array ==============");
			try (FileWriter file = new FileWriter("C:/Users/Ilyess/Desktop/nation.json")) {

				file.write(jArray.toString());
				file.flush();

			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("============ END ==============");

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		function();
		//test();
	}

}
