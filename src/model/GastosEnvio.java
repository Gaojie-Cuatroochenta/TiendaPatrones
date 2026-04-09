package model;

public class GastosEnvio extends PedidoDecorator {
    private double cantidad;

    public GastosEnvio(Pedido pedido, double cantidad) {
        super(pedido);
        this.cantidad = cantidad;
    }

    @Override
    public double calcularTotal() {
        return super.calcularTotal() + cantidad;
    }

    @Override
    public String toString() {
        return super.toString() + " + Gastos de envío " + cantidad;
    }
}