package de.doridian.multibukkit.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@BaseCommand.Name("setlevel")
public class SetLevelCommand extends BaseCommand {
	@Override
	public boolean onCommandAll(final CommandSender commandSender, Command command, String s, String[] strings) throws Exception {
		final Player other = getPlayerSingle(strings[0]);
		final Integer level = Integer.parseInt(strings[1]);
		new Thread() {
			@Override
			public void run() {
				try {
					plugin.playerAPI.setLevel(other, level);
					commandSender.sendMessage("Level of player " + other.getName() + " set to " + level);
				} catch(Exception e) {
					commandSender.sendMessage("Error: " + e.getMessage());
					e.printStackTrace();
				}
			}
		}.start();
		return true;
	}
}