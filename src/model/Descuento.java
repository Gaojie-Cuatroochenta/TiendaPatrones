package model;

public class Descuento extends PedidoDecorator {
    private double cantidad;

    public Descuento(Pedido pedido, double cantidad) {
        super(pedido);
        this.cantidad = cantidad;
    }

    @Override
    public double calcularTotal() {
        return super.calcularTotal() - cantidad;
    }

    @Override
    public String toString() {
        return super.toString() + " + Descuento " + cantidad;
    }
}