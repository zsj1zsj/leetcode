package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {

		if (intervals == null)
			return null;

		Comparator c = new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {

				if (o1.start == o2.start) {
					if (o1.end == o2.end)
						return 0;
					else if (o1.end > o2.end)
						return 1;
					else {
						return -1;
					}
				} else if (o1.start > o2.start) {
					return 1;
				} else {
					return -1;
				}
			}
		};

		Collections.sort(intervals, c);

		List<Interval> result = new ArrayList<>();

		for (Interval i : intervals) {
			if (result.isEmpty()) {
				result.add(i);
			} else {
				if (result.get(result.size() - 1).end >= i.start) {
					Interval newInt = result.get(result.size() - 1);
					newInt.end = Math.max(newInt.end, i.end);
				} else {
					result.add(i);
				}
			}
		}

		return intervals;

	}

	public static void main(String[] args) {

	}
}
