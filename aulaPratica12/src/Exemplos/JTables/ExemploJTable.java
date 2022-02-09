package Exemplos.JTables;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ExemploJTable extends JScrollPane{
    public ExemploJTable() {
        Tabela cidades = new Tabela();
        JTable table = new JTable(cidades);
        setViewportView(table);
        cidades.adicionarCidade(new Cidade("Joinville", "Santa Catarina"));
        cidades.adicionarCidade(new Cidade("Curitiba", "Paraná"));
        cidades.adicionarCidade(new Cidade("Florianópolis", "Santa Catarina"));
    }
}
