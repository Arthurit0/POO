package interfaceGráfica;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.List;

import javax.swing.*;

import dados.Gasto;
import exceptions.SelectException;
import negocio.Financas;

public class TelaFiltroCategoria extends JFrame {

    private static Financas financas;
    private JButton jButtonVoltar;
    private JComboBox<String> jComboBoxCategoria;
    private JLabel jLabelTitulo;
    private JPanel jPanel;
    private JScrollPane jScrollPane;
    private JTable jTable;

    public TelaFiltroCategoria(Financas financas) {
        TelaFiltroCategoria.financas = financas;
        initComponents();
    }
   
    private void initComponents() {

        jPanel = new JPanel();
        jLabelTitulo = new JLabel();
        jComboBoxCategoria = new JComboBox<>();
        jButtonVoltar = new JButton();
        jScrollPane = new JScrollPane();
        jTable = new JTable();

        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 700;
        int height = 600;
        setPreferredSize(new java.awt.Dimension(width, height));
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setResizable(false);
        setTitle("Despesas por categoria");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel.setBackground(new java.awt.Color(205, 241, 241));
        jPanel.setBorder(BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255), 7));

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

        jScrollPane.setPreferredSize(new java.awt.Dimension(450, 400));

        try {
            jTable = financas.tabelaDeGastos();
        } catch (SelectException e) {
            JOptionPane.showMessageDialog(jPanel, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        jScrollPane.setViewportView(jTable);

        GroupLayout jPanelLayout = new GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jButtonVoltar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addComponent(jLabelTitulo)
                        .addGap(111, 111, 111))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addComponent(jComboBoxCategoria, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 593, GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addGap(34, 34, 34)
                .addComponent(jComboBoxCategoria, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jButtonVoltar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            JOptionPane.showMessageDialog(jPanel, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }                                                   

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        JFrame TelaMenu = new TelaMenu(financas);
        TelaMenu.setVisible(true);
        dispose();
    }                        
}
