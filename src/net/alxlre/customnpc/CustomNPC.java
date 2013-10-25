package net.alxlre.customnpc;

import java.io.File;

import net.alxlre.customnpc.npc.NPCParser;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomNPC extends JavaPlugin {

	private static CustomNPC _i;

	public void onDisable() {

	}

	public void onEnable() {
		try {
			NPCParser.parse(new File(Bukkit.getWorldContainer(), "text.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onLoad() {
		CustomNPC._i = this;
	}

	public static CustomNPC get() {
		return CustomNPC._i;
	}

}
