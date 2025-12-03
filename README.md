# Chat Formatter

![img.png](img.png)

A simple chat formatter plugin for Allay

## Features

- Custom format for chat/join/quit messages
- Support PlaceholderAPI
- Added PAPI variable `{message}` which represents the last message the player sent

## Command

- `/chatformat` or `/cf`
- `/cf [chat|join|quit] <format>` to set the format for chat/join/quit messages
- `/cf reload` to reload 

## Config Example

`config.yml`:
```yml
chat-format: '[§a{device_os}§r][§b{mc_version}§r][§d{ping}ms§r]<{player_name}> {message}'
join-message-format: '[§a+§r] {player_name}'
quit-message-format: '[§c-§r] {player_name}'
```

## Dependencies

- [PlaceholderAPI](https://github.com/AllayMC/PlaceholderAPI)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.