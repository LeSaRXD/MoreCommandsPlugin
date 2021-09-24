package me.LeSaR.morecommands.completers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class FirstArgCompleter implements TabCompleter{
	
	private List<String> list;
	
	public FirstArgCompleter(Set<String> list_){
		
		List<String> list_temp = new ArrayList<String>();
		
		for(String str : list_) list_temp.add(str);
		
		list = list_temp;
		
	}
	
	public FirstArgCompleter(List<String> list_){
		
		list = list_;
		
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(args.length != 1) return new ArrayList<String>();
		
		return list;
		
	}
	
}