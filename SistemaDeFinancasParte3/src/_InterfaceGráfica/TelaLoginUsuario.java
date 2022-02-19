package _InterfaceGráfica;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.LineBorder;

import exceptions.SelectException;
import exceptions.SenhaIncorretaException;
import exceptions.UsuarioNaoExisteException;
import negocio.Financas;

public class TelaLoginUsuario extends JFrame {

    static Financas financas;
    private JButton jButtonDeletarConta;
    private JButton jButtonEntrar;
    private JButton jButtonNovoUsuario;
    private JLabel jLabelLogin;
    private JLabel jLabelPassword;
    private JLabel jLabelTitulo;
    private static JPanel jPanel1;
    private JPasswordField jPasswordFieldSenha;
    private JTextField jTextFieldLogin;

    public TelaLoginUsuario(Financas financas) {
        TelaLoginUsuario.financas = financas;
        initComponents();
    }

    public TelaLoginUsuario() {
        try {
            TelaLoginUsuario.financas = new Financas();
        } catch (ClassNotFoundException | SQLException | SelectException e) {
            JOptionPane.showMessageDialog(jPanel1, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        initComponents();
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        jLabelTitulo = new JLabel();
        jLabelLogin = new JLabel();
        jLabelPassword = new JLabel();
        jTextFieldLogin = new JTextField();
        jButtonEntrar = new JButton();
        jButtonDeletarConta = new JButton();
        jButtonNovoUsuario = new JButton();
        jPasswordFieldSenha = new JPasswordField();

        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 600;
        int height = 500;
        setPreferredSize(new java.awt.Dimension(width, height));
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setResizable(false);
        setTitle("Login de Usuário");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(205, 241, 241));
        jPanel1.setBorder(new LineBorder(new java.awt.Color(51, 255, 255), 6, true));

        jLabelTitulo.setFont(new java.awt.Font("Roboto Cn", 0, 48));
        jLabelTitulo.setText("Login de Usuário");
        jLabelTitulo.setToolTipText("");

        jLabelLogin.setFont(new java.awt.Font("Roboto Lt", 0, 24));
        jLabelLogin.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelLogin.setText("Login");

        jLabelPassword.setFont(new java.awt.Font("Roboto Lt", 0, 24));
        jLabelPassword.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelPassword.setText("Senha");

        jTextFieldLogin.setFont(new java.awt.Font("Roboto", 0, 14));

        jButtonEntrar.setFont(new java.awt.Font("Roboto Cn", 0, 14));
        jButtonEntrar.setText("Entrar");
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });

        jButtonDeletarConta.setBackground(new java.awt.Color(255, 102, 102));
        jButtonDeletarConta.setFont(new java.awt.Font("Roboto Cn", 0, 14));
        jButtonDeletarConta.setText("Deletar Conta");
        jButtonDeletarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletarContaActionPerformed(evt);
            }
        });

        jButtonNovoUsuario.setFont(new java.awt.Font("Roboto Cn", 0, 14));
        jButtonNovoUsuario.setText("Criar novo usuário");
        jButtonNovoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoUsuarioActionPerformed(evt);
            }
        });

        jPasswordFieldSenha.setFont(new java.awt.Font("Roboto", 0, 14));
        jPasswordFieldSenha.setText("123");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 131, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelTitulo)
                                .addGap(125, 125, 125))
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonEntrar, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                .addGap(248, 248, 248))
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldLogin, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(jButtonNovoUsuario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPasswordFieldSenha)
                                    .addComponent(jLabelLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(201, 201, 201))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonDeletarConta)
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEntrar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonNovoUsuario, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(jButtonDeletarConta, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    protected void jButtonEntrarActionPerformed(ActionEvent evt) {
        String login = jTextFieldLogin.getText();
        String decodedPassword = "";
        char[] password = jPasswordFieldSenha.getPassword();

        for (char c : password) {
            decodedPassword += c;
        }

        try {
            financas.login(login, decodedPassword);
            JFrame TelaMenu = new TelaMenu(financas);
            TelaMenu.setVisible(true);
            dispose();

        } catch (SelectException | UsuarioNaoExisteException | SenhaIncorretaException e) {
            JOptionPane.showMessageDialog(jPanel1, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void jButtonNovoUsuarioActionPerformed(ActionEvent evt) {
        JFrame telaCadastroUsuario = new TelaCadastroUsuario(financas);
        telaCadastroUsuario.setVisible(true);
        dispose();
    }

    protected void jButtonDeletarContaActionPerformed(ActionEvent evt) {
        JFrame telaDeletarUsuario = new TelaDeletarUsuario(financas);
        telaDeletarUsuario.setVisible(true);
        dispose();
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLoginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLoginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLoginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLoginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLoginUsuario().setVisible(true);
            }
        });
    }
}
