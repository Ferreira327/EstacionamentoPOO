import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulacao {

    private int quantidadeAreas = 0;
    private List<AreaDeEstacionamento> areas;

    public Simulacao(){
        areas = new ArrayList<>();
    }

    private void adicionarArea(AreaDeEstacionamento area){
        quantidadeAreas += 1;
        areas.add(area);
    }

    public List<AreaDeEstacionamento> getAreas() {
        return areas;
    }

    public void iniciar() {
        

        adicionarArea(new AreaDeEstacionamento(2, 3, 2)); // Estacionamento 1
        adicionarArea(new AreaDeEstacionamento(1, 2, 1)); // Estacionamento 2
        adicionarArea(new AreaDeEstacionamento(1, 2, 1)); // Estacionamento 3
        adicionarArea(new AreaDeEstacionamento(1, 2, 1)); // Estacionamento 3
        adicionarArea(new AreaDeEstacionamento(1, 2, 1)); // Estacionamento 3
        adicionarArea(new AreaDeEstacionamento(1, 2, 1)); // Estacionamento 3
        
        Mapa mapa = new Mapa();

        List<AreaDeEstacionamento> areas = getAreas();

        for(AreaDeEstacionamento areaDeEstacionamento : areas){
            mapa.adicionarEstacionamento(areaDeEstacionamento.getEstacionamento());
        }

        JanelaSimulacao janelaSimulacao = new JanelaSimulacao(mapa);
        
        while (true) {
            
            janelaSimulacao.executarAcao();

            // Gera um veículo e atribui a um estacionamento específico
            
            int indiceEstacionamento = new Random().nextInt(areas.size()); // Escolhe um estacionamento aleatório
            AreaDeEstacionamento area = areas.get(indiceEstacionamento);
            Veiculo v = gerarVeiculo(indiceEstacionamento);
            // Adiciona o veículo ao estacionamento escolhido
            if (area.verificarPistaEntrada()) {
                mapa.adicionarItem(v);
                area.adicionarVeiculo(v);
            }

            // Executa um passo de simulação para cada estacionamento
            for (AreaDeEstacionamento areaEstacionamento : areas) {
                Veiculo veiculoSaindo = areaEstacionamento.executarPasso();
                if (veiculoSaindo != null) {
                    mapa.removerItem(veiculoSaindo);
                }
               
                // Exibe o estado atual de cada estacionamento
                //estacionamento.verPistaEntrada();
                //estacionamento.verEstacionamento();
                //estacionamento.verPistaSaida();
            }

            esperar(1000); // Pausa a simulação por 1 segundo
        }
    }

    private static Veiculo gerarVeiculo(int indiceEstacionamento) {
        Veiculo novoVeiculo;
        Random gerador = new Random();
        int numero = gerador.nextInt(6);
        int posicaoX = 0;
        posicaoX = indiceEstacionamento * 250 + 250;
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
                throw new AssertionError();
        }

        return novoVeiculo;
    }

    private static void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}