package me.daoge.chatformatter;

import org.allaymc.api.eventbus.EventHandler;
import org.allaymc.api.eventbus.event.player.PlayerChatEvent;
import org.allaymc.api.eventbus.event.server.PlayerQuitEvent;
import org.allaymc.api.eventbus.event.server.PlayerSpawnEvent;
import org.allaymc.papi.PlaceholderAPI;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author daoge_cmd
 */
public class CFListener {

    protected Map<UUID, String> chats;
    protected PlaceholderAPI papi;

    public CFListener() {
        this.chats = new ConcurrentHashMap<>();
        this.papi = PlaceholderAPI.getAPI();
        this.papi.registerPlaceholder(ChatFormatter.getInstance(), "message",
                (player, params) -> chats.getOrDefault(player.getUniqueId(), ""));
    }

    @EventHandler
    protected void onPlayerChat(PlayerChatEvent event) {
        var player = event.getPlayer();
        var message = event.getMessage();
        this.chats.put(player.getUniqueId(), message);
        event.setHeader("");
        event.setMessage(this.papi.setPlaceholders(player, ChatFormatter.getInstance().getConfig().chatFormat()));
    }

    @EventHandler
    protected void onPlayerSpawn(PlayerSpawnEvent event) {
        var player = event.getPlayer();
        event.setJoinMessage(this.papi.setPlaceholders(player.getControlledEntity(), ChatFormatter.getInstance().getConfig().joinMessageFormat()));
    }

    @EventHandler
    protected void onPlayerQuit(PlayerQuitEvent event) {
        var player = event.getPlayer();
        this.chats.remove(player.getLoginData().getUuid());
        event.setQuitMessage(this.papi.setPlaceholders(player.getControlledEntity(), ChatFormatter.getInstance().getConfig().quitMessageFormat()));
    }
}
