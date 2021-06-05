package vista;

import dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vista {

    public Vista(){
    }

    public Pedido nuevoPedido(int codigoCliente, LocalDate primeraFechaEntrega, int cantidadEntregas, Intervalo periodicidad){
        Pedido pedido = new Pedido(codigoCliente,primeraFechaEntrega,cantidadEntregas,periodicidad);
        Planificador planificador = new Planificador();
        planificador.calcularFechas(pedido);
        return pedido;
    }

    public void agregarArticulo(Pedido pedido, int codigoArticulo, int cantidad, int tolerancia) {
        Planificador planificador = new Planificador();
        Articulo articulo = Empresa.getInstance().obtenerArticulo(codigoArticulo);
        articulo.setCantidad(cantidad);
        planificador.agregarArticulo(pedido,articulo,tolerancia);
    }

    public void agregarEnvase(Pedido pedido, int codigoEnvase) {
        Planificador planificador = new Planificador();
        Envase envase = Empresa.getInstance().obtenerEnvase(codigoEnvase);
        planificador.agregarEnvase(pedido,envase);
    }

    public void mostrarEnvasesPorTipoArticulo(TipoArticulo tipoArticulo){
        List<Envase> envases = Empresa.getInstance().obtenerEnvasesPorTipoArticulo(tipoArticulo);
        List<String> codigoDescripcionEnvase = new ArrayList<>();
        envases.forEach(envase -> codigoDescripcionEnvase.add("Codigo: " + envase.getCodigo() + " Descripcion: " + envase.getDescripcion()));
        codigoDescripcionEnvase.forEach(System.out::println);
    }

    public int finalizarPedido(Pedido pedido){
        return pedido.getCodigo();
    }
}
