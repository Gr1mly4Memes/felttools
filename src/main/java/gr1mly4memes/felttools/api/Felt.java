package gr1mly4memes.felttools.api;

import org.bukkit.plugin.Plugin;
import java.util.Objects;

public class Felt {

    private static FeltServer server;

    /**
     * Version info for current Felt
     */
    public static FeltVersion getVersion() {
        return getServer().getVersion();
    }

    /**
     * Register a mod event handler.
     *
     * @param target Either a {@link Class} instance or an arbitrary object.
     * @since 1.6.2
     */
    public static void registerModEvent(Plugin plugin, Object eventBus, Object target) {
        getServer().registerModEvent(plugin, eventBus, target);
    }

    /**
     * Gets the {@link TickingTracker} instance.
     *
     * @return the ticking tracker
     * @since 1.4.0
     */
    public static TickingTracker getTickingTracker() {
        return getServer().getTickingTracker();
    }

    /**
     * Get current platform Felt is running
     *
     * @return current platform
     * @since 1.6.0
     */
    public static FeltPlatform getPlatform() {
        return FeltPlatform.current();
    }

    private static FeltServer getServer() {
        return Objects.requireNonNull(server, "Server not set!");
    }

    /**
     * Internal api for Felt
     */
    public static void setServer(FeltServer server) {
        Objects.requireNonNull(server, "server");
        if (Felt.server != null) {
            throw new IllegalStateException("Server already set!");
        }
        Felt.server = server;
    }
}
