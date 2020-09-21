/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ModuloConexao;
import java.sql.*;
import java.text.DateFormat;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.util.Date;

/**
 *
 * @author Jader
 */
public class CadUsuario extends javax.swing.JInternalFrame {
    Connection conexao = null;//sempre importar
    PreparedStatement pst = null;//sempre importar
    ResultSet rs = null;//sempre importar
    /**
     * Creates new form CadUsuario
     */
    public CadUsuario() {
        initComponents();
       
        conexao = ModuloConexao.conector();//sempre digitar em todos os formularios
    }
    
    public void setar_campos() {
        int setar = tblUsuarios.getSelectedRow();
        txtNomeUser.setText(tblUsuarios.getModel().getValueAt(setar, 1).toString());
        txtCpfUser.setText(tblUsuarios.getModel().getValueAt(setar, 2).toString());
        txtTelUser.setText(tblUsuarios.getModel().getValueAt(setar, 3).toString());
        txtDataUser.setText(tblUsuarios.getModel().getValueAt(setar, 4).toString());
        txtRgUser.setText(tblUsuarios.getModel().getValueAt(setar, 5).toString());
        txtEmailUser.setText(tblUsuarios.getModel().getValueAt(setar, 6).toString());
        txtSenhaUser.setText(tblUsuarios.getModel().getValueAt(setar, 7).toString());
        cbFuncaoUser.setSelectedItem(tblUsuarios.getModel().getValueAt(setar, 8).toString());
        cbSitUser.setSelectedItem(tblUsuarios.getModel().getValueAt(setar, 9).toString());
        txtCodUser.setText(tblUsuarios.getModel().getValueAt(setar, 0).toString());
        // alinha abaixo desabilita o botão adicionar
        btnSalvarUser.setEnabled(false);
    }
    
