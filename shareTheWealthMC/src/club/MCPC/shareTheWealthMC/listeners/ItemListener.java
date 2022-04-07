package club.MCPC.shareTheWealthMC.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import club.MCPC.shareTheWealthMC.Main;



public class ItemListener implements Listener
{
	@SuppressWarnings("unused")
	private Main plugin;
	private ArrayList<ItemStack> valuableList = new ArrayList<ItemStack>(); 
	
	public ItemListener(Main plugin)
	
	{
		
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
		//valuableList
		valuableList.add(new ItemStack(Material.DIAMOND));
		valuableList.add(new ItemStack(Material.EMERALD));
		valuableList.add(new ItemStack(Material.IRON_INGOT));
		valuableList.add(new ItemStack(Material.GOLD_INGOT));
		valuableList.add(new ItemStack(Material.GOLDEN_APPLE));
		valuableList.add(new ItemStack(Material.DIAMOND_HORSE_ARMOR));
		valuableList.add(new ItemStack(Material.SADDLE));
		valuableList.add(new ItemStack(Material.NAME_TAG));
	}
	
	
	@EventHandler
	public void onValuableItemPick(EntityPickupItemEvent p)
	{
		Item placeholder = p.getItem();
		ItemStack valuable = placeholder.getItemStack();
		if(!(p.getEntity() instanceof Player))
		{
			return;
		}
		
		if(valuableList.contains(valuable)) 
		{
		Player adamSmith = (Player) p.getEntity();
		adamSmith.getInventory().remove(valuable);
		adamSmith.sendMessage("You have been greedy... Pay the tax");
		List<Player> playersOnline = new ArrayList<>(Bukkit.getOnlinePlayers());
		Random randomizer = new Random();
		Player communist = playersOnline.get(randomizer.nextInt(playersOnline.size()));
		communist.getInventory().addItem(valuable);
		communist.sendMessage("You have been gifted by the taxman");
		}
	}
}





