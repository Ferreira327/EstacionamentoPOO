import java.awt.Image;

/**
 * Classe abstrata que representa um veículo genérico.
 * Define os atributos e métodos básicos para veículos, como tamanho, localização,
 * imagem, cor e comportamento abstrato para ações específicas.
 * 
 * Relacionamentos:
 * - Utiliza a classe {@link Localizacao} para controlar a posição do veículo.
 * - Interage com {@link PistaEntrada} para controlar os limites de movimentação.
 * 
 * Constantes:
 * - {@link #TAMANHO_CARRO}, {@link #TAMANHO_MOTO}, {@link #TAMANHO_CAMINHAO} 
 *   representam os tamanhos padrão para diferentes tipos de veículos.
 * 
 * @author Gabriel Ferreira
 */
public abstract class Veiculo {
    public final static int TAMANHO_CARRO = 30;
    public final static int TAMANHO_MOTO = 20;
    public final static int TAMANHO_CAMINHAO = 80; 
    private static int valorId = 0;
    private final int tamanho; 
    private Localizacao localizacao; 
    private final int id;
    private Image imagem; 
    private String cor; 
    /**
     * Construtor da classe Veiculo.
     * Inicializa os atributos principais de um veículo, incluindo tamanho, localização e imagem.
     * 
     * @param tamanho o tamanho do veículo.
     * @param posicao a localização inicial do veículo.
     * @param imagem a imagem representativa do veículo.
     */
    public Veiculo(int tamanho, Localizacao posicao, Image imagem) {
        this.id = ++valorId;
        this.tamanho = tamanho;
        this.localizacao = posicao;
        this.imagem = imagem;
    }

    /**
     * Define a cor e atualiza a imagem do veículo.
     * 
     * @param cor a nova cor do veículo.
     * @param imagem a nova imagem do veículo.
     */
    public void setCor(String cor, Image imagem) {
        this.cor = cor;
        this.imagem = imagem;
    }

    /**
     * Método abstrato que deve ser implementado para definir como a cor é selecionada.
     */
    public abstract void selecionaCor();

    /**
     * Retorna o tamanho do veículo.
     * 
     * @return o tamanho do veículo.
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * Retorna a posição atual do veículo no eixo Y.
     * 
     * @return a posição no eixo Y.
     */
    public int getPosicao() {
        return localizacao.getY();
    }

    /**
     * Retorna a localização atual do veículo.
     * 
     * @return a localização do veículo.
     */
    public Localizacao getLocalizacaoAtual() {
        return localizacao;
    }

    /**
     * Atualiza a localização do veículo.
     * 
     * @param posicao a nova posição do veículo.
     */
    public void setPosicao(Localizacao posicao) {
        this.localizacao = posicao;
    }

    /**
     * Retorna a imagem representativa do veículo.
     * 
     * @return a imagem do veículo.
     */
    public Image getImagem() {
        return imagem;
    }

    /**
     * Move o veículo em determinado sentido no eixo Y.
     * Se o sentido for positivo, o veículo se move para frente; caso contrário, para trás.
     * Respeita os limites definidos em {@link PistaEntrada}.
     * 
     * @param sentido o sentido do movimento, {@code true} para frente e {@code false} para trás.
     */
    public void andar(boolean sentido) {
        if (sentido) {
            localizacao.moverY(20);
            if (localizacao.getY() > PistaEntrada.tamanhoY) {
                localizacao.moverY(PistaEntrada.tamanhoY);
            }
        } else {
            localizacao.moverY(-20);
            if (localizacao.getY() < 0) {
                localizacao.moverY(localizacao.getY() - localizacao.getY());
            }
        }
    }

    /**
     * Retorna o ID único do veículo.
     * 
     * @return o ID do veículo.
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna uma representação textual do veículo, incluindo sua posição no eixo Y.
     * 
     * @return uma string com informações sobre o veículo.
     */
    @Override
    public String toString() {
        return "Posição: " + localizacao.getY() + "\n====================\n";
    }

    /**
     * Método abstrato que define uma ação específica para o veículo.
     * 
     * @return uma string que descreve a ação realizada.
     */
    public abstract String acao();
}