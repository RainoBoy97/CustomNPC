package net.alxlre.customnpc.utils;

import java.util.logging.Level;

import net.alxlre.customnpc.CustomNPC;

public class Log {

	private static CustomNPC cnpc;

	static {
		Log.cnpc = CustomNPC.get();
	}

	public static void log(String... msgs) {
		log(Level.INFO, msgs);
	}

	public static void log(Level lvl, String... msgs) {
		for (String msg : msgs) {
			cnpc.getLogger().log(lvl, msg);
		}
	}

	public static void log(Exception e) {
		log(Level.WARNING, e.getMessage());
		e.printStackTrace();
	}

}