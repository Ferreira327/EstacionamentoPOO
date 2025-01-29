/**
 * Interface que representa uma pista genérica.
 * 
 * Define o comportamento básico que qualquer pista deve implementar,
 * como adicionar veículos à pista.
 */
public interface Pista {

    /**
     * Adiciona um veículo à pista.
     * 
     * @param e o veículo a ser adicionado.
     */
    void adicionarVeiculo(Veiculo e);
}