package club.MCPC.shareTheWealthMC.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import club.MCPC.shareTheWealthMC.Main;

public class ItemListener implements Listener
{
	@SuppressWarnings("unused")
	private Main plugin;
	
	public ItemListener(Main plugin)
	{
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
}
