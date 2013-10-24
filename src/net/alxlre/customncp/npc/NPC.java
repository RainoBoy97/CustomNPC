package net.alxlre.customncp.npc;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public interface NPC {
	// Might need major reworking. This is how I imagined it.
	public void teleport(Player p);
	public void teleport(Location l);
	public void chat(String text);
	public void kill();
	public void damage(int damage);
	public void heal(int health);
	public int getHealth();
	public World getWorld();
	public String getName();
}
