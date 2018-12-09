package lambda;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

import PO.Employee;

public class constructorref {
	static AtomicInteger count = new AtomicInteger(0);

	public static void main(String[] args) {
		List<String> names = Arrays.asList(new String[] { "zsj", "wjh", "zym" });

		names.stream().map(Employee::new).forEach(System.out::println);
		
		List<Employee> employees = names.stream().map(Employee::new).collect(Collectors.toList());

		repeat(10, i -> System.out.println("Countdown:" + (9 - i)));

		BufferedImage frenchFlag = createImage(150, 100,
				(x, y) -> x < 50 ? Color.blue : x < 100 ? Color.white : Color.red);

//		for (int i = 0; i <= 100; i++) {
//			new Thread(() -> {
//				System.out.println("hello:" + count);
//				count.incrementAndGet();
//			}).start();
//		}
		
		Collections.sort(names,(x,y)->x.compareTo(y));
		Collections.sort(employees,(x,y)->x.getName().compareTo(y.getName()));
		
		employees.forEach(System.out::println);
		
	}

	public static BufferedImage createImage(int width, int height, PixelFunction f) {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++) {
				Color color = f.apply(x, y);
				image.setRGB(x, y, color.getRGB());
			}
		return image;
	}

	public static void repeat(int n, IntConsumer action) {
		for (int i = 0; i < n; i++)
			action.accept(i);
	}
}
