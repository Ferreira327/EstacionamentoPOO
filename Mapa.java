import java.util.*;

/**
 * Representa um mapa com todos os itens que participam da simulacao
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Mapa {
    private ArrayList<Veiculo> itens;
    private ArrayList<Estacionamento> estacionamentos;
    

    public Mapa() {
        itens = new ArrayList<>();
        estacionamentos = new ArrayList<>();
    }

    public ArrayList<Veiculo> getVeiculos(){
        return itens;
    }

    public ArrayList<Estacionamento> getEstacionamento(){
        return estacionamentos;
    }

    
    public void adicionarItem(Veiculo v){
        itens.add(v);
    }

    public void adicionarEstacionamento(Estacionamento e){
        estacionamentos.add(e);
    }
    
    public void removerItem(Veiculo v){
        itens.remove(v);
    }
    
    public void atualizarMapa(Veiculo v){
        removerItem(v);
        if(v.getPosicao() - v.getTamanho() >= 0){
        adicionarItem(v);}
    }
    
    /* 
    public Veiculo getItem(int x, int y){
        return itens[x][y];
    }
    */
    
}
