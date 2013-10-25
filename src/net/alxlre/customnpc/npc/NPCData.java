package net.alxlre.customnpc.npc;

import org.bukkit.inventory.ItemStack;

public class NPCData {

	protected String name;
	protected double health;
	protected double damage;
	
	//0 - helmet, 1 - chestplate, 2 - leggings, 3 - boots, 4 - in hand
	protected ItemStack[] equipment;
	
}
