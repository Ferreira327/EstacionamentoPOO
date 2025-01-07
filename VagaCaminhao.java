public class VagaCaminhao extends Vaga{

    public VagaCaminhao(){
        super(TAMANHO_CAMINHAO);
    }

    @Override
    public String toString(){
        return "Vaga de Caminhão\n" + super.toString();
    }


}