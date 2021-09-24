package me.LeSaR.morecommands.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.LeSaR.morecommands.Main;
import me.LeSaR.morecommands.completers.NullCompleter;

public class SpawnCommand implements CommandExecutor{
	
	private Main plugin;
	
	public SpawnCommand(Main plugin_){
		
		this.plugin = plugin_;
		
		plugin.getCommand("spawn").setExecutor(this);
		
		plugin.getCommand("spawn").setTabCompleter(new NullCompleter());
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if(!(sender instanceof Player)) return false;
		
		Player player = (Player) sender;
		
		Location spawn = player.getWorld().getSpawnLocation();
		
		player.teleport(spawn);
		
		return true;
		
	}
	
}