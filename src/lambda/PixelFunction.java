package lambda;

import java.awt.Color;

@FunctionalInterface
public interface PixelFunction {
	Color apply(int x, int y);
}
