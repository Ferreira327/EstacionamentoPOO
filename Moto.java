public class Moto extends Veiculo{

    public Moto(int posicao){
        super(25,posicao);
    }

    @Override
    public String toString(){
        return "====================\nMoto\n"+ super.toString();
    }

}
