package me.LeSaR.morecommands.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.LeSaR.morecommands.Main;
import me.LeSaR.morecommands.completers.NullCompleter;

public class EndCommand implements CommandExecutor{
	
	private Main plugin;
	
	public EndCommand(Main plugin_){
		
		this.plugin = plugin_;
		
		plugin.getCommand("end").setExecutor(this);
		
		plugin.getCommand("end").setTabCompleter(new NullCompleter());
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if(!(sender instanceof Player)) return false;
		
		Player player = (Player) sender;
		
		Location end = plugin.getServer().getWorld("world_the_end").getSpawnLocation();
		
		player.teleport(end);
		
		return true;
		
	}
	
}