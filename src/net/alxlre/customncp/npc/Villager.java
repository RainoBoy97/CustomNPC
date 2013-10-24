package net.alxlre.customncp.npc;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Villager implements NPC {
	
	private int health;

	@Override
	public void teleport(Player p) {
		
	}

	@Override
	public void teleport(Location l) {
		
	}

	@Override
	public void chat(String text) {
		
	}

	@Override
	public void kill() {
		
	}

	@Override
	public void damage(int damage) {
		health -= damage;
		if (health <= 0) kill();
	}

	@Override
	public void heal(int health) {
		this.health += health;
		if (this.health > 20) this.health = 20;
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public World getWorld() {
		return null;
	}

	@Override
	public String getName() {
		return null;
	}

}
