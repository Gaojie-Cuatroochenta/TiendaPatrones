package model;

public class Cliente {
	public void recibirNotificacion(Pedido p) {
		System.out.println("Confirmado pedido: " + p.getId() + " precio: " + p.getImporteFinal());
	}
}
