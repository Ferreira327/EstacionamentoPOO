import java.util.Random;
import javax.swing.ImageIcon;

public class Moto extends Veiculo {

    public Moto(Localizacao posicao) {
        super(Veiculo.TAMANHO_MOTO, posicao, null); // Inicialmente, a imagem é null
        selecionaCor(); // Define a cor e a imagem da moto
    }

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

    @Override
    public String toString() {
        return "====================\nMoto\n" + super.toString();
    }

    @Override
    public String acao() {
        return "Moto Empinou";
    }
}