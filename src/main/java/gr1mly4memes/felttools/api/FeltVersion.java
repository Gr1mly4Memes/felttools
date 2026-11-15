package gr1mly4memes.felttools.api;

import java.util.Objects;

public class FeltVersion {

    /** Minecraft 26.3. */
    public static final FeltVersion V26_3 = new FeltVersion("26.3", 26300, "");

    private final String name;
    private final int num;
    private final String pkg;
    private final String releaseName;

    public FeltVersion(String name, int num, String pkg) {
        this(name, num, pkg, null);
    }

    public FeltVersion(String name, int num, String pkg, String releaseName) {
        this.name = name;
        this.num = num;
        this.pkg = pkg;
        this.releaseName = releaseName;
    }

    public String getName() {
        return name;
    }

    public String packageName() {
        return pkg;
    }

    public String getReleaseName() {
        return releaseName;
    }

    @Override
    public String toString() {
        return "FeltVersion{" +
            "name='" + name + '\'' +
            ", num=" + num +
            ", releaseName='" + releaseName + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeltVersion that = (FeltVersion) o;
        return num == that.num &&
            Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, num);
    }

    private static FeltVersion version;

    public static FeltVersion current() {
        if (FeltVersion.version == null) throw new IllegalStateException("Version is not set!");
        return version;
    }

    public static void setVersion(FeltVersion version) {
        if (FeltVersion.version != null) throw new IllegalStateException("Version is already set!");
        if (version == null) throw new IllegalArgumentException("Version cannot be null!");
        FeltVersion.version = version;
    }

    public static boolean atLeast(FeltVersion v) {
        return v.num <= version.num;
    }

    public static boolean lesserThan(FeltVersion v) {
        return v.num > version.num;
    }
}
