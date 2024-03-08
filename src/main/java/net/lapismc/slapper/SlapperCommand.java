package net.lapismc.slapper;

import net.lapismc.lapiscore.LapisCorePlugin;
import net.lapismc.lapiscore.commands.LapisCoreCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Random;

public class SlapperCommand extends LapisCoreCommand {

    protected SlapperCommand(LapisCorePlugin core) {
        super(core, "slap", "Slap a player in a random direction", new ArrayList<>());
    }

    @Override
    protected void onCommand(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            if (!sender.hasPermission("slapper.slap")) {
                sender.sendMessage(ChatColor.RED + "You are not permitted to slap!");
                return;
            }
        }
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Specify a player");
            return;
        }
        Player p = Bukkit.getPlayer(args[0]);
        if (p == null) {
            sender.sendMessage(ChatColor.RED + "Player is not online");
            return;
        }
        Vector currentVelocity = p.getVelocity();
        Random r = new Random();
        int newX = r.nextInt(10) * (r.nextBoolean() ? 1 : -1);
        int newY = p.isFlying() ? (r.nextInt(20) * (r.nextBoolean() ? 1 : -1)) : r.nextInt(10);
        int newZ = r.nextInt(10) * (r.nextBoolean() ? 1 : -1);
        currentVelocity.add(new Vector(newX, newY, newZ));
        p.setVelocity(currentVelocity);
        sender.sendMessage(ChatColor.GOLD + "Slapped " + p.getName());
    }
}
