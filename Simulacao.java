import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulacao {
    public static void main(String[] args) {
        // Cria uma lista de estacionamentos
        List<AreaDeEstacionamento> estacionamentos = new ArrayList<>();
        estacionamentos.add(new AreaDeEstacionamento(2, 3, 2)); // Estacionamento 1
        estacionamentos.add(new AreaDeEstacionamento(1, 2, 1)); // Estacionamento 2
        estacionamentos.add(new AreaDeEstacionamento(1, 2, 1)); // Estacionamento 3
        
        Mapa mapa = new Mapa();
        for(AreaDeEstacionamento estacionamento : estacionamentos){
            mapa.adicionarEstacionamento(estacionamento.getEstacionamento());
        }
        JanelaSimulacao janelaSimulacao = new JanelaSimulacao(mapa);

        while (true) {
            janelaSimulacao.executarAcao();

            // Gera um veículo e atribui a um estacionamento específico
            
            int indiceEstacionamento = new Random().nextInt(estacionamentos.size()); // Escolhe um estacionamento aleatório
            AreaDeEstacionamento area = estacionamentos.get(indiceEstacionamento);
            Veiculo v = gerarVeiculo(indiceEstacionamento);
            // Adiciona o veículo ao estacionamento escolhido
            if (area.verificarPistaEntrada()) {
                mapa.adicionarItem(v);
                area.adicionarVeiculo(v);
            }

            // Executa um passo de simulação para cada estacionamento
            for (AreaDeEstacionamento estacionamento : estacionamentos) {
                Veiculo veiculoSaindo = estacionamento.executarPasso();
                if (veiculoSaindo != null) {
                    mapa.removerItem(veiculoSaindo);
                }

                // Exibe o estado atual de cada estacionamento
                estacionamento.verPistaEntrada();
                estacionamento.verEstacionamento();
                estacionamento.verPistaSaida();
            }

            esperar(1000); // Pausa a simulação por 1 segundo
        }
    }

    private static Veiculo gerarVeiculo(int indiceEstacionamento) {
        Veiculo novoVeiculo;
        Random gerador = new Random();
        int numero = gerador.nextInt(6);
        int posicaoX = 0;
        if(indiceEstacionamento == 0){
            posicaoX = 250;
        }
        else if (indiceEstacionamento == 1) {
            posicaoX = 500;
        }
        else if (indiceEstacionamento == 2) {
            posicaoX = 750;
        }
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