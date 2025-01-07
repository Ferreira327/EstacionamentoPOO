public class Simulacao {
    public static void main(String[] args) {
        AreaDeEstacionamento area = new AreaDeEstacionamento(2,3,2);

        for(int i = 0; i<15; i++){
            area.executarPasso();
            area.verPistaEntrada();
            area.verEstacionamento();
            area.verPistaSaida();
        }
    }
    
}
