import java.util.*;


public class Estacionamento {
    private static int tamanhoX = 700;
    private static int tamanhoY = 400;
    private List<Vaga> vagas;
    Queue<Vaga> filaSair;

    public Estacionamento(int caminhao, int moto, int carro) throws RuntimeException{
        vagas = new ArrayList<>();
        filaSair = new LinkedList<>();
        if(caminhao*(Vaga.TAMANHO_ESPACO_VAGA+Veiculo.TAMANHO_CAMINHAO) + moto*(Vaga.TAMANHO_ESPACO_VAGA+Veiculo.TAMANHO_MOTO)+ carro*(Vaga.TAMANHO_ESPACO_VAGA+Veiculo.TAMANHO_CARRO) <= 700){
            for(int i = 0; i<carro; i++){
                vagas.add(new VagaCarro());
            }
            for(int i = 0; i<moto; i++){
                vagas.add(new VagaMoto());
            }
            for(int i = 0; i<caminhao; i++){
                vagas.add(new VagaCaminhao());
            }
        }
        else{
            throw new RuntimeException("Estacionamento não permite o número de vagas");
        }
    }

    public void entrarCarro(Veiculo ve){
        Random gerador = new Random();

        for(Vaga v: vagas){
            if(v.isDisponivel() && (ve.getTamanho() == (v.getTamanho()-Vaga.TAMANHO_ESPACO_VAGA))){
                ve.setPosicao(300);
                v.setVeiculo(ve,gerador.nextInt(3)+12);
                return ;
            }
        }
    }

    public void controlarEstacionamento(){
        for(Vaga v: vagas){
            if(!v.isDisponivel()){
                if(!v.controlarVaga()){
                    filaSair.add(v);
                }
            }
        }
    }

    public Veiculo liberarCarro(){
        Vaga liberar = filaSair.poll();
        return liberar.liberarVaga();
    }

    public int tamanhoProximoVeiculoSair(){
        return filaSair.peek().getTamanho();
    }
    
    public boolean verificarFilaSaida(){
        return !filaSair.isEmpty();
    }



    @Override
    public String toString(){
        String retornar = "=Estacionamento=\n";
        for(Vaga v : vagas){
            retornar += v.toString();
        }
        return retornar;
    }
    


    
    

    
    
}
