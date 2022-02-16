package _InterfaceGráfica;

import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelLogin = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jTextFieldLogin = new javax.swing.JTextField();
        jButtonCadastrar = new javax.swing.JButton();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 600;
        int height = 500;
        setPreferredSize(new java.awt.Dimension(width, height));
        setBounds(center.x - width / 2, center.y - height / 2, width, height);

        jPanel1.setBackground(new java.awt.Color(205, 241, 241));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 255, 255), 6, true));

        jLabelTitulo.setFont(new java.awt.Font("Roboto Cn", 0, 48));
        jLabelTitulo.setText("Cadastro de Usuário");
        jLabelTitulo.setToolTipText("");

        jLabelLogin.setFont(new java.awt.Font("Roboto Lt", 0, 24));
        jLabelLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogin.setText("Digite seu login");

        jLabelPassword.setFont(new java.awt.Font("Roboto Lt", 0, 24));
        jLabelPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelTitulo)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCadastrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(201, 201, 201))))
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
                .addGap(18, 18, 18)
                .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
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
            JOptionPane.showMessageDialog(jPanel1, "Usuário Cadastrado com sucesso!", "Sucesso!", JOptionPane.OK_CANCEL_OPTION);
            JFrame telaLogin = new TelaLoginUsuario(financas);
            telaLogin.setVisible(true);
            this.dispose();
        } catch (InsertException | SelectException e) {
            JOptionPane.showMessageDialog(jPanel1, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }                                                                                 

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                                
        JFrame telaLogin = new TelaLoginUsuario(financas);
        telaLogin.setVisible(true);
        this.dispose();
    }                                               

    // public static void main(String args[]) {
    //     try {
    //         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    //             if ("Nimbus".equals(info.getName())) {
    //                 javax.swing.UIManager.setLookAndFeel(info.getClassName());
    //                 break;
    //             }
    //         }
    //     } catch (ClassNotFoundException ex) {
    //         java.util.logging.Logger.getLogger(TelaCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (InstantiationException ex) {
    //         java.util.logging.Logger.getLogger(TelaCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (IllegalAccessException ex) {
    //         java.util.logging.Logger.getLogger(TelaCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //         java.util.logging.Logger.getLogger(TelaCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     }
    //     java.awt.EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             new TelaCadastroUsuario(financas).setVisible(true);
    //         }
    //     });
    // }
}
