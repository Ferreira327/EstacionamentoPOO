/**
 * Classe que representa uma vaga específica para caminhões.
 * 
 * Esta classe é uma especialização da classe {@link Vaga}, utilizando o tamanho específico
 * de um caminhão definido em {@link Veiculo#TAMANHO_CAMINHAO}.
 */
public class VagaCaminhao extends Vaga {

    /**
     * Construtor da classe VagaCaminhao.
     * Inicializa a vaga com o tamanho padrão para caminhões, utilizando 
     * {@link Veiculo#TAMANHO_CAMINHAO}.
     */
    public VagaCaminhao() {
        super(Veiculo.TAMANHO_CAMINHAO);
    }

    /**
     * Retorna uma representação textual da vaga para caminhões.
     * Inclui uma descrição específica para diferenciar de outros tipos de vagas.
     * 
     * @return uma string com informações sobre a vaga de caminhão.
     */
    @Override
    public String toString() {
        return "Vaga de Caminhão\n" + super.toString();
    }
}