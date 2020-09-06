/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Component;
import static java.awt.SystemColor.desktop;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Jader
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnAgendamentos = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel5 = new javax.swing.JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/bg_tela_inicial.png"));
        Image image = icon.getImage();
        jDesktopPaneInicio = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuPaciente = new javax.swing.JMenuItem();
        menuAgendamento = new javax.swing.JMenuItem();
        menuCadUsuarios = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(855, 851));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(50, 203, 254));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pacientes");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Agendamentos");

        jButton1.setBackground(new java.awt.Color(50, 203, 254));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon cadastro paciente2.png"))); // NOI18N
        jButton1.setToolTipText("Cadastro de Pacientes");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAgendamentos.setBackground(new java.awt.Color(50, 203, 254));
        btnAgendamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon agendamentos.png"))); // NOI18N
        btnAgendamentos.setToolTipText("Agendamentos");
        btnAgendamentos.setBorder(null);
        btnAgendamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendamentosActionPerformed(evt);
            }
        });

        btnSair.setBackground(new java.awt.Color(50, 203, 254));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon logout.png"))); // NOI18N
        btnSair.setToolTipText("Sair");
        btnSair.setBorder(null);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgendamentos)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(25, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btnSair)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(50, 50, 50)
                .addComponent(btnAgendamentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addGap(148, 148, 148))
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );

        jLabel5.setText("Desenvolvido por STARTECH DEVELOP Copyright 2020");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "Telefone", "Médico", "Horário", "Situação"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Agendamentos do dia");

        jDesktopPaneInicio.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneInicio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneInicioLayout = new javax.swing.GroupLayout(jDesktopPaneInicio);
        jDesktopPaneInicio.setLayout(jDesktopPaneInicioLayout);
        jDesktopPaneInicioLayout.setHorizontalGroup(
            jDesktopPaneInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jDesktopPaneInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPaneInicioLayout.setVerticalGroup(
            jDesktopPaneInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneInicioLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(407, Short.MAX_VALUE))
        );

        lblUsuario.setText("jLabel3");

        jMenuBar1.setBackground(new java.awt.Color(0, 51, 255));

        jMenu1.setText("Novo");

        menuPaciente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon cadastro paciente - menu.png"))); // NOI18N
        menuPaciente.setText("Paciente");
        menuPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPacienteActionPerformed(evt);
            }
        });
        jMenu1.add(menuPaciente);

        menuAgendamento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuAgendamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon agendamentos - menu.png"))); // NOI18N
        menuAgendamento.setText("Agendamento");
        menuAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAgendamentoActionPerformed(evt);
            }
        });
        jMenu1.add(menuAgendamento);

        menuCadUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuCadUsuarios.setText("Usuário");
        menuCadUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadUsuariosActionPerformed(evt);
            }
        });
        jMenu1.add(menuCadUsuarios);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Sobre");
        jMenuBar1.add(jMenu3);

        jMenu2.setText("Sair");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icon logout - menu.png"))); // NOI18N
        jMenuItem4.setText("Sair");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDesktopPaneInicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                        .addComponent(lblUsuario)
                        .addGap(124, 124, 124)))
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDesktopPaneInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblUsuario)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1050, 740));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPacienteActionPerformed
        // chamar tela de cliente
        CadPaciente Paciente = new CadPaciente();
        jDesktopPaneInicio.add(Paciente);
        try
        {
            Paciente.setSelected(true);
        }
        catch(java.beans.PropertyVetoException e)
        {
        }
        
        Paciente.show();
    }//GEN-LAST:event_menuPacienteActionPerformed

    private void menuAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAgendamentoActionPerformed
        CadPaciente Paciente = new CadPaciente();
        jDesktopPaneInicio.add(Paciente);
        try
        {
            Paciente.setSelected(true);
        }
        catch(java.beans.PropertyVetoException e)
        {
        }
        
        Paciente.show();
    }//GEN-LAST:event_menuAgendamentoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         CadPaciente Paciente = new CadPaciente();
        jDesktopPaneInicio.add(Paciente);
        try
        {
            Paciente.setSelected(true);
        }
        catch(java.beans.PropertyVetoException e)
        {
        }
        
        Paciente.show();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // quando clicar na opção sair exibe uma caixa de confirmação
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       // quando clicar na opção sair exibe uma caixa de confirmação
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void btnAgendamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendamentosActionPerformed
        CadAgendamento Agendamento = new CadAgendamento();
        jDesktopPaneInicio.add(Agendamento);
        try
        {
            Agendamento.setSelected(true);
        }
        catch(java.beans.PropertyVetoException e)
        {
        }
        
        Agendamento.show();
    }//GEN-LAST:event_btnAgendamentosActionPerformed

    private void menuCadUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadUsuariosActionPerformed
        CadUsuario Usuario = new CadUsuario();
        jDesktopPaneInicio.add(Usuario);
        try
        {
            Usuario.setSelected(true);
        }
        catch(java.beans.PropertyVetoException e)
        {
        }
        
        Usuario.show();
    }//GEN-LAST:event_menuCadUsuariosActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendamentos;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPaneInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    protected javax.swing.JLabel lblUsuario;
    protected javax.swing.JMenuItem menuAgendamento;
    protected javax.swing.JMenuItem menuCadUsuarios;
    public javax.swing.JMenuItem menuPaciente;
    // End of variables declaration//GEN-END:variables
}
