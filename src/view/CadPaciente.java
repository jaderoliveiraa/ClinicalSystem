/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Jader
 */
public class CadPaciente extends javax.swing.JInternalFrame {

    Connection conexao = null;//sempre importar
    PreparedStatement pst = null;//sempre importar
    ResultSet rs = null;//sempre importar

    public CadPaciente() {
        initComponents();
        conexao = ModuloConexao.conector();//sempre digitar em todos os formularios
    }
    
    //metodos para adicionar usuarios
    private void adicionar_paciente() {
        String sql = "Insert into tb_pacientes (nome, cpf, dataNasc,  rg,  email, tel, responsavel, endereco, num, bairro, cidade, estado, situacao)values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtPacNome.getText());
            pst.setString(2, txtPacCpf.getText());
            //Date data = new Date();
            //DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
            //txtPacNasc.setText(data.toString());
            pst.setString(3, txtPacNasc.getText());
            pst.setString(4, txtPacRg.getText());
            pst.setString(5, txtPacEmail.getText());
            pst.setString(6, txtPacTel.getText());
            pst.setString(7, txtPacResp.getText());
            pst.setString(8, txtPacEnd.getText());            
            pst.setString(9, txtPacNum.getText());
            pst.setString(10, txtPacBairro.getText());
            pst.setString(11, txtPacCidade.getText());
            pst.setString(12, cbPacEstado.getSelectedItem().toString());
            pst.setString(13, cbPacSit.getSelectedItem().toString());

            //validação dos campos obrigatórios
            if ((txtPacNome.getText().isEmpty()) || (txtPacCpf.getText().isEmpty()) || (txtPacNasc.getText().isEmpty() ||
                    txtPacRg.getText().isEmpty() || txtPacEmail.getText().isEmpty() || txtPacTel.getText().isEmpty() ||
                    txtPacResp.getText().isEmpty() || txtPacEnd.getText().isEmpty() || txtPacNum.getText().isEmpty() ||
                    txtPacBairro.getText().isEmpty() || txtPacCidade.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "TODOS os Campos são Obrigatórios!");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Paciente Adicionado com Sucesso!");
                    txtPacNome.setText(null);
                    txtPacCpf.setText(null);
                    txtPacNasc.setText(null);
                    txtPacRg.setText(null);
                    txtPacEmail.setText(null);
                    txtPacTel.setText(null);
                    txtPacResp.setText(null);
                    txtPacEnd.setText(null);
                    txtPacNum.setText(null);
                    txtPacBairro.setText(null);
                    txtPacCidade.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //metodo para popular a tabela Pacicentes
    private void pesquisar_paciente() {
        String sql = "select * from tb_pacientes where nome like ?";
        try {
            pst = conexao.prepareStatement(sql);
            //passando o conteúdo da caixa de pesquisa para a ?
            //atenção ao % que é a continuação da string sql
            pst.setString(1, "%" + txtPacPesq.getText() + "%");
            rs = pst.executeQuery();
            //A linha abaixo usa a biblioteca Rs2Xml.jar para preencher a tabela
            tblPac.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void popular_tabela() {
        String sql = "select * from tb_pacientes";
        try {
            pst = conexao.prepareStatement(sql);
            //passando o conteúdo da caixa de pesquisa para a ?
            //atenção ao % que é a continuação da string sql
            pst.setString(1, sql);
            rs = pst.executeQuery();
            //A linha abaixo usa a biblioteca Rs2Xml.jar para preencher a tabela
            tblPac.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //metodo para setar os campos ao clicar em uma linha
    public void setar_campos() {
        int setar = tblPac.getSelectedRow();
        txtPacNome.setText(tblPac.getModel().getValueAt(setar, 1).toString());
        txtPacCpf.setText(tblPac.getModel().getValueAt(setar, 2).toString());
        txtPacNasc.setText(tblPac.getModel().getValueAt(setar, 3).toString());
        txtPacRg.setText(tblPac.getModel().getValueAt(setar, 4).toString());
        txtPacEmail.setText(tblPac.getModel().getValueAt(setar, 5).toString());
        txtPacTel.setText(tblPac.getModel().getValueAt(setar, 6).toString());
        txtPacResp.setText(tblPac.getModel().getValueAt(setar, 7).toString());
        txtPacEnd.setText(tblPac.getModel().getValueAt(setar, 8).toString());
        txtPacNum.setText(tblPac.getModel().getValueAt(setar, 9).toString());
        txtPacBairro.setText(tblPac.getModel().getValueAt(setar, 10).toString());
        txtPacCidade.setText(tblPac.getModel().getValueAt(setar, 11).toString());
        cbPacEstado.setSelectedItem(tblPac.getModel().getValueAt(setar, 12).toString());
        cbPacSit.setSelectedItem(tblPac.getModel().getValueAt(setar, 13).toString());
        txtPacCod.setText(tblPac.getModel().getValueAt(setar, 0).toString());
        // alinha abaixo desabilita o botão adicionar
        btnPacSave.setEnabled(false);
    }
    

    //metodo para editar paciente
    private void alterar_paciente() {
        String sql = "UPDATE `tb_pacientes` SET `nome`=?,`cpf`=?,`dataNasc`=?,`rg`=?,`email`=?,`tel`=?,`responsavel`=?,`endereco`=?,`num`=?,`bairro`=?,`cidade`=?,`estado`=?, `situacao`=? WHERE `id`=?";
       //String sql = "UPDATE `tb_pacientes` SET `nome`=?,`cpf`=?, `dataNasc`=?, `rg`=?, `email`=?, `tel`=?,`responsavel`=?,`endereco`=?,`num`=? `bairro`=?, `cidade`=?, `estado`=? WHERE `id`=?";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtPacNome.getText());
            pst.setString(2, txtPacCpf.getText());
            pst.setString(3, txtPacNasc.getText());
            pst.setString(4, txtPacRg.getText());
            pst.setString(5, txtPacEmail.getText());
            pst.setString(6, txtPacTel.getText());
            pst.setString(7, txtPacResp.getText());
            pst.setString(8, txtPacEnd.getText());
            pst.setString(9, txtPacNum.getText());
            pst.setString(10, txtPacBairro.getText());
            pst.setString(11, txtPacCidade.getText());
            pst.setString(12, cbPacEstado.getSelectedItem().toString());
            pst.setString(13, cbPacSit.getSelectedItem().toString());
            pst.setInt(14, Integer.parseInt(txtPacCod.getText()));
            btnPacSave.setEnabled(false);
            if ((txtPacCod.getText().isEmpty()) || (txtPacNome.getText().isEmpty()) || (txtPacCpf.getText().isEmpty()) || (txtPacEmail.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "TODOS os Campos são Obrigatórios!");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso!");
                    txtPacNome.setText(null);
                    txtPacCpf.setText(null);
                    txtPacNasc.setText(null);
                    txtPacRg.setText(null);
                    txtPacEmail.setText(null);
                    txtPacTel.setText(null);
                    txtPacResp.setText(null);
                    txtPacEnd.setText(null);
                    txtPacNum.setText(null);
                    txtPacBairro.setText(null);
                    txtPacCidade.setText(null);
                    txtPacCod.setText(null);
                    btnPacSave.setEnabled(true);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPacNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPacCpf = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPacRg = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPacNasc = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPacResp = new javax.swing.JTextField();
        txtPacEmail = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtPacTel = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtPacCod = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPacEnd = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtPacNum = new javax.swing.JTextField();
        txtPacBairro = new javax.swing.JTextField();
        txtPacCidade = new javax.swing.JTextField();
        cbPacEstado = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cbPacSit = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtPacPesq = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPac = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnPacEdit = new javax.swing.JButton();
        btnPacSave = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setClosable(true);
        setTitle("Cadastro de Pacientes");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(50, 203, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Pessoais"));

        jLabel2.setText("Nome");

        jLabel3.setText("CPF");

        try {
            txtPacCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("RG");

        jLabel5.setText("Data de Nasc.");

        try {
            txtPacNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Responsável");

        jLabel13.setText("E-mail");

        try {
            txtPacTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel14.setText("Tel");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("Código");

        txtPacCod.setEditable(false);
        txtPacCod.setBackground(new java.awt.Color(255, 255, 255));
        txtPacCod.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPacResp)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPacNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPacRg, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPacEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                            .addComponent(txtPacNome))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPacTel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPacCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPacCod, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPacCod, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPacNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPacCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtPacRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(txtPacEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(txtPacTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtPacNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPacResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(50, 203, 254));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        jLabel7.setText("Endereço");

        jLabel8.setText("Bairro");

        jLabel9.setText("Cidade");

        jLabel10.setText("Estado");

        txtPacEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPacEndActionPerformed(evt);
            }
        });

        jLabel11.setText("Nº");

        cbPacEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CE", "AC", "AL", "AP", "AM", "BA", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        jLabel1.setText("Situação");

        cbPacSit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPacEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPacNum, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPacBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPacCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPacEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPacSit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtPacNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtPacEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(txtPacBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPacCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPacEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cbPacSit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setText("Pesquisa");

        txtPacPesq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPacPesqKeyReleased(evt);
            }
        });

        tblPac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblPac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPacMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPac);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Editar");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Adicionar");

        btnPacEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btm_edit.png"))); // NOI18N
        btnPacEdit.setBorder(null);
        btnPacEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacEditActionPerformed(evt);
            }
        });

        btnPacSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/btn_save.png"))); // NOI18N
        btnPacSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPacPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPacEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(btnPacSave, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabel18)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPacPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPacSave, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPacEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPacEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPacEndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPacEndActionPerformed

    private void txtPacPesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPacPesqKeyReleased
        pesquisar_paciente();
    }//GEN-LAST:event_txtPacPesqKeyReleased

