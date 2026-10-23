package figura;
public class Esfera extends FiguraTridimensional {

    private Punto centro;
    private double radio;

    public Esfera(Punto centro, double radio) {
        this.centro = centro;
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return 4 * Math.PI * radio * radio;
    }

    @Override
    public double calcularVolumen() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
    }
}
