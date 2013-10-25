package net.alxlre.customnpc.behaviour;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

import org.bukkit.Bukkit;

public class Parser {

	private Set<String> keywords;
	private BufferedReader br;

	public Parser() {
		keywords = new HashSet<String>();
		keywords.add("teleport");
		keywords.add("chat");
	}

	public void parse(File file) throws IOException {
		br = new BufferedReader(new FileReader(file));
		String line;
		while ((line = br.readLine()) != null) {
			if (line.startsWith("(")) processControl(line);
			else processDirectCommand(line);
			br.close();
		}
	}

	private void processDirectCommand(String line) {
		String keyword = line.split("\"")[0].substring(1);
		if (!keywordsContainsString(keyword)) {
			Bukkit.getLogger().log(Level.SEVERE, "Could not identify keyword " + keyword);
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

	private void processControl(String line) {
		line = line.substring(1);
		if (!line.endsWith(")")) {
			Bukkit.getLogger().log(Level.SEVERE, "Could not find matching parantheses:\n" + line);
			interrupt();
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
		
		for (String s : keywords) {
			if (str == s) return true;
		}
		
		return false;
	}

	/*
	 * EXAMPLE BEHAVIOUR FILE 
	 * #repeat=true, time=10s 
	 * (start) 
	 * chat "Hello!"
	 * (wait 1000) 
	 * ($p = find "RainoBoy97") 
	 * chat "Hello '$p.name'!" 
	 * teleport $p.location 
	 * (end)
	 */

}
