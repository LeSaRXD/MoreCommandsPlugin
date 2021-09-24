package me.LeSaR.morecommands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.LeSaR.morecommands.commands.*;
import me.LeSaR.morecommands.listeners.*;

public class Main extends JavaPlugin{
	
	public List<Player> invisiblePlayers = new ArrayList<Player>();
	
	public Map<String, Location> warps = new HashMap<String, Location>();
	
	@Override
	public void onEnable(){
		
		//commands
		
		new GmcCommand(this);
		new GmsCommand(this);
		
		new SpawnCommand(this);
		new NetherCommand(this);
		new OverworldCommand(this);
		new EndCommand(this);
		
		new BroadcastCommand(this);
		
		new EChestCommand(this);
		
		new VanishCommand(this);
		
		new TimerCommand(this);
		new BCTimerCommand(this);
		
		new SudoCommand(this);
		
		
		
		//listeners
		
		new PlayerJoinListener(this);
		
	}
	
}