package com.yiorno.consolemsg;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.CommandBlock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class ConsoleMsg extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if(cmd.getName().equalsIgnoreCase("consolemsg")){

            //if(!(sender instanceof CommandBlock) && !(sender instanceof ConsoleCommandSender)){
            //    sender.sendMessage("コマンドブロックから実行してください");
            //    return true;
            //}

            Player p;

            if(args.length != 0) {

                String receiver = args[0];
                p = Bukkit.getServer().getPlayer(receiver);

                //sender.sendMessage("1");


                if (p!=null) {

                    String msg = null;

                    for (int i = 1; i < args.length; i++){

                        if(i == 1){

                            msg = args[1];

                        } else {

                            msg = msg + " " + args[i];

                        }
                    }


                    String newMsg = ChatColor.translateAlternateColorCodes('&', msg);
                    p.sendMessage(newMsg);

                    //sender.sendMessage("2");

                }
            }
        }

        return false;
    }
}
