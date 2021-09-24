package me.LeSaR.morecommands.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.LeSaR.morecommands.Main;
import me.LeSaR.morecommands.completers.NullCompleter;

public class NetherCommand implements CommandExecutor{
	
	private Main plugin;
	
	public NetherCommand(Main plugin_){
		
		this.plugin = plugin_;
		
		plugin.getCommand("nether").setExecutor(this);
		
		plugin.getCommand("nether").setTabCompleter(new NullCompleter());
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if(!(sender instanceof Player)) return false;
		
		Player player = (Player) sender;
		
		Location nether = plugin.getServer().getWorld("world_nether").getSpawnLocation();
		
		player.teleport(nether);
		
		return true;
		
	}
	
}