import java.awt.Image;
import java.util.*;


public class Estacionamento {
    private static final int TAMANHO_ESTACIONAMENTO = 257;
    private static int quantidade = 0;
    private Localizacao localizacao;
    private int posicao;
    private List<Vaga> vagas;
    private Image imagem;
    Queue<Veiculo> filaSair;

    public Estacionamento(int caminhao, int moto, int carro, Image imagem) throws RuntimeException{
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
        this.imagem = imagem;
        quantidade++;
        posicao = 250*quantidade;
        localizacao = new Localizacao(posicao-AreaDeEstacionamento.ESPACO_ESTACIONAMENTO, TAMANHO_ESTACIONAMENTO);
    }

    public Image getImagem(){
        return imagem;
    }

    public Localizacao getLocalizacaoAtual(){
        return localizacao;
    }

    public int getTamanho() {
        return 200;
    }

    public void entrarCarro(Veiculo ve){
        Random gerador = new Random();

        for(Vaga v: vagas){
            if(v.isDisponivel() && (ve.getTamanho() == (v.getTamanho()-Vaga.TAMANHO_ESPACO_VAGA))){
                ve.setPosicao(new Localizacao(posicao+AreaDeEstacionamento.ESPACO_PISTA, 300));
                v.setVeiculo(ve,gerador.nextInt(3)+12);
                return ;
            }
        }

        ve.setPosicao(new Localizacao(posicao+AreaDeEstacionamento.ESPACO_PISTA,300));
        filaSair.add(ve);


    }

    public void controlarEstacionamento(){
        for(Vaga v: vagas){
            if(!v.isDisponivel()){
                if(!v.controlarVaga()){
                    filaSair.add(v.getVeiculo());
                }
            }
        }
    }

    public Veiculo liberarCarro(){
        Veiculo liberar = filaSair.poll();
        for(Vaga v: vagas){
            if(v.getVeiculo() == liberar){
                v.liberarVaga();
            }
        }
        return liberar;
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
