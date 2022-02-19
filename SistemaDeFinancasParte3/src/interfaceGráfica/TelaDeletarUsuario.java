package interfaceGráfica;

import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.*;
import javax.swing.border.LineBorder;

import dados.User;
import exceptions.DeleteException;
import negocio.Financas;

public class TelaDeletarUsuario extends JFrame {

    static Financas financas;
    private JButton jButtonCancelar;
    private JButton jButtonExcluir;
    private JLabel jLabelLogin;
    private JLabel jLabelPassword;
    private JLabel jLabelTitulo;
    private JPanel jPanel;
    private JPasswordField jPasswordFieldSenha;
    private JTextField jTextFieldLogin;

    public TelaDeletarUsuario(Financas financas) {
        TelaDeletarUsuario.financas = financas;
        initComponents();
    }
                        
    private void initComponents() {
        jPanel = new JPanel();
        jLabelTitulo = new JLabel();
        jLabelLogin = new JLabel();
        jLabelPassword = new JLabel();
        jTextFieldLogin = new JTextField();
        jButtonExcluir = new JButton();
        jPasswordFieldSenha = new JPasswordField();
        jButtonCancelar = new JButton();

        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 600;
        int height = 500;
        setPreferredSize(new java.awt.Dimension(width, height));
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setResizable(false);
        setTitle("Exclusão de Usuário");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel.setBackground(new java.awt.Color(241, 205, 205));
        jPanel.setBorder(new LineBorder(new java.awt.Color(255, 50, 50), 6, true));

        jLabelTitulo.setFont(new java.awt.Font("Roboto Cn", 0, 48));
        jLabelTitulo.setText("Excluir Usuário");
        jLabelTitulo.setToolTipText("");

        jLabelLogin.setFont(new java.awt.Font("Roboto Lt", 0, 24));
        jLabelLogin.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelLogin.setText("Digite seu login");

        jLabelPassword.setFont(new java.awt.Font("Roboto Lt", 0, 24));
        jLabelPassword.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelPassword.setText("Digite sua Senha");

        jTextFieldLogin.setFont(new java.awt.Font("Roboto", 0, 14));

        jButtonExcluir.setBackground(new java.awt.Color(255, 102, 102));
        jButtonExcluir.setFont(new java.awt.Font("Roboto Cn", 0, 14));
        jButtonExcluir.setText("Deletar Conta");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jPasswordFieldSenha.setFont(new java.awt.Font("Roboto", 0, 14));

        jButtonCancelar.setFont(new java.awt.Font("Roboto Cn", 0, 14));
        jButtonCancelar.setText("Cancelar Exclusão");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        GroupLayout jPanelLayout = new GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap(155, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addComponent(jLabelTitulo)
                        .addGap(149, 149, 149))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                            .addComponent(jLabelPassword, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                            .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldLogin, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                .addComponent(jPasswordFieldSenha, GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonExcluir, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonCancelar, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(201, 201, 201)))))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addComponent(jLabelLogin)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldLogin, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelPassword)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldSenha, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonExcluir, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(jButtonCancelar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }                     

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {                                               
        String login = jTextFieldLogin.getText();
        char[] password = jPasswordFieldSenha.getPassword();
        String passwordDecoded = "";

        for (char c : password) {
            passwordDecoded += c;
        }

        User deletado = new User();
        deletado.setLogin(login);
        deletado.setSenha(passwordDecoded);

        try {
            financas.removeUser(deletado);
            JOptionPane.showMessageDialog(jPanel, "Usuário Excluído com Sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            backToMenu();
        } catch (DeleteException e) {
            JOptionPane.showMessageDialog(jPanel, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }                                                                        

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                                
        backToMenu();
    }

    private void backToMenu() {
        JFrame telaLogin = new TelaLoginUsuario(financas);
        telaLogin.setVisible(true);
        dispose();
    }                  

}
