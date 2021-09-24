package me.LeSaR.morecommands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.LeSaR.morecommands.Main;
import me.LeSaR.morecommands.completers.FirstArgNameCompleter;

public class EChestCommand implements CommandExecutor{
	
	private Main plugin;
	
	public EChestCommand(Main plugin_){
		
		this.plugin = plugin_;
		
		plugin.getCommand("echest").setExecutor(this);
		
		plugin.getCommand("echest").setTabCompleter(new FirstArgNameCompleter(plugin));
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player) && args.length == 0) return false;
		
		Player player;
		
		if(args.length >= 1){
			
			if(plugin.getServer().getPlayer(args[0]) == null){
				
				sender.sendMessage("§4No such player");
				return false;
				
			}
			
			player = plugin.getServer().getPlayer(args[0]);
			
		}else player = (Player) sender;
		
		if(player.getEnderChest() == null){
			
			sender.sendMessage("§4Player has no ender chest!");
			return true;
			
		}
		
		Inventory echest = player.getEnderChest();
		
		((Player) sender).openInventory(echest);
		
		return true;
		
	}
	
}