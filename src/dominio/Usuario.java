package dominio;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    int codigo;
    List<Pedido> pedidos;

    public Usuario(int codigo){
        this.codigo = codigo;
        this.pedidos = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
