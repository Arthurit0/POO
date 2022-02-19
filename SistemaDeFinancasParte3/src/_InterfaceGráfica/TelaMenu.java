package _InterfaceGráfica;

import java.awt.CardLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.*;
import org.jfree.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;

import exceptions.SelectException;
import negocio.Financas;

public class TelaMenu extends JFrame {

    static Financas financas;
    private JButton jButtonAddGasto;
    private JButton jButtonEditGasto;
    private JButton jButtonExit;
    private JButton jButtonGastosCateg;
    private JButton jButtonGastosMes;
    private JButton jButtonLogoff;
    private JButton jButtonRmvGasto;
    private JButton jButtonCardBarra;
    private JButton jButtonCardScatter;
    private JButton jButtonCardTabela;
    private JLabel jLabelMenu1;
    private JLabel jLabelMenu2;
    private JPanel jPanelCard1;
    private JPanel jPanelCard2;
    private JPanel jPanelCard3;
    private JPanel jPanel;
    private JPanel jPanelMainCard;
    private JScrollPane jScrollPane1;
    private ChartPanel chartPanel2;
    private ChartPanel scatterPanel3;
    private JTable jTable;

    public TelaMenu(Financas financas) {
        TelaMenu.financas = financas;
        initComponents();
    }
  
    private void initComponents() {
        jPanel = new JPanel();
        jLabelMenu2 = new JLabel();
        jLabelMenu1 = new JLabel();
        jButtonCardBarra = new JButton();
        jButtonCardTabela = new JButton();
        jButtonCardScatter = new JButton();
        jPanelMainCard = new JPanel();
        jPanelCard1 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jPanelCard2 = new JPanel();
        jPanelCard3 = new JPanel();
        jButtonEditGasto = new JButton();
        jButtonGastosMes = new JButton();
        jButtonGastosCateg = new JButton();
        jButtonAddGasto = new JButton();
        jButtonRmvGasto = new JButton();
        jButtonLogoff = new JButton();
        jButtonExit = new JButton();

        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 1280;
        int height = 720;
        setPreferredSize(new java.awt.Dimension(width, height));
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setResizable(false);
        setTitle("Menu de Finanças");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel.setBackground(new java.awt.Color(205, 241, 241));
        jPanel.setBorder(BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255), 7));
        jPanel.setToolTipText("");

        jLabelMenu2.setFont(new java.awt.Font("Roboto Bk", 0, 48));
        jLabelMenu2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelMenu2.setText("de Negócios");

        jLabelMenu1.setFont(new java.awt.Font("Roboto Bk", 0, 48));
        jLabelMenu1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelMenu1.setText("Menu do Sistema");

        jButtonCardBarra.setFont(new java.awt.Font("Roboto Cn", 0, 14));
        jButtonCardBarra.setText("Barra");
        jButtonCardBarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCardBarraActionPerformed(evt);
            }
        });

        jButtonCardTabela.setFont(new java.awt.Font("Roboto Cn", 0, 14));
        jButtonCardTabela.setText("Tabela");
        jButtonCardTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCardTabelaActionPerformed(evt);
            }
        });

        jButtonCardScatter.setFont(new java.awt.Font("Roboto Cn", 0, 14));
        jButtonCardScatter.setText("Scatter");
        jButtonCardScatter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCardScatterActionPerformed(evt);
            }
        });

        try {
            jTable = financas.tabelaDeGastos();
        } catch (SelectException e) {
            JOptionPane.showMessageDialog(jPanel, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);

        }
        jScrollPane1.setViewportView(jTable);

        GroupLayout jPanelCardLayout1 = new GroupLayout(jPanelCard1);
        jPanelMainCard.setLayout(new java.awt.CardLayout());
        jPanelCard1.setLayout(jPanelCardLayout1);
        jPanelCardLayout1.setHorizontalGroup(
            jPanelCardLayout1.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addGroup(jPanelCardLayout1.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelCardLayout1.setVerticalGroup(
            jPanelCardLayout1.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addGroup(jPanelCardLayout1.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelMainCard.add(jPanelCard1, "Card1");

        JFreeChart barras = ChartFactory.createBarChart("Gasto por Mês", "Mês", "Valor Total", financas.barraDeGastos(), PlotOrientation.VERTICAL, true, true, false);
        chartPanel2 = new ChartPanel(barras);

        GroupLayout jPanelCardLayout2 = new GroupLayout(jPanelCard2);
        jPanelCard2.setLayout(jPanelCardLayout2);
        jPanelCardLayout2.setHorizontalGroup(
            jPanelCardLayout2.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addGroup(jPanelCardLayout2.createSequentialGroup()
                .addContainerGap()
                .addComponent(chartPanel2, GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelCardLayout2.setVerticalGroup(
            jPanelCardLayout2.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addGroup(jPanelCardLayout2.createSequentialGroup()
                .addContainerGap()
                .addComponent(chartPanel2, GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                .addContainerGap())
        );

        
        jPanelMainCard.add(jPanelCard2, "Card2");
        
        JFreeChart scatter = ChartFactory.createScatterPlot("Scatter de Gasto do Ano", "Ano", "Valor", financas.scatterDeGastos(), PlotOrientation.VERTICAL, true, true, true);
        scatterPanel3 = new ChartPanel(scatter);

        GroupLayout jPanelCardLayout3 = new GroupLayout(jPanelCard3);
        jPanelCard3.setLayout(jPanelCardLayout3);
        jPanelCardLayout3.setHorizontalGroup(
            jPanelCardLayout3.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addGroup(jPanelCardLayout3.createSequentialGroup()
                .addContainerGap()
                .addComponent(scatterPanel3, GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelCardLayout3.setVerticalGroup(
            jPanelCardLayout3.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addGroup(jPanelCardLayout3.createSequentialGroup()
                .addContainerGap()
                .addComponent(scatterPanel3, GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelMainCard.add(jPanelCard3, "Card3");

        jButtonEditGasto.setFont(new java.awt.Font("Roboto Lt", 0, 18));
        jButtonEditGasto.setText("Editar Despesa");
        jButtonEditGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditGastoActionPerformed(evt);
            }
        });

        jButtonGastosMes.setFont(new java.awt.Font("Roboto Lt", 0, 18));
        jButtonGastosMes.setText("Visualizar Despesas por Mês");
        jButtonGastosMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGastosMesActionPerformed(evt);
            }
        });

        jButtonGastosCateg.setFont(new java.awt.Font("Roboto Lt", 0, 18));
        jButtonGastosCateg.setText("Visualizar Despesas por Categoria");
        jButtonGastosCateg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGastosCategActionPerformed(evt);
            }
        });

        jButtonAddGasto.setFont(new java.awt.Font("Roboto Lt", 0, 18));
        jButtonAddGasto.setText("Adicionar Despesa");
        jButtonAddGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddGastoActionPerformed(evt);
            }
        });

        jButtonRmvGasto.setFont(new java.awt.Font("Roboto Lt", 0, 18));
        jButtonRmvGasto.setText("Remover Despesa");
        jButtonRmvGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRmvGastoActionPerformed(evt);
            }
        });

        jButtonLogoff.setFont(new java.awt.Font("Roboto Lt", 0, 18));
        jButtonLogoff.setText("Logoff");
        jButtonLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoffActionPerformed(evt);
            }
        });

        jButtonExit.setFont(new java.awt.Font("Roboto Lt", 0, 18));
        jButtonExit.setText("Sair do Programa");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        GroupLayout jPanelLayout = new GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonEditGasto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonGastosMes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonGastosCateg, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                            .addComponent(jButtonAddGasto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonRmvGasto, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonLogoff, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonExit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabelMenu2, GroupLayout.PREFERRED_SIZE, 496, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMainCard, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCardTabela, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButtonCardBarra, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButtonCardScatter, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
            .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLayout.createSequentialGroup()
                    .addComponent(jLabelMenu1, GroupLayout.PREFERRED_SIZE, 496, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 770, Short.MAX_VALUE)))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabelMenu2)
                        .addGap(43, 43, 43)
                        .addComponent(jButtonAddGasto, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonGastosMes, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonGastosCateg, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEditGasto, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonRmvGasto, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonLogoff, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonExit, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelMainCard, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(9, 9, 9)
                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCardTabela, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCardBarra, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCardScatter, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
            .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabelMenu1)
                    .addContainerGap(626, Short.MAX_VALUE)))
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

    protected void jButtonAddGastoActionPerformed(ActionEvent evt) {
        JFrame telaAdicionarGasto = new TelaAdicionarGasto(financas);
        telaAdicionarGasto.setVisible(true);
        dispose();
    }

    protected void jButtonGastosMesActionPerformed(ActionEvent evt) {
        JFrame telaFiltroMes = new TelaFiltroMes(financas);
        telaFiltroMes.setVisible(true);
        dispose();
    }

    protected void jButtonGastosCategActionPerformed(ActionEvent evt) {
        JFrame telaFiltroCategoria = new TelaFiltroCategoria(financas);
        telaFiltroCategoria.setVisible(true);
        dispose();
    }

    protected void jButtonEditGastoActionPerformed(ActionEvent evt) {
        JFrame telaEditarGasto = new TelaEditarGasto(financas);
        telaEditarGasto.setVisible(true);
        dispose();
    }

    protected void jButtonRmvGastoActionPerformed(ActionEvent evt) {
        JFrame telaExcluirGasto = new TelaExcluirGasto(financas);
        telaExcluirGasto.setVisible(true);
        dispose();
    }

    protected void jButtonLogoffActionPerformed(ActionEvent evt) {
        financas.logoff();
        JFrame telaLoginUsuario = new TelaLoginUsuario(financas);
        telaLoginUsuario.setVisible(true);
        dispose();
    }

    protected void jButtonExitActionPerformed(ActionEvent evt) {
        System.exit(1);
    }


    private void jButtonCardTabelaActionPerformed(ActionEvent evt) {       
        CardLayout card = (CardLayout)jPanelMainCard.getLayout();
        card.show(jPanelMainCard, "Card1");
    }                                                 

    private void jButtonCardBarraActionPerformed(ActionEvent evt) {  
        CardLayout card = (CardLayout)jPanelMainCard.getLayout();
        card.show(jPanelMainCard, "Card2");
    }                                                

    private void jButtonCardScatterActionPerformed(ActionEvent evt) {    
        CardLayout card = (CardLayout)jPanelMainCard.getLayout();
        card.show(jPanelMainCard, "Card3");
    }                                                  
}
