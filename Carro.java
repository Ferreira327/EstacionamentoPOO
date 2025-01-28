import java.util.Random;
import javax.swing.ImageIcon;

public class Carro extends Veiculo {
    public Carro(Localizacao posicao) {
        super(Veiculo.TAMANHO_CARRO, posicao, null);
        selecionaCor();
    }

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

    @Override
    public String toString() {
        return "====================\nCarro\n" + super.toString();
    }
}