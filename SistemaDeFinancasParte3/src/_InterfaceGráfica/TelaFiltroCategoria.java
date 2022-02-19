package _InterfaceGráfica;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.List;

import javax.swing.*;

import dados.Gasto;
import exceptions.SelectException;
import negocio.Financas;

public class TelaFiltroCategoria extends JFrame {

    static Financas financas;
    private JButton jButtonVoltar;
    private JComboBox<String> jComboBoxCategoria;
    private JLabel jLabelTitulo;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTable jTable;

    public TelaFiltroCategoria(Financas financas) {
        TelaFiltroCategoria.financas = financas;
        initComponents();
    }
   
    private void initComponents() {

        jPanel1 = new JPanel();
        jLabelTitulo = new JLabel();
        jComboBoxCategoria = new JComboBox<>();
        jButtonVoltar = new JButton();
        jScrollPane1 = new JScrollPane();
        jTable = new JTable();

        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 700;
        int height = 600;
        setPreferredSize(new java.awt.Dimension(width, height));
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setResizable(false);
        setTitle("Despesas por categoria");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(205, 241, 241));
        jPanel1.setBorder(BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255), 7));

        jLabelTitulo.setFont(new java.awt.Font("Roboto Cn", 0, 48));
        jLabelTitulo.setText("Despesas por Categoria");
        jLabelTitulo.setToolTipText("");

        jComboBoxCategoria.setFont(new java.awt.Font("Roboto Lt", 0, 14));
        jComboBoxCategoria.setModel(new DefaultComboBoxModel<>(new String[] { "Comida", "Lazer", "Educação", "Saúde", "Transporte", "Outros" }));
        jComboBoxCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCategoriaItemStateChanged(evt);
            }
        });

        jButtonVoltar.setFont(new java.awt.Font("Roboto Cn", 0, 14));
        jButtonVoltar.setText("Voltar ao Menu");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jScrollPane1.setPreferredSize(new java.awt.Dimension(450, 400));

        try {
            jTable = financas.tabelaDeGastos();
        } catch (SelectException e) {
            JOptionPane.showMessageDialog(jPanel1, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        jScrollPane1.setViewportView(jTable);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jButtonVoltar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelTitulo)
                        .addGap(111, 111, 111))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBoxCategoria, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 593, GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addGap(34, 34, 34)
                .addComponent(jComboBoxCategoria, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jButtonVoltar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void jComboBoxCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {                                                    
        int cat = jComboBoxCategoria.getSelectedIndex() + 1;
        try {
            List<Gasto> gastosFiltrados = financas.selectGastosFromCategoria(cat);
            TabelaGastos tabelaGastos = (TabelaGastos) jTable.getModel();
            tabelaGastos.resetGastos();
            tabelaGastos.populateGastos(gastosFiltrados);
        } catch (SelectException e) {
            JOptionPane.showMessageDialog(jPanel1, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }                                                   

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        JFrame TelaMenu = new TelaMenu(financas);
        TelaMenu.setVisible(true);
        dispose();
    }                        
}
