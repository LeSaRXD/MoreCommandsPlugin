package me.LeSaR.morecommands.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.LeSaR.morecommands.Main;
import me.LeSaR.morecommands.completers.FirstArgNameCompleter;

public class GmsCommand implements CommandExecutor{
	
	private Main plugin;
	
	public GmsCommand(Main plugin_){
		
		this.plugin = plugin_;

		plugin.getCommand("gms").setExecutor(this);
		
		plugin.getCommand("gms").setTabCompleter(new FirstArgNameCompleter(plugin));
		
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
		
		player.setGameMode(GameMode.SURVIVAL);
		
		return true;
		
	}
	
}