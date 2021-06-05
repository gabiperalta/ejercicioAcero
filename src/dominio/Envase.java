package dominio;

public class Envase {
    int codigo;
    String descripcion;
    TipoArticulo tipoArticulo;
    int capacidad;

    public Envase(int codigo, String descripcion, TipoArticulo tipoArticulo, int capacidad){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipoArticulo = tipoArticulo;
        this.capacidad = capacidad;
    }

    public TipoArticulo getTipoArticulo(){
        return tipoArticulo;
    }

    public int getCodigo(){
        return codigo;
    }

    public String getDescripcion(){
        return descripcion;
    }
}
