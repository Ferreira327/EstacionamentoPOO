import java.util.Random;
import javax.swing.ImageIcon;

/**
 * Classe que representa uma moto, um tipo específico de veículo.
 * 
 * A classe define características e comportamentos específicos para motos,
 * como a seleção aleatória de cor e imagem, além de uma ação única para a moto.
 */
public class Moto extends Veiculo {

    /**
     * Construtor da classe Moto.
     * 
     * Inicializa a moto com seu tamanho padrão e posição inicial, além de
     * configurar uma cor e imagem aleatória para a moto.
     * 
     * @param posicao a posição inicial da moto.
     */
    public Moto(Localizacao posicao) {
        super(Veiculo.TAMANHO_MOTO, posicao, null); // Inicialmente, a imagem é null
        selecionaCor(); // Define a cor e a imagem da moto
    }

    /**
     * Define uma cor e imagem aleatória para a moto.
     * 
     * As cores e imagens possíveis são pré-definidas em arrays.
     */
    @Override
    public void selecionaCor() {
        String[] cores = {"branca", "branca_azul", "vermelha"};
        String[] imagens = {
            "Imagens/moto_branca.png",
            "Imagens/moto_branca_azul.png",
            "Imagens/moto_vermelha.png"
        };

        int indiceCor = new Random().nextInt(cores.length);
        String corSelecionada = cores[indiceCor];
        ImageIcon imagemSelecionada = new ImageIcon(Moto.class.getResource(imagens[indiceCor]));

        setCor(corSelecionada, imagemSelecionada.getImage());
    }

    /**
     * Retorna uma representação textual da moto.
     * 
     * Inclui informações específicas da moto e dados herdados do veículo.
     * 
     * @return uma string que descreve a moto.
     */
    @Override
    public String toString() {
        return "====================\nMoto\n" + super.toString();
    }

    /**
     * Retorna uma ação específica realizada pela moto.
     * 
     * @return uma string que descreve a ação da moto.
     */
    @Override
    public String acao() {
        return "Moto Empinou";
    }
}