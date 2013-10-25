package net.alxlre.customnpc.npc;

import java.io.File;
import java.util.logging.Level;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import net.alxlre.customnpc.utils.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class NPCParser {

	public static NPCData parse(File file) throws Exception {
		NPCData data = new NPCData();

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(file);
		Element main = (Element) doc.getElementsByTagName("npc").item(0);
		if (main == null){
			log("npc", file);
		}
		
		return data;
	}
	
	private static void log(String isnull, File file) {
		Log.log(Level.WARNING, isnull + " is null in:  " + file.getAbsolutePath());
	}

}
