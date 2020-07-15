package de.jeff_media.InvUnload;

import org.bukkit.ChatColor;

public class Messages {
	Main plugin;

	final String PREFIX, MSG_COULD_NOT_UNLOAD, MSG_RADIUS_TOO_HIGH, MSG_NOT_A_NUMBER, MSG_NO_CHESTS_NEARBY, MSG_INVENTORY_EMPTY, MSG_NOTHING_FOUND;
final String BL_ADDED1, BL_ADDED2, BL_ALREADYADDED1, BL_ALREADYADDED2, BL_INVALID1, BL_INVALID2, BL_REMOVED1, BL_REMOVED2, BL_NOTTHERE1, BL_NOTTHERE2,BL_NOTHINGSPECIFIED;

	Messages(Main plugin) {
		this.plugin = plugin;
		
		PREFIX = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("message-prefix"));

		MSG_COULD_NOT_UNLOAD = PREFIX + ChatColor.translateAlternateColorCodes('&', plugin.getConfig()
				.getString("message-could-not-unload", "&7Nothing to unload: There are no chests for the remaining items."));
		
		MSG_RADIUS_TOO_HIGH = PREFIX + ChatColor.translateAlternateColorCodes('&', plugin.getConfig()
				.getString("message-radius-too-high","&cError:&7 The radius cannot be higher than %d blocks."));
		
		MSG_NOT_A_NUMBER = PREFIX + ChatColor.translateAlternateColorCodes('&', plugin.getConfig()
				.getString("message-error-not-a-number", "&cError:&7 '%s' is not a valid number."));
		
		MSG_NO_CHESTS_NEARBY = PREFIX+ ChatColor.translateAlternateColorCodes('&', plugin.getConfig()
				.getString("message-no-chests-nearby","&7Nothing to unload: There are no chests nearby. Adjust the radius or walk closer to your chests."));
		
		MSG_INVENTORY_EMPTY = PREFIX+ ChatColor.translateAlternateColorCodes('&', plugin.getConfig()
				.getString("message-inventory-empty","&7Nothing to unload: Your inventory is already empty."));

		MSG_NOTHING_FOUND = PREFIX+ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("message-nothing-found","&7Could not find any chests containing %s."));

		BL_ADDED1=ChatColor.GREEN+"%s has been added to your blacklist.";
		BL_ADDED2=ChatColor.GREEN+"%d materials have been added to your blacklist.";
		BL_ALREADYADDED1=ChatColor.YELLOW+"%s already was on your blacklist.";
		BL_ALREADYADDED2=ChatColor.YELLOW+"%d materials already were on your blacklist.";
		BL_INVALID1=ChatColor.RED+"%s is not a valid materials.";
		BL_INVALID2=ChatColor.RED+"%d materials were invalid.";

		BL_REMOVED1=ChatColor.GREEN+"%s has been removed from your blacklist.";
		BL_REMOVED2=ChatColor.GREEN+"%d materials have been removed from your blacklist.";
		BL_NOTTHERE1=ChatColor.YELLOW+"%s was not on your blacklist.";
		BL_NOTTHERE2=ChatColor.YELLOW+"%d materials were not on your blacklist.";

		BL_NOTHINGSPECIFIED=ChatColor.GRAY+"You must either hold an item in your hand or specify at least material as parameter.";
	}
}
