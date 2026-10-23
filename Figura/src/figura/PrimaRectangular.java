package figura;

public class PrimaRectangular extends FiguraTridimensional {

    private Punto origen;
    private double largo;
    private double ancho;
    private double alto;

    public PrimaRectangular(Punto origen, double largo, double ancho, double alto) {
        this.origen = origen;
        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public double calcularArea() {
        return 2 * (largo*ancho + largo*alto + ancho*alto);
    }

    @Override
    public double calcularVolumen() {
        return largo * ancho * alto;
    }
}