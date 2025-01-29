/**
 * Classe que representa uma vaga específica para carros.
 * 
 * Esta classe é uma especialização da classe {@link Vaga}, utilizando o tamanho específico
 * de um carro definido em {@link Veiculo#TAMANHO_CARRO}.
 */
public class VagaCarro extends Vaga {

    /**
     * Construtor da classe VagaCarro.
     * Inicializa a vaga com o tamanho padrão para carros, utilizando 
     * {@link Veiculo#TAMANHO_CARRO}.
     */
    public VagaCarro() {
        super(Veiculo.TAMANHO_CARRO);
    }

    /**
     * Retorna uma representação textual da vaga para carros.
     * Inclui uma descrição específica para diferenciar de outros tipos de vagas.
     * 
     * @return uma string com informações sobre a vaga de carro.
     */
    @Override
    public String toString() {
        return "Vaga de Carro\n" + super.toString();
    }
}