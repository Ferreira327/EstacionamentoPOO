import javax.swing.ImageIcon;

public class Moto extends Veiculo{

    public Moto(Localizacao posicao){
        super(Veiculo.TAMANHO_MOTO,posicao,new ImageIcon(Caminhao.class.getResource("Imagens/moto.png")).getImage());
    }

    @Override
    public String toString(){
        return "====================\nMoto\n"+ super.toString();
    }

}
