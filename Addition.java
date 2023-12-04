import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Addition {
	// Return a list of the integers in [a, b)
	public static ArrayList<Integer> range(int a, int b) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = a; i < b; ++i) {
			result.add(i);
		}
		return result;
	}

	public static void main(String[] args) {
		ArrayList<Integer> range1 = Addition.range(50, 54);
		List<Integer> expected = Arrays.asList(new Integer[]{50, 51, 52, 53});

		assert range1.size() == expected.size();
		for (int i = 0; i < range1.size(); ++i) {
			assert range1.get(i) == expected.get(i);
		}

		ArrayList<Integer> range2 = Addition.range(50000, 50004);
		List<Integer> expected2 = Arrays.asList(new Integer[]{50000, 50001, 50002, 50003});

		assert range2.size() == expected2.size();
		for (int i = 0; i < range2.size(); ++i) {
			int a = range2.get(i);
			int b = expected2.get(i);
			// System.out.format("%d %d %d\n", i, range2.get(i), expected2.get(i));
			assert a == b;
		}
	}
}
