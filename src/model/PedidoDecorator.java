package model;

import model.Pedido;

public abstract class PedidoDecorator extends Pedido {
    protected Pedido pedido;

    public PedidoDecorator(Pedido pedido) {
        super(pedido.getId(), pedido.getImporteBase());
        this.pedido = pedido;
    }

    @Override
    public double calcularTotal() {
        return pedido.calcularTotal();
    }

    @Override
    public String toString() {
        return pedido.toString();
    }
}