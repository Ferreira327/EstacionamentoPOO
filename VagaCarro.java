public class VagaCarro extends Vaga{

    public VagaCarro(){
        super(Veiculo.TAMANHO_CARRO);
    }

    @Override
    public String toString(){
        return "Vaga de Carro\n" + super.toString();
    }
    
}
