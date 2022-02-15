package oldMenu;

import java.sql.SQLException;

import _InterfaceGráfica.TelaLoginUsuario;
import exceptions.SelectException;
import negocio.Financas;

public class MainStarter {
    static Financas financas;
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
