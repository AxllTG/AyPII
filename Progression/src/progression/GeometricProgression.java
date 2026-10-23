package progression;

public class GeometricProgression extends AbstractProgression {

	protected long base;

	// constructor Progression 1, 2, 4, 8...
	public GeometricProgression() {
		this(2, 1); // inicia en 1 con base 2;
	}

	// constructor de progresion geometrica 1, b, b^2, b^3, ... , por base b^n+1
	public GeometricProgression(long b) {
		this(b, 1); // inicia en 1.
	}

	// constructor de progresion geometrica con bases y inicios arbitrarios
	public GeometricProgression(long b, long start) {
		super(start);
		base = b;
	}

	protected void advance() {
		current *= base; // multiplica
	}

}
