package chat;

import java.awt.Color;
import java.awt.Image;
import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Servidor extends javax.swing.JFrame {

    ServerSocket servidor = null;
    Socket socket = null;
    BufferedReader lector = null;
    PrintWriter escritor = null;
    String usuario = "Default";
    int port = 9000;
    ImageIcon i=new ImageIcon("/src/imagen/fondo.jpg");
    public Servidor() {
        Thread principal = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    servidor = new ServerSocket(port);
                    while (true) {
                        socket = servidor.accept();
                        leer();
                        escribir();
                    }
                } catch (Exception ex) {
                    System.out.println("Error " + ex);
                }
            }
        });
        initComponents();
        fondoo.setIcon(i);
        jMenuItem2.setText("Nombre de usuario");
        jMenuItem1.setText("Puerto");
        jMenuItem3.setText("Foto de perfil");
        fondoo.setText("Fondo");
        borrar.setText("Borrar conversacion");
        AConver.setText("Archivar conversacion");
        foto.setBounds(21, -2, 64, 80);
        jScrollPane3.setOpaque(false);
        jScrollPane3.setBorder(null);
        enviar.setBounds(300, 475, 63, 50);
        jScrollPane4.setOpaque(false);
        jScrollPane4.getViewport().setOpaque(false);
        jScrollPane4.setBorder(null);
        texto.setBorder(null);
        texto.setBackground(new Color(0, 0, 0, 30));
        setTitle("Servidor");
        setSize(385, 600);
        principal.start();
    }

    public void leer() {
        Thread leer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    while (true) {
                        String mrecibido = lector.readLine();
                        texto.append(mrecibido + "\n");
                    }
                } catch (Exception ex) {
                    System.out.println("Error " + ex);
                }
            }
        });
        leer.start();
    }

    public void escribir() {
        Thread escribir = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    escritor = new PrintWriter(socket.getOutputStream(), true);
                    enviar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String menviado = tenviado.getText();
                            texto.append("Yo: " + menviado + "\n\n");
                            escritor.println(usuario + ": " + menviado + "\n");
                            tenviado.setText("");
                        }
                    });
                } catch (Exception ex) {
                    System.out.println("Error " + ex);
                }
            }
        });
        escribir.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        fondoo = new javax.swing.JMenuItem();
        borrar = new javax.swing.JMenuItem();
        AConver = new javax.swing.JMenuItem();
        NServidor = new javax.swing.JTextField();
        enviar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tenviado = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextArea();
        menub = new javax.swing.JButton();
        p = new javax.swing.JLabel();
        NombreServidor = new javax.swing.JLabel();
        Color = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        foto = new javax.swing.JLabel();
        puerto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jMenuItem2.setText("jMenuItem2");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem2);

        jMenuItem1.setText("jMenuItem1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem1);

        jMenuItem3.setText("jMenuItem3");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem3);

        fondoo.setText("jMenuItem4");
        fondoo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fondooActionPerformed(evt);
            }
        });
        jPopupMenu2.add(fondoo);

        borrar.setText("jMenuItem4");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });
        jPopupMenu2.add(borrar);

        AConver.setText("jMenuItem3");
        AConver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AConverActionPerformed(evt);
            }
        });
        jPopupMenu2.add(AConver);

        NServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NServidorActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        enviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/enviar.png"))); // NOI18N
        enviar.setContentAreaFilled(false);
        getContentPane().add(enviar);
        enviar.setBounds(300, 470, 63, 50);

        jScrollPane3.setOpaque(false);

        tenviado.setColumns(20);
        tenviado.setLineWrap(true);
        tenviado.setRows(5);
        tenviado.setWrapStyleWord(true);
        tenviado.setOpaque(false);
        jScrollPane3.setViewportView(tenviado);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(40, 480, 250, 40);

        texto.setColumns(20);
        texto.setLineWrap(true);
        texto.setRows(5);
        texto.setWrapStyleWord(true);
        texto.setBorder(null);
        texto.setOpaque(false);
        jScrollPane4.setViewportView(texto);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(30, 110, 290, 340);

        menub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/menubutton.png"))); // NOI18N
        menub.setComponentPopupMenu(jPopupMenu2);
        menub.setContentAreaFilled(false);
        getContentPane().add(menub);
        menub.setBounds(320, 20, 40, 40);

        p.setForeground(new java.awt.Color(255, 255, 255));
        p.setText("Puerto");
        getContentPane().add(p);
        p.setBounds(90, 50, 120, 14);

        NombreServidor.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        NombreServidor.setForeground(new java.awt.Color(255, 255, 255));
        NombreServidor.setText("Default");
        getContentPane().add(NombreServidor);
        NombreServidor.setBounds(90, 20, 90, 30);

        Color.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Color.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Color.png"))); // NOI18N
        getContentPane().add(Color);
        Color.setBounds(0, 0, 380, 560);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/cuadrotexto.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 320, 530);

        foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/foto.png"))); // NOI18N
        getContentPane().add(foto);
        foto.setBounds(34, 20, 40, 30);
        getContentPane().add(puerto);
        puerto.setBounds(220, 20, 60, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-6, -6, 390, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NServidorActionPerformed

    }//GEN-LAST:event_NServidorActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        usuario = JOptionPane.showInputDialog(this, "Ingrese su nombre de usuario");
        NombreServidor.setText(usuario);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        port = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el numero de su puerto"));
        p.setText("Puerto: " + String.valueOf(port));
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG", "jpg", "png");
        fc.setFileFilter(fil);
        fc.setMultiSelectionEnabled(false);
        int r = fc.showOpenDialog(this);
        if (r == JFileChooser.APPROVE_OPTION) {
            String ruta = fc.getSelectedFile().getAbsolutePath();
            ImageIcon imagen1 = new ImageIcon(ruta);
            Icon fondo1 = new ImageIcon(imagen1.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT));
            foto.setIcon(fondo1);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void fondooActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fondooActionPerformed
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG", "jpg", "png");
        fc.setFileFilter(fil);
        fc.setMultiSelectionEnabled(false);
        int r = fc.showOpenDialog(this);
        if (r == JFileChooser.APPROVE_OPTION) {
            String ruta = fc.getSelectedFile().getAbsolutePath();
            ImageIcon imagen1 = new ImageIcon(ruta);
            Icon fondo1 = new ImageIcon(imagen1.getImage().getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_DEFAULT));
            jLabel2.setIcon(fondo1);
        }
        }    catch(Exception ex){
    
}
    }//GEN-LAST:event_fondooActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        texto.setText("");
    }//GEN-LAST:event_borrarActionPerformed

    private void AConverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AConverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AConverActionPerformed

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
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Servidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AConver;
    private javax.swing.JLabel Color;
    private javax.swing.JTextField NServidor;
    private javax.swing.JLabel NombreServidor;
    private javax.swing.JMenuItem borrar;
    private javax.swing.JButton enviar;
    private javax.swing.JMenuItem fondoo;
    private javax.swing.JLabel foto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton menub;
    private javax.swing.JLabel p;
    private javax.swing.JTextField puerto;
    private javax.swing.JTextArea tenviado;
    private javax.swing.JTextArea texto;
    // End of variables declaration//GEN-END:variables
}
