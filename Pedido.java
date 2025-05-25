package techlab.proyecto;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Producto> productos;

    public Pedido() {
        this.productos = new ArrayList<>();
    }

    public void agregarAlPedido(Producto producto){
        this.productos.add(producto);
    }
}