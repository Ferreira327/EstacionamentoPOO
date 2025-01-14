public class AreaDeEstacionamento{

    private PistaEntrada pistaEntrada;
    private PistaSaida pistaSaida;
    private Estacionamento estacionamento;


    public AreaDeEstacionamento(int qtdVagasCaminhao, int qtdVagasMoto, int qtdVagasCarro){
        pistaEntrada = new PistaEntrada();
        pistaSaida = new PistaSaida();
        estacionamento = new Estacionamento(qtdVagasCaminhao, qtdVagasMoto, qtdVagasCarro);
    }

    public void verPistaEntrada(){
        System.out.println(pistaEntrada);
    }

    public void verPistaSaida(){
        System.out.println(pistaSaida);
    }

    public void verEstacionamento(){
        System.out.println(estacionamento);
    }

    public Veiculo executarPasso(){
        Veiculo saida = pistaEntrada.andarPista();
            if(saida != null){
                estacionamento.entrarCarro(saida);
            }
            estacionamento.controlarEstacionamento();
            if(estacionamento.verificarFilaSaida()){
                if(pistaSaida.verificarSaida(estacionamento.tamanhoProximoVeiculoSair())){
                    pistaSaida.adicionarVeiculo(estacionamento.liberarCarro());
                }
            }
            saida = pistaSaida.andarPista();
            if(saida != null){
                return saida;
            }
            return null;
    }

    public boolean verificarPistaEntrada(){
        if(pistaEntrada.temProximo()){
            return false;
        }
        return true;
    }

    public void adicionarVeiculo(Veiculo v){
        pistaEntrada.escolherProximo(v);
    }
    
}
