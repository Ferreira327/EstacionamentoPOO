import java.util.*;

public class PistaSaida{
    public static int tamanhoY = 300;
    public static int tamanhoX = 60;
    LinkedList<Veiculo> veiculos;

    public PistaSaida(){
        veiculos = new LinkedList<>();       
    }
    

    public boolean verificarSaida(int tamanhoProximo){
        if( veiculos.isEmpty() || ((250-tamanhoProximo) > veiculos.getLast().getPosicao())){
            return true;
        }
        return false;
    }


    public void adicionarVeiculo(Veiculo e){
        if(verificarSaida(e.getTamanho())){
            veiculos.add(e);
        }
    }

    public Veiculo andarPista(){ // Método para movimentar a pista e, se o veículo estiver no final dela, retorná-lo
        Veiculo retornar = null;
        Iterator<Veiculo> iterador = veiculos.descendingIterator(); //Iterator para modificar os veículos
            while(iterador.hasNext()){ 
                Veiculo v = iterador.next();
                if(v.getPosicao() - v.getTamanho() <= 0){ // Se a posição do veículo + seu tamanho for maior que o limite da pista, ele é retornado e retirado da lista.
                    iterador.remove();
                    retornar = v;
                }
                else{
                v.andar(false);}
            }
            return retornar;
        }

        @Override
        public String toString(){
            Iterator<Veiculo> iterador = veiculos.descendingIterator();
            String palavra = "\nPista Saida\n";
            while(iterador.hasNext()){
                Veiculo v = iterador.next();
                palavra += v.toString() ;
            }
            return palavra;
        }
            
    
}
