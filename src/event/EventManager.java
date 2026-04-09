package event;
import java.util.ArrayList;
import java.util.List;

import model.Equipo;
import model.Pedido;

public class EventManager {
    private List<Equipo> clientes = new ArrayList<>();

    public void subscribe(Equipo cliente) {
        clientes.add(cliente);
    }

    public void notifyClientes(Pedido pedido) {
        for (Equipo c : clientes) {
            c.recibirNotificacion(pedido);
        }
    }
}