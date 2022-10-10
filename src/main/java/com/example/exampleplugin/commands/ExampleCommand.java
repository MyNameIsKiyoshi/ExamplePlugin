package com.example.exampleplugin.commands;

import com.example.exampleplugin.*;
import com.example.exampleplugin.utils.*;
import net.minecraft.network.protocol.game.*;
import net.minecraft.server.level.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.craftbukkit.v1_19_R1.entity.*;
import org.bukkit.entity.*;

import javax.annotation.*;
import java.util.*;

public class ExampleCommand implements CommandExecutor, TabCompleter {

    /**
     * @name ExampleCommand
     * @desc When player do /examplecommand Make owosssssss ✨
     * @param sender Source of the command
     * @param command Command which was executed
     * @param label Alias of the command which was used
     * @param args Passed command arguments
     * @code {@link com.example.exampleplugin.commands.ExampleCommand}
     * @todo Go to src/main/resources and modify config.yml or en_US in /lang/en_US.yml
     * @return
     */
    @SuppressWarnings("ALL")
    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String label, @Nonnull String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(Format.color("You must be a player to execute this command."));
            return true;
        }

        Player player = (Player) sender;
        EntityPlayer ep = ((CraftPlayer)player).getHandle();
        PacketPlayOutEntityStatus status = new PacketPlayOutEntityStatus(ep, (byte) 35);

        if(player.isOp()){
            String exampleVariableFromConfig = Main.getInstance().getConfig().getString("ExampleVariable");
            player.sendMessage(Format.rgb(79, 56, 94, "&lStrange Purple!!! " + exampleVariableFromConfig));
            player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 100, 1);
            ep.b.a(status);
        } else {
            player.sendMessage(Format.color("&cYou mus be an Operator to execute this command. " + Message.ExampleMessageEN()));
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
        }

        return false;
    }
    @SuppressWarnings("SameParameterValue")
    private void a(List<String> s, String arg, String test) {
        if (test.startsWith(arg.toLowerCase()))
            s.add(test);
    }

    @SuppressWarnings("ALL")
    @Override
    public List<String> onTabComplete(CommandSender arg0, Command arg1, String arg2, String[] args) {
        List<String> s = new ArrayList<>();
        if(arg1.getName().equals("examplecommand")) {
            if(args.length == 1) {
                a(s, args[0], "I Like Kiyoshi");
                return s;
            }
        }
        return null;
    }
}
