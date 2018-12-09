package collection;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

class MySpliterator implements Spliterator<String> {
	int currentPos;
	final List<String> list;

	public MySpliterator(List<String> list) {
		this.list = list;
	}

	@Override
	public boolean tryAdvance(Consumer<? super String> action) {
		action.accept(list.get(currentPos++));
		return currentPos < list.size();
	}

	@Override
	public Spliterator<String> trySplit() {
		if (list.size() - currentPos < 3)
			return null;
		int currentSize = list.size() - currentPos;
		return new MySpliterator(list.subList(currentPos, currentSize/2+currentPos));
	}

	@Override
	public long estimateSize() {
		return list.size();
	}

	@Override
	public int characteristics() {
		return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
	}

}

public class TestSpliterator {
	public static void main(String[] args) {
		List<String> nameList = Arrays.asList("Ram", "Sheila", "Mukesh", "Rani", "Nick", "Amy", "Desi", "Margo");
		MySpliterator splitStr1 = new MySpliterator(nameList);
		MySpliterator splitStr2 = (MySpliterator) splitStr1.trySplit();

		splitStr1.forEachRemaining(System.out::println);
		System.out.println("-----------");
		splitStr2.forEachRemaining(System.out::println);

		System.out.println("--------------");

		Spliterator<String> splitStr3 = nameList.spliterator();
		Spliterator<String> splitStr4 = splitStr3.trySplit();
		splitStr3.forEachRemaining(System.out::println);
		System.out.println("--------------");
		splitStr4.forEachRemaining(System.out::println);
		
		
		System.out.println(4>>>1);

	}
}
