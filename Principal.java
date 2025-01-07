public class Principal {
    public static void main(String[] args) {
        PistaEntrada pista = new PistaEntrada();
        PistaSaida pistaSaida = new PistaSaida();
        Estacionamento estacionamento = new Estacionamento(2, 3, 2);

        for(int i = 0; i<130;i++){
            System.out.println(pista);
            System.out.println(estacionamento);
            System.out.println(pistaSaida);
            Veiculo saida = pista.andarPista();
            if(saida != null){
                estacionamento.entrarCarro(saida);
            }
            estacionamento.controlarEstacionamento();
            if(estacionamento.verificarFilaSaida()){
                if(pistaSaida.verificarSaida(estacionamento.tamanhoProximoVeiculoSair())){
                    pistaSaida.adicionarVeiculo(estacionamento.liberarCarro());
                }
            }
            pistaSaida.andarPista();
        }
    }
    
}
