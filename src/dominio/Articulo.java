package dominio;

public class Articulo {
    int id;
    String descripcion;
    Material material;
    TipoArticulo tipoArticulo;
    int tolerancia;
    int cantidad;

    public Articulo(int id,String descripcion,Material material,TipoArticulo tipoArticulo,int tolerancia){
        this.id = id;
        this.descripcion = descripcion;
        this.material = material;
        this.tipoArticulo = tipoArticulo;
        this.tolerancia = tolerancia;
    }

    public int getId(){
        return this.id;
    }

    public boolean cumpleTolerancia(int tolerancia) {
        return this.tolerancia >= tolerancia;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
