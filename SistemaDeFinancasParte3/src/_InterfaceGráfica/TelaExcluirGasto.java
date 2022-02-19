package _InterfaceGráfica;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.List;

import javax.swing.*;
import javax.swing.border.LineBorder;

import dados.Gasto;
import exceptions.DeleteException;
import exceptions.SelectException;
import negocio.Financas;

public class TelaExcluirGasto extends JFrame {

    static Financas financas;
    private JButton jButtonCancelar;
    private JButton jButtonConfirmRmv;
    private JComboBox<String> jComboBoxID;
    private JLabel jLabelID;
    private JLabel jLabelTitulo;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTable jTable;

    public TelaExcluirGasto(Financas financas) {
        TelaExcluirGasto.financas = financas;
        initComponents();
    }
                        
    private void initComponents() {
        jPanel1 = new JPanel();
        jLabelTitulo = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTable = new JTable();
        jButtonCancelar = new JButton();
        jButtonConfirmRmv = new JButton();
        jComboBoxID = new JComboBox<>();
        jLabelID = new JLabel();

        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 700;
        int height = 600;
        setPreferredSize(new java.awt.Dimension(width, height));
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setPreferredSize(new java.awt.Dimension(700, 600));
        setResizable(false);
        setTitle("Remover Despesa");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(241, 205, 205));
        jPanel1.setBorder(new LineBorder(new java.awt.Color(255, 50, 50), 6, true));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 600));

        jLabelTitulo.setFont(new java.awt.Font("Roboto Cn", 0, 48));
        jLabelTitulo.setText("Excluir Despesa");
        jLabelTitulo.setToolTipText("");

        jScrollPane1.setPreferredSize(new java.awt.Dimension(450, 400));

        try {
            jTable = financas.tabelaDeGastos();
        } catch (SelectException e) {
            JOptionPane.showMessageDialog(jPanel1, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        jScrollPane1.setViewportView(jTable);

        jButtonCancelar.setFont(new java.awt.Font("Roboto Cn", 0, 14));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setPreferredSize(new java.awt.Dimension(75, 25));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonConfirmRmv.setBackground(new java.awt.Color(255, 102, 102));
        jButtonConfirmRmv.setFont(new java.awt.Font("Roboto Cn", 0, 14));
        jButtonConfirmRmv.setText("Confirmar Exclusão");
        jButtonConfirmRmv.setPreferredSize(new java.awt.Dimension(75, 25));
        jButtonConfirmRmv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmRmvActionPerformed(evt);
            }
        });

        jComboBoxID.setFont(new java.awt.Font("Roboto Lt", 0, 18));
        jComboBoxID.setModel(new DefaultComboBoxModel<>(addAllIDs()));

        jLabelID.setFont(new java.awt.Font("Roboto Lt", 0, 18));
        jLabelID.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelID.setText("ID da despesa a excluir");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jComboBoxID, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jButtonCancelar, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonConfirmRmv, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelTitulo)
                        .addGap(187, 187, 187))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelID)
                        .addGap(254, 254, 254))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabelTitulo)
                .addGap(13, 13, 13)
                .addComponent(jLabelID, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxID, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConfirmRmv, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        pack();
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

    private void jButtonConfirmRmvActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        String selected = (String) jComboBoxID.getSelectedItem();
        if(selected != "IDs"){
            int IdSelected = Integer.parseInt(selected);
            try {
                financas.removeGasto(financas.selectGasto(IdSelected));
                JOptionPane.showMessageDialog(jPanel1, "Gasto excluído com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                backToMenu();
            } catch (DeleteException | SelectException e) {
                JOptionPane.showMessageDialog(jPanel1, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(jPanel1, "Nenhum ID selecionado", "Sem seleção!", JOptionPane.OK_CANCEL_OPTION);
        }
    }
    
    private void backToMenu() {
        JFrame telaLogin = new TelaMenu(financas);
        telaLogin.setVisible(true);
        dispose();
    }                             
}
