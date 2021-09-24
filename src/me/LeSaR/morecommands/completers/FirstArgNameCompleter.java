package me.LeSaR.morecommands.completers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import me.LeSaR.morecommands.Main;

public class FirstArgNameCompleter implements TabCompleter{
	
	Main plugin;
	
	public FirstArgNameCompleter(Main plugin_){
		
		plugin = plugin_;
		
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(args.length != 1) return new ArrayList<String>();
		
		List<String> names = new ArrayList<String>();
		
		for(Player online : plugin.getServer().getOnlinePlayers()) names.add(online.getName());
		
		return names;
		
	}
	
}