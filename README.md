![Logo](./docs/logo.png)
[![Build Status](https://travis-ci.org/HasseNasse/bion.svg?branch=master)](https://travis-ci.org/HasseNasse/bion)  
"flourished; to be in a vigorous state;"

# Architectural Decisions:
## Server Configuration Management 
  ```yaml
  sequenceDiagram  
      participant Bootstrap  
      participant ConfigHandler  
      participant ConfigBank  
      participant Config  
      participant FileConfigLoader  
      participant EnvConfigLoader  
      participant SystemConfigLoader

      ConfigBank->>Config: new Config(supplier)
      Config-->>ConfigBank: config
      Bootstrap->>ConfigHandler: get(ConfigBank.myConfig)
      ConfigHandler->>Config: getValue()
      Config->>ConfigBank: ConfigBank.ORDINAL.getValue()
      ConfigBank-->>Config: 100 | 300 | 500
      Config->>FileConfigLoader: get(String key)
      FileConfigLoader-->>Config: Optional.of(x)
      Config->>EnvConfigLoader: get(String key)
      EnvConfigLoader-->>Config: Optional.of(x)
      Config->>SystemConfigLoader: get(String key)
      SystemConfigLoader-->>Config: Optional.of(x)
      Config->>Config: setValue(x)
      Config-->>ConfigHandler: value
      ConfigHandler-->>Bootstrap: value
  ```
