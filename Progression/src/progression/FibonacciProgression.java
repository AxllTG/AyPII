package progression;

public class FibonacciProgression extends AbstractProgression {

	protected long prev;

	public FibonacciProgression() {
		this(0, 1); // inicializa de manera default
	}

	public FibonacciProgression(long first, long second) {
		super(first);
		prev = second - first;
	}

	protected void advance() {
		long temp = prev;
		prev = current;
		current += temp;
	}

}
