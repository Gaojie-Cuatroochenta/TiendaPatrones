package controller;

import java.io.IOException;

import model.DatosOperacion;
import model.OpcionMenu;
import model.Pedido;
import view.VistaConsola;
import writer.PedidoFileWriter;

public class AppController {
	private PedidoController pc;
	private VistaConsola vista;
	private PedidoFileWriter pfw;
	
	public AppController(PedidoController pc, VistaConsola vista, PedidoFileWriter pfw) {
		this.pc = pc;
		this.vista = vista;
		this.pfw = pfw;
	}
	
	public boolean procesarOpcion(int op) {
		String id;
		switch(op) {
			case OpcionMenu.CREAR_PEDIDO_IMPORTE_BASE:
				id = vista.leerId();
				double imp = vista.leerImporte();
				pc.crearPedido(id, imp);
				return true;
			case OpcionMenu.APLICAR_OPERACION:
				DatosOperacion data = vista.leerDatosOperacion();
				boolean procesado = pc.procesarOperacion(data.getOperacion(), data.getId(), data.getCantidad());
				if (!procesado) {
					vista.mostrarMsgPedidoNoEncontrado();
				}
				return true;
			case OpcionMenu.CONFIRMAR_PEDIDO:
				id = vista.leerId();
				Pedido p = pc.obtenerPedidoPorId(id);
				if (p != null) {
					pc.confirmarPedido(p);
					try {
						pfw.guardarPedido(p);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				return true;
			case OpcionMenu.CERRAR:
				return false;
			default:
				vista.mostrarOpcionNoEncontrado();
				return true;
		}
	}
}
