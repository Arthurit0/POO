package interfaceGráfica;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.List;

import javax.swing.*;

import dados.Gasto;
import exceptions.SelectException;
import negocio.Financas;

public class TelaFiltroMes extends JFrame {

    static Financas financas;
    private JButton jButtonVoltar;
    private JComboBox<String> jComboBoxMes;
    private JLabel jLabelTitulo;
    private JPanel jPanel;
    private JScrollPane jScrollPane;
    private JTable jTable; 

    public TelaFiltroMes(Financas financas) {
        TelaFiltroMes.financas = financas;
        initComponents();
    }

    private void initComponents() {

        jPanel = new JPanel();
        jLabelTitulo = new JLabel();
        jScrollPane = new JScrollPane();
        jTable = new JTable();
        jComboBoxMes = new JComboBox<>();
        jButtonVoltar = new JButton();

        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 700;
        int height = 600;
        setPreferredSize(new java.awt.Dimension(width, height));
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setResizable(false);
        setTitle("Despesas em cada mês");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel.setBackground(new java.awt.Color(205, 241, 241));
        jPanel.setBorder(BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255), 7));

        jLabelTitulo.setFont(new java.awt.Font("Roboto Cn", 0, 48));
        jLabelTitulo.setText("Despesas por Mês");
        jLabelTitulo.setToolTipText("");

        jScrollPane.setPreferredSize(new java.awt.Dimension(450, 400));

        try {
            jTable = financas.tabelaDeGastos();
        } catch (SelectException e) {
            JOptionPane.showMessageDialog(jPanel, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        jScrollPane.setViewportView(jTable);

        jComboBoxMes.setFont(new java.awt.Font("Roboto Lt", 0, 14));
        jComboBoxMes.setModel(new DefaultComboBoxModel<>(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        jComboBoxMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMesActionPerformed(evt);
            }
        });

        jButtonVoltar.setFont(new java.awt.Font("Roboto Cn", 0, 14));
        jButtonVoltar.setText("Voltar ao Menu");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        GroupLayout jPanelLayout = new GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addComponent(jComboBoxMes, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 593, GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jLabelTitulo))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButtonVoltar)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addGap(34, 34, 34)
                .addComponent(jComboBoxMes, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
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

    private void jComboBoxMesActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        int mes = jComboBoxMes.getSelectedIndex() + 1;
        try {
            List<Gasto> gastosFiltrados = financas.selectGastosFromMes(mes);
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
