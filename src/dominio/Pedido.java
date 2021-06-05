package dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    int codigo;
    int codigoCliente;
    List<LocalDate> fechasDeEntrega;
    Intervalo periodicidad;
    List<Articulo> articulos;
    List<Envase> envases;
    int cantidadEntregas;

    public Pedido(int codigoCliente, LocalDate fechaEntrega, int cantidadEntregas, Intervalo periodicidad){
        this.codigoCliente = codigoCliente;
        this.fechasDeEntrega = new ArrayList<>();
        this.articulos = new ArrayList<>();
        this.envases = new ArrayList<>();
        this.fechasDeEntrega.add(fechaEntrega);
        this.cantidadEntregas = cantidadEntregas;
        this.periodicidad = periodicidad;
        this.generarCodigo();
    }

    public void agregarArticulo(Articulo articulo){
        this.articulos.add(articulo);
    }

    public void agregarFecha(LocalDate fecha){
        this.fechasDeEntrega.add(fecha);
    }

    public int getCantidadEntregas() {
        return cantidadEntregas;
    }

    public Intervalo getPeriodicidad() {
        return periodicidad;
    }

    public LocalDate getFechaDeEntrega(int indice){
        return fechasDeEntrega.get(indice);
    }

    public void agregarEnvase(Envase envase) {
        this.envases.add(envase);
    }

    public int getCodigo(){
        return codigo;
    }

    private void generarCodigo(){
        Usuario usuario = Empresa.getInstance().obtenerUsuario(this.codigoCliente);
        this.codigo = usuario.getPedidos().size();
    }
}
