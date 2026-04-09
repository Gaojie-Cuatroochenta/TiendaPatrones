package view;

import java.util.Scanner;

import model.DatosOperacion;
import model.OpcionMenu;
import model.OpcionOperacion;

public class VistaConsola {
	private static Scanner sc = new Scanner(System.in);
	
	public void mostrarMenuPrincipal() {
		System.out.println(OpcionMenu.CREAR_PEDIDO_IMPORTE_BASE + ". Crear pedido con un importe base\n"
				+ OpcionMenu.APLICAR_OPERACION + ". Aplicar una combinacion de operaciones\n"
				+ OpcionMenu.CONFIRMAR_PEDIDO + ". Confirmar pedido\n"
				+ OpcionMenu.CERRAR + ". Cerrar\n");
	}
	
	public int leerOpcion() {
		return leerInt("Elija una opcion:");
	}
	
	public String leerId() {
		return leerString("Introduzca el id:");
	}
	
	public double leerImporte() {
		return leerDouble("Introduce el importe");	
	}
	
	public double leerCantidad() {
		return leerDouble("Introduce la cantidad");
		
	}
	
	public double leerImpuesto() {
		return leerDouble("Introduce el porcentaje(%) de impuesto");
	}
	
	public double leerDouble(String mensaje) {
	    while (true) {
	        try {
	            System.out.println(mensaje);
	            return Double.parseDouble(sc.nextLine());
	        } catch (NumberFormatException e) {
	            System.out.println("Valor no válido. Inténtalo de nuevo.");
	        }
	    }
	}
	
	public int leerInt(String mensaje) {
		while (true) {
	        try {
	            System.out.println(mensaje);
	            return Integer.parseInt(sc.nextLine());
	        } catch (NumberFormatException e) {
	            System.out.println("Valor no válido. Inténtalo de nuevo.");
	        }
	    }
	}
	
	public String leerString(String mensaje) {
		System.out.println(mensaje);
		return sc.nextLine();
	}
	
	public DatosOperacion leerDatosOperacion() {
		mostrarMenuOperaciones();
	    int operacion = leerOpcion();
	    String id = leerId();
	    double cantidad;
	    switch(operacion) {
		    case OpcionOperacion.APLICAR_DESCUENTO:
				cantidad = leerCantidad(); break;
			case OpcionOperacion.APLICAR_RECARGO:
				cantidad = leerCantidad(); break;
			case OpcionOperacion.PONER_GASTO_ENVIO:
				cantidad = leerCantidad(); break;
			case OpcionOperacion.PONER_IMPUESTO:
				cantidad = leerImpuesto(); break;
			default:
				cantidad = 0; break;
	    }

	    return new DatosOperacion(operacion, id, cantidad);
	}
	
	public void mostrarMenuOperaciones() {
		System.out.println(OpcionOperacion.APLICAR_DESCUENTO + ". Aplicar descuento\n"
				+ OpcionOperacion.APLICAR_RECARGO + ". Aplicar recargo\n"
				+ OpcionOperacion.PONER_IMPUESTO + ". Poner impuesto\n"
				+ OpcionOperacion.PONER_GASTO_ENVIO + ". Poner gasto de envio\n");
	}
	
	public void mostrarOpcionNoEncontrado() {
		System.out.println("Opcion inválida o no encontrada");
	}

	public void mostrarMsgPedidoNoEncontrado() {
		System.out.println("No se ha encontrado el pedido");
	}
}
