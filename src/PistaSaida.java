import java.util.*;

/**
 * Classe que representa a pista de saída de veículos.
 * 
 * A pista de saída gerencia os veículos que estão saindo do estacionamento.
 * Ela utiliza uma lista ligada para armazenar os veículos e oferece métodos
 * para verificar se um veículo pode entrar na pista, adicionar veículos e mover
 * os veículos ao longo da pista.
 */
public class PistaSaida {
    private LinkedList<Veiculo> veiculos;

    /**
     * Construtor da classe PistaSaida.
     * Inicializa a lista de veículos como vazia.
     */
    public PistaSaida() {
        veiculos = new LinkedList<>();
    }

    /**
     * Verifica se há espaço para um veículo de determinado tamanho na pista de saída.
     * 
     * @param tamanhoProximo o tamanho do próximo veículo a ser adicionado.
     * @return {@code true} se o veículo puder ser adicionado, {@code false} caso contrário.
     */
    public boolean verificarSaida(int tamanhoProximo) {
        return veiculos.isEmpty() || ((250 - tamanhoProximo) > veiculos.getLast().getPosicao());
    }

    /**
     * Adiciona um veículo à pista de saída, caso haja espaço suficiente.
     * 
     * @param e o veículo a ser adicionado.
     */
    public void adicionarVeiculo(Veiculo e) {
        if (verificarSaida(e.getTamanho())) {
            veiculos.add(e);
        }
    }

    /**
     * Move todos os veículos da pista de saída, ajustando suas posições.
     * 
     * Se um veículo atingir o início da pista (posição 0), ele será removido
     * e retornado pelo método.
     * 
     * @return o veículo que chegou ao final da pista, ou {@code null} se nenhum veículo chegou ao final.
     */
    public Veiculo andarPista() {
        Veiculo retornar = null;
        Iterator<Veiculo> iterador = veiculos.descendingIterator(); 
        while (iterador.hasNext()) {
            Veiculo v = iterador.next();
            if (v.getPosicao() - v.getTamanho() <= 0) {
                iterador.remove();
                retornar = v;
            } else {
                v.andar(false);
            }
        }
        return retornar;
    }

    /**
     * Retorna uma representação textual da pista de saída e dos veículos nela presentes.
     * 
     * @return uma string com informações sobre a pista de saída e seus veículos.
     */
    @Override
    public String toString() {
        Iterator<Veiculo> iterador = veiculos.descendingIterator();
        String palavra = "\nPista Saída\n";
        while (iterador.hasNext()) {
            Veiculo v = iterador.next();
            palavra += v.toString();
        }
        return palavra;
    }
}