package model;

public class Impuesto extends PedidoDecorator {
    private double porcentaje;

    public Impuesto(Pedido pedido, double porcentaje) {
        super(pedido);
        this.porcentaje = porcentaje;
    }

    @Override
    public double calcularTotal() {
        return super.calcularTotal() * (1 + porcentaje / 100);
    }

    @Override
    public String toString() {
        return super.toString() + " + Impuesto " + porcentaje + "%";
    }
}
