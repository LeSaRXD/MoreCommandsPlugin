package me.LeSaR.morecommands.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.LeSaR.morecommands.Main;

public class PlayerJoinListener implements Listener{
	
	private Main plugin;
	
	public PlayerJoinListener(Main plugin_){
		
		plugin = plugin_;
		
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
	}
	
	@EventHandler
	public void playerJoin(PlayerJoinEvent event){
		
		Player player = event.getPlayer();
		
		if(player == null) return;
		
		 if(player.hasPermission("server.players.seevanished")) return;
		
		for(Player invisible : plugin.invisiblePlayers) player.hidePlayer(plugin, invisible);
		
	}
	
}