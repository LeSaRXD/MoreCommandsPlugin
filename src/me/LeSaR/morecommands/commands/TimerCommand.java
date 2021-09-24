package me.LeSaR.morecommands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;

import me.LeSaR.morecommands.Main;
import me.LeSaR.morecommands.completers.NullCompleter;

public class TimerCommand implements CommandExecutor{
	
	private Main plugin;
	
	public TimerCommand(Main plugin_){
		
		this.plugin = plugin_;
		
		plugin.getCommand("timer").setExecutor(this);
		
		plugin.getCommand("timer").setTabCompleter(new NullCompleter());
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		int time;
		
		try{
			time = Integer.parseInt(args[0]);
		}catch(Exception e){
			return false;
		}
		
		if(time < 1) return false;
		
		sender.sendMessage("§6Timer has started!");
		
		new BukkitRunnable(){
			
			@Override
			public void run(){
				
				sender.sendMessage("§6Time's up!");
				
			}
			
		}.runTaskLater(plugin, (long) (time * 20L));
		
		return true;
		
	}
	
}