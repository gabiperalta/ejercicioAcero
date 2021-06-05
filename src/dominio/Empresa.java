package dominio;

import java.util.List;
import java.util.stream.Collectors;

public class Empresa {
    List<Articulo> articulos;
    List<Envase> envases;
    List<Usuario> usuarios;

    private static class EmpresaHolder {
        static final dominio.Empresa singleInstanceEmpresa = new dominio.Empresa();
    }

    public static dominio.Empresa getInstance() {
        return EmpresaHolder.singleInstanceEmpresa;
    }

    public Empresa(){

    }

    public Articulo obtenerArticulo(int codigo){
        return articulos.stream().filter(articulo -> articulo.getId() == codigo)
                .findAny()
                .orElse(null);
    }

    public List<Envase> obtenerEnvasesPorTipoArticulo(TipoArticulo tipoArticulo) {
        return envases.stream().filter(envase -> envase.getTipoArticulo() == tipoArticulo)
                .collect(Collectors.toList());
    }

    public Envase obtenerEnvase(int codigoEnvase) {
        return envases.stream().filter(envase -> envase.getCodigo() == codigoEnvase)
                .findAny()
                .orElse(null);
    }

    public Usuario obtenerUsuario(int codigo){
        return usuarios.stream().filter(usuario -> usuario.getCodigo() == codigo)
                .findAny()
                .orElse(null);
    }

    public void agregarArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }

    public void agregarEnvases(List<Envase> envases) {
        this.envases = envases;
    }

    public void agregarUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
