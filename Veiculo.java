public abstract class Veiculo{
    public final static int TAMANHO_CARRO = 50;
    public final static int TAMANHO_MOTO = 25;
    public final static int TAMANHO_CAMINHAO = 100;
    private static int valorId = 0;
    private final int tamanho;
    private int posicao;
    private final int id;

    public Veiculo(int tamanho, int posicao){
        this.id = ++valorId;
        this.tamanho = tamanho;
        this.posicao = posicao;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
    

    public void andar(boolean sentido){
        if(sentido){
            posicao += 40;
            if(posicao > PistaEntrada.tamanhoY){
                posicao = PistaEntrada.tamanhoY;
            }
        }
        else{
            posicao -= 20;
            if(posicao<0){
                posicao = 0;
            }
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return "Posicao: " + posicao + "\n====================\n";
    }

    
}