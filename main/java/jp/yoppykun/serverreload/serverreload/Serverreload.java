package jp.yoppykun.serverreload.serverreload;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Serverreload extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Pluginを有効にしました。");
        getCommand("sreload").setExecutor(this);
        super.onEnable();

    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0){
            sender.sendMessage("引数が足りません:reload,stop");
        } else {
            if (args[0].equalsIgnoreCase("reload")){
                if (args.length != 1) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kick @a "+args[1]);
                } else {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kick @a サーバーを再起動しています。");
                }


                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "reload confirm");
            } else if (args[0].equalsIgnoreCase("stop")){
                if (args.length != 1) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kick @a"+args[1]);
                } else {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kick @a サーバを停止しています。");
                }


                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "stop");
            } else {sender.sendMessage("引数が違います:reload,stop");}
        }
        return true;
    }
    @Override
    public void onDisable() {
        getLogger().info("Pluginを無効にしました。");
        super.onDisable();
    }
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (!command.getName().equalsIgnoreCase("sreload")) return super.onTabComplete(sender, command, alias, args);
        if (args.length == 1) {
            if (args[0].length() == 0) {
                return Arrays.asList("reload", "stop");
            } else {
                

                if ("reload".startsWith(args[0])) {
                    return Collections.singletonList("reload");
                } else if ("stop".startsWith(args[0])) {
                    return Collections.singletonList("stop");
                }
            }
        }

        return super.onTabComplete(sender, command, alias, args);
    }
    }
