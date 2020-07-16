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
import javax.swing.table.TableColumnModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import static proyecto.Proyecto.transi;
import static proyecto.Proyecto.stringueadorF;
import static proyecto.Proyecto.stringueadorI;
import static proyecto.Proyecto.transf;

public class ViCot extends javax.swing.JFrame {

      
    
    String id,canti,iden;
    DefaultComboBoxModel modeloCliente;
    ArrayList<Cliente>listC=new ArrayList<>();
    ArrayList<Cotizacion> cotizacion = new ArrayList<>();   
    ArrayList<Producto> listaProductos = new ArrayList<>();
    ArrayList<Producto> paraCo = new ArrayList<>();    
    ArrayList<Cotizacion> pruco = new ArrayList<>();   
    public void guardarROM() throws IOException {
 
        try (FileWriter fichero = new FileWriter("ROMcot.txt",true);
                FileReader lector = new FileReader("ROMcot.txt")) {
             
            for (int d = 0; d < cotizacion.size(); d++) {

                fichero.write(cotizacion.get(d).toString());
            }
            fichero.close();
         }

    }
    
    public void guardarROMprodF() throws IOException {
 
        try (FileWriter fichero = new FileWriter("ROMprod.txt");
                FileReader lector = new FileReader("ROMprod.txt")) {
             
            for (int d = 0; d < listaProductos.size(); d++) {

                fichero.write(listaProductos.get(d).toString());
            }
            fichero.close();
         }

    }  
    
