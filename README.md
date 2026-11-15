# felttools

API and utility classes for Fabric hybrid server development, plus a set of custom Mixin
annotations and injectors that go beyond what stock Mixin offers.

## What's inside

- **`api`** - the hybrid-server SPI: `Felt`, `FeltServer`, `FeltVersion`, `TickingTracker`,
  and `PluginPatcher`.
- **`mixin`** - custom injection annotations: `@Decorate`, `@Eject`, `@Local`,
  `@InlineField`, `@InlineMethod`, `@RenameInto`, `@TransformAccess`, `@CreateConstructor`,
  `@ShadowConstructor`, plus the `MixinTools` entry point that wires the injectors and
  post-mixin processors.
- **`mixin/ap`** - the `EjectProvider` annotation processor.
- **`func` / `product` / `collection`** - arity-0..22 function interfaces, immutable tuples,
  typed maps, and bidirectional collection views.
- **`util`** - `Unsafe` wrapper, runtime enum injection (`EnumHelper`, `FeltDynamEnum`),
  `Blackhole` (JIT-defeating sinks), and small collection/array helpers.

## Usage

Via [JitPack](https://jitpack.io) - builds straight from this repo, no Maven publishing needed:

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
dependencies {
    implementation 'com.github.gr1mly4memes:felttools:v1.0.1'
}
```

Or as a git submodule / composite build if you want to hack on it locally.

The mixin annotations and processors are picked up automatically through
`META-INF/services/javax.annotation.processing.Processor` - no extra configuration needed.

## Requirements

- Java 25
- `net.fabricmc:sponge-mixin` on the classpath at runtime (compile-only dependency here)
- Guava, json-simple and spigot-api are `compileOnly`; you only need them if you use the
  classes that reference them (e.g. `InlineFieldProcessor` uses Guava)

## Credits

This project is built on the work of:

- [ArclightPowered/api](https://github.com/ArclightPowered/api) - the original Arclight API
  and mixin tooling this started from
- [IzzelAliz/tools](https://github.com/IzzelAliz/tools) - the upstream tools repository
- [MohistMC/Tools](https://github.com/MohistMC/Tools) - related hybrid-server tooling