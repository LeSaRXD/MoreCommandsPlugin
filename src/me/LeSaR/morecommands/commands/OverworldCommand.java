package me.LeSaR.morecommands.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.LeSaR.morecommands.Main;
import me.LeSaR.morecommands.completers.NullCompleter;

public class OverworldCommand implements CommandExecutor{
	
	private Main plugin;
	
	public OverworldCommand(Main plugin_){
		
		this.plugin = plugin_;
		
		plugin.getCommand("overworld").setExecutor(this);
		
		plugin.getCommand("overworld").setTabCompleter(new NullCompleter());
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if(!(sender instanceof Player)) return false;
		
		Player player = (Player) sender;
		
		Location nether = plugin.getServer().getWorld("world").getSpawnLocation();
		
		player.teleport(nether);
		
		return true;
		
	}
	
}