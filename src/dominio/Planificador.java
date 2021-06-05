package dominio;

import java.time.LocalDate;

public class Planificador {

    public void calcularFechas(Pedido pedido){
        int i = 1;
        LocalDate nuevaFecha = null;
        while (i < pedido.getCantidadEntregas()){
            if(pedido.getPeriodicidad() == Intervalo.MENSUAL) {
                nuevaFecha = pedido.getFechaDeEntrega(i - 1);
                nuevaFecha.plusMonths(1);
            }
            else if(pedido.getPeriodicidad() == Intervalo.SEMANAL) {
                nuevaFecha = pedido.getFechaDeEntrega(i - 1);
                nuevaFecha.plusWeeks(1);
            }
            pedido.agregarFecha(nuevaFecha);
            i++;
        }
    }

    public void agregarArticulo(Pedido pedido, Articulo articulo, int tolerancia) {
        if(articulo.cumpleTolerancia(tolerancia)){
            pedido.agregarArticulo(articulo);
        }
    }

    public void agregarEnvase(Pedido pedido, Envase envase) {
        pedido.agregarEnvase(envase);
    }
}
