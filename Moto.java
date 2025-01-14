public class Moto extends Veiculo{

    public Moto(Localizacao posicao){
        super(25,posicao);
    }

    @Override
    public String toString(){
        return "====================\nMoto\n"+ super.toString();
    }

}
