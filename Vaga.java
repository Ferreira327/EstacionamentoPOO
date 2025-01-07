public abstract class Vaga {
    private Veiculo v;
    private int tamanho; 
    private float preco;
    private int tempo; // Tempo que o carro pode ficar na vaga
    private int tempoAtual; // Tempo do carro na vaga
    private boolean disponivel; // Se a vaga está ocupada ou não
    public static final int TAMANHO_CAMINHAO = 100;
    public static final int TAMANHO_CARRO = 50;
    public static final int TAMANHO_MOTO = 25;

    public Vaga(int tamanho){
        tempo = 0;
        disponivel = true;
        this.tamanho = tamanho;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public int getTamanho(){
        return tamanho;
    }
    
    public Veiculo getVeiculo(){
        return v;
    }
    
    public void setVeiculo(Veiculo v,int tempo){
        if(isDisponivel()){
            disponivel = false;
            this.v = v;
            this.tempo = tempo;
            tempoAtual = 0;
        }
    }

    public boolean controlarVaga(){
        if(tempoAtual == -1)
            return true;
        tempoAtual += 1;
        if(tempoAtual < tempo){
            return true;
        }
        tempoAtual = -1;
        return false;
    }

    public Veiculo liberarVaga(){
        Veiculo ve = this.v;
        this.v = null;
        disponivel = true;
        tempo = 0;
        return ve;
    }

    @Override
    public String toString(){
        if(disponivel){
        return "Disponível: Sim\n\n";}
        else{
            if(tempoAtual == -1){
                return "Disponível: Não\nVeículo: " + v.getId()+ "\nTempo: Esperando saída\n\n";
            }
            return "Disponível: Não\nVeículo: " + v.getId()+ "\nTempo: "+ tempoAtual+"\n\n";
        } 
    }
    
    
}
