package me.ItsMeeeh.MuteExtension;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MuteExtension
  extends JavaPlugin
  implements Listener
{
  public boolean globalmute = false;
  public List<String> muted = new ArrayList<String>();
  public List<String> freezed = new ArrayList<String>();
  
  public void onDisable()
  {
    super.onDisable();
  }
  
  public void onEnable()
  {
    Bukkit.getPluginManager().registerEvents(this, this);
    super.onEnable();
  }
  
  public void onLoad()
  {
    super.onLoad();
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if ((cmd.getName().equalsIgnoreCase("glm")) && 
      ((sender instanceof Player)) && 
      (sender.hasPermission("clearmychat.globalmute")))
    {
      @SuppressWarnings("unused")
	Player p = (Player)sender;
      if (this.globalmute)
      {
        this.globalmute = false;
        Bukkit.broadcastMessage(ChatColor.DARK_AQUA + "[MuteExtension] " + ChatColor.RED + "Globalmute is now off");
        return true;
      }
      if (!this.globalmute)
      {
        this.globalmute = true;
        Bukkit.broadcastMessage(ChatColor.DARK_AQUA + "[MuteExtension] " + ChatColor.RED + "Globalmute is now on");
        return true;
      }
      return true;
    }
    if ((cmd.getName().equalsIgnoreCase("mp")) && 
      ((sender instanceof Player)) && 
      (args.length == 1) && 
      (sender.hasPermission("clearmychat.mute.player")))
    {
      Player p = (Player)sender;
      try
      {
        Player t = Bukkit.getPlayer(args[0]);
        String target = t.getName();
        if (this.muted.contains(target))
        {
          p.sendMessage(ChatColor.DARK_AQUA + "[MuteExtension] " + ChatColor.RED + args[0] + " is no longer muted!");
          this.muted.remove(target);
          return true;
        }
        if (!this.muted.contains(target))
        {
          if (t.hasPermission("clearmychat.mute.ignore"))
          {
            p.sendMessage(ChatColor.DARK_AQUA + "[MuteExtension] " + ChatColor.RED + "you can't mute " + args[0]);
            return true;
          }
          this.muted.add(target);
          p.sendMessage(ChatColor.DARK_AQUA + "[MuteExtension] " + ChatColor.RED + args[0] + " is now muted!");
          return true;
        }
      }
      catch (NullPointerException err)
      {
        p.sendMessage(ChatColor.DARK_AQUA + "[MuteExtension] " + ChatColor.RED + args[0] + " is offline!");
        return true;
      }
    }
    return false;
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onChat(AsyncPlayerChatEvent eve)
  {
    if ((this.globalmute) && 
      (!eve.getPlayer().hasPermission("GlobalMute.ignore.globalmute"))) {
      eve.setCancelled(true);
    }
    if (this.muted.contains(eve.getPlayer().getName()))
    {
      eve.setCancelled(true);
      eve.getPlayer().sendMessage(ChatColor.DARK_AQUA + "[MuteExtension] " + ChatColor.RED + "You are muted, you can't Chat while you are muted!");
    }
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onCommand(PlayerCommandPreprocessEvent evt)
  {
    if (this.muted.contains(evt.getPlayer().getName()))
    {
      evt.setCancelled(true);
      evt.getPlayer().sendMessage(ChatColor.DARK_AQUA + "[MuteExtension] " + ChatColor.RED + "You are muted, you can't use Commands while you are muted!");
    }
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onMove(PlayerMoveEvent peve)
  {
    if (this.freezed.contains(peve.getPlayer().getName()))
    {
      peve.setCancelled(true);
      peve.getPlayer().sendMessage(ChatColor.DARK_AQUA + "[MuteExtension] " + ChatColor.RED + "You are freezed, you can't move while you are freezed!");
    }
  }
}
