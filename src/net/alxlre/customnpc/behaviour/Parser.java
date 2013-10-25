package net.alxlre.customnpc.behaviour;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

import net.alxlre.customnpc.utils.Log;

import org.bukkit.Bukkit;

public class Parser {

	private Set<String> commandKeywords;
	private Set<String> controlKeywords;
	private BufferedReader br;
	private boolean isHeaderParsed = false;

	public Parser() {
		commandKeywords = new HashSet<String>();
		controlKeywords = new HashSet<String>();
		commandKeywords.add("teleport");
		commandKeywords.add("chat");
	}

	public void parse(File file) throws IOException {
		br = new BufferedReader(new FileReader(file));
		String line;
		while ((line = br.readLine()) != null) {
			if (!isHeaderParsed) {
				processHeader(line, file);
				isHeaderParsed = true;
			}
			if (line.startsWith("(")) processControl(line, file);
			else processDirectCommand(line, file);
			br.close();
		}
	}

	private void processHeader(String line, File file) {
		if (!line.startsWith("#")) {
			Log.log(Level.SEVERE, "Unknown header in file " + file.getName());
			interrupt();
		}
	}

	private void processDirectCommand(String line, File file) {
		String keyword = line.split("\"")[0].substring(1);
		if (!keywordsContainsString(keyword)) {
			Log.log(Level.SEVERE, "Could not identify keyword " + keyword + "in file " + file.getName());
			interrupt();
		}
		
		switch (keyword) {
		case "teleport":
			//Teleport
			break;
		case "chat":
			//Chat
			break;
		}
	}

	private void processControl(String line, File file) {
		line.substring(1);
		if (!line.endsWith(")")) {
			Log.log(Level.SEVERE, "Could not find matching parantheses in file " + file.getName() + " on line:\n" + line);
			interrupt();
		}
		
		line = line.substring(line.length(), line.length() - 1);
		
		if (controlKeywordsContainsString(line.substring(line.length(), line.indexOf(' ')))) {
			
		}
	}
	
	public void interrupt() {
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean keywordsContainsString(String str) {
		
		for (String s : commandKeywords) {
			if (str == s) return true;
		}
		
		return false;
	}
	
private boolean controlKeywordsContainsString(String str) {
		
		for (String s : controlKeywords) {
			if (str == s) return true;
		}
		
		return false;
	}

	/*
	 * EXAMPLE BEHAVIOUR FILE 
	 * #repeat=true, pause=10s 
	 * (start) 
	 * chat "Hello!"
	 * (wait 1000) 
	 * ($p = find "RainoBoy97") 
	 * chat "Hello '$p.name'!" 
	 * teleport $p.location 
	 * (end)
	 */

}
