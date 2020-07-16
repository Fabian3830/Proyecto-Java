/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Pc
 */
public class Empleado {
    private String nombre, ced, tel, sal;
    
    public Empleado() {
    }

    public Empleado(String nombre, String ced, String tel, String sal) {
        this.nombre = nombre;
        this.ced = ced;
        this.tel = tel;
        this.sal = sal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCed() {
        return ced;
    }

    public void setCed(String ced) {
        this.ced = ced;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return nombre + "-" + ced + "-" + tel + "-" + sal + "-";
    }


}
