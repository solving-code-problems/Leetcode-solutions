package other.firstbadversion;

public class VersionControl {
    private final int n = 4;
    public boolean isBadVersion(int x) {
        return x >= n;
    }
}
