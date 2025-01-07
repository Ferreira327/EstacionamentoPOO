public class Carro extends Veiculo{
    public Carro(int posicao){
        super(50,posicao);
    }

    @Override
    public String toString(){
        return "====================\nCarro\n"+ super.toString();
    }
}
