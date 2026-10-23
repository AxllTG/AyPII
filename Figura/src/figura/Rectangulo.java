package figura;

public class Rectangulo extends FiguraBidimensional {

    private Punto esquina;
    private double base;
    private double altura;

    public Rectangulo(Punto esquina, double base, double altura) {
        this.esquina = esquina;
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }
}