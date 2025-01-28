import java.util.Random;
import javax.swing.ImageIcon;

public class Caminhao extends Veiculo {

    public Caminhao(Localizacao posicao) {
        super(Veiculo.TAMANHO_CAMINHAO, posicao, null);
        selecionaCor(); 
    }

    @Override
    public void selecionaCor() {
        String[] cores = {"azul_marrom", "azul_preto", "branco_vermelho", "verde_branco", "vermelho"};
        String[] imagens = {
            "Imagens/caminhao_azul_marrom.png",
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

    @Override
    public String toString() {
        return "====================\nCaminhao\n" + super.toString();
    }
}