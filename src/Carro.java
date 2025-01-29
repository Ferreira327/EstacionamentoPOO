import java.util.Random;
import javax.swing.ImageIcon;

/**
 * Classe que representa um Carro, estendendo a classe Veiculo.
 * O Carro possui uma cor e imagem associada, que são selecionadas aleatoriamente.
 */
public class Carro extends Veiculo {

    /**
     * Constrói um novo Carro com uma posição especificada.
     * A cor e imagem do carro são definidas ao ser instanciado.
     *
     * @param posicao Posição inicial do veículo.
     */
    public Carro(Localizacao posicao) {
        super(Veiculo.TAMANHO_CARRO, posicao, null);
        selecionaCor();
    }

    /**
     * Seleciona aleatoriamente uma cor e imagem associada ao carro.
     * As cores disponíveis são preto, azul e verde.
     * A imagem correspondente é carregada e associada ao carro.
     */
    public void selecionaCor() {
        String[] cores = {"preto", "azul", "verde"};
        String[] imagens = {
            "Imagens/carro_preto.png",
            "Imagens/carro_azul.png",
            "Imagens/carro_verde.png"
        };

        int indiceCor = new Random().nextInt(cores.length);
        String corSelecionada = cores[indiceCor];
        ImageIcon imagemSelecionada = new ImageIcon(Carro.class.getResource(imagens[indiceCor]));

        setCor(corSelecionada, imagemSelecionada.getImage());
    }

    /**
     * Retorna uma representação textual do Carro, incluindo suas características herdadas de Veiculo.
     *
     * @return String representando o Carro.
     */
    @Override
    public String toString() {
        return "====================\nCarro\n" + super.toString();
    }

    /**
     * Realiza uma ação específica para o Carro. No caso, ele pisca o farol.
     *
     * @return Ação realizada pelo carro ("Carro Piscou Farol").
     */
    @Override
    public String acao() {
        return "Carro Piscou Farol";
    }
}