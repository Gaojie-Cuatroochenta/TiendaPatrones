package writer;

import java.io.FileWriter;
import java.io.IOException;

import model.Pedido;

public class PedidoFileWriter {
    private String rutaArchivo;

    public PedidoFileWriter(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public void guardarPedido(Pedido pedido) throws IOException {
        try (FileWriter fw = new FileWriter(rutaArchivo, true)) {
            fw.write(pedido.toString() + "\n");
        }
    }
}