package figura;

public class TestFigura {
    public static void main(String[] args) {

        Punto p = new Punto(0, 0, 0);

        Figura[] figuras = new Figura[4];

        figuras[0] = new Circulo(p, 5);
        figuras[1] = new Rectangulo(p, 4, 6);
        figuras[2] = new Esfera(p, 3);
        figuras[3] = new PrimaRectangular(p, 2, 3, 4);

        for (Figura f : figuras) {
            System.out.println("Área: " + f.calcularArea());
            System.out.println("Perímetro: " + f.calcularPerimetro());
            System.out.println("Volumen: " + f.calcularVolumen());
            System.out.println("----------------------");
        }
    }
}