import java.util.*;

/**
 * Representa um mapa contendo todos os itens que participam da simulação.
 * 
 * O mapa gerencia uma lista de veículos e estacionamentos, permitindo a 
 * adição, remoção e atualização de itens no ambiente da simulação.
 * 
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Mapa {
    //Lista de veículos no mapa
    private ArrayList<Veiculo> itens;
    //Lista de estacionamentos no mapa 
    private ArrayList<Estacionamento> estacionamentos;

    /**
     * Construtor padrão da classe Mapa.
     * 
     * Inicializa as listas de veículos e estacionamentos como vazias.
     */
    public Mapa() {
        itens = new ArrayList<>();
        estacionamentos = new ArrayList<>();
    }

    /**
     * Retorna a lista de veículos presentes no mapa.
     * 
     * @return uma lista de objetos {@link Veiculo}.
     */
    public ArrayList<Veiculo> getVeiculos() {
        return itens;
    }

    /**
     * Retorna a lista de estacionamentos presentes no mapa.
     * 
     * @return uma lista de objetos {@link Estacionamento}.
     */
    public ArrayList<Estacionamento> getEstacionamento() {
        return estacionamentos;
    }

    /**
     * Adiciona um veículo ao mapa.
     * 
     * @param v o veículo a ser adicionado.
     */
    public void adicionarItem(Veiculo v) {
        itens.add(v);
    }

    /**
     * Adiciona um estacionamento ao mapa.
     * 
     * @param e o estacionamento a ser adicionado.
     */
    public void adicionarEstacionamento(Estacionamento e) {
        estacionamentos.add(e);
    }

    /**
     * Remove um veículo do mapa.
     * 
     * @param v o veículo a ser removido.
     */
    public void removerItem(Veiculo v) {
        itens.remove(v);
    }

    /**
     * Atualiza a posição de um veículo no mapa.
     * 
     * Remove o veículo do mapa e o reinsere se ele ainda estiver dentro dos limites válidos.
     * 
     * @param v o veículo a ser atualizado.
     */
    public void atualizarMapa(Veiculo v) {
        removerItem(v);
        if (v.getPosicao() - v.getTamanho() >= 0) {
            adicionarItem(v);
        }
    }
}   