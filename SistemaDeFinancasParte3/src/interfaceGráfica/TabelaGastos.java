package interfaceGráfica;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dados.Gasto;

public class TabelaGastos extends AbstractTableModel {

    private List<Gasto> gastos = new LinkedList<Gasto>();

    @Override
    public int getRowCount() {
        return gastos.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return gastos.get(linha).getId();

            case 1:
                return gastos.get(linha).getNome();

            case 2:
                return gastos.get(linha).getData();

            case 3:
                return gastos.get(linha).getValor();

            case 4:
                int cat = gastos.get(linha).getCategoria();

                switch (cat) {
                    case 1:
                        return "Comida";

                    case 2:
                        return "Lazer";

                    case 3:
                        return "Educação";

                    case 4:
                        return "Saúde";

                    case 5:
                        return "Transporte";

                    case 6:
                        return "Outros";
                
                    default:
                        return null;
                }

            case 5:
                return gastos.get(linha).getDescricao();
        
            default:
                throw new IllegalArgumentException();
        }
    }

    public String getColumnName(int coluna) {
        switch (coluna) {
            case 0:
                return "Id";

            case 1:
                return "Nome";

            case 2:
                return "Data";

            case 3:
                return "Valor";

            case 4:
                return "Categoria";

            case 5:
                return "Descricao";
        
            default:
                throw new IllegalArgumentException();
        }
    }

    public void addGasto(Gasto gasto){
        gastos.add(gasto);
        this.fireTableStructureChanged();
    }

    public void populateGastos(List<Gasto> newGastos){
        for (Gasto gasto : newGastos) {
            gastos.add(gasto);
        }
        this.fireTableStructureChanged();
    }
    
    public void resetGastos(){
        gastos.clear();
        this.fireTableStructureChanged();
    }
    
}
