# Refined Storage NeoForge 26.3 Port

This source tree targets NeoForge only. Fabric platform modules, Fabric API integration, Fabric JEI integration, and Fabric Loom build configuration are not included.

## Target versions

- Minecraft `26.3`
- NeoForm `26.3-1`
- NeoForge `26.3.0.4-beta`
- Java `25`
- JEI `31.0.0.5`
- ModDevGradle `2.0.147`

## NeoForge modules

- `refinedstorage-neoforge`
- `refinedstorage-neoforge-api`
- `refinedstorage-jei-integration-neoforge`

Shared common and API modules remain part of the project because the NeoForge implementation depends on them.

## Build

On Windows, from the project root:

```powershell
.\gradlew.bat :refinedstorage-neoforge:build
```

To build the JEI integration as well:

```powershell
.\gradlew.bat :refinedstorage-neoforge:build :refinedstorage-jei-integration-neoforge:build
```

Built JAR files are written to each module's `build\libs` directory.

## Development client

```powershell
.\gradlew.bat :refinedstorage-neoforge:runClient
```

For the JEI integration development client:

```powershell
.\gradlew.bat :refinedstorage-jei-integration-neoforge:runClient
```
