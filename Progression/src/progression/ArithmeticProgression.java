package progression;

public class ArithmeticProgression extends AbstractProgression {

	protected long increment;

	// constructor de progresion 0, 1, 2,..
	public ArithmeticProgression() {
		this(1, 0); // inicializa en 0 con incremento en 1.
	}

	public ArithmeticProgression(long stepsize) {
		this(stepsize, 0); //  inicializa en 0
	}

	public ArithmeticProgression(long stepsize, long start) {
		super(start);
		increment = stepsize;
	}

	protected void advance() {
		current += increment;
	}

}
