 
package proyecto;

import java.util.ArrayList;

 
public class Cotizacion {
        
        String id,cliente,fecha; 
        ArrayList<Producto> listP = new ArrayList<>();
        float montoCalculado;
        
   
   public Cotizacion() {
    }

     

    Cotizacion(String id,String cliente, String fecha, ArrayList<Producto> listP, float montoCalculado) {
        this.fecha=fecha; 
        this.id=id;
        this.cliente = cliente;
        this.listP=listP;
        this.montoCalculado = montoCalculado;
    }
     
    
      public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

 

    public float getMontoCalculado() {
        return montoCalculado;
    }

    public void setMontoCalculado(float montoCalculado) {
        this.montoCalculado = montoCalculado;
    }

    public ArrayList<Producto> getListP() {
        return listP;
    }

    public void setListP(ArrayList<Producto> listP) {
        this.listP = listP;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    

    @Override
    public String toString() {
        return  id+"<<"+cliente + "<<" + fecha + "<<" + listP.toString() + "<<" + montoCalculado + "<<";
    }

    
    
    
     

}
