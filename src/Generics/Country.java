package Generics;

import java.util.Arrays;
import java.util.List;

public interface Country {

	public List<String> getLanguages();

	public static class Germany implements Country {

		@Override
		public List<String> getLanguages() {
			return Arrays.asList("German", "French");
		}
	}
	
	public static class France implements Country {

		@Override
		public List<String> getLanguages() {
			return Arrays.asList("French");
		}
	}
	
}