    private void tblPacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPacMouseClicked
        setar_campos();
    }//GEN-LAST:event_tblPacMouseClicked

    private void btnPacEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacEditActionPerformed
        alterar_paciente();
    }//GEN-LAST:event_btnPacEditActionPerformed

    private void btnPacSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacSaveActionPerformed
        adicionar_paciente();
    }//GEN-LAST:event_btnPacSaveActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
      // popular_tabela();
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPacEdit;
    private javax.swing.JButton btnPacSave;
    private javax.swing.JComboBox<String> cbPacEstado;
    private javax.swing.JComboBox<String> cbPacSit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPac;
    private javax.swing.JTextField txtPacBairro;
    private javax.swing.JTextField txtPacCidade;
    private javax.swing.JTextField txtPacCod;
    private javax.swing.JFormattedTextField txtPacCpf;
    private javax.swing.JTextField txtPacEmail;
    private javax.swing.JTextField txtPacEnd;
    private javax.swing.JFormattedTextField txtPacNasc;
    private javax.swing.JTextField txtPacNome;
    private javax.swing.JTextField txtPacNum;
    private javax.swing.JTextField txtPacPesq;
    private javax.swing.JTextField txtPacResp;
    private javax.swing.JTextField txtPacRg;
    private javax.swing.JFormattedTextField txtPacTel;
    // End of variables declaration//GEN-END:variables
}
