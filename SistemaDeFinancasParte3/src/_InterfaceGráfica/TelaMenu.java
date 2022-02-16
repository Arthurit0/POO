package _InterfaceGráfica;

import java.awt.CardLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import negocio.Financas;

public class TelaMenu extends javax.swing.JFrame {

    static Financas financas;
    private javax.swing.JButton jButtonAddGasto;
    private javax.swing.JButton jButtonEditGasto;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonGastosCateg;
    private javax.swing.JButton jButtonGastosMes;
    private javax.swing.JButton jButtonLogoff;
    private javax.swing.JButton jButtonRmvGasto;
    private javax.swing.JButton jButtonCardBarra;
    private javax.swing.JButton jButtonCardScatter;
    private javax.swing.JButton jButtonCardTabela;
    private javax.swing.JLabel jLabelMenu1;
    private javax.swing.JLabel jLabelMenu2;
    private javax.swing.JPanel jPanelCard1;
    private javax.swing.JPanel jPanelCard2;
    private javax.swing.JPanel jPanelCard3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelMainCard;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;

    public TelaMenu(Financas financas) {
        TelaMenu.financas = financas;
        initComponents();
    }
    @SuppressWarnings("unchecked")     
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabelMenu2 = new javax.swing.JLabel();
        jLabelMenu1 = new javax.swing.JLabel();
        jButtonCardBarra = new javax.swing.JButton();
        jButtonCardTabela = new javax.swing.JButton();
        jButtonCardScatter = new javax.swing.JButton();
        jPanelMainCard = new javax.swing.JPanel();
        jPanelCard1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanelCard2 = new javax.swing.JPanel();
        jPanelCard3 = new javax.swing.JPanel();
        jButtonEditGasto = new javax.swing.JButton();
        jButtonGastosMes = new javax.swing.JButton();
        jButtonGastosCateg = new javax.swing.JButton();
        jButtonAddGasto = new javax.swing.JButton();
        jButtonRmvGasto = new javax.swing.JButton();
        jButtonLogoff = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 1280;
        int height = 720;
        setPreferredSize(new java.awt.Dimension(width, height));
        setBounds(center.x - width / 2, center.y - height / 2, width, height);

        jPanel1.setBackground(new java.awt.Color(205, 241, 241));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255), 7));
        jPanel1.setToolTipText("");

        jLabelMenu2.setFont(new java.awt.Font("Roboto Bk", 0, 48));
        jLabelMenu2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMenu2.setText("de Negócios");

        jLabelMenu1.setFont(new java.awt.Font("Roboto Bk", 0, 48));
        jLabelMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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

        jPanelMainCard.setLayout(new java.awt.CardLayout());

        jTable1.setFont(new java.awt.Font("Roboto", 0, 12));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Data", "Valor", "Categoria", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanelCard1Layout = new javax.swing.GroupLayout(jPanelCard1);
        jPanelCard1.setLayout(jPanelCard1Layout);
        jPanelCard1Layout.setHorizontalGroup(
            jPanelCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(jPanelCard1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelCard1Layout.setVerticalGroup(
            jPanelCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(jPanelCard1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelMainCard.add(jPanelCard1, "Card1");

        javax.swing.GroupLayout jPanelCard2Layout = new javax.swing.GroupLayout(jPanelCard2);
        jPanelCard2.setLayout(jPanelCard2Layout);
        jPanelCard2Layout.setHorizontalGroup(
            jPanelCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGap(0, 690, Short.MAX_VALUE)
        );
        jPanelCard2Layout.setVerticalGroup(
            jPanelCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGap(0, 618, Short.MAX_VALUE)
        );

        jPanelMainCard.add(jPanelCard2, "Card2");

        javax.swing.GroupLayout jPanelCard3Layout = new javax.swing.GroupLayout(jPanelCard3);
        jPanelCard3.setLayout(jPanelCard3Layout);
        jPanelCard3Layout.setHorizontalGroup(
            jPanelCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGap(0, 690, Short.MAX_VALUE)
        );
        jPanelCard3Layout.setVerticalGroup(
            jPanelCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGap(0, 618, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonEditGasto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonGastosMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonGastosCateg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                            .addComponent(jButtonAddGasto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonRmvGasto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonLogoff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabelMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMainCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCardTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButtonCardBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButtonCardScatter, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabelMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 770, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabelMenu2)
                        .addGap(43, 43, 43)
                        .addComponent(jButtonAddGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonGastosMes, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonGastosCateg, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEditGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonRmvGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonLogoff, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelMainCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCardTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCardBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCardScatter, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabelMenu1)
                    .addContainerGap(626, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

    }                      

    protected void jButtonAddGastoActionPerformed(ActionEvent evt) {
    }

    protected void jButtonGastosMesActionPerformed(ActionEvent evt) {
    }

    protected void jButtonGastosCategActionPerformed(ActionEvent evt) {
    }

    protected void jButtonEditGastoActionPerformed(ActionEvent evt) {
    }

    protected void jButtonRmvGastoActionPerformed(ActionEvent evt) {
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
                                  
    // public static void main(String args[]) {
    //     java.awt.EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             new TelaMenu().setVisible(true);
    //         }
    //     });
    // }

}
