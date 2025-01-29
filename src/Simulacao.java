import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe Simulacao representa a lógica principal para gerenciar e executar a simulação
 * de um sistema de estacionamento. Essa classe organiza as áreas de estacionamento,
 * cria veículos e gerencia o fluxo de veículos entre os estacionamentos.
 */
public class Simulacao {

    /**
     * Quantidade de áreas de estacionamento existentes.
     */
    private int quantidadeAreas = 0;

    /**
     * Lista das áreas de estacionamento gerenciadas na simulação.
     */
    private List<AreaDeEstacionamento> areas;

    /**
     * Construtor da classe Simulacao. Inicializa a lista de áreas de estacionamento.
     */
    public Simulacao() {
        areas = new ArrayList<>();
    }

    /**
     * Adiciona uma nova área de estacionamento à simulação.
     * 
     * @param area a área de estacionamento a ser adicionada.
     */
    private void adicionarArea(AreaDeEstacionamento area) {
        quantidadeAreas += 1;
        areas.add(area);
    }

    /**
     * Retorna a lista de áreas de estacionamento gerenciadas pela simulação.
     * 
     * @return lista de áreas de estacionamento.
     */
    public List<AreaDeEstacionamento> getAreas() {
        return areas;
    }

    /**
     * Inicia o processo de simulação. Configura as áreas de estacionamento, cria o mapa
     * para exibição e gerencia a entrada e saída de veículos de forma contínua.
     */
    public void iniciar() {

        // Adiciona várias áreas de estacionamento com capacidades pré-definidas
        adicionarArea(new AreaDeEstacionamento(2, 3, 2));
        adicionarArea(new AreaDeEstacionamento(1, 2, 1));
        adicionarArea(new AreaDeEstacionamento(1, 2, 1));

        Mapa mapa = new Mapa();

        List<AreaDeEstacionamento> areas = getAreas();
        for (AreaDeEstacionamento areaDeEstacionamento : areas) {
            mapa.adicionarEstacionamento(areaDeEstacionamento.getEstacionamento());
        }

        JanelaSimulacao janelaSimulacao = new JanelaSimulacao(mapa);

        while (true) {

            janelaSimulacao.executarAcao();

            int indiceEstacionamento = new Random().nextInt(areas.size());
            AreaDeEstacionamento area = areas.get(indiceEstacionamento);
            Veiculo v = gerarVeiculo(indiceEstacionamento);

            if (area.verificarPistaEntrada()) {
                mapa.adicionarItem(v);
                area.adicionarVeiculo(v);
            }

            for (AreaDeEstacionamento areaEstacionamento : areas) {
                Veiculo veiculoSaindo = areaEstacionamento.executarPasso();
                if (veiculoSaindo != null) {
                    mapa.removerItem(veiculoSaindo);
                }
            }

            esperar(1000);
        }
    }

    /**
     * Gera um novo veículo com base em um índice de estacionamento específico.
     * 
     * @param indiceEstacionamento índice do estacionamento ao qual o veículo será atribuído.
     * @return o veículo criado (Carro, Moto ou Caminhão).
     */
    private static Veiculo gerarVeiculo(int indiceEstacionamento) {
        Veiculo novoVeiculo;
        Random gerador = new Random();
        int numero = gerador.nextInt(6);
        int posicaoX = indiceEstacionamento * 250 + 250;

        switch (numero) {
            case 0, 1, 2:
                novoVeiculo = new Carro(new Localizacao(posicaoX, 0));
                break;
            case 3, 4:
                novoVeiculo = new Moto(new Localizacao(posicaoX, 0));
                break;
            case 5:
                novoVeiculo = new Caminhao(new Localizacao(posicaoX, 0));
                break;
            default:
                throw new AssertionError("Tipo de veículo inválido");
        }

        return novoVeiculo;
    }

    /**
     * Faz a thread principal da simulação esperar por um determinado período de tempo.
     * 
     * @param milisegundos tempo de espera em milissegundos.
     */
    private static void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}