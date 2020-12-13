package me.bluenitrox.lobby.manager;


import me.bluenitrox.all.Database;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ScoreboardManager {

    public static void setBoard(Player p) {
        //p.setDisplayName("§8[§6" + exp.getLevel(p.getUniqueId()) + "§8]§r " + p.getName());
        Scoreboard scoreboard = new Scoreboard();
        ScoreboardObjective obj = scoreboard.registerObjective("TEST", IScoreboardCriteria.b);
        obj.setDisplayName("§8« §c§lDemonMC §8»");
        PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(obj, 0);
        PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);

        ScoreboardScore a1 = new ScoreboardScore(scoreboard, obj, " ");
        ScoreboardScore a2 = new ScoreboardScore(scoreboard, obj, "§8● §7Coins");
        ScoreboardScore a11 = new ScoreboardScore(scoreboard, obj, "§8➝  §6" + Database.getCoins(p.getUniqueId()));
        ScoreboardScore a4 = new ScoreboardScore(scoreboard, obj, "  ");
        ScoreboardScore a5 = new ScoreboardScore(scoreboard, obj, "§8● §7Teamspeak");
        ScoreboardScore a12 = new ScoreboardScore(scoreboard, obj, "§8➝  §6DemonMC.eu");
        ScoreboardScore a6 = new ScoreboardScore(scoreboard, obj, "           ");
        ScoreboardScore a30 = new ScoreboardScore(scoreboard, obj, "§8● §7Website");
        ScoreboardScore a40 = new ScoreboardScore(scoreboard, obj, "§a§8➝  §6DemonMC.eu");
        ScoreboardScore a41 = new ScoreboardScore(scoreboard, obj, "    ");
        ScoreboardScore a7 = new ScoreboardScore(scoreboard, obj, "§8§m-------------");
        ScoreboardScore a8 = new ScoreboardScore(scoreboard, obj, "§8» §7IP: §c§lDemonMC.eu");
        //ScoreboardScore a3 = new ScoreboardScore(scoreboard, obj, "§9      ");
        a1.setScore(12);
        a2.setScore(11);
        a11.setScore(10);
        a4.setScore(9);
        a5.setScore(8);
        a12.setScore(7);
        a6.setScore(6);
        a30.setScore(5);
        a40.setScore(4);
        a41.setScore(3);
        a7.setScore(2);
        a8.setScore(1);
        //a3.setScore(0);
        PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(obj, 1);
        PacketPlayOutScoreboardScore pa1 = new PacketPlayOutScoreboardScore(a1);
        PacketPlayOutScoreboardScore pa2 = new PacketPlayOutScoreboardScore(a2);
        //PacketPlayOutScoreboardScore pa3 = new PacketPlayOutScoreboardScore(a3);
        PacketPlayOutScoreboardScore pa4 = new PacketPlayOutScoreboardScore(a4);
        PacketPlayOutScoreboardScore pa5 = new PacketPlayOutScoreboardScore(a5);
        PacketPlayOutScoreboardScore pa6 = new PacketPlayOutScoreboardScore(a6);
        PacketPlayOutScoreboardScore pa7 = new PacketPlayOutScoreboardScore(a7);
        PacketPlayOutScoreboardScore pa8 = new PacketPlayOutScoreboardScore(a8);
        PacketPlayOutScoreboardScore pa11 = new PacketPlayOutScoreboardScore(a11);
        PacketPlayOutScoreboardScore pa12 = new PacketPlayOutScoreboardScore(a12);
        PacketPlayOutScoreboardScore pa15 = new PacketPlayOutScoreboardScore(a30);
        PacketPlayOutScoreboardScore pa16 = new PacketPlayOutScoreboardScore(a40);
        PacketPlayOutScoreboardScore pa17 = new PacketPlayOutScoreboardScore(a41);
        sendPacket(removePacket, p);
        sendPacket(createPacket, p);
        sendPacket(display, p);
        sendPacket(pa1, p);
        sendPacket(pa2, p);
        //sendPacket(pa3,p);
        sendPacket(pa4, p);
        sendPacket(pa5, p);
        sendPacket(pa6, p);
        sendPacket(pa7, p);
        sendPacket(pa8, p);
        sendPacket(pa11, p);
        sendPacket(pa12, p);
        sendPacket(pa15, p);
        sendPacket(pa16, p);
        sendPacket(pa17, p);

    }

    private static void sendPacket(Packet packet, Player p) {
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
    }


}
