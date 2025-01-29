import javax.swing.ImageIcon;

/**
 * Classe que representa a área de estacionamento, composta por uma pista de entrada,
 * uma pista de saída e o estacionamento propriamente dito.
 */
public class AreaDeEstacionamento {

    private PistaEntrada pistaEntrada;
    private PistaSaida pistaSaida;
    private Estacionamento estacionamento;
    public static final int ESPACO_PISTA = 69;
    public static final int ESPACO_ESTACIONAMENTO = 52;
    public static final int POSICAO_ESTACIONADO = 300;

    /**
     * Construtor da classe AreaDeEstacionamento. Inicializa a pista de entrada, a pista de saída
     * e o estacionamento com base na quantidade de vagas disponíveis para caminhões, motos e carros.
     *
     * @param qtdVagasCaminhao A quantidade de vagas para caminhões.
     * @param qtdVagasMoto A quantidade de vagas para motos.
     * @param qtdVagasCarro A quantidade de vagas para carros.
     */
    public AreaDeEstacionamento(int qtdVagasCaminhao, int qtdVagasMoto, int qtdVagasCarro) {
        pistaEntrada = new PistaEntrada();
        pistaSaida = new PistaSaida();
        estacionamento = new Estacionamento(qtdVagasCaminhao, qtdVagasMoto, qtdVagasCarro,
            new ImageIcon(Estacionamento.class.getResource("Imagens/estacionamento.png")).getImage());
    }

    /**
     * Retorna o estacionamento associado a esta área de estacionamento.
     *
     * @return O estacionamento.
     */
    public Estacionamento getEstacionamento() {
        return estacionamento;
    }

    /**
     * Exibe informações sobre a pista de entrada.
     */
    public void verPistaEntrada() {
        System.out.println(pistaEntrada);
    }

    /**
     * Exibe informações sobre a pista de saída.
     */
    public void verPistaSaida() {
        System.out.println(pistaSaida);
    }

    /**
     * Exibe informações sobre o estacionamento.
     */
    public void verEstacionamento() {
        System.out.println(estacionamento);
    }

    /**
     * Faz os veículos avançarem na área de estacionamento, realizando operações na pista de entrada,
     * no estacionamento e na pista de saída.
     * O veículo que sair do estacionamento é retornado, ou null caso nenhum veículo tenha saído.
     *
     * @return Um veículo que saiu da área, ou null se nenhum veículo sair.
     */
    public Veiculo executarPasso() {
        Veiculo saida = pistaEntrada.andarPista();
        if (saida != null) {
            estacionamento.entrarCarro(saida);
        }
        estacionamento.controlarEstacionamento();
        if (estacionamento.verificarFilaSaida()) {
            if (pistaSaida.verificarSaida(estacionamento.tamanhoProximoVeiculoSair())) {
                pistaSaida.adicionarVeiculo(estacionamento.liberarCarro());
            }
        }
        saida = pistaSaida.andarPista();
        if (saida != null) {
            return saida;
        }
        return null;
    }

    /**
     * Verifica se há algum veículo esperando na pista de entrada.
     *
     * @return true se não houver veículos na pista de entrada, false caso contrário.
     */
    public boolean verificarPistaEntrada() {
        return !pistaEntrada.temProximo();
    }

    /**
     * Adiciona um veículo à pista de entrada.
     *
     * @param v Veículo a ser adicionado à pista de entrada.
     */
    public void adicionarVeiculo(Veiculo v) {
        pistaEntrada.escolherProximo(v);
    }
}