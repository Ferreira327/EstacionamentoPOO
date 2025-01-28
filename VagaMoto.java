/**
 * Classe que representa uma vaga específica para motos.
 * 
 * Esta classe é uma especialização da classe {@link Vaga}, utilizando o tamanho específico
 * de uma moto definido em {@link Veiculo#TAMANHO_MOTO}.
 */
public class VagaMoto extends Vaga {

    /**
     * Construtor da classe VagaMoto.
     * Inicializa a vaga com o tamanho padrão para motos, utilizando 
     * {@link Veiculo#TAMANHO_MOTO}.
     */
    public VagaMoto() {
        super(Veiculo.TAMANHO_MOTO);
    }

    /**
     * Retorna uma representação textual da vaga para motos.
     * Inclui uma descrição específica para diferenciar de outros tipos de vagas.
     * 
     * @return uma string com informações sobre a vaga de moto.
     */
    @Override
    public String toString() {
        return "Vaga de Moto\n" + super.toString();
    }
}