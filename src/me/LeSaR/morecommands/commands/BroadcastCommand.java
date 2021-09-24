package me.LeSaR.morecommands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.LeSaR.morecommands.Main;
import me.LeSaR.morecommands.completers.NullCompleter;

public class BroadcastCommand implements CommandExecutor{
	
	private Main plugin;
	
	public BroadcastCommand(Main plugin_){
		
		this.plugin = plugin_;
		
		plugin.getCommand("broadcast").setExecutor(this);
		
		plugin.getCommand("broadcast").setTabCompleter(new NullCompleter());
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		String message = String.join(" ", args);
		message = message.replaceAll("&", "§");
		
		plugin.getServer().broadcastMessage(message);
			
		return true;
		
	}
	
}