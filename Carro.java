public class Carro extends Veiculo{
    public Carro(Localizacao posicao){
        super(50,posicao);
    }

    @Override
    public String toString(){
        return "====================\nCarro\n"+ super.toString();
    }
}
