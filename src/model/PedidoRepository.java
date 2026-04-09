package model;

import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {
	private List<Pedido> pedidos = new ArrayList<>();
	
	public boolean guardar(Pedido p) {
		try {
			this.pedidos.add(p);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean borrarPorId(String id) {
	    Pedido pedido = buscarPorId(id);
	    return borrar(pedido);
	}
	
	public boolean borrar(Pedido p) {
		if (p != null) {
	        return pedidos.remove(p);
	    } else {
	        return false;
	    }
	}
	
	public Pedido buscarPorId(String id) {
		for (Pedido pedido : pedidos) {
			if (pedido.getId().equals(id)) {
				return pedido;
			}
		}
		return null;
	}
}
