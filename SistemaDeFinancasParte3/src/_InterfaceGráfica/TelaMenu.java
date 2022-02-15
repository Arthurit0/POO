package _InterfaceGráfica;

import java.awt.CardLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import negocio.Financas;

public class TelaMenu extends javax.swing.JFrame {

    static Financas financas;
    private java.awt.Button buttonAddGasto;
    private java.awt.Button buttonEditarGasto;
    private java.awt.Button buttonExit;
    private java.awt.Button buttonGastoCat;
    private java.awt.Button buttonGastoMes;
    private java.awt.Button buttonLogoff;
    private java.awt.Button buttonRemoveGasto;
    private javax.swing.JButton jButtonCardBarra;
    private javax.swing.JButton jButtonCardScatter;
    private javax.swing.JButton jButtonCardTabela;
    private javax.swing.JLabel jLabelMenu1;
    private javax.swing.JLabel jLabelMenu2;
    private javax.swing.JPanel jPanelCard1;
    private javax.swing.JPanel jPanelCard2;
    private javax.swing.JPanel jPanelCard3;
    private javax.swing.JPanel jPanelLeft;
    private javax.swing.JPanel jPanelMainCard;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;

    public TelaMenu(Financas financas) {
        TelaMenu.financas = financas;
        initComponents();
    }
    @SuppressWarnings("unchecked")     
    private void initComponents() {

        jPanelLeft = new javax.swing.JPanel();
        jLabelMenu2 = new javax.swing.JLabel();
        jLabelMenu1 = new javax.swing.JLabel();
        buttonGastoMes = new java.awt.Button();
        buttonAddGasto = new java.awt.Button();
        buttonGastoCat = new java.awt.Button();
        buttonEditarGasto = new java.awt.Button();
        buttonRemoveGasto = new java.awt.Button();
        buttonLogoff = new java.awt.Button();
        buttonExit = new java.awt.Button();
        jButtonCardBarra = new javax.swing.JButton();
        jButtonCardTabela = new javax.swing.JButton();
        jButtonCardScatter = new javax.swing.JButton();
        jPanelMainCard = new javax.swing.JPanel();
        jPanelCard1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanelCard2 = new javax.swing.JPanel();
        jPanelCard3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 1280;
        int height = 720;
        setPreferredSize(new java.awt.Dimension(width, height));
        setBounds(center.x - width / 2, center.y - height / 2, width, height);

        jPanelLeft.setBackground(new java.awt.Color(205, 241, 241));
        jPanelLeft.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255), 7));
        jPanelLeft.setToolTipText("");

        jLabelMenu2.setFont(new java.awt.Font("Roboto Bk", 0, 48));
        jLabelMenu2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMenu2.setText("de Negócios");

        jLabelMenu1.setFont(new java.awt.Font("Roboto Bk", 0, 48));
        jLabelMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMenu1.setText("Menu do Sistema");

        buttonGastoMes.setBackground(new java.awt.Color(243, 243, 243));
        buttonGastoMes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonGastoMes.setFont(new java.awt.Font("Roboto Lt", 0, 18));
        buttonGastoMes.setLabel("Visualizar Despesas por Mês");
        buttonGastoMes.setName("");
        buttonGastoMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGastoMesActionPerformed(evt);
            }
        });

        buttonAddGasto.setBackground(new java.awt.Color(243, 243, 243));
        buttonAddGasto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonAddGasto.setFont(new java.awt.Font("Roboto Lt", 0, 18));
        buttonAddGasto.setLabel("Adicionar Despesa");
        buttonAddGasto.setName("");
        buttonAddGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddGastoActionPerformed(evt);
            }
        });

        buttonGastoCat.setBackground(new java.awt.Color(243, 243, 243));
        buttonGastoCat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonGastoCat.setFont(new java.awt.Font("Roboto Lt", 0, 18));
        buttonGastoCat.setLabel("Visualizar Despesas por Categoria");
        buttonGastoCat.setName("");
        buttonGastoCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGastoCatActionPerformed(evt);
            }
        });

        buttonEditarGasto.setBackground(new java.awt.Color(243, 243, 243));
        buttonEditarGasto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonEditarGasto.setFont(new java.awt.Font("Roboto Lt", 0, 18));
        buttonEditarGasto.setLabel("Editar Despesa");
        buttonEditarGasto.setName("");
        buttonEditarGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarGastoActionPerformed(evt);
            }
        });

        buttonRemoveGasto.setBackground(new java.awt.Color(243, 243, 243));
        buttonRemoveGasto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonRemoveGasto.setFont(new java.awt.Font("Roboto Lt", 0, 18));
        buttonRemoveGasto.setLabel("Remover Despesa");
        buttonRemoveGasto.setName("");
        buttonRemoveGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveGastoActionPerformed(evt);
            }
        });

        buttonLogoff.setBackground(new java.awt.Color(243, 243, 243));
        buttonLogoff.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonLogoff.setFont(new java.awt.Font("Roboto Lt", 0, 18));
        buttonLogoff.setLabel("Logoff");
        buttonLogoff.setName("");
        buttonLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogoffActionPerformed(evt);
            }
        });

        buttonExit.setBackground(new java.awt.Color(243, 243, 243));
        buttonExit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonExit.setFont(new java.awt.Font("Roboto Lt", 0, 18));
        buttonExit.setLabel("Fechar Programa");
        buttonExit.setName("");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        jButtonCardBarra.setFont(new java.awt.Font("Roboto Lt", 0, 12));
        jButtonCardBarra.setText("Barra");
        jButtonCardBarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCardBarraActionPerformed(evt);
            }
        });

        jButtonCardTabela.setFont(new java.awt.Font("Roboto Lt", 0, 12));
        jButtonCardTabela.setText("Tabela");
        jButtonCardTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCardTabelaActionPerformed(evt);
            }
        });

        jButtonCardScatter.setFont(new java.awt.Font("Roboto Lt", 0, 12));
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
            jPanelCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCard1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelCard1Layout.setVerticalGroup(
            jPanelCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCard1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelMainCard.add(jPanelCard1, "Card1");

        javax.swing.GroupLayout jPanelCard2Layout = new javax.swing.GroupLayout(jPanelCard2);
        jPanelCard2.setLayout(jPanelCard2Layout);
        jPanelCard2Layout.setHorizontalGroup(
            jPanelCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );
        jPanelCard2Layout.setVerticalGroup(
            jPanelCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
        );

        jPanelMainCard.add(jPanelCard2, "Card2");

        javax.swing.GroupLayout jPanelCard3Layout = new javax.swing.GroupLayout(jPanelCard3);
        jPanelCard3.setLayout(jPanelCard3Layout);
        jPanelCard3Layout.setHorizontalGroup(
            jPanelCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );
        jPanelCard3Layout.setVerticalGroup(
            jPanelCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
        );

        jPanelMainCard.add(jPanelCard3, "Card3");

        javax.swing.GroupLayout jPanelLeftLayout = new javax.swing.GroupLayout(jPanelLeft);
        jPanelLeft.setLayout(jPanelLeftLayout);
        jPanelLeftLayout.setHorizontalGroup(
            jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLeftLayout.createSequentialGroup()
                .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLeftLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonGastoMes, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonGastoCat, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonEditarGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonRemoveGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonLogoff, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAddGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMainCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLeftLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCardTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonCardBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonCardScatter, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
            .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLeftLayout.createSequentialGroup()
                    .addComponent(jLabelMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 770, Short.MAX_VALUE)))
        );
        jPanelLeftLayout.setVerticalGroup(
            jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLeftLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabelMenu2)
                .addGap(33, 33, 33)
                .addComponent(buttonAddGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonGastoMes, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonGastoCat, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonEditarGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonRemoveGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonLogoff, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMainCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCardBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCardTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCardScatter, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLeftLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabelMenu1)
                    .addContainerGap(626, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                      

    private void buttonAddGastoActionPerformed(ActionEvent evt) {
        
    }
    private void buttonGastoMesActionPerformed(ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void buttonGastoCatActionPerformed(ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void buttonEditarGastoActionPerformed(ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void buttonRemoveGastoActionPerformed(ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void buttonLogoffActionPerformed(ActionEvent evt) {                                             
        financas.logoff();
        JFrame telaLoginUsuario = new TelaLoginUsuario(financas);
        telaLoginUsuario.setVisible(true);
        dispose();
    }                                            

    private void buttonExitActionPerformed(ActionEvent evt) {      
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
