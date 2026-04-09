package model;

public class Recargo extends PedidoDecorator {
    private double cantidad;

    public Recargo(Pedido pedido, double cantidad) {
        super(pedido);
        this.cantidad = cantidad;
    }

    @Override
    public double calcularTotal() {
        return super.calcularTotal() + cantidad;
    }

    @Override
    public String toString() {
        return super.toString() + " + Recargo " + cantidad;
    }
}