    //metodo para popular a tabela usuarios
    private void pesquisar_usuario() {
        String sql = "select * from tb_usuarios where nome like ?";
        try {
            pst = conexao.prepareStatement(sql);
            //passando o conteúdo da caixa de pesquisa para a ?
            //atenção ao % que é a continuação da string sql
            pst.setString(1, "%" + txtPesquisaUser.getText() + "%");
            rs = pst.executeQuery();
            //A linha abaixo usa a biblioteca Rs2Xml.jar para preencher a tabela
            tblUsuarios.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void alterar() {
        
        String sql = "UPDATE `tb_usuarios` SET `nome`=?,`cpf`=?,`tel`=?,`dataNasc`=?,`rg`=?,`email`=?,`senha`=?,`perfil`=?,`situacao`=? WHERE `id`=?";
        //String sql = "update tb_usuarios set nome=?, cpf=?, tel=?, dataNasc=?, rg=?, email=?, senha=?, perfil=?, situacao=?, where id=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeUser.getText());
            pst.setString(2, txtCpfUser.getText());
            pst.setString(3, txtTelUser.getText());
            pst.setString(4, txtDataUser.getText());
            pst.setString(5, txtRgUser.getText());
            pst.setString(6, txtEmailUser.getText());
            pst.setString(7, txtSenhaUser.getText());
            pst.setString(8, cbFuncaoUser.getSelectedItem().toString());
            pst.setString(9, cbSitUser.getSelectedItem().toString());
            pst.setInt(10, Integer.parseInt(txtCodUser.getText()));
            btnSalvarUser.setEnabled(false);
            if ((txtCodUser.getText().isEmpty()) || (txtNomeUser.getText().isEmpty()) || (txtCpfUser.getText().isEmpty()) || (txtEmailUser.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "TODOS os Campos são Obrigatórios!");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso!");
                    txtNomeUser.setText(null);
                    txtCpfUser.setText(null);
                    txtTelUser.setText(null);
                    txtDataUser.setText(null);
                    txtRgUser.setText(null);
                    txtEmailUser.setText(null);
                    txtSenhaUser.setText(null);
                    btnSalvarUser.setEnabled(true);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    //metodos para adicionar usuarios
    private void adicionar() {
        String sql = "Insert into tb_usuarios (nome, cpf, tel, dataNasc, rg, email, senha, perfil, situacao)values (?,?,?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeUser.getText());
            pst.setString(2, txtCpfUser.getText());
            pst.setString(3, txtTelUser.getText());
            Date data = new Date();
            DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
            txtDataUser.setText(data.toString());
            pst.setString(4, formatador.format(data));
            pst.setString(5, txtRgUser.getText());
            pst.setString(6, txtEmailUser.getText());
            pst.setString(7, txtSenhaUser.getText());
            pst.setString(8, cbFuncaoUser.getSelectedItem().toString());
            pst.setString(9, cbSitUser.getSelectedItem().toString());

            //validação dos campos obrigatórios
            if ((txtNomeUser.getText().isEmpty()) || (txtCpfUser.getText().isEmpty()) || (txtTelUser.getText().isEmpty() ||
                    txtDataUser.getText().isEmpty() || txtRgUser.getText().isEmpty() || txtEmailUser.getText().isEmpty() ||
                    txtSenhaUser.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "TODOS os Campos são Obrigatórios!");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário Adicionado com Sucesso!");
                    txtNomeUser.setText(null);
                    txtCpfUser.setText(null);
                    txtTelUser.setText(null);
                    txtDataUser.setText(null);
                    txtRgUser.setText(null);
                    txtEmailUser.setText(null);
                    txtSenhaUser.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPesquisaUser = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNomeUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCpfUser = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtRgUser = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDataUser = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmailUser = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTelUser = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        cbFuncaoUser = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbSitUser = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtSenhaUser = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        txtCodUser = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnSalvarUser = new javax.swing.JButton();
        btnAlterarUser = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuários");
        setPreferredSize(new java.awt.Dimension(916, 637));

        txtPesquisaUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaUserKeyReleased(evt);
            }
        });

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Telefone", "E-mail", "Função"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        jPanel1.setBackground(new java.awt.Color(50, 203, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Pessoais"));

        jLabel2.setText("Nome");

        jLabel3.setText("CPF");

        try {
            txtCpfUser.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("RG");

        jLabel5.setText("Data de Nasc.");

        try {
            txtDataUser.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Função");

        jLabel13.setText("E-mail");

        try {
            txtTelUser.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel14.setText("Tel");

        cbFuncaoUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Recepcionista", "Administrador", "Suporte", "Médico" }));

        jLabel7.setText("Situação");

        cbSitUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));

        jLabel8.setText("Senha");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Código");

        txtCodUser.setEditable(false);
        txtCodUser.setBackground(new java.awt.Color(255, 255, 255));
        txtCodUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtCodUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodUser.setToolTipText("Código de Usuário");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDataUser, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRgUser, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmailUser, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addComponent(txtNomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCpfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSenhaUser))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbFuncaoUser, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbSitUser, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(296, 296, 296)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCodUser, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodUser, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtRgUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(txtEmailUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(txtSenhaUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtDataUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(txtTelUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(cbFuncaoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(cbSitUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Editar");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Adicionar");

        jLabel12.setText("Pesquisa");

        btnSalvarUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_save.png"))); // NOI18N
        btnSalvarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarUserActionPerformed(evt);
            }
        });

        btnAlterarUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btm_edit.png"))); // NOI18N
        btnAlterarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPesquisaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(btnAlterarUser, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btnSalvarUser, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisaUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAlterarUser, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvarUser, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        setBounds(0, 0, 879, 643);
    }// </editor-fold>//GEN-END:initComponents

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        setar_campos();
    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void txtPesquisaUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaUserKeyReleased
        pesquisar_usuario();
    }//GEN-LAST:event_txtPesquisaUserKeyReleased

    private void btnAlterarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarUserActionPerformed
        alterar();
    }//GEN-LAST:event_btnAlterarUserActionPerformed

    private void btnSalvarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarUserActionPerformed
        adicionar();
    }//GEN-LAST:event_btnSalvarUserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarUser;
    private javax.swing.JButton btnSalvarUser;
    private javax.swing.JComboBox<String> cbFuncaoUser;
    private javax.swing.JComboBox<String> cbSitUser;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtCodUser;
    private javax.swing.JFormattedTextField txtCpfUser;
    private javax.swing.JFormattedTextField txtDataUser;
    private javax.swing.JTextField txtEmailUser;
    private javax.swing.JTextField txtNomeUser;
    private javax.swing.JTextField txtPesquisaUser;
    private javax.swing.JTextField txtRgUser;
    private javax.swing.JPasswordField txtSenhaUser;
    private javax.swing.JFormattedTextField txtTelUser;
    // End of variables declaration//GEN-END:variables
}
