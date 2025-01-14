import javax.swing.ImageIcon;

public class Carro extends Veiculo{
    public Carro(Localizacao posicao){
        super(Veiculo.TAMANHO_CARRO,posicao,new ImageIcon(Carro.class.getResource("Imagens/veiculo.png")).getImage());
        
        
    }

    @Override
    public String toString(){
        return "====================\nCarro\n"+ super.toString();
    }
}
