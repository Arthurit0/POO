package interfaceGráfica;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;

import dados.Gasto;
import exceptions.InsertException;
import exceptions.SelectException;
import negocio.Financas;

public class TelaAdicionarGasto extends JFrame {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
    private static Financas financas;
    private JButton jButtonAdd;
    private JButton jButtonCancelar;
    private JComboBox<String> jComboBoxCategoria;
    private JLabel jLabelCategoria;
    private JLabel jLabelData;
    private JLabel jLabelDescricao;
    private JLabel jLabelNome;
    private JLabel jLabelTitulo;
    private JLabel jLabelValor;
    private JPanel jPanel;
    private JScrollPane jScrollPane;
    private JTextField jTextFieldData;
    private JTextField jTextFieldNome;
    private JTextField jTextFieldValor;
    private JTextPane jTextPaneDesc;     

    public TelaAdicionarGasto(Financas financas) {
        TelaAdicionarGasto.financas = financas;
        initComponents();
    }
                   
    private void initComponents() {
        jPanel = new JPanel();
        jLabelTitulo = new JLabel();
        jLabelNome = new JLabel();
        jTextFieldNome = new JTextField();
        jLabelData = new JLabel();
        jTextFieldData = new JTextField();
        jLabelDescricao = new JLabel();
        jScrollPane = new JScrollPane();
        jTextPaneDesc = new JTextPane();
        jLabelCategoria = new JLabel();
        jTextFieldValor = new JTextField();
        jComboBoxCategoria = new JComboBox<>();
        jLabelValor = new JLabel();
        jButtonAdd = new JButton();
        jButtonCancelar = new JButton();

        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 500;
        int height = 700;
        setPreferredSize(new java.awt.Dimension(width, height));
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setResizable(false);
        setTitle("Adicionar Despesa");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel.setBackground(new java.awt.Color(205, 241, 241));
        jPanel.setBorder(BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255), 7));

        jLabelTitulo.setFont(new java.awt.Font("Roboto Cn", 0, 48));
        jLabelTitulo.setText("Cadastro de Despesa");
        jLabelTitulo.setToolTipText("");

        jLabelNome.setFont(new java.awt.Font("Roboto Lt", 0, 24));
        jLabelNome.setText("Nome da Despesa");

        jTextFieldNome.setFont(new java.awt.Font("Roboto Lt", 0, 14));


        jLabelData.setFont(new java.awt.Font("Roboto Lt", 0, 24));
        jLabelData.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelData.setText("Data da Despesa");

        jTextFieldData.setFont(new java.awt.Font("Roboto Lt", 0, 14));
        jTextFieldData.setText("\"DD/MM\"");

        jLabelDescricao.setFont(new java.awt.Font("Roboto Lt", 0, 24));
        jLabelDescricao.setText("Descrição da Despesa");

        jTextPaneDesc.setFont(new java.awt.Font("Roboto Lt", 0, 14));
        jTextPaneDesc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane.setViewportView(jTextPaneDesc);

        jLabelCategoria.setFont(new java.awt.Font("Roboto Lt", 0, 24));
        jLabelCategoria.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelCategoria.setText("Categoria");
        jLabelCategoria.setToolTipText("");

        jTextFieldValor.setFont(new java.awt.Font("Roboto Lt", 0, 14));

        jComboBoxCategoria.setFont(new java.awt.Font("Roboto Lt", 0, 14));
        jComboBoxCategoria.setModel(new DefaultComboBoxModel<>(new String[] { "Comida", "Lazer", "Educação", "Saúde", "Transporte", "Outros" }));


        jLabelValor.setFont(new java.awt.Font("Roboto Lt", 0, 24));
        jLabelValor.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelValor.setText("Valor da Despesa (R$)");

        jButtonAdd.setFont(new java.awt.Font("Roboto Cn", 0, 12));
        jButtonAdd.setText("+ Adicionar");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonCancelar.setFont(new java.awt.Font("Roboto Cn", 0, 12));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        GroupLayout jPanelLayout = new GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabelDescricao))
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldNome, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
                                .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldData, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                                    .addComponent(jTextFieldValor, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                                    .addComponent(jComboBoxCategoria, GroupLayout.Alignment.TRAILING, 0, 274, Short.MAX_VALUE)
                                    .addGroup(jPanelLayout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabelData, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabelValor, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanelLayout.createSequentialGroup()
                                    .addGap(39, 39, 39)
                                    .addComponent(jLabelNome))))
                        .addGap(101, 101, 101))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAdd, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addGap(0, 36, Short.MAX_VALUE)
                        .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                .addComponent(jLabelCategoria, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addGap(140, 140, 140))
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                .addComponent(jLabelTitulo)
                                .addGap(38, 38, 38))))))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addComponent(jLabelNome)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNome, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelDescricao)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelData)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldData, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelValor)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldValor, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelCategoria)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxCategoria, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addComponent(jButtonAdd, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addComponent(jButtonCancelar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
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

    private void backToMenu() {
        JFrame telaLogin = new TelaMenu(financas);
        telaLogin.setVisible(true);
        dispose();
    }

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
            Gasto gasto = new Gasto();

            if((jTextFieldNome.getText() == "")
              || (jTextFieldData.getText() == "")
              || (jTextFieldValor.getText() == "")){
                JOptionPane.showMessageDialog(jPanel, "Campos não preenchidos!", "Campos Vazios!", JOptionPane.OK_CANCEL_OPTION);
              } else{
                    gasto.setNome(jTextFieldNome.getText());
                    gasto.setDescricao((jTextPaneDesc.getText()));
                    try {
                        gasto.setData(sdf.parse(jTextFieldData.getText()));
                        gasto.setValor(Float.parseFloat(jTextFieldValor.getText()));
                        gasto.setCategoria(jComboBoxCategoria.getSelectedIndex()+1);
                        financas.addGasto(gasto);
                        JOptionPane.showMessageDialog(jPanel, "Gasto cadastrado com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                        backToMenu();
                    } catch (ParseException e) {
                        JOptionPane.showMessageDialog(jPanel, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
                        jTextFieldData.setText("\"DD/MM\"");
                    }
                }
        } catch (InsertException | SelectException | NumberFormatException e) {
            JOptionPane.showMessageDialog(jPanel, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void jButtonCancelarActionPerformed(ActionEvent evt) {
        backToMenu();
    }
}
