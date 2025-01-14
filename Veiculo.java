import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Veiculo{
    public final static int TAMANHO_CARRO = 50;
    public final static int TAMANHO_MOTO = 25;
    public final static int TAMANHO_CAMINHAO = 100;
    private static int valorId = 0;
    private final int tamanho;
    private Localizacao localizacao;
    private final int id;
    private Image imagem;

    public Veiculo(int tamanho, Localizacao posicao){
        this.id = ++valorId;
        this.tamanho = tamanho;
        this.localizacao = posicao;
        imagem = new ImageIcon(getClass().getResource("Imagens/veiculo.png")).getImage();
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getPosicao() {
        return localizacao.getY();
    }

    public Localizacao getLocalizacaoAtual(){
        return localizacao;
    }

    public void setPosicao(Localizacao posicao) {
        this.localizacao = posicao;
    }
    
    public Image getImagem(){
        return imagem;
    }

    public void andar(boolean sentido){
        if(sentido){
            localizacao.moverY(20);;
            if(localizacao.getY() > PistaEntrada.tamanhoY){
                localizacao.moverY(PistaEntrada.tamanhoY);
            }
        }
        else{
            localizacao.moverY(-20);
            if(localizacao.getY() < 0){
                localizacao.moverY(localizacao.getY()-localizacao.getY());
            }
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return "Posicao: " + localizacao.getY() + "\n====================\n";
    }

    

    
}