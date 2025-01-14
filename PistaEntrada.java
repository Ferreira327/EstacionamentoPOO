import java.util.*;

public class PistaEntrada{
    public static int tamanhoY = 300;
    public static int tamanhoX = 60;
    Veiculo proximo;
    LinkedList<Veiculo> veiculos;

    public PistaEntrada(){
        veiculos = new LinkedList<>(); // Lista de Veículos
    }

    
    public Veiculo andarPista(){ // Método para movimentar a pista e, se o veículo estiver no final dela, retorná-lo
        Veiculo retornar = null;
        Iterator<Veiculo> iterador = veiculos.descendingIterator(); //Iterator para modificar os veículos
            while(iterador.hasNext()){ 
                Veiculo v = iterador.next();
                if(v.getPosicao() + v.getTamanho() >= tamanhoY){ // Se a posição do veículo + seu tamanho for maior que o limite da pista, ele é retornado e retirado da lista.
                    retornar = v;
                    iterador.remove();
                }
                else{
                v.andar(true);}
            }
            adicionarVeiculo();
            return retornar;
    }

    
    private void adicionarVeiculo(){
        if( veiculos.isEmpty() || ((proximo.getTamanho()+10) < veiculos.getLast().getPosicao())){ // Se a entrada da pista tiver espaço, o próximo veículo é adicionado
            veiculos.add(proximo);
            proximo = null;
        }
    }

    
    public void escolherProximo(Veiculo v){ // Gerador do proximo veículo, onde cada veículo tem um peso diferente na geração
        this.proximo = v;
    }

    @Override
    public String toString(){
        Iterator<Veiculo> iterador = veiculos.descendingIterator();
        String palavra = "=Pista Entrada=\n";
        while(iterador.hasNext()){
            Veiculo v = iterador.next();
            palavra += v.toString() ;
        }
        return palavra;
    }

    public boolean temProximo(){
        if(proximo == null){
            return false;
        }
        return true;
    }

    
    
}
