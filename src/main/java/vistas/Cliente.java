/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import com.mycompany.chat.rmi.ChatClient;
import com.mycompany.chat.rmi.ChatRoomRemote;
import com.mycompany.chat.rmi.ChatService;
import com.mycompany.chat.rmi.ChatServiceRemote;

import com.mycompany.chat.rmi.ClientCallback;
import com.mycompany.chat.rmi.ClientCallback;
import com.mycompany.chat.rmi.ClientCallbackImpl;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


/**
 *
 * @author Belén
 */
public class Cliente extends javax.swing.JFrame {

    private ChatClient clienteRMI;
    private ChatServiceRemote chatService;
    private ClientCallbackImpl clientCallback;
    private ChatRoomRemote chatRoom;

    private String userName;
    public Cliente() {
        initComponents();
       txtPanelChat.setEnabled(false);
       txtPanelChat.setDisabledTextColor(Color.BLACK);
    
        btnLogout.setEnabled(false);
        btnEnviarMensaje.setEnabled(false);
        this.getContentPane().setBackground(Color.getHSBColor(0.5444f, 0.6126f, 0.4353f));
        // Agrega un KeyListener al campo de texto
        txtNombreCliente.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetterOrDigit(c)) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // No necesitamos implementar este método, pero es necesario para la interfaz KeyListener
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // No necesitamos implementar este método, pero es necesario para la interfaz KeyListener
            }
        });
          clienteRMI = new ChatClient();
    }
    
   private void connectToServer() {
        final int PORT = 8888;
        final String HOST = "localhost"; // Asegúrate de que esta dirección sea correcta

        try {
            ClientCallbackImpl callback = new ClientCallbackImpl(txtPanelChat); // Pass the JTextArea
            clienteRMI.connectToServer(HOST, PORT, callback);
            txtPanelChat.append("Bienvenido al chat room!\n");
              System.out.println("Bienvenido al chat room!\n");
           // txtPanelChat.append("Por favor, inicie sesión con el comando: LOGIN usuario_o_nick\n");
        } catch (RemoteException | NotBoundException e) {
            JOptionPane.showMessageDialog(this, "Error al conectar con el servidor de chat: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
 private void ClienteLogueado() throws IOException {
        String nombre = txtNombreCliente.getText();
        labelDescripcionCliente.setText("Usuario: " + nombre);
        btnLogin.setEnabled(false);
        btnLogout.setEnabled(true);
        btnEnviarMensaje.setEnabled(true);
        txtNombreCliente.setEnabled(false); // Deshabilita la edición del nombre después de registrarse
        try {
            clienteRMI.login(nombre);
            userName = nombre;
             System.out.println("Usuario: "+userName);
        } catch (RemoteException e) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Error al iniciar sesión: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarInterfaz() throws IOException {
        labelDescripcionCliente.setText("");
        txtNombreCliente.setText("");
        txtMensajeCliente.setText("");
        txtPanelChat.setText("");
        btnLogin.setEnabled(true);
        btnLogout.setEnabled(false);
        btnEnviarMensaje.setEnabled(false);
        txtNombreCliente.setEnabled(true);
        clienteRMI.logout();
        System.out.println("Usuario desconectado");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        labelDescripcionCliente = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPanelChat = new javax.swing.JTextArea();
        txtMensajeCliente = new javax.swing.JTextField();
        btnEnviarMensaje = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Nombre de Usuario:");

        txtNombreCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreClienteActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(102, 255, 153));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        labelDescripcionCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelDescripcionCliente.setText("Usuario: ");
        labelDescripcionCliente.setToolTipText("");

        btnLogout.setBackground(new java.awt.Color(153, 255, 153));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        txtPanelChat.setColumns(20);
        txtPanelChat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPanelChat.setRows(5);
        jScrollPane1.setViewportView(txtPanelChat);

        txtMensajeCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMensajeCliente.setToolTipText("");

        btnEnviarMensaje.setBackground(new java.awt.Color(153, 255, 153));
        btnEnviarMensaje.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEnviarMensaje.setText("Enviar");
        btnEnviarMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarMensajeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelDescripcionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombreCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 34, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtMensajeCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEnviarMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)))))
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDescripcionCliente))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMensajeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEnviarMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18))))
        );

        jLabel2.getAccessibleContext().setAccessibleName("labelNombreChatter");
        txtNombreCliente.getAccessibleContext().setAccessibleName("");
        btnLogin.getAccessibleContext().setAccessibleName("btnLogin");
        labelDescripcionCliente.getAccessibleContext().setAccessibleName("labelNombreRegistrado");
        btnLogout.getAccessibleContext().setAccessibleName("btnLogout");
        btnLogout.getAccessibleContext().setAccessibleDescription("");
        txtMensajeCliente.getAccessibleContext().setAccessibleName("txtMensajeChatter");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreClienteActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtNombreClienteActionPerformed

    
    private void btnEnviarMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarMensajeActionPerformed
     /* try {
        String mensaje = txtMensajeCliente.getText();
        txtMensajeCliente.setText(""); // Clear message field after sending

        if (!mensaje.isEmpty()) {
            chatService.executeCommand("CHAT", mensaje);
        }
    } catch (RemoteException ex) {
        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error al enviar mensaje: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }   catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }*/
      try {
            String mensaje = txtMensajeCliente.getText();
            txtMensajeCliente.setText(""); // Clear message field after sending

            if (!mensaje.isEmpty()) {
                clienteRMI.sendMessage(mensaje);
            }
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al enviar mensaje: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEnviarMensajeActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
  /* try {
        String nombre = txtNombreCliente.getText();
        labelDescripcionCliente.setText("Usuario: " + nombre);
        btnLogin.setEnabled(false);
        btnLogout.setEnabled(true);
        btnEnviarMensaje.setEnabled(true);
        txtNombreCliente.setEnabled(false); // Disable name editing after registration
        connectToServer();
        // Verifica que chatService no sea nulo
        if (chatService != null) {
            chatService.executeCommand("LOGIN", nombre);
            userName = nombre;
        } else {
            JOptionPane.showMessageDialog(this, "Error: chatService no inicializado correctamente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (IOException ex) {
        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error al iniciar sesión: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    ex.printStackTrace();
    }
        */
       connectToServer();
        try {
            ClienteLogueado();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    
    
    
   

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
     //   limpiarInterfaz();
         try {
        limpiarInterfaz();
    } catch (IOException ex) {
        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error al cerrar sesión: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnLogoutActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Cliente().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviarMensaje;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogout;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDescripcionCliente;
    private javax.swing.JTextField txtMensajeCliente;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextArea txtPanelChat;
    // End of variables declaration//GEN-END:variables
}

