# Chat Formatter

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
chat-format: "[{device_os}][{mc_version}][{ping}ms]<{player_name}> {message}"
join-message-format: '[§a+§f] {player_name}'
quit-message-format: '[§c-§f] {player_name}'
```

## Dependencies

- [PlaceholderAPI](https://github.com/AllayMC/PlaceholderAPI)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.