package me.ItsMeeeh.ClearGlobalChat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CGC extends JavaPlugin {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,String label, String[] args) {
		
		Player p = null;
		if(sender instanceof Player){
			p = (Player) sender;
		}
		
		
		if(cmd.getName().equalsIgnoreCase("CGC")){		
			if(p.hasPermission("clearmychat.global")){
				
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(ChatColor.DARK_AQUA + "[ClearGlobalChat] " + ChatColor.RED + "Everyone's Chat has been Cleared!");
				return true;
			} else {
				sender.sendMessage(ChatColor.DARK_RED + "You Are The Console. You Can't do that! :P");
				return true;
			}
		}
		
		
		
		return false;
	}
	
	
}
