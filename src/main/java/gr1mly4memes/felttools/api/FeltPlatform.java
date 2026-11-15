package gr1mly4memes.felttools.api;

/**
 * Platforms where Felt supports
 */
public enum FeltPlatform {
    VANILLA,
    FABRIC;

    private static FeltPlatform platform;

    public static void setPlatform(FeltPlatform platform) {
        if (FeltPlatform.platform != null) throw new IllegalStateException("Platform is already set!");
        if (platform == null) throw new IllegalArgumentException("Platform cannot be null!");
        FeltPlatform.platform = platform;
    }

    public static FeltPlatform current() {
        if (FeltPlatform.platform == null) throw new IllegalStateException("Version is not set!");
        return platform;
    }
}
