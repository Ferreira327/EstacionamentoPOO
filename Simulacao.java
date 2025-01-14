import java.util.Random;

public class Simulacao {
    public static void main(String[] args) {
        AreaDeEstacionamento area = new AreaDeEstacionamento(2,3,2);
        Mapa mapa = new Mapa();
        JanelaSimulacao janelaSimulacao = new JanelaSimulacao(mapa);
        for(int i = 0; i<15; i++){
            janelaSimulacao.executarAcao();
            if(area.verificarPistaEntrada()){
                Veiculo v = gerarVeiculo();
                mapa.adicionarItem(v);
                area.adicionarVeiculo(v);
            }
            area.executarPasso();
            area.verPistaEntrada();
            area.verEstacionamento();
            area.verPistaSaida();
            esperar(1000);
        }
    }

    private static Veiculo gerarVeiculo(){

        Veiculo novoVeiculo;
        Random gerador = new Random();
        int numero = gerador.nextInt(6);

        switch (numero) {
            case 0,1,2:
                novoVeiculo = new Carro(new Localizacao(10,0));
                break;
            case 3,4:
                novoVeiculo = new Moto(new Localizacao(10,0));
                break;
            case 5:
                novoVeiculo = new Caminhao(new Localizacao(10,0));
                break;
            default:
                throw new AssertionError();
        }


        return novoVeiculo;
    }

    private static void esperar(int milisegundos){
        try{
            Thread.sleep(milisegundos);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
    
}
