import java.util.*;

public class PistaEntrada{
    public static int tamanhoY = 300;
    public static int tamanhoX = 60;
    Veiculo proximo;
    LinkedList<Veiculo> veiculos;

    public PistaEntrada(){
        escolherProximo(); // Sempre que uma Pista de entrada for criada, um veículo estará em espera para entrar
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
            escolherProximo();
        }
    }

    
    private void escolherProximo(){ // Gerador do proximo veículo, onde cada veículo tem um peso diferente na geração
        Random gerador = new Random();
        int numero = gerador.nextInt(6);

        switch (numero) {
            case 0,1,2:
                this.proximo = new Carro(0);
                break;
            case 3,4:
                this.proximo = new Moto(0);
                break;
            case 5:
                this.proximo = new Caminhao(0);
                break;
            default:
                throw new AssertionError();
        }
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

    
    
}
