import javax.swing.ImageIcon;


/**
 * Classe que representa a área de estacionamento, composta por uma pista de entrada,
 * uma pista de saída e o estacionamento propriamente dito.
 */

public class AreaDeEstacionamento{

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

    public AreaDeEstacionamento(int qtdVagasCaminhao, int qtdVagasMoto, int qtdVagasCarro){
        pistaEntrada = new PistaEntrada();
        pistaSaida = new PistaSaida();
        estacionamento = new Estacionamento(qtdVagasCaminhao, qtdVagasMoto, qtdVagasCarro,new ImageIcon(Estacionamento.class.getResource("Imagens/estacionamento.png")).getImage());
    }

    public Estacionamento getEstacionamento(){
        return estacionamento;
    }

    public void verPistaEntrada(){
        System.out.println(pistaEntrada);
    }

    public void verPistaSaida(){
        System.out.println(pistaSaida);
    }

    public void verEstacionamento(){
        System.out.println(estacionamento);
    }


    /**
     * Faz os veículos avançarem na área de estacionamento, realizando operações na pista de entrada,
     * no estacionamento e na pista de saída.
     *
     * @return Um veículo que saiu da área, ou nulo se nenhum veículo sair.
     */

    public Veiculo executarPasso(){
        Veiculo saida = pistaEntrada.andarPista();
            if(saida != null){
                estacionamento.entrarCarro(saida);
            }
            estacionamento.controlarEstacionamento();
            if(estacionamento.verificarFilaSaida()){
                if(pistaSaida.verificarSaida(estacionamento.tamanhoProximoVeiculoSair())){
                    pistaSaida.adicionarVeiculo(estacionamento.liberarCarro());
                }
            }
            saida = pistaSaida.andarPista();
            if(saida != null){
                return saida;
            }
            return null;
    }

    public boolean verificarPistaEntrada(){
        if(pistaEntrada.temProximo()){
            return false;
        }
        return true;
    }

    public void adicionarVeiculo(Veiculo v){
        pistaEntrada.escolherProximo(v);
    }


    
}
