public class VagaMoto extends Vaga{

    public VagaMoto(){
        super(Veiculo.TAMANHO_MOTO);
    }
    

    @Override
    public String toString(){
        return "Vaga de Moto\n" + super.toString();
    }
}
