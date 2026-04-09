package event;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Pedido;

public class EventManager {
    private List<Cliente> clientes = new ArrayList<>();

    public void subscribe(Cliente cliente) {
        clientes.add(cliente);
    }

    public void notifyClientes(Pedido pedido) {
        for (Cliente c : clientes) {
            c.recibirNotificacion(pedido);
        }
    }
}