package me.daoge.chatformatter;

import eu.okaeri.configs.ConfigManager;
import eu.okaeri.configs.yaml.snakeyaml.YamlSnakeYamlConfigurer;
import lombok.Getter;
import org.allaymc.api.plugin.Plugin;
import org.allaymc.api.registry.Registries;
import org.allaymc.api.server.Server;

public class ChatFormatter extends Plugin {

    @Getter
    protected static ChatFormatter instance;

    {
        instance = this;
    }

    @Getter
    protected CFConfig config;

    @Override
    public void onLoad() {
        this.pluginLogger.info("ChatFormatter loaded!");
    }

    @Override
    public void onEnable() {
        this.pluginLogger.info("ChatFormatter enabled!");
        this.config = ConfigManager.create(
                CFConfig.class,
                it -> {
                    it.withConfigurer(new YamlSnakeYamlConfigurer());
                    it.withBindFile(this.pluginContainer.dataFolder().resolve("config.yml"));
                    it.withRemoveOrphans(true);
                    it.saveDefaults();
                    it.load(true);
                }
        );
        Registries.COMMANDS.register(new CFCommand());
        Server.getInstance().getEventBus().registerListener(new CFListener());
    }

    @Override
    public void onDisable() {
        this.pluginLogger.info("ChatFormatter disabled!");
        this.config.save();
    }
}