package app;

import controller.AppController;
import controller.PedidoController;
import event.EventManager;
import model.Equipo;
import model.PedidoRepository;
import view.VistaConsola;
import writer.PedidoFileWriter;

public class Main {

	public static void main(String[] args) {
		VistaConsola vista = new VistaConsola();
        EventManager em = new EventManager();
        PedidoRepository pr = new PedidoRepository();
        PedidoController pc = new PedidoController(em, pr);
        PedidoFileWriter pfw = new PedidoFileWriter("pedidos_confirmados.txt");
        AppController ac = new AppController(pc, vista, pfw);
        Equipo cli = new Equipo();
        em.subscribe(cli);
        
        boolean cerrar;
        do {
        		vista.mostrarMenuPrincipal();
            int opcion = vista.leerOpcion();
            cerrar = ac.procesarOpcion(opcion);
		} while (cerrar);
        
	}

}
