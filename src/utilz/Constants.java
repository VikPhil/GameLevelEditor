package utilz;

public class Constants {

	public static class WindowConstants {
		public static final int DEFAULT_TALE = 64;
		public static final float SCALE = 1.0f;
		public static final int SIZE_IN_WIDTH = 24;
		public static final int SIZE_IN_HEIGHT = 12;
		public static final int SIZE = (int) (DEFAULT_TALE * SCALE);
		public static final int EDITOR_WIDTH = (int) (SIZE * SIZE_IN_WIDTH);
		public static final int EDITOR_HEIGHT = (int) (SIZE * SIZE_IN_HEIGHT);
		public static final int TALE_COUNT = 6;
		public static final int WIDTH_RIGHT_BAR = EDITOR_WIDTH - DEFAULT_TALE * TALE_COUNT;
	}
}
