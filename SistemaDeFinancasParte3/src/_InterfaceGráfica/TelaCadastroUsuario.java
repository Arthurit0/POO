package _InterfaceGráfica;

import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.*;
import javax.swing.border.LineBorder;

import dados.User;
import exceptions.InsertException;
import exceptions.SelectException;
import negocio.Financas;

public class TelaCadastroUsuario extends JFrame{

    static Financas financas;
    private JButton jButtonCadastrar;
    private JButton jButtonCancelar;
    private JLabel jLabelLogin;
    private JLabel jLabelPassword;
    private JLabel jLabelTitulo;
    private JPanel jPanel1;
    private JPasswordField jPasswordFieldSenha;
    private JTextField jTextFieldLogin;  
    
    public TelaCadastroUsuario(Financas financas) {
        TelaCadastroUsuario.financas = financas;
        initComponents();
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        jLabelTitulo = new JLabel();
        jLabelLogin = new JLabel();
        jLabelPassword = new JLabel();
        jTextFieldLogin = new JTextField();
        jButtonCadastrar = new JButton();
        jPasswordFieldSenha = new JPasswordField();
        jButtonCancelar = new JButton();

        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 600;
        int height = 500;
        setPreferredSize(new java.awt.Dimension(width, height));
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setResizable(false);
        setTitle("Cadastro de Usuário");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(205, 241, 241));
        jPanel1.setBorder(new LineBorder(new java.awt.Color(51, 255, 255), 6, true));

        jLabelTitulo.setFont(new java.awt.Font("Roboto Cn", 0, 48));
        jLabelTitulo.setText("Cadastro de Usuário");
        jLabelTitulo.setToolTipText("");

        jLabelLogin.setFont(new java.awt.Font("Roboto Lt", 0, 24));
        jLabelLogin.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelLogin.setText("Digite seu login");

        jLabelPassword.setFont(new java.awt.Font("Roboto Lt", 0, 24));
        jLabelPassword.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelPassword.setText("Digite sua Senha");

        jTextFieldLogin.setFont(new java.awt.Font("Roboto", 0, 14));

        jButtonCadastrar.setFont(new java.awt.Font("Roboto Cn", 0, 14));
        jButtonCadastrar.setText("Cadastrar Usuário");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jPasswordFieldSenha.setFont(new java.awt.Font("Roboto", 0, 14));

        jButtonCancelar.setFont(new java.awt.Font("Roboto Cn", 0, 14));
        jButtonCancelar.setText("Cancelar Cadastro");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelTitulo)
                        .addGap(100, 100, 100))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldLogin, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(jPasswordFieldSenha, GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCadastrar, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCancelar, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelPassword, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(201, 201, 201))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
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
                .addComponent(jButtonCadastrar, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(jButtonCancelar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

    }                                                                                                                                 

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        String login = jTextFieldLogin.getText();
        char[] password = jPasswordFieldSenha.getPassword();
        String passwordDecoded = "";

        for (char c : password) {
            passwordDecoded += c;
        }

        User novoUsuario = new User();
        novoUsuario.setLogin(login);
        novoUsuario.setSenha(passwordDecoded);

        try {
            financas.addUser(novoUsuario);
            JOptionPane.showMessageDialog(jPanel1, "Usuário Cadastrado com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            backToMenu();
        } catch (InsertException | SelectException e) {
            JOptionPane.showMessageDialog(jPanel1, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
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