    public final void cargarROM() throws IOException {

        String llegan = null;
        try {
            FileReader lector = new FileReader("ROMprod.txt");
            BufferedReader BR = new BufferedReader(lector);
            llegan = BR.readLine();

        } catch (IOException ex) {
        }
        if (llegan != null) {
            String[] partes = llegan.split("-");
            System.out.println(llegan);
            int k;

            for (k = 0; k < partes.length; k += 5) {
                float s = Float.parseFloat(partes[k + 3]);
                int e = Integer.parseInt(partes[k + 4]);
                Producto produ = new Producto(partes[k], partes[k + 1], partes[k + 2], s, e);
                listaProductos.add(produ);
            }
            System.out.println(llegan);
        }
    }

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
                pruco.add(coti);
            }
             
        }
        
    }
          public final void cargarRM() throws IOException {

        String llegan = null;
        try {
            FileReader lector = new FileReader("ROMcli.txt");
            BufferedReader BR = new BufferedReader(lector);
            llegan = BR.readLine();

        } catch (IOException ex) {
        }
        if(llegan!=null){
        String[] partes = llegan.split("-");
        System.out.println(llegan);
        int k;

        for (k = 0; k < partes.length; k += 5) {
             
            Cliente cline = new Cliente(partes[k], partes[k + 1], partes[k + 2],partes[k+3],partes[k+4]);
            listC.add(cline);
        }
        System.out.println(llegan);
        }
    }
    
    public ViCot() throws IOException {
        initComponents();
          cargarRM();
          cargarROM();
            ensenar();
        cargarROMcot();
        cargarCombo();
        AutoCompleteDecorator.decorate(comboBoxCliente);
        
       
       
      jtap.addMouseListener(new MouseAdapter() {
            DefaultTableModel model = new DefaultTableModel();

            @Override
            public void mouseClicked(MouseEvent e) {
                int i = jtap.getSelectedRow();
                id = paraCo.get(i).getId();
                 
                canti= (jtap.getValueAt(i, 2).toString());
                
            }
        });
       if(pruco.size()<=0){
            btnRegistro.setEnabled(false);
            }
        if(pruco.size()>0){
            btnRegistro.setEnabled(true);
            }
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
        jLabel6 = new javax.swing.JLabel();
        txtcant = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnAñadir = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtap = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        modcan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        modid = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtdia = new javax.swing.JTextField();
        txtmes = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtano = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnFIN = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtidco = new javax.swing.JTextField();
        btnMenu = new javax.swing.JButton();
        btnRegistro = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        comboBoxCliente = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        comboBoxIV = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtUtilidad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        jButton3.setText("editar");

        jButton4.setText("guardar");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cliente *");

        jLabel6.setText("Cantidad");

        txtcant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantActionPerformed(evt);
            }
        });

        jLabel7.setText("ID");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        btnAñadir.setText("Añadir");
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });

        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
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
                "Nombre", "Precio", "Cantidad", "Precio x Cantidad", "precio final"
            }
        ));
        jtap.setRowHeight(20);
        jScrollPane1.setViewportView(jtap);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        modcan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modcanActionPerformed(evt);
            }
        });

        jLabel8.setText("cantidad");

        modid.setText("ID a editar");

        jLabel13.setText("dia*");

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

        jLabel14.setText("mes*");

        txtano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtanoActionPerformed(evt);
            }
        });

        jLabel15.setText("año*");

        btnFIN.setText("Finalizar");
        btnFIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFINActionPerformed(evt);
            }
        });

        jLabel3.setText("ID de la cotización*");

        txtidco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidcoActionPerformed(evt);
            }
        });

        btnMenu.setText("Menú principal");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        btnRegistro.setText("Registro de Cotizaciones");
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        jLabel4.setText("Campos obligatorios *");

        comboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Cotización");

        comboBoxIV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0%", "13%" }));
        comboBoxIV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxIVActionPerformed(evt);
            }
        });

        jLabel9.setText("% I.V");

        jLabel10.setText("Utilidad");

        txtUtilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUtilidadActionPerformed(evt);
            }
        });

        jLabel11.setText("%");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtcant, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                        .addComponent(txtId, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtdia, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtidco))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtmes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtano, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel9))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(btnAñadir)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel10)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtUtilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(comboBoxIV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(26, 26, 26))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel5)
                                        .addGap(156, 156, 156)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(modcan, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(modid)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnFIN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtidco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel13)
                            .addComponent(txtdia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(txtano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(comboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(comboBoxIV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtcant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtUtilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(btnAñadir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnQuitar))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnFIN, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .addComponent(btnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(modid)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modcan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(btnGuardar)
                            .addComponent(btnEditar)))
                    .addComponent(btnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void cargarCombo(){
        String combo[]= new String[listC.size()+1];
        
        
            for (int k=0;k<listC.size();k++){
                if(k==0){
                    combo[0]="Seleccione un cliente";
                }
                int combazo=k+1;
                combo[combazo]=listC.get(k).getNombre(); 
            }
               
            
            
        modeloCliente=new DefaultComboBoxModel(combo);
        comboBoxCliente.setModel(modeloCliente);
    }

    public int bPP(String h){
      int posicion=-1;
      
      for(int d=0;d<listaProductos.size();d++){
          if(h.equals(listaProductos.get(d).getId())){
           posicion=d;
           break;
          }
      }
      if(posicion==-1){
          JOptionPane.showMessageDialog(null,"id introducido no coincide ningún producto");
      }
      return posicion;
    }
    
    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        try {
             String h=txtId.getText();
            int bqd=bPP(h);
            if(bqd!=-1){
                
                int s=transi(txtcant.getText());
                Producto produ=new Producto(listaProductos.get(bqd).getId(),listaProductos.get(bqd).getNombre(),
                        listaProductos.get(bqd).getDescripcion(),listaProductos.get(bqd).getPrecio(),s);
              paraCo.add(produ);
                
            ensenar();
            
            
            txtId.setText(""); 
            txtcant.setText("");}
        } catch (IOException ex) {
            Logger.getLogger(ViCot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAñadirActionPerformed

    
    public void ensenar() throws IOException{
        float suma=0;
         
       
        String[][] matriz = new String[paraCo.size()+1][5];
         
           
       for (int i = 0; i < paraCo.size(); i++) {
            matriz[i][0] = paraCo.get(i).getNombre();
            matriz[i][1] = stringueadorF(paraCo.get(i).getPrecio());
            matriz[i][2] = stringueadorI(paraCo.get(i).getCantidad());  
             
            matriz[i][3] = stringueadorF(paraCo.get(i).getPrecio()*paraCo.get(i).getCantidad()) ;
           suma+=transf(matriz[i][3]);
        }
       if(!txtUtilidad.getText().equals("")){
       float por1=transf(txtUtilidad.getText())/100;
        float por2=por1+1;
       
             if(comboBoxIV.getSelectedIndex()==0){
           if(!txtUtilidad.getText().equals("")){
                String a=(suma*por2)+"";
               matriz[0][4]=a;  
                     System.out.print(suma);
                      System.out.println(); 
           }
//           else{
//                  matriz[0][4]=stringueadorF(suma);
//                    System.out.print(suma);
//                     System.out.println();
           
            
       }
       else{
           if(!txtUtilidad.getText().equals("")){
                por2+=0.13;
               String a=(suma*por2)+"";
               matriz[0][4]=a;  
                     System.out.print(suma);
                     System.out.println(); 
           }
            else{
               float IV=0.13f;
                matriz[0][4]=stringueadorF(suma*IV);  
                     System.out.print(suma);
                     System.out.println(); 
           }
        }
       }
//                   matriz[0][4]=stringueadorF(suma);
//                    System.out.print(suma);
//                     System.out.println();
       jtap.setModel(new javax.swing.table.DefaultTableModel(
            matriz,
            new String [] {
               "nombre", "precio", "cantidad", "precio*cantidad", "precio final"
            }
        ));
          TableColumnModel columnModel = jtap.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(60);
        columnModel.getColumn(1).setPreferredWidth(10);
        columnModel.getColumn(2).setPreferredWidth(10);
        columnModel.getColumn(3).setPreferredWidth(10);
        columnModel.getColumn(4).setPreferredWidth(10);
         
    }
    
    
    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
       for (int i = 0; i < paraCo.size(); i++) {

            if (id == null ? paraCo.get(i).getId() == null : id.equals(paraCo.get(i).getId())) {
                paraCo.remove(i);
            }

        }
        try {
                  
            ensenar();
            
        } catch (IOException ex) {
            Logger.getLogger(ViCot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       modcan.setText(canti);
       modid.setText(id);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
          for (int i = 0; i < paraCo.size(); i++) {

            if (modid.getText().equals(paraCo.get(i).getId())) {
                
                paraCo.get(i).setCantidad( transi(modcan.getText()));
                 
            
            }  

        }
           
           modcan.setText("");
         
        modid.setText("");
        try {
             
            ensenar();
        } catch (IOException ex) {
            Logger.getLogger(ViCot.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtcantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcantActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void modcanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modcanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modcanActionPerformed

    private void txtdiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiaActionPerformed

    private void txtmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmesActionPerformed

    private void txtanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtanoActionPerformed
         
    }//GEN-LAST:event_txtanoActionPerformed

      public void misterBodega() {

        for (int f = 0; f < listaProductos.size(); f++) {
           
            for (int d = 0; d < paraCo.size(); d++) {
                
                if (listaProductos.get(f).getId().equals(paraCo.get(d).getId())) {
                    int s = listaProductos.get(f).getCantidad() - paraCo.get(d).getCantidad();
                    if(s>=0){
                    listaProductos.get(f).setCantidad(s);
                    }
                     if(s<0){
                       JOptionPane.showMessageDialog(null, "no quedan suficientes existencias de ese producto");
                    }
                 }
            }
        }

    }

    private void btnFINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFINActionPerformed
        String fecha = txtdia.getText() + "/" + txtmes.getText() + "/" + txtano.getText();
        float emi = transf(jtap.getValueAt(0, 4).toString());
        System.out.println(emi);
        
        String nulo=null;
        String nulof="//";
        if (((fecha.equals(nulof) || comboBoxCliente.getSelectedItem().equals("Seleccione un cliente")) || txtidco.equals(nulo))||emi==0.0) {
        JOptionPane.showMessageDialog(null,"complete los espacios obligatorios y añada mínimo un artículo");
        } else {
            Cotizacion coti = new Cotizacion(txtidco.getText(), comboBoxCliente.getSelectedItem().toString(), fecha, paraCo, emi);
            cotizacion.add(coti);
            misterBodega();

            try {
                guardarROM();
                guardarROMprodF();
                cargarROMcot();
                if(pruco.size()<=0){
            btnRegistro.setEnabled(false);
            }
        if(pruco.size()>0){
            btnRegistro.setEnabled(true);
            }
            } catch (IOException ex) {
                Logger.getLogger(ViCot.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            txtdia.setText("");
            txtmes.setText("");
            txtano.setText("");
            txtidco.setText("");
        }
        /*if((fecha.equals(nulof) || txtcliente.getText().equals(nulo)) || txtidco.equals(nulo)){
          JOptionPane.showMessageDialog(null,"complete los espacios obligatorios y añada mínimo un articulo");
        }*/
    }//GEN-LAST:event_btnFINActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        try {
            Menu menu = new Menu();
            menu.setVisible(true);
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(ViEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
          try {
            
            
             
            ViCotVer menu = new ViCotVer();
            menu.setVisible(true);
            this.setVisible(false);
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(ViEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void txtidcoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidcoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidcoActionPerformed

    private void txtUtilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUtilidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUtilidadActionPerformed

    private void comboBoxIVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxIVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxIVActionPerformed

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
            java.util.logging.Logger.getLogger(ViCot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViCot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViCot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViCot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new ViCot().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(ViCot.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFIN;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JComboBox<String> comboBoxCliente;
    private javax.swing.JComboBox<String> comboBoxIV;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtap;
    private javax.swing.JTextField modcan;
    private javax.swing.JLabel modid;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtUtilidad;
    private javax.swing.JTextField txtano;
    private javax.swing.JTextField txtcant;
    private javax.swing.JTextField txtdia;
    private javax.swing.JTextField txtidco;
    private javax.swing.JTextField txtmes;
    // End of variables declaration//GEN-END:variables

     
}
