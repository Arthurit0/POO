package _InterfaceGráfica;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import exceptions.SelectException;
import exceptions.SenhaIncorretaException;
import exceptions.UsuarioNaoExisteException;
import negocio.Financas;

public class TelaLoginUsuario extends javax.swing.JFrame {

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
        System.out.printf("Primeira instância");
        try {
            TelaLoginUsuario.financas = new Financas();
        } catch (ClassNotFoundException | SQLException | SelectException e) {
            JOptionPane.showMessageDialog(jPanel1, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelLogin = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jTextFieldLogin = new javax.swing.JTextField();
        jButtonEntrar = new javax.swing.JButton();
        jButtonDeletarConta = new javax.swing.JButton();
        jButtonNovoUsuario = new javax.swing.JButton();
        jPasswordFieldSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 600;
        int height = 500;
        setPreferredSize(new java.awt.Dimension(600, 500));
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(205, 241, 241));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 255, 255), 6, true));

        jLabelTitulo.setFont(new java.awt.Font("Roboto Cn", 0, 48));
        jLabelTitulo.setText("Login de Usuário");
        jLabelTitulo.setToolTipText("");

        jLabelLogin.setFont(new java.awt.Font("Roboto", 0, 24));
        jLabelLogin.setText("Login");

        jLabelPassword.setFont(new java.awt.Font("Roboto", 0, 24));
        jLabelPassword.setText("Senha");

        jButtonEntrar.setFont(new java.awt.Font("Roboto", 0, 12));
        jButtonEntrar.setText("Entrar");
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });

        jButtonDeletarConta.setBackground(new java.awt.Color(255, 102, 102));
        jButtonDeletarConta.setFont(new java.awt.Font("Roboto", 0, 12));
        jButtonDeletarConta.setText("Deletar Conta");
        jButtonDeletarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletarContaActionPerformed(evt);
            }
        });

        jButtonNovoUsuario.setFont(new java.awt.Font("Roboto", 0, 12));
        jButtonNovoUsuario.setText("Criar novo usuário");
        jButtonNovoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoUsuarioActionPerformed(evt);
            }
        });

        jPasswordFieldSenha.setText("123");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 144, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelLogin)
                                .addGap(264, 264, 264))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelPassword)
                                .addGap(260, 260, 260))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelTitulo)
                                .addGap(125, 125, 125))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(248, 248, 248))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(jButtonNovoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPasswordFieldSenha))
                                .addGap(201, 201, 201))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonDeletarConta)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addComponent(jLabelLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonNovoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jButtonDeletarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        // pack();
    }// </editor-fold>                        

    protected void jButtonEntrarActionPerformed(ActionEvent evt) {
        String login = jTextFieldLogin.getText();
        String decodedPassword = "";
        char[] password = jPasswordFieldSenha.getPassword();

        for (char c : password) {
            decodedPassword += c;
        }

        try {
            financas.login(login, decodedPassword);
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
        // /* Set the Nimbus look and feel */
        // //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        // /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        //  * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
        //  */
        // try {
        //     for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        //         if ("Nimbus".equals(info.getName())) {
        //             javax.swing.UIManager.setLookAndFeel(info.getClassName());
        //             break;
        //         }
        //     }
        // } catch (ClassNotFoundException ex) {
        //     java.util.logging.Logger.getLogger(TelaLoginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        // } catch (InstantiationException ex) {
        //     java.util.logging.Logger.getLogger(TelaLoginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        // } catch (IllegalAccessException ex) {
        //     java.util.logging.Logger.getLogger(TelaLoginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        // } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        //     java.util.logging.Logger.getLogger(TelaLoginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        // }
        // //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if(financas == null){
                    new TelaLoginUsuario().setVisible(true);
                }else{
                    // new TelaLoginUsuario(financas).setVisible(true);
                }
            }
        });
    }
}
