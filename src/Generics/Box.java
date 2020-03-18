package Generics;

public class Box<T> {

	private T content;

	public Box(T content) {
		this.content = content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public T getContent() {
		return this.content;
	}

	
	public static void main(String[] args) {

		Box<String> stringBox = new Box<>("HelloWorld");
		String s = stringBox.getContent();

		Box<Integer> integerBox = new Box<>(100);
		int i = integerBox.getContent();

		Box<Box<String>> nestedStringBox = new Box<>(stringBox);
		Box<String> content = nestedStringBox.getContent();
		String innerContent = content.getContent();
	}
}