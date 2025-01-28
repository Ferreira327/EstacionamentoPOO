import java.util.*;

public class PistaEntrada {
    public static int tamanhoY = 300;
    //public static int tamanhoX = 60;
    Veiculo proximo;
    LinkedList<Veiculo> veiculos;

    public PistaEntrada() {
        veiculos = new LinkedList<>(); // Lista de Veículos
    }

    public Veiculo andarPista() {
        Veiculo retornar = null;
        Iterator<Veiculo> iterador = veiculos.descendingIterator(); // Iterator para modificar os veículos
        while (iterador.hasNext()) {
            Veiculo v = iterador.next();
            if (v != null && v.getPosicao() + v.getTamanho() >= tamanhoY) { // Verifica se v não é null
                retornar = v;
                iterador.remove();
            } else if (v != null) {
                v.andar(true);
            }
        }
        adicionarVeiculo();
        return retornar;
    }

    private void adicionarVeiculo() {
        if (proximo != null && (veiculos.isEmpty() || (proximo.getTamanho() + 10) < veiculos.getLast().getPosicao())) {
            veiculos.add(proximo);
            proximo = null;
        }
    }

    public void escolherProximo(Veiculo v) {
        this.proximo = v;
    }

    @Override
    public String toString() {
        Iterator<Veiculo> iterador = veiculos.descendingIterator();
        String palavra = "=Pista Entrada=\n";
        while (iterador.hasNext()) {
            Veiculo v = iterador.next();
            if (v != null) { // Verifica se v não é null
                palavra += v.toString();
            }
        }
        return palavra;
    }

    public boolean temProximo() {
        return proximo != null; // Retorna true se próximo não for null
    }
}