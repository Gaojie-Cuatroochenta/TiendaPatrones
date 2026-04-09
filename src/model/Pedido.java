package model;

public class Pedido {
    private String id;
    private double importeBase;

    public Pedido(String id, double importeBase) {
        this.id = id;
        this.importeBase = importeBase;
    }

    public String getId() {
        return id;
    }

    public double getImporteBase() {
        return importeBase;
    }

    public double calcularTotal() {
        return importeBase;
    }

    @Override
    public String toString() {
        return "Pedido " + id + ": Importe base " + String.format("%.2f", importeBase);
    }
}