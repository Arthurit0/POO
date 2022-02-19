/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package _InterfaceGráfica;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.*;

import dados.Gasto;
import exceptions.SelectException;
import exceptions.UpdateException;
import negocio.Financas;

public class TelaEditarGasto extends JFrame {

    
    static Financas financas;
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
    private JButton jButtonCancelar;
    private JButton jButtonConfirmEdit;
    private JComboBox<String> jComboBoxCategoria;
    private JComboBox<String> jComboBoxID;
    private JLabel jLabelCateg;
    private JLabel jLabelData;
    private JLabel jLabelDesc;
    private JLabel jLabelID;
    private JLabel jLabelNome;
    private JLabel jLabelTitulo;
    private JLabel jLabelValor;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTable jTable;
    private JTextField jTextFieldData;
    private JTextField jTextFieldNome;
    private JTextField jTextFieldValor;
    private JTextPane jTextPaneDesc;

    public TelaEditarGasto(Financas financas) {
        TelaEditarGasto.financas = financas;
        initComponents();
    }
                       
    private void initComponents() {

        jPanel1 = new JPanel();
        jLabelTitulo = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTable = new JTable();
        jComboBoxID = new JComboBox<>();
        jLabelID = new JLabel();
        jLabelNome = new JLabel();
        jTextFieldNome = new JTextField();
        jComboBoxCategoria = new JComboBox<>();
        jLabelCateg = new JLabel();
        jLabelData = new JLabel();
        jTextFieldData = new JTextField();
        jLabelValor = new JLabel();
        jTextFieldValor = new JTextField();
        jButtonCancelar = new JButton();
        jLabelDesc = new JLabel();
        jScrollPane2 = new JScrollPane();
        jTextPaneDesc = new JTextPane();
        jButtonConfirmEdit = new JButton();

        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 700;
        int height = 700;
        setPreferredSize(new java.awt.Dimension(width, height));
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setResizable(false);
        setTitle("Editar Despesa");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(205, 241, 241));
        jPanel1.setBorder(BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255), 7));

        jLabelTitulo.setFont(new java.awt.Font("Roboto Cn", 0, 48));
        jLabelTitulo.setText("Editar Despesa");
        jLabelTitulo.setToolTipText("");

        try {
            jTable = financas.tabelaDeGastos();
        } catch (SelectException e) {
            JOptionPane.showMessageDialog(jPanel1, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        jScrollPane1.setViewportView(jTable);

        jComboBoxID.setFont(new java.awt.Font("Roboto Lt", 0, 18));
        jComboBoxID.setModel(new DefaultComboBoxModel<>(addAllIDs()));
        jComboBoxID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxIDActionPerformed(evt);
            }
        });

        jLabelID.setFont(new java.awt.Font("Roboto Lt", 0, 18));
        jLabelID.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelID.setText("ID da despesa a editar");

        jLabelNome.setFont(new java.awt.Font("Roboto Lt", 0, 24));
        jLabelNome.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelNome.setText("Nome da Despesa");

        jTextFieldNome.setFont(new java.awt.Font("Roboto Lt", 0, 14));

        jComboBoxCategoria.setFont(new java.awt.Font("Roboto Lt", 0, 14));
        jComboBoxCategoria.setModel(new DefaultComboBoxModel<>(new String[] { "Comida", "Lazer", "Educação", "Saúde", "Transporte", "Outros" }));

        jLabelCateg.setFont(new java.awt.Font("Roboto Lt", 0, 24));
        jLabelCateg.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelCateg.setText("Categoria");

        jLabelData.setFont(new java.awt.Font("Roboto Lt", 0, 24));
        jLabelData.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelData.setText("Data");

        jTextFieldData.setFont(new java.awt.Font("Roboto Lt", 0, 14));
        jTextFieldData.setText("DD/MM");

        jLabelValor.setFont(new java.awt.Font("Roboto Lt", 0, 24));
        jLabelValor.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelValor.setText("Valor");

        jTextFieldValor.setFont(new java.awt.Font("Roboto Lt", 0, 14));

        jButtonCancelar.setFont(new java.awt.Font("Roboto Cn", 0, 14));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setPreferredSize(new java.awt.Dimension(75, 25));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabelDesc.setFont(new java.awt.Font("Roboto Lt", 0, 18));
        jLabelDesc.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelDesc.setText("Descrição");

        jTextPaneDesc.setFont(new java.awt.Font("Roboto Lt", 0, 12));
        jScrollPane2.setViewportView(jTextPaneDesc);

        jButtonConfirmEdit.setFont(new java.awt.Font("Roboto Cn", 0, 14));
        jButtonConfirmEdit.setText("Confirmar Edição");
        jButtonConfirmEdit.setPreferredSize(new java.awt.Dimension(75, 25));
        jButtonConfirmEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmEditActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelID)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jComboBoxID, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldValor, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                    .addComponent(jLabelValor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelDesc)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane2)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNome, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldNome, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelCateg, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25))
                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jComboBoxCategoria, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 43, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 593, GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addGap(36, 36, 36))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jLabelTitulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jButtonCancelar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButtonConfirmEdit, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelData, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldData, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelID, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNome)
                    .addComponent(jLabelCateg))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxID, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNome, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCategoria, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelDesc)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabelData)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldData))
                        .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabelValor)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldValor, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConfirmEdit, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

    }
    
    protected void jComboBoxIDActionPerformed(ActionEvent evt) {
        int selecionado = jComboBoxID.getSelectedIndex();
        if(selecionado != 0){
            try {
                TabelaGastos tabelaGastos = (TabelaGastos) jTable.getModel();
                int id = (int) tabelaGastos.getValueAt(selecionado-1, 0);

                Gasto gastoSelecionado = financas.selectGasto(id);

                jTextFieldNome.setText("");
                jTextFieldData.setText("");
                jTextFieldValor.setText("");
                jTextPaneDesc.setText("");
                jComboBoxCategoria.setSelectedIndex(0);

                jTextFieldNome.setText(gastoSelecionado.getNome());
                jTextFieldData.setText(gastoSelecionado.getData());
                jTextFieldValor.setText(Float.toString(gastoSelecionado.getValor()));
                jTextPaneDesc.setText(gastoSelecionado.getDescricao());
                jComboBoxCategoria.setSelectedIndex(gastoSelecionado.getCategoria()-1);
                
            } catch (SelectException e) {
                JOptionPane.showMessageDialog(jPanel1, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private String[] addAllIDs() {
        try {
            List<Gasto> gastos = financas.seeAllGastos();
            String[] Ids = new String[gastos.size()+1];

            Ids[0] = "IDs";

            for(int i = 0; i <= gastos.size()-1; i++){
                Ids[i+1] = Integer.toString(gastos.get(i).getId());
            }

            return Ids;

        } catch (SelectException e) {
            JOptionPane.showMessageDialog(jPanel1, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    
    }                                             

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                                
        backToMenu();
    }                                               

    private void jButtonConfirmEditActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        try {
            Gasto gasto = new Gasto();

            gasto.setNome(jTextFieldNome.getText());
            gasto.setDescricao((jTextPaneDesc.getText()));
            gasto.setData(sdf.parse(jTextFieldData.getText()));
            gasto.setValor(Float.parseFloat(jTextFieldValor.getText()));
            gasto.setCategoria(jComboBoxCategoria.getSelectedIndex()+1);
            
            String verificaID = (String)jComboBoxID.getSelectedItem();

            if(verificaID == "IDs"){
                JOptionPane.showMessageDialog(jPanel1, "Erro: Nenhum ID selecionado!", "Erro!", JOptionPane.ERROR_MESSAGE);
            }else{
                int id = Integer.parseInt(verificaID);
                gasto.setId(id);

                if(gasto.equals(financas.selectGasto(id))){
                    JOptionPane.showMessageDialog(jPanel1, "Não houve nenhuma alteração...", "Nenhuma ação realizada", JOptionPane.OK_CANCEL_OPTION);
                }else{
                    financas.updateGasto(gasto);
                    JOptionPane.showMessageDialog(jPanel1, "Gasto editado com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                    backToMenu();
                }
            }
        } catch (UpdateException | SelectException | ParseException | NumberFormatException e) {
            JOptionPane.showMessageDialog(jPanel1, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            backToMenu();
        }
    }

    private void backToMenu() {
        JFrame telaLogin = new TelaMenu(financas);
        telaLogin.setVisible(true);
        dispose();
    }                                              
}
