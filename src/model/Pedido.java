package model;

public class Pedido {
	private String id;
	private double importeBase;
	private double importeFinal;
	private double impuesto;
	private double gastoEnvio;
	private double descuento;
	private double recargo;
	
	public Pedido(String id, double impBase) {
		this.id = id;
		this.importeBase = impBase;
	}

	public String getId() {
		return id;
	}

	public double getImporteBase() {
		return importeBase;
	}

	public double getImporteFinal() {
		importeFinal = (importeBase + this.gastoEnvio + this.recargo - this.descuento) * (1 + this.impuesto/100);
		return importeFinal;
	}

	public double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}

	public double getGastoEnvio() {
		return gastoEnvio;
	}
	
	public void setGastoEnvio(double gastoEnvio) {
		this.gastoEnvio = gastoEnvio;
	}
	
	
	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public double getRecargo() {
		return recargo;
	}

	public void setRecargo(double recargo) {
		this.recargo = recargo;
	}

	@Override
	public String toString() {
	    return String.format("%s;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f",
	            id,
	            importeBase,
	            getImporteFinal(),
	            impuesto,
	            gastoEnvio,
	            descuento,
	            recargo
	    );
	}
}
