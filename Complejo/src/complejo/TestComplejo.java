package complejo;

public class TestComplejo {

	public static void main(String[] args) {
		Complejo c1 = new Complejo(3,1);
		Complejo c2 = new Complejo(2,7);
		
		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2 + "\n");
		

		
		System.out.println("suma: " + c1.sumar(c2));
		System.out.println("resta: " + c1.restar(c2));
		
		
	}

}
