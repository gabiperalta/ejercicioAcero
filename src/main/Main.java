package main;

import dominio.*;
import vista.Vista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Articulo> articulos = new ArrayList<>();
        articulos.add(new Articulo(1,"Tubo 1", Material.ALUMINIO, TipoArticulo.TUBO,10));
        articulos.add(new Articulo(2,"Tubo 2", Material.ACERO, TipoArticulo.TUBO,25));
        articulos.add(new Articulo(3,"Pieza 1", Material.ALUMINIO, TipoArticulo.PIEZA,8));
        Empresa.getInstance().agregarArticulos(articulos);

        List<Envase> envases = new ArrayList<>();
        envases.add(new Envase(1,"Envase 1",TipoArticulo.TUBO,5));
        envases.add(new Envase(2,"Envase 2",TipoArticulo.TUBO,10));
        envases.add(new Envase(3,"Envase 3",TipoArticulo.TUBO,7));
        envases.add(new Envase(4,"Envase 4",TipoArticulo.PIEZA,2));
        Empresa.getInstance().agregarEnvases(envases);

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1234));
        Empresa.getInstance().agregarUsuarios(usuarios);

        Vista vista = new Vista();
        Pedido pedido = vista.nuevoPedido(1234, LocalDate.of(2021,6,1),2,Intervalo.MENSUAL);

        vista.agregarArticulo(pedido,2,8,15);
        vista.agregarArticulo(pedido,3,1,7);

        vista.mostrarEnvasesPorTipoArticulo(TipoArticulo.TUBO);
        vista.mostrarEnvasesPorTipoArticulo(TipoArticulo.PIEZA);

        vista.agregarEnvase(pedido,2);
        vista.agregarEnvase(pedido,4);

        System.out.println("Codigo de pedido: " + vista.finalizarPedido(pedido));
    }
}
