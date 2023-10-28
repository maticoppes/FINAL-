
package logica;
import java.util.List;

public class Rol {
    private int id;
    private String nombreRoll;
    private String descripcion;
    private List <Usuario> ListaUsuario;
    public Rol() {
    }

    public Rol(String nombreRoll, String descripcion, List<Usuario> ListaUsuario) {
        this.nombreRoll = nombreRoll;
        this.descripcion = descripcion;
        this.ListaUsuario = ListaUsuario;
    }

    public List<Usuario> getListaUsuario() {
        return ListaUsuario;
    }

    public void setListaUsuario(List<Usuario> ListaUsuario) {
        this.ListaUsuario = ListaUsuario;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreRoll() {
        return nombreRoll;
    }

    public void setNombreRoll(String nombreRoll) {
        this.nombreRoll = nombreRoll;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
