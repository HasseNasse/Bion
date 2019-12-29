![Logo](./docs/logo.png)
[![Build Status](https://travis-ci.org/HasseNasse/bion.svg?branch=master)](https://travis-ci.org/HasseNasse/bion)  
**"flourished;"** -Greek poet.  
**"The bound state of two solitons(self-reinforcing wave packet that maintains its shape while it propagates at a constant velocity) is known as a bion"** - [Wikipedia](https://en.wikipedia.org/wiki/Soliton#Bions)

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

    Note right of SystemConfigLoader: Ordinal = 400
    Note right of EnvConfigLoader: Ordinal = 300
    Note right of FileConfigLoader: Ordinal = 100
    ConfigHandler->>SystemConfigLoader: SystemConfigLoader.INSTANCE
    SystemConfigLoader-->>ConfigHandler: that
    ConfigHandler->>EnvConfigLoader: EnvConfigLoader.INSTANCE
    EnvConfigLoader-->>ConfigHandler: that
    ConfigHandler->>FileConfigLoader: FileConfigLoader.INSTANCE
    FileConfigLoader-->>ConfigHandler: that
    Bootstrap->>ConfigHandler: get(String key)
    loop every loader until value is found
      ConfigHandler->>SystemConfigLoader: get(String key)
      SystemConfigLoader-->>ConfigHandler: Optional<?> value
      ConfigHandler->>EnvConfigLoader: get(String key)
      EnvConfigLoader-->>ConfigHandler: Optional<?> value
      ConfigHandler->>FileConfigLoader: get(String key)
      FileConfigLoader-->>ConfigHandler: Optional<?> value
    end
    ConfigHandler-->>Bootstrap: Optional<?> value
  ```
