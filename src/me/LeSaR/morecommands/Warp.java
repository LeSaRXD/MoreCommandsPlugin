package me.LeSaR.morecommands;

import org.bukkit.Location;
import org.bukkit.World;

public class Warp extends Location{
	
	public String name;
	
	public Warp(String name_, World world, double x, double y, double z){
		
		super(world, x, y, z);
		
		name = name_;
		
	}
	
	public Warp(String name_, Location loc){
		
		super(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ());
		
		name = name_;
		
	}
	
}