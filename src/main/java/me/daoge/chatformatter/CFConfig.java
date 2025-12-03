package me.daoge.chatformatter;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.configs.annotation.CustomKey;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author daoge_cmd
 */
@Getter
@Setter
@Accessors(fluent = true)
public class CFConfig extends OkaeriConfig {
    @Comment("The format of chat")
    @CustomKey("chat-format")
    private String chatFormat = "<{player_name}> {message}";

    @Comment("The format of join message")
    @CustomKey("join-message-format")
    private String joinMessageFormat = "[§a+§f] {player_name}";

    @Comment("The format of quit message")
    @CustomKey("quit-message-format")
    private String quitMessageFormat = "[§c-§f] {player_name}";
}
