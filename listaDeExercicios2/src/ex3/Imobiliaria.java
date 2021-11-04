package ex3;

import java.util.ArrayList;
import java.util.List;

public class Imobiliaria {
    
    private String nome = "não nomeada";
    List<Imovel> imoveis = new ArrayList<Imovel>();
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Imovel> gImoveis(){
        return imoveis;
    }

    public void cadastraImovel(Imovel imovel){
        imoveis.add(imovel);
    }

    public String toString(){
        String str = "";

        str += "Imobiliaria "+this.nome+"\n";

        for(int i=0; i<imoveis.size(); i++){
            str += "\n=> Imóvel nº"+(i+1)+":\n";
            str += imoveis.get(i)+"\n";
        }

        return str;
    }

    public List<Imovel> filtrarPorArea(float x){
        List<Imovel> imoveisFiltrados = new ArrayList<Imovel>();

        for(int i=0; i < imoveis.size(); i++){
            if(imoveis.get(i).Area() >= x){
                imoveisFiltrados.add(imoveis.get(i));
            }
        }

        return imoveisFiltrados;

    }

}
