 
package proyecto;

public class Cliente {

    String cedula;
    String nombre;
    String telefono;
    String correo;
    String direccion;

    public Cliente() {
    }

    public Cliente(String cedula, String nombre, String telefono, String correo, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return   cedula + "-" + nombre + "-" + telefono + "-" + correo + "-" + direccion +"-";
    }


    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
  
  
  
}
