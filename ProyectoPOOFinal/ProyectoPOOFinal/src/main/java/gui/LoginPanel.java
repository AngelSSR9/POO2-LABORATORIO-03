package gui;

import com.mycompany.proyectopoofinal.Almacen;
import com.mycompany.proyectopoofinal.Cliente;
import com.mycompany.proyectopoofinal.Constantes;
import com.mycompany.proyectopoofinal.SistemaGestion;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class LoginPanel extends javax.swing.JPanel {

    private SistemaGestion sistemaGestion;

    public LoginPanel() {
        initComponents();
        setVisible(true);

        agregarEventos();

        Almacen almacen = new Almacen();
        almacen = almacen.cargarAlmacen();
        this.sistemaGestion = new SistemaGestion(almacen);
    }

    private void reestablecerComponentes() {
        registrarseButton.setEnabled(false);

        dniInvalidoLbl.setVisible(false);
        telefonoInvalidoLbl.setVisible(false);
        ingreseNombreLbl.setVisible(false);
        ingreseEmailLbl.setVisible(false);
        ingresePasswordLbl.setVisible(false);
    }

    private void agregarEventos() {
        reestablecerComponentes();
        /*dniRegistroTxt.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                // El cursor está disponible para escribir
                System.out.println("Cursor disponible para escribir");
            }

            public void focusLost(FocusEvent e) {
                // El cursor no está disponible para escribir
                System.out.println("Cursor no disponible para escribir");
            }
        });*/

        nombreRegistroTxt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Se ejecuta cuando se inserta texto en el JTextField
                if (nombreRegistroTxt.getText().isEmpty()) {
                    ingreseNombreLbl.setVisible(true);
                    registrarseButton.setEnabled(false);
                } else {
                    ingreseNombreLbl.setVisible(false);
                    if (!hayCampoVacio()) {
                        registrarseButton.setEnabled(true);
                    }
                }
                //System.out.println("Se ha insertado texto: " + dniRegistroTxt.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // Se ejecuta cuando se elimina texto del JTextField

                if (nombreRegistroTxt.getText().isEmpty()) {
                    ingreseNombreLbl.setVisible(true);
                    registrarseButton.setEnabled(false);
                } else {
                    ingreseNombreLbl.setVisible(false);
                    if (!hayCampoVacio()) {
                        registrarseButton.setEnabled(true);
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Se ejecuta cuando se cambia el estilo del texto (p. ej., formato de fuente)
            }
        });

        emailRegistroTxt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Se ejecuta cuando se inserta texto en el JTextField
                if (emailRegistroTxt.getText().isEmpty()) {
                    ingreseEmailLbl.setVisible(true);
                    registrarseButton.setEnabled(false);
                } else {
                    ingreseEmailLbl.setVisible(false);
                    if (!hayCampoVacio()) {
                        registrarseButton.setEnabled(true);
                    }
                }
                //System.out.println("Se ha insertado texto: " + dniRegistroTxt.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // Se ejecuta cuando se elimina texto del JTextField

                if (emailRegistroTxt.getText().isEmpty()) {
                    ingreseEmailLbl.setVisible(true);
                    registrarseButton.setEnabled(false);

                } else {
                    ingreseEmailLbl.setVisible(false);
                    if (!hayCampoVacio()) {
                        registrarseButton.setEnabled(true);
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Se ejecuta cuando se cambia el estilo del texto (p. ej., formato de fuente)
            }
        });

        dniRegistroTxt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Se ejecuta cuando se inserta texto en el JTextField
                if (!Constantes.esDniValido(dniRegistroTxt)) {
                    dniInvalidoLbl.setVisible(true);
                    registrarseButton.setEnabled(false);
                } else {
                    dniInvalidoLbl.setVisible(false);
                    if (!hayCampoVacio()) {
                        registrarseButton.setEnabled(true);
                    }
                }
                //System.out.println("Se ha insertado texto: " + dniRegistroTxt.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // Se ejecuta cuando se elimina texto del JTextField

                if (!Constantes.esDniValido(dniRegistroTxt)) {
                    dniInvalidoLbl.setVisible(true);
                    registrarseButton.setEnabled(false);
                } else {
                    dniInvalidoLbl.setVisible(false);
                    if (!hayCampoVacio()) {
                        registrarseButton.setEnabled(true);
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Se ejecuta cuando se cambia el estilo del texto (p. ej., formato de fuente)
            }
        });

        telefonoRegistroTxt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Se ejecuta cuando se inserta texto en el JTextField
                if (!Constantes.esTelefonoValido(telefonoRegistroTxt)) {
                    telefonoInvalidoLbl.setVisible(true);
                    registrarseButton.setEnabled(false);
                } else {
                    telefonoInvalidoLbl.setVisible(false);
                    if (!hayCampoVacio()) {
                        registrarseButton.setEnabled(true);
                    }
                }

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // Se ejecuta cuando se elimina texto del JTextField

                if (!Constantes.esTelefonoValido(telefonoRegistroTxt)) {
                    telefonoInvalidoLbl.setVisible(true);
                    //if(!hayCampoVacio())
                    registrarseButton.setEnabled(false);
                } else {
                    telefonoInvalidoLbl.setVisible(false);
                    if (!hayCampoVacio()) {
                        registrarseButton.setEnabled(true);
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Se ejecuta cuando se cambia el estilo del texto (p. ej., formato de fuente)
            }
        });

        passwordRegistroTxt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (String.valueOf(passwordRegistroTxt.getPassword()).isEmpty()) {
                    ingresePasswordLbl.setVisible(true);
                    registrarseButton.setEnabled(false);
                } else {
                    ingresePasswordLbl.setVisible(false);
                    if (!hayCampoVacio()) {
                        registrarseButton.setEnabled(true);
                    }
                }

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // Se ejecuta cuando se elimina texto del JTextField
                if (String.valueOf(passwordRegistroTxt.getPassword()).isEmpty()) {
                    ingresePasswordLbl.setVisible(true);
                    registrarseButton.setEnabled(false);
                } else {
                    ingresePasswordLbl.setVisible(false);
                    if (!hayCampoVacio()) {
                        registrarseButton.setEnabled(true);
                    }
                }

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Se ejecuta cuando se cambia el estilo del texto (p. ej., formato de fuente)
            }
        });

    }

    private boolean hayCampoVacio() {
        String nombre = nombreRegistroTxt.getText();
        String dniTxt = dniRegistroTxt.getText();
        String telefonoTxt = telefonoRegistroTxt.getText();
        String email = emailRegistroTxt.getText();
        String password = String.valueOf(passwordRegistroTxt.getPassword());

        return nombre.isEmpty() || dniTxt.isEmpty() || telefonoTxt.isEmpty() || email.isEmpty() || password.isEmpty();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        registrarseButton = new javax.swing.JButton();
        nombreRegistroTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        telefonoRegistroTxt = new javax.swing.JTextField();
        emailRegistroTxt = new javax.swing.JTextField();
        dniRegistroTxt = new javax.swing.JTextField();
        passwordRegistroTxt = new javax.swing.JPasswordField();
        dniInvalidoLbl = new javax.swing.JLabel();
        telefonoInvalidoLbl = new javax.swing.JLabel();
        ingreseNombreLbl = new javax.swing.JLabel();
        ingreseEmailLbl = new javax.swing.JLabel();
        ingresePasswordLbl = new javax.swing.JLabel();
        loginPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        iniciarSesionButton = new javax.swing.JButton();
        emailLoginTxt = new javax.swing.JTextField();
        passwordLoginTxt = new javax.swing.JPasswordField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registerPanel.setBackground(new java.awt.Color(23, 137, 89));
        registerPanel.setForeground(new java.awt.Color(70, 247, 109));
        registerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CREAR CUENTA ");
        registerPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 25, -1, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");
        registerPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 78, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DNI:");
        registerPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("E-mail:");
        registerPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Contraseña:");
        registerPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        registrarseButton.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        registrarseButton.setText("Registrarse");
        registrarseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarseButtonActionPerformed(evt);
            }
        });
        registerPanel.add(registrarseButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 382, 163, 47));

        nombreRegistroTxt.setBackground(new java.awt.Color(255, 255, 255));
        nombreRegistroTxt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        nombreRegistroTxt.setForeground(new java.awt.Color(0, 0, 0));
        nombreRegistroTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        nombreRegistroTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreRegistroTxtActionPerformed(evt);
            }
        });
        registerPanel.add(nombreRegistroTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 73, 210, 32));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Teléfono:");
        registerPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        telefonoRegistroTxt.setBackground(new java.awt.Color(255, 255, 255));
        telefonoRegistroTxt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        telefonoRegistroTxt.setForeground(new java.awt.Color(0, 0, 0));
        telefonoRegistroTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        telefonoRegistroTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoRegistroTxtActionPerformed(evt);
            }
        });
        registerPanel.add(telefonoRegistroTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 210, 32));

        emailRegistroTxt.setBackground(new java.awt.Color(255, 255, 255));
        emailRegistroTxt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        emailRegistroTxt.setForeground(new java.awt.Color(0, 0, 0));
        emailRegistroTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        emailRegistroTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailRegistroTxtActionPerformed(evt);
            }
        });
        registerPanel.add(emailRegistroTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 210, 32));

        dniRegistroTxt.setBackground(new java.awt.Color(255, 255, 255));
        dniRegistroTxt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        dniRegistroTxt.setForeground(new java.awt.Color(0, 0, 0));
        dniRegistroTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        dniRegistroTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniRegistroTxtActionPerformed(evt);
            }
        });
        registerPanel.add(dniRegistroTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 210, 32));

        passwordRegistroTxt.setBackground(new java.awt.Color(255, 255, 255));
        passwordRegistroTxt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        passwordRegistroTxt.setForeground(new java.awt.Color(0, 0, 0));
        passwordRegistroTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        registerPanel.add(passwordRegistroTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 209, 32));

        dniInvalidoLbl.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        dniInvalidoLbl.setForeground(new java.awt.Color(153, 0, 51));
        dniInvalidoLbl.setText("DNI inválido");
        registerPanel.add(dniInvalidoLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 109, 20));

        telefonoInvalidoLbl.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        telefonoInvalidoLbl.setForeground(new java.awt.Color(153, 0, 51));
        telefonoInvalidoLbl.setText("Teléfono inválido");
        registerPanel.add(telefonoInvalidoLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 109, -1));

        ingreseNombreLbl.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        ingreseNombreLbl.setForeground(new java.awt.Color(153, 0, 51));
        ingreseNombreLbl.setText("Ingrese un nombre");
        registerPanel.add(ingreseNombreLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 109, 20));

        ingreseEmailLbl.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        ingreseEmailLbl.setForeground(new java.awt.Color(153, 0, 51));
        ingreseEmailLbl.setText("Ingrese un correo");
        registerPanel.add(ingreseEmailLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 109, 20));

        ingresePasswordLbl.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        ingresePasswordLbl.setForeground(new java.awt.Color(153, 0, 51));
        ingresePasswordLbl.setText("Ingrese una contraseña");
        registerPanel.add(ingresePasswordLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, -1, 20));

        add(registerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 470));

        loginPanel.setBackground(new java.awt.Color(204, 204, 204));
        loginPanel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(23, 137, 89));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("INICIAR SESIÓN");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(23, 137, 89));
        jLabel7.setText("E-mail:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(23, 137, 89));
        jLabel8.setText("Contraseña:");

        iniciarSesionButton.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        iniciarSesionButton.setForeground(new java.awt.Color(23, 137, 89));
        iniciarSesionButton.setText("Ingresar");
        iniciarSesionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarSesionButtonActionPerformed(evt);
            }
        });

        emailLoginTxt.setBackground(new java.awt.Color(255, 255, 255));
        emailLoginTxt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        emailLoginTxt.setForeground(new java.awt.Color(0, 0, 0));
        emailLoginTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        emailLoginTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailLoginTxtActionPerformed(evt);
            }
        });

        passwordLoginTxt.setBackground(new java.awt.Color(255, 255, 255));
        passwordLoginTxt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        passwordLoginTxt.setForeground(new java.awt.Color(0, 0, 0));
        passwordLoginTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iniciarSesionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(41, 41, 41)
                                .addComponent(emailLoginTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(passwordLoginTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLoginTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(42, 42, 42)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(passwordLoginTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(iniciarSesionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        add(loginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 370, 460));
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarSesionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarSesionButtonActionPerformed
        // TODO add your handling code here:
        String email = emailLoginTxt.getText();
        String password = String.valueOf(passwordLoginTxt.getPassword());
        Cliente cliente = sistemaGestion.getAlmacen().buscarCliente(email);
        if (cliente != null) {
            if (cliente.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(null, "Inicio de sesion exitoso.");
                System.out.println(cliente.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Email no registrado.");
        }

    }//GEN-LAST:event_iniciarSesionButtonActionPerformed

    private void nombreRegistroTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreRegistroTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreRegistroTxtActionPerformed

    private void telefonoRegistroTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoRegistroTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoRegistroTxtActionPerformed

    private void emailRegistroTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailRegistroTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailRegistroTxtActionPerformed

    private void dniRegistroTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniRegistroTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniRegistroTxtActionPerformed

    private void emailLoginTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailLoginTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailLoginTxtActionPerformed

    private void registrarseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarseButtonActionPerformed
        // TODO add your handling code here:

        String nombre = nombreRegistroTxt.getText();
        int dni = Integer.parseInt(dniRegistroTxt.getText());
        int telefono = Integer.parseInt(telefonoRegistroTxt.getText());
        String email = emailRegistroTxt.getText();
        if (!sistemaGestion.getAlmacen().getClientes().containsKey(email)) {
            String password = String.valueOf(passwordRegistroTxt.getPassword());

            Cliente cliente = new Cliente(nombre, dni, telefono, email, password);
            //guardamos el cliente en el registro
            sistemaGestion.getAlmacen().agregarCliente(cliente);
            sistemaGestion.getAlmacen().guardarAlmacen();

            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente.\nPor favor inicie sesión para continuar.");
            System.out.println(cliente.toString());
            nombreRegistroTxt.setText("");
            dniRegistroTxt.setText("");
            telefonoRegistroTxt.setText("");
            emailRegistroTxt.setText("");
            passwordRegistroTxt.setText("");
            registrarseButton.setEnabled(false);

            dniInvalidoLbl.setVisible(false);
            telefonoInvalidoLbl.setVisible(false);
            ingreseNombreLbl.setVisible(false);
            ingreseEmailLbl.setVisible(false);
            ingresePasswordLbl.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Ya existe una cuenta creada con el email ingresado.\nPor favor ingrese uno diferente.");
        }

    }//GEN-LAST:event_registrarseButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dniInvalidoLbl;
    private javax.swing.JTextField dniRegistroTxt;
    private javax.swing.JTextField emailLoginTxt;
    private javax.swing.JTextField emailRegistroTxt;
    private javax.swing.JLabel ingreseEmailLbl;
    private javax.swing.JLabel ingreseNombreLbl;
    private javax.swing.JLabel ingresePasswordLbl;
    private javax.swing.JButton iniciarSesionButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JTextField nombreRegistroTxt;
    private javax.swing.JPasswordField passwordLoginTxt;
    private javax.swing.JPasswordField passwordRegistroTxt;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JButton registrarseButton;
    private javax.swing.JLabel telefonoInvalidoLbl;
    private javax.swing.JTextField telefonoRegistroTxt;
    // End of variables declaration//GEN-END:variables
}
