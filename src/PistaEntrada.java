import java.util.*;

/**
 * Classe que representa a pista de entrada de veículos.
 * 
 * A pista de entrada é responsável por gerenciar os veículos que estão entrando no estacionamento.
 * Os veículos são armazenados em uma lista ligada e movem-se em direção ao final da pista.
 */
public class PistaEntrada {
    public static int tamanhoY = 300; // Tamanho máximo da pista no eixo Y
    private Veiculo proximo; // Próximo veículo a entrar na pista
    private LinkedList<Veiculo> veiculos; // Lista de veículos na pista de entrada

    /**
     * Construtor da classe PistaEntrada.
     * Inicializa a lista de veículos como vazia.
     */
    public PistaEntrada() {
        veiculos = new LinkedList<>();
    }

    /**
     * Move todos os veículos na pista de entrada, ajustando suas posições.
     * Se um veículo atingir o final da pista (posição >= {@link #tamanhoY}), ele é removido
     * e retornado pelo método.
     * 
     * @return o veículo que atingiu o final da pista, ou {@code null} se nenhum veículo atingiu o final.
     */
    public Veiculo andarPista() {
        Veiculo retornar = null;
        Iterator<Veiculo> iterador = veiculos.descendingIterator(); // Iterador para modificar os veículos
        while (iterador.hasNext()) {
            Veiculo v = iterador.next();
            if (v != null && v.getPosicao() + v.getTamanho() >= tamanhoY) { // Verifica se o veículo atingiu o final
                retornar = v;
                iterador.remove();
            } else if (v != null) {
                v.andar(true); // Move o veículo para frente
            }
        }
        adicionarVeiculo(); // Adiciona o próximo veículo à pista, se aplicável
        return retornar;
    }

    /**
     * Adiciona o próximo veículo à pista, caso haja espaço suficiente.
     */
    private void adicionarVeiculo() {
        if (proximo != null && (veiculos.isEmpty() || (proximo.getTamanho() + 10) < veiculos.getLast().getPosicao())) {
            veiculos.add(proximo);
            proximo = null;
        }
    }

    /**
     * Define o próximo veículo que entrará na pista.
     * 
     * @param v o próximo veículo a ser adicionado.
     */
    public void escolherProximo(Veiculo v) {
        this.proximo = v;
    }

    /**
     * Retorna uma representação textual da pista de entrada e dos veículos nela presentes.
     * 
     * @return uma string com informações sobre a pista de entrada e seus veículos.
     */
    @Override
    public String toString() {
        Iterator<Veiculo> iterador = veiculos.descendingIterator();
        String palavra = "=Pista Entrada=\n";
        while (iterador.hasNext()) {
            Veiculo v = iterador.next();
            if (v != null) { // Verifica se o veículo não é null
                palavra += v.toString();
            }
        }
        return palavra;
    }

    /**
     * Verifica se há um próximo veículo a ser adicionado à pista.
     * 
     * @return {@code true} se há um próximo veículo, {@code false} caso contrário.
     */
    public boolean temProximo() {
        return proximo != null;
    }
}