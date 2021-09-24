package me.LeSaR.morecommands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.LeSaR.morecommands.Main;
import me.LeSaR.morecommands.completers.FirstArgNameCompleter;

public class SudoCommand implements CommandExecutor{
	
	Main plugin;
	
	public SudoCommand(Main plugin_){
		
		this.plugin = plugin_;
		
		plugin.getCommand("sudo").setExecutor(this);
		
		plugin.getCommand("sudo").setTabCompleter(new FirstArgNameCompleter(plugin));
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if(args.length < 2) return false;
		
		Player player = plugin.getServer().getPlayer(args[0]);
		
		if(player == null){
			
			sender.sendMessage("§4No such player");
			return false;
			
		}
		
		String message = "";
		
		for(int i = 1; i < args.length; i++) message += args[i] + " ";
		
		player.chat(message);
		
		return true;
		
	}
	
}