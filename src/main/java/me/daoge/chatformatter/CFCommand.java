package me.daoge.chatformatter;

import org.allaymc.api.command.Command;
import org.allaymc.api.command.tree.CommandTree;

import java.util.Locale;

/**
 * @author daoge_cmd
 */
public class CFCommand extends Command {

    public CFCommand() {
        super("chatformat", "The command of chat formatter", "chatformatter.command");
        this.aliases.add("cf");
    }

    @Override
    public void prepareCommandTree(CommandTree tree) {
        tree.getRoot()
                .enumClass("msgtype", MsgType.class)
                .str("format")
                .exec(ctx -> {
                    MsgType type = ctx.getResult(0);
                    String format = ctx.getResult(1);

                    var config = ChatFormatter.getInstance().getConfig();
                    switch (type) {
                        case CHAT -> config.chatFormat(format);
                        case JOIN -> config.joinMessageFormat(format);
                        case QUIT -> config.quitMessageFormat(format);
                    }
                    config.save();
                    ctx.getSender().sendMessage("[CF] Set " + type.name().toLowerCase(Locale.ROOT) + " message format to " + format);

                   return ctx.success();
                })
                .root()
                .key("reload")
                .exec(ctx -> {
                    ChatFormatter.getInstance().getConfig().load();
                    ctx.getSender().sendMessage("[CF] Config is reloaded");
                    return ctx.success();
                });
    }

    public enum MsgType {
        CHAT,
        JOIN,
        QUIT
    }
}
