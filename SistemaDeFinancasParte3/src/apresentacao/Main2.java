package apresentacao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import exceptions.SelectException;
import negocio.Financas;

public class Main2 {
    static Financas financas;
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        try {
            financas = new Financas();
        } catch (ClassNotFoundException | SQLException | SelectException e) {
            System.err.print(e.getMessage());
        }

        TelaLoginUsuario telaDeLogin = new TelaLoginUsuario(financas);
        telaDeLogin.setVisible(true);
        



    }
}
