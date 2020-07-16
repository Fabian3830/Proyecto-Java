package proyecto;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import static proyecto.Proyecto.stringueadorF;
import static proyecto.Proyecto.stringueadorI;
import static proyecto.Proyecto.transf;

public class ViCotVer extends javax.swing.JFrame {
    int busqued;
    int pos;
    String idcoti, cliente, fecha;

    ArrayList<Cotizacion> cotizacion = new ArrayList<>();
    ArrayList<Producto> listaProductos = new ArrayList<>();
    ArrayList<Producto> paraCo = new ArrayList<>();
    DefaultComboBoxModel modeloCot;

    public final void cargarROMcot() throws IOException {

        String llegan = null;
        try {
            FileReader lector = new FileReader("ROMcot.txt");
            BufferedReader BR = new BufferedReader(lector);
            llegan = BR.readLine();

        } catch (IOException ex) {
        }
        if (llegan != null) {
            String[] partes = llegan.split("<<");
             
            int k;

            for (k = 0; k < partes.length; k += 5) {
                ArrayList<Producto> paraCargar = new ArrayList<>();
                String p = partes[k + 3].replace("]", "").replace("[", "").replace(", ", "");
                String g[] = p.split("-");
                
                for (int d = 0; d < g.length; d += 5) {

                    float s = Float.parseFloat(g[d + 3]);
                    int e = Integer.parseInt(g[d + 4]);
                    Producto produ = new Producto(g[d], g[d + 1], g[d + 2], s, e);
                     
                     paraCargar.add(produ);
                       
                }
                Cotizacion coti = new Cotizacion(partes[k], partes[k + 1], partes[k + 2], paraCargar, transf(partes[k + 4]));
                cotizacion.add(coti);
            }
             
        }
        
    }
  
     public void guardarROM() throws IOException {
 
        try (FileWriter fichero = new FileWriter("ROMcot.txt");
                FileReader lector = new FileReader("ROMcot.txt")) {
             
            for (int d = 0; d < cotizacion.size(); d++) {

                fichero.write(cotizacion.get(d).toString());
            }
            fichero.close();
         }

    }
    
    public ViCotVer() throws IOException {
        initComponents();

        cargarROMcot();
        ensenar2();
        ensenar();
        cargarCombo();
        AutoCompleteDecorator.decorate(comboBoxCot);
        int busqueda=cotizacion.size();  
        jpat.addMouseListener(new MouseAdapter() {
            DefaultTableModel model = new DefaultTableModel();

            @Override
            public void mouseClicked(MouseEvent e) {
                 jpat.setRowSelectionAllowed(true);
                int i;
                i = jpat.getSelectedRow() ;
                 idcoti = (jpat.getValueAt(i, 2).toString());
                paraCo=(ArrayList<Producto>) cotizacion.get(i).getListP().clone();
                System.out.println(paraCo.toString());
                try {
                    ensenar();
                } catch (IOException ex) {
                    Logger.getLogger(ViCotVer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
         
            
                   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtap = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtdia = new javax.swing.JTextField();
        txtmes = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtano = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtidco = new javax.swing.JTextField();
        btnMenu = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jpat = new javax.swing.JTable();
        btnrestaurar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        comboBoxCot = new javax.swing.JComboBox<>();

        jLabel2.setText("jLabel2");

        jButton3.setText("editar");

        jButton4.setText("guardar");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cliente");

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        jtap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Precio", "Cantidad", "Precio x Cantidad", "Precio Final"
            }
        ));
        jtap.setRowHeight(20);
        jScrollPane1.setViewportView(jtap);

        jLabel13.setText("Dia");

        txtdia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiaActionPerformed(evt);
            }
        });

        txtmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmesActionPerformed(evt);
            }
        });

        jLabel14.setText("Mes");

        txtano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtanoActionPerformed(evt);
            }
        });

        jLabel15.setText("Año");

        jLabel3.setText("ID de la cotización");

        btnMenu.setText("Volver");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        jpat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Cliente", "Fecha", "ID"
            }
        ));
        jScrollPane2.setViewportView(jpat);

        btnrestaurar.setText("Restaurar");
        btnrestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrestaurarActionPerformed(evt);
            }
        });

        btneliminar.setText("Borrar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtidco, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxCot, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtdia, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtmes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtano, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnbuscar))
                            .addComponent(btnrestaurar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMenu)
                            .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtidco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel13)
                            .addComponent(txtdia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(txtano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxCot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnrestaurar)
                            .addComponent(btneliminar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public int bPP(String h) {
        int posicion = -1;

        for (int d = 0; d < listaProductos.size(); d++) {
            if (h.equals(listaProductos.get(d).getId())) {
                posicion = d;
                break;
            }
        }
        if (posicion == -1) {
            JOptionPane.showMessageDialog(null, "id introducido no coincide ningún producto");
        }
        return posicion;
    }
    public void cargarCombo(){
        String combo[]= new String[cotizacion.size()+1];
        
        
            for (int k=0;k<cotizacion.size();k++){
                if(k==0){
                    combo[0]="Seleccione un cliente";
                }
                int combazo=k+1;
                combo[combazo]=cotizacion.get(k).getCliente(); 
            }
               
            
            
        modeloCot=new DefaultComboBoxModel(combo);
        comboBoxCot.setModel(modeloCot);
    }

    public void ensenar() throws IOException {
        float suma = 0;
       
        String[][] matriz = new String[paraCo.size() + 1][5];

        for (int i = 0; i < paraCo.size(); i++) {
            matriz[i][0] = paraCo.get(i).getNombre();
            matriz[i][1] = stringueadorF(paraCo.get(i).getPrecio());
            matriz[i][2] = stringueadorI(paraCo.get(i).getCantidad());

            matriz[i][3] = stringueadorF(paraCo.get(i).getPrecio() * paraCo.get(i).getCantidad());
            suma += transf(matriz[i][3]);
        }
        matriz[0][4] = stringueadorF(suma);
        
        jtap.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "Nombre", "Precio", "Cantidad", "Precio x Cantidad", "Precio final"
                }
        ));

    }

    public void ensenar2() throws IOException {
        int gogo=cotizacion.size();
        if(gogo==0){
          gogo+=1;
        }
        
        String[][] matrizCot = new String[gogo][3];

        for (int i = 0; i < cotizacion.size(); i++) {
            matrizCot[i][0] = cotizacion.get(i).getCliente();
            matrizCot[i][1] = cotizacion.get(i).getFecha();
            matrizCot[i][2] = cotizacion.get(i).getId();
        }

        jpat.setModel(new javax.swing.table.DefaultTableModel(
                matrizCot,
                new String[]{
                    "Cliente", "Fecha", "ID"
                }
        ));

    }
 
    private void txtdiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiaActionPerformed

    private void txtmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmesActionPerformed

    private void txtanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtanoActionPerformed

    }//GEN-LAST:event_txtanoActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        try {
            ViCot menu = new ViCot();
            menu.setVisible(true);
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(ViCotVer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
      fecha=txtdia.getText()+"/"+txtmes.getText()+"/"+txtano.getText();
      cliente=comboBoxCot.getSelectedItem().toString();
      idcoti=txtidco.getText();
      if(!fecha.equals("//")||!cliente.equals("Seleccione un cliente")||!idcoti.equals("")){
            btneliminar.setEnabled(false);
          ArrayList<Cotizacion> temporal = new ArrayList<>();
           temporal=(ArrayList<Cotizacion>) cotizacion.clone();
           cotizacion.clear();
           for(int d=0;d<temporal.size();d++){
               
              if(fecha.equals(temporal.get(d).getFecha())||cliente.equals(temporal.get(d).getCliente())||idcoti.equals(temporal.get(d).getId())){
              
                  cotizacion.add(temporal.get(d));
                  
               }
               
           }
           
          try {
              ensenar();
              ensenar2();
          } catch (IOException ex) {
              Logger.getLogger(ViCotVer.class.getName()).log(Level.SEVERE, null, ex);
          }
      
      }
      
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnrestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrestaurarActionPerformed
        try {
            cotizacion.clear();
            cargarROMcot();
            ensenar();
            ensenar2();
            btneliminar.setEnabled(true);
        } catch (IOException ex) {
            Logger.getLogger(ViCotVer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnrestaurarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        int s=JOptionPane.showConfirmDialog(null,"¿Esta seguro?los datos se perderan por siempre");
        if(s==0){
        
        for (int i = 0; i <cotizacion.size(); i++) {

            if (idcoti == null ? cotizacion.get(i).getId() == null : idcoti.equals(cotizacion.get(i).getId())) {
                cotizacion.remove(i);
            }

        }
        try {
            guardarROM();
            ensenar2();    
            ensenar();
            
        } catch (IOException ex) {
            Logger.getLogger(ViCot.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViCotVer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViCotVer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViCotVer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViCotVer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new ViCotVer().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(ViCotVer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnrestaurar;
    private javax.swing.JComboBox<String> comboBoxCot;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jpat;
    private javax.swing.JTable jtap;
    private javax.swing.JTextField txtano;
    private javax.swing.JTextField txtdia;
    private javax.swing.JTextField txtidco;
    private javax.swing.JTextField txtmes;
    // End of variables declaration//GEN-END:variables

}
