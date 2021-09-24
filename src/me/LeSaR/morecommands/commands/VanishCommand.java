package me.LeSaR.morecommands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.LeSaR.morecommands.Main;
import me.LeSaR.morecommands.completers.FirstArgNameCompleter;

public class VanishCommand implements CommandExecutor{
	
	private Main plugin;
	
	public VanishCommand(Main plugin_){
		
		plugin = plugin_;
		
		plugin.getCommand("vanish").setExecutor(this);
		
		plugin.getCommand("vanish").setTabCompleter(new FirstArgNameCompleter(plugin));
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

		if(!(sender instanceof Player) && args.length == 0) return false;
		
		Player player;
		
		if(args.length >= 1){
			
			player = plugin.getServer().getPlayer(args[0]);
			
			if(player == null){
				
				sender.sendMessage("§4No such player");
				return false;
				
			}
		
		}else player = (Player) sender;
		
		if(plugin.invisiblePlayers.remove(player)){
			
			sender.sendMessage("§6Made " + player.getName() + " visible!");
			
			for(Player online : plugin.getServer().getOnlinePlayers()) online.showPlayer(plugin, player);
			
		}else{
			
			plugin.invisiblePlayers.add(player);
			
			sender.sendMessage("§6Made " + player.getName() + " invisible!");
			
			for(Player online : plugin.getServer().getOnlinePlayers()) if(!online.hasPermission("server.players.seevanished")) online.hidePlayer(plugin, player);
			
		}
		
		return true;
		
	}
	
}