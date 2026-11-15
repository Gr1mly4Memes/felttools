package gr1mly4memes.felttools.api;

import org.bukkit.plugin.Plugin;

public interface FeltServer {

    /**
     * @see Felt#getVersion()
     */
    default FeltVersion getVersion() {
        return FeltVersion.current();
    }

    /**
     * @see Felt#registerModEvent(Plugin, Object, Object)
     * @since 1.6.2
     */
    void registerModEvent(Plugin plugin, Object eventBus, Object target);

    /**
     * @return ticking tracker
     * @see Felt#getTickingTracker()
     */
    TickingTracker getTickingTracker();
}
