public class Caminhao extends Veiculo{

    public Caminhao(Localizacao posicao) {
        super(100,posicao);
    }

    @Override
    public String toString(){
        return "====================\nCaminhao\n"+ super.toString();
    }
}
