package controller;

import model.Descuento;
import model.GastosEnvio;
import model.Impuesto;
import model.OpcionOperacion;
import model.Pedido;
import model.PedidoRepository;
import model.Recargo;
import event.EventManager;

public class PedidoController {
	private PedidoRepository repo;
	private EventManager em;
	
	public PedidoController(EventManager em, PedidoRepository repo) {
		this.em = em;
		this.repo = repo;
	}
	
	public boolean crearPedido(String id, double imp) {
		try {
			repo.guardar(new Pedido(id, imp));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean confirmarPedido(Pedido p) {
		try {
			em.notifyClientes(p);
			repo.borrar(p);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean procesarOperacion(int op, String id, double cantidad) {
		Pedido pedido = repo.buscarPorId(id);
		if (pedido != null) {
			switch(op) {
				case OpcionOperacion.APLICAR_DESCUENTO:
					pedido = new Descuento(pedido, cantidad);
					break;
				case OpcionOperacion.APLICAR_RECARGO:
					pedido = new Recargo(pedido, cantidad);
					break;
				case OpcionOperacion.PONER_GASTO_ENVIO:
					pedido = new GastosEnvio(pedido, cantidad);
					break;
				case OpcionOperacion.PONER_IMPUESTO:
					pedido = new Impuesto(pedido, cantidad);
					break;
			}
			repo.borrar(repo.buscarPorId(id));
			repo.guardar(pedido);
			return true;
		} else {
			return false;
		}
	}
	
	public Pedido obtenerPedidoPorId(String id) {
	    return repo.buscarPorId(id);
	}
}
