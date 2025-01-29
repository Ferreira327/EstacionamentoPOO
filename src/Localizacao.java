/**
 * Representa uma localização no mapa com coordenadas X e Y.
 * 
 * A localização pode ser ajustada ou consultada para determinar a posição de objetos no mapa.
 */
public class Localizacao {
    private int x; 
    private int y;

    /**
     * Construtor da classe Localizacao.
     * 
     * Inicializa as coordenadas X e Y com os valores fornecidos.
     * 
     * @param x a coordenada X inicial.
     * @param y a coordenada Y inicial.
     */
    public Localizacao(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Retorna a coordenada X.
     * 
     * @return o valor da coordenada X.
     */
    public int getX() {
        return x;
    }

    /**
     * Define um novo valor para a coordenada X.
     * 
     * @param x o novo valor da coordenada X.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Retorna a coordenada Y.
     * 
     * @return o valor da coordenada Y.
     */
    public int getY() {
        return y;
    }

    /**
     * Move a coordenada Y de acordo com o deslocamento fornecido.
     * 
     * @param deslocamento o valor a ser adicionado à coordenada Y.
     */
    public void moverY(int deslocamento) {
        this.y += deslocamento;
    }
}