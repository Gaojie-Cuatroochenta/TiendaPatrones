package model;

public class Equipo {
	public void recibirNotificacion(Pedido p) {
		System.out.println("Confirmado pedido: " + p.getId() + " precio: " + p.calcularTotal());
	}
}
