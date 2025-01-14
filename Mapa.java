
import java.util.*;

/**
 * Representa um mapa com todos os itens que participam da simulacao
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Mapa {
    private ArrayList<Veiculo> itens;
    

    public Mapa() {
        itens = new ArrayList<>();
    }

    public ArrayList<Veiculo> getVeiculos(){
        return itens;
    }

    
    public void adicionarItem(Veiculo v){
        itens.add(v);
    }
    
    public void removerItem(Veiculo v){
        itens.remove(v);
    }
    
    public void atualizarMapa(Veiculo v){
        removerItem(v);
        adicionarItem(v);
    }
    
    /* 
    public Veiculo getItem(int x, int y){
        return itens[x][y];
    }
    */
    
}
