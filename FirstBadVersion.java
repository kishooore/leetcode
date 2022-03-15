
public class FirstBadVersion extends VersionControl {

    public static void main(String[] args) {
        FirstBadVersion badVersion = new FirstBadVersion();
        int result = badVersion.firstBadVersion(2126753390);
        System.out.print(result);
    }

    private int firstBadVersion(int n) {
        int first = 1;
        int last = n;
        int badVersionSoFar = n;
        while ((last - first) > 1) {
            int mid = first + ((last - first) / 2);
            if (isBadVersion(mid)) {
                badVersionSoFar = mid;
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
        if (isBadVersion(last)) {
            badVersionSoFar = last;
        }
        if (isBadVersion(first)) {
            badVersionSoFar = first;
        }
        return badVersionSoFar;
    }
}

class VersionControl {
    boolean isBadVersion(int n) {
        if (n >= 1702766719) {
            return true;
        }
        return false;
    }
}
