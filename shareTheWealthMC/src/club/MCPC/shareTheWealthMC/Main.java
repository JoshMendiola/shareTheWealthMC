package club.MCPC.shareTheWealthMC;

import org.bukkit.plugin.java.JavaPlugin;

import club.MCPC.shareTheWealthMC.listeners.ItemListener;

public class Main extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		new ItemListener(this);
	}
}
