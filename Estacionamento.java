import java.awt.Image;
import java.util.*;

/**
 * Classe que representa um Estacionamento. 
 * Gerencia as vagas de diferentes tipos de veículos (carro, moto, caminhão), 
 * o fluxo de entrada e saída dos veículos, e a exibição da imagem do estacionamento.
 */
public class Estacionamento {
    private static final int TAMANHO_ESTACIONAMENTO = 257;
    private static int quantidade = 0;
    private Localizacao localizacao;
    private int posicao;
    private List<Vaga> vagas;
    private Image imagem;
    Queue<Veiculo> filaSair;
    private String ultimaAtualizacao;

    /**
     * Constrói um novo estacionamento com um número específico de vagas para caminhões, motos e carros. 
     * A quantidade total de espaço no estacionamento não pode ultrapassar um valor limite.
     *
     * @param caminhao Número de vagas para caminhões.
     * @param moto Número de vagas para motos.
     * @param carro Número de vagas para carros.
     * @param imagem Imagem representando o estacionamento.
     * @throws RuntimeException Se a soma do tamanho total das vagas ultrapassar o limite permitido.
     */
    public Estacionamento(int caminhao, int moto, int carro, Image imagem) throws RuntimeException {
        vagas = new ArrayList<>();
        filaSair = new LinkedList<>();
        if (caminhao * (Vaga.TAMANHO_ESPACO_VAGA + Veiculo.TAMANHO_CAMINHAO) + 
            moto * (Vaga.TAMANHO_ESPACO_VAGA + Veiculo.TAMANHO_MOTO) + 
            carro * (Vaga.TAMANHO_ESPACO_VAGA + Veiculo.TAMANHO_CARRO) <= 700) {
            
            for (int i = 0; i < carro; i++) {
                vagas.add(new VagaCarro());
            }
            for (int i = 0; i < moto; i++) {
                vagas.add(new VagaMoto());
            }
            for (int i = 0; i < caminhao; i++) {
                vagas.add(new VagaCaminhao());
            }
        } else {
            throw new RuntimeException("Estacionamento não permite o número de vagas");
        }
        this.imagem = imagem;
        quantidade++;
        posicao = 250 * quantidade;
        localizacao = new Localizacao(posicao - AreaDeEstacionamento.ESPACO_ESTACIONAMENTO, TAMANHO_ESTACIONAMENTO);
    }

    /**
     * Retorna a imagem associada ao estacionamento.
     *
     * @return Imagem do estacionamento.
     */
    public Image getImagem() {
        return imagem;
    }

    /**
     * Retorna a localização atual do estacionamento.
     *
     * @return Localização do estacionamento.
     */
    public Localizacao getLocalizacaoAtual() {
        return localizacao;
    }

    /**
     * Retorna o tamanho do estacionamento.
     *
     * @return Tamanho do estacionamento.
     */
    public int getTamanho() {
        return 200;
    }

    /**
     * Método responsável por permitir a entrada de um veículo no estacionamento.
     * O veículo é posicionado na vaga adequada, ou colocado na fila de saída se não houver vaga disponível.
     *
     * @param ve Veículo a ser estacionado.
     */
    public void entrarCarro(Veiculo ve) {
        Random gerador = new Random();

        for (Vaga v : vagas) {
            if (v.isDisponivel() && (ve.getTamanho() == (v.getTamanho() - Vaga.TAMANHO_ESPACO_VAGA))) {
                ve.setPosicao(new Localizacao(posicao + AreaDeEstacionamento.ESPACO_PISTA, 300));
                v.setVeiculo(ve, gerador.nextInt(3) + 12);
                ultimaAtualizacao = ve.acao();
                return;
            }
        }

        ve.setPosicao(new Localizacao(posicao + AreaDeEstacionamento.ESPACO_PISTA, 300));
        filaSair.add(ve);
    }

    /**
     * Controla as vagas do estacionamento, gerenciando veículos que precisam sair.
     */
    public void controlarEstacionamento() {
        for (Vaga v : vagas) {
            if (!v.isDisponivel()) {
                if (!v.controlarVaga()) {
                    filaSair.add(v.getVeiculo());
                }
            }
        }
    }

    /**
     * Libera o veículo que está na frente da fila de saída, permitindo que o veículo deixe o estacionamento.
     *
     * @return O veículo que foi liberado.
     */
    public Veiculo liberarCarro() {
        Veiculo liberar = filaSair.poll();
        for (Vaga v : vagas) {
            if (v.getVeiculo() == liberar) {
                v.liberarVaga();
            }
        }
        return liberar;
    }

    /**
     * Retorna o tamanho do próximo veículo a sair do estacionamento.
     *
     * @return Tamanho do próximo veículo a sair.
     */
    public int tamanhoProximoVeiculoSair() {
        return filaSair.peek().getTamanho();
    }

    /**
     * Verifica se existe algum veículo na fila de saída do estacionamento.
     *
     * @return true se houver veículos na fila de saída, caso contrário, false.
     */
    public boolean verificarFilaSaida() {
        return !filaSair.isEmpty();
    }

    /**
     * Retorna a posição do estacionamento.
     *
     * @return Posição do estacionamento.
     */
    public int getPosicao() {
        return posicao;
    }

    /**
     * Método toString que gera uma representação textual do estacionamento e das vagas.
     *
     * @return String com informações sobre o estacionamento e suas vagas.
     */
    @Override
    public String toString() {
        String retornar = "=Estacionamento=\n";
        for (Vaga v : vagas) {
            retornar += v.toString();
        }
        return retornar;
    }

    /**
     * Retorna a última atualização realizada no estacionamento, como uma mensagem relacionada ao último veículo.
     *
     * @return String com a última atualização.
     */
    public String verAtualizacao() {
        return this.ultimaAtualizacao;
    }
}