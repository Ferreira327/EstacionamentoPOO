import java.util.Random;
import javax.swing.ImageIcon;

/**
 * Classe que representa um Caminhão, estendendo a classe Veiculo.
 * O Caminhão possui uma cor e imagem associada, que são selecionadas aleatoriamente.
 */
public class Caminhao extends Veiculo {

    /**
     * Constrói um novo Caminhão com uma posição especificada.
     * A cor e imagem do caminhão são definidas ao ser instanciado.
     *
     * @param posicao Posição inicial do veículo.
     */
    public Caminhao(Localizacao posicao) {
        super(Veiculo.TAMANHO_CAMINHAO, posicao, null);
        selecionaCor(); 
    }

    /**
     * Seleciona aleatoriamente uma cor e imagem associada ao caminhão.
     * As cores disponíveis são: azul e preto, branco e vermelho, verde e branco, e vermelho.
     * A imagem correspondente à cor selecionada é carregada e associada ao caminhão.
     */
    @Override
    public void selecionaCor() {
        String[] cores = {"azul_preto", "branco_vermelho", "verde_branco", "vermelho"};
        String[] imagens = {
            "Imagens/caminhao_azul_preto.png",
            "Imagens/caminhao_branco_vermelho.png",
            "Imagens/caminhao_verde_branco.png",
            "Imagens/caminhao_vermelho.png"
        };

        int indiceCor = new Random().nextInt(cores.length);
        String corSelecionada = cores[indiceCor];
        ImageIcon imagemSelecionada = new ImageIcon(Caminhao.class.getResource(imagens[indiceCor]));

        setCor(corSelecionada, imagemSelecionada.getImage());
    }

    /**
     * Retorna uma representação textual do Caminhão, incluindo suas características herdadas de Veiculo.
     *
     * @return String representando o Caminhão.
     */
    @Override
    public String toString() {
        return "====================\nCaminhao\n" + super.toString();
    }

    /**
     * Realiza uma ação específica para o Caminhão. No caso, ele buzinou.
     *
     * @return Ação realizada pelo caminhão ("Caminhao Buzinou").
     */
    @Override
    public String acao() {
        return "Caminhao Buzinou";
    }
}