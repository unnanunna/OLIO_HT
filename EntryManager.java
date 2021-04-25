package HT;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class EntryManager {
	
	/*private jtn Entry;
	
	public int getEntry(jtn Entry) {
		return jokuint;
	}
	
	public boolean saveEntry(jtn Entry) {
		return jokuboolean;
	}
	
	private boolean readEntries() {
		
	}*/
	private String waterAmount = "";
	private String vitaminAmount = "";
	private String formatedDay = "";
	//private String filename = "xmlFile.txt";
	private String filename = "FileInfo.txt";
	
	public void saveData(LocalDate date, int iwater, int vitamins) {
		waterAmount = String.valueOf(iwater);
		
		if (vitamins == 0) {
			vitaminAmount = "not taken";
		}
		else if (vitamins > 0) {
			vitaminAmount = "taken";
		}
		
		//formatedDay = date.format(DateTimeFormatter.ofPattern("dd.mm.yyyy"));
		formatedDay = date.toString();
		
		//https://examples.javacodegeeks.com/core-java/xml/parsers/documentbuilderfactory/create-xml-file-in-java-using-dom-parser-example/
		
		/*try {
			File file = new File(filename);
			if (file.createNewFile()) {
				System.out.println("Wörks");
			}
			else {
				System.out.println("On jo");
			}
		} catch (IOException e) {
			System.out.println("bröblem");
			e.printStackTrace();
		}*/
		
		try (FileWriter fw = new FileWriter(filename, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw))
		{
			out.println(formatedDay + ';' + waterAmount + ';' + vitaminAmount + '\n');
			//bw.write(formatedDay + ';' + waterAmount + ';' + vitaminAmount);
			//bw.close();
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
		}
		/*try (FileWriter fw = new FileWriter(filename, true);
				BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
		
		{
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            
            //root
            Element root = document.createElement("user");
            document.appendChild(root);
            
            //day
            Element day = document.createElement("day");
            day.appendChild(document.createTextNode(formatedDay));
            root.appendChild(day);
            
            //water amount
            Element water = document.createElement("water");
            water.appendChild(document.createTextNode(waterAmount));
            day.appendChild(water);
            
            //vitamin
            Element vitamin = document.createElement("vitamin");
            vitamin.appendChild(document.createTextNode(vitaminAmount));
            day.appendChild(water);
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(filename);
			
			transformer.transform(domSource, streamResult);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
	}
	
	public void readData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			
			System.out.println();
			String output = "";
			int length;
			//String[] parts = new String[3];
			while ((output = br.readLine()) != null) {
				//output = output.replace("\n", "");
				String[] parts = output.split(";", 3);
				length = output.length();
				if (length > 0) {
					System.out.println(parts[0] + " you had " + parts[1] + " ml water and had " + parts[2] + " your vitamins.");
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {	
		}
		
	}

}
