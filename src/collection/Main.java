package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		// HashMap<String, Integer> map = new HashMap<String, Integer>();
		// map.put("Alice", 555);
		// map.put("Mary", 2);
		//
		// map.merge("Alice", 33, Math::floorMod);
		//
		// map.forEach((k, v) -> System.out.println("k:" + k + " v:" + v));
		//
		// Stream.generate(Math::random).limit(100).forEach(System.out::println);
		// IntStream.range(1, 101).forEach(System.out::println);
		//
		// Arrays.asList(new String[] { "hello", "world" }).stream()
		// .map(s -> (s.substring(0, 1).toUpperCase() +
		// s.substring(1))).forEach(System.out::println);
		// Stream<String> temp = Arrays.asList(new String[] { "hello", "world"
		// }).stream();
		//
		List<String> list = Arrays.asList(new String[] { "hello", "world" });
		Stream.of(list).flatMap(x -> x.stream()).forEach(System.out::println);
		;
		//
		// test();
		//

		// long start = System.currentTimeMillis();
		// LongStream.iterate(0, i -> i + 1).filter(x -> new
		// BigInteger(String.valueOf(x)).isProbablePrime(1))
		// .limit(99999999999999L).forEach(System.out::println);
		// System.out.println(System.currentTimeMillis() - start);
		IntStream.iterate(1, i -> i + 3).limit(10).forEach(System.out::println);

		int[] a = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int i = 1; i < 1000; i++) {

		}

		int[] arr = { 1, 3, 8, 9, 6 };
		insertSort(arr);

		 new Random().ints().distinct().limit(10).boxed().collect(Collectors.toList()).stream().map(x->x%100).forEach(System.out::println);

	}

	public static void insertSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i - 1;
			for (; j >= 0 && array[j] > temp; j--) {
				// 将大于temp的值整体后移一个单位
				array[j + 1] = array[j];
			}
			array[j + 1] = temp;
		}

		System.out.println(Arrays.toString(array) + " insertSort");
	}

	public static void test() {
		// Stream<String>, GOOD!
		Arrays.stream(new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } }).flatMap(x -> Arrays.stream(x))
				.forEach(System.out::println);

	}

	public static Stream<String> letters(String s) {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			result.add(s.substring(i, i + 1));
		}
		return result.stream();
	}
}
