package algorithms;

public class FirstBadVersion {
	public int firstBadVersion(int n) {
		int start = 1, end = n;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (!isBadVersion(mid))
				start = mid + 1;
			else
				end = mid;
		}
		return start;
	}

	boolean isBadVersion(int n) {
		return true;
	}

	public static void main(String[] args) {
		FirstBadVersion fb = new FirstBadVersion();
		System.out.println(fb.firstBadVersion(5));
	}
}
