package model;

public class DatosOperacion {
	private int operacion;
	private String id;
	private double cantidad;
	
	public DatosOperacion(int operacion, String id, double cantidad) {
		this.operacion = operacion;
		this.id = id;
		this.cantidad = cantidad;
	}

	public int getOperacion() {
		return operacion;
	}

	public String getId() {
		return id;
	}

	public double getCantidad() {
		return cantidad;
	}
	
	
}
