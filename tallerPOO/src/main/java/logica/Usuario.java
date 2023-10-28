
package logica;
public class Usuario {

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
   private String nombre;
    private String contrasenia;
    private Rol rol;
    
     public Usuario() {
    }

    public Usuario(String nombre, String contrasenia, Rol rol) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }
  
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContraseña(String contrasenia) {
        this.contrasenia = contrasenia;
    }

   
}
