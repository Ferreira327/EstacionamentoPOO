import javax.swing.ImageIcon;


public class Caminhao extends Veiculo{

    public Caminhao(Localizacao posicao) {
        super(Veiculo.TAMANHO_CAMINHAO,posicao,new ImageIcon(Caminhao.class.getResource("Imagens/caminhao.png")).getImage());
    }

    @Override
    public String toString(){
        return "====================\nCaminhao\n"+ super.toString();
    }
}
