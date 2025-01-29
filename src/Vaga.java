/**
 * Classe abstrata que representa uma vaga de estacionamento.
 * Define atributos e comportamentos básicos de uma vaga, como disponibilidade, tamanho, 
 * veículo alocado e controle de tempo de permanência.
 * 
 * Relacionamentos:
 * - Associação com a classe {@link Veiculo}, que representa o veículo estacionado na vaga.
 * 
 * Constantes:
 * - {@link #TAMANHO_ESPACO_VAGA} define um tamanho adicional padrão para a vaga.
 */
public abstract class Vaga {

    private Veiculo v; // Veículo estacionado na vaga
    private int tamanho; // Tamanho da vaga
    private float preco; // Preço cobrado pela vaga (não utilizado no código atual)
    private int tempo; // Tempo limite para o veículo permanecer na vaga
    private int tempoAtual; // Tempo que o veículo está na vaga
    private boolean disponivel; // Indica se a vaga está disponível
    public static final int TAMANHO_ESPACO_VAGA = 20; // Tamanho adicional padrão da vaga

    /**
     * Construtor da classe Vaga.
     * Inicializa a vaga como disponível, com o tamanho especificado somado a {@link #TAMANHO_ESPACO_VAGA}.
     * 
     * @param tamanho o tamanho base da vaga.
     */
    public Vaga(int tamanho) {
        tempo = 0;
        disponivel = true;
        this.tamanho = tamanho + TAMANHO_ESPACO_VAGA;
    }

    /**
     * Verifica se a vaga está disponível.
     * 
     * @return {@code true} se a vaga estiver disponível, {@code false} caso contrário.
     */
    public boolean isDisponivel() {
        return disponivel;
    }

    /**
     * Retorna o tamanho da vaga.
     * 
     * @return o tamanho da vaga.
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * Retorna o veículo atualmente estacionado na vaga.
     * 
     * @return o veículo estacionado, ou {@code null} se a vaga estiver disponível.
     */
    public Veiculo getVeiculo() {
        return v;
    }

    /**
     * Define o veículo a ser estacionado na vaga, caso ela esteja disponível.
     * Atualiza o tempo limite de permanência e marca a vaga como ocupada.
     * 
     * @param v o veículo a ser estacionado.
     * @param tempo o tempo limite para o veículo permanecer na vaga.
     */
    public void setVeiculo(Veiculo v, int tempo) {
        if (isDisponivel()) {
            disponivel = false;
            this.v = v;
            this.tempo = tempo;
            tempoAtual = 0;
        }
    }

    /**
     * Controla o tempo de permanência do veículo na vaga.
     * Incrementa o tempo atual e verifica se o tempo limite foi atingido.
     * 
     * @return {@code true} se o veículo ainda pode permanecer na vaga, {@code false} caso contrário.
     */
    public boolean controlarVaga() {
        if (tempoAtual == -1)
            return true;
        tempoAtual += 1;
        if (tempoAtual < tempo) {
            return true;
        }
        tempoAtual = -1;
        return false;
    }

    /**
     * Libera a vaga, removendo o veículo estacionado.
     * Marca a vaga como disponível e reinicia os tempos.
     * 
     * @return o veículo que foi removido da vaga.
     */
    public Veiculo liberarVaga() {
        Veiculo ve = this.v;
        this.v = null;
        disponivel = true;
        tempo = 0;
        return ve;
    }

    /**
     * Retorna uma representação textual da vaga.
     * Indica se a vaga está disponível ou ocupada, e exibe informações do veículo estacionado.
     * 
     * @return uma string com o estado atual da vaga.
     */
    @Override
    public String toString() {
        if (disponivel) {
            return "Disponível: Sim\n\n";
        } else {
            if (tempoAtual == -1) {
                return "Disponível: Não\nVeículo: " + v.getId() + "\nTempo: Esperando saída\n\n";
            }
            return "Disponível: Não\nVeículo: " + v.getId() + "\nTempo: " + tempoAtual + "\n\n";
        }
    }
}