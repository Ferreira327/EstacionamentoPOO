public class Localizacao {
    private int x;
    private int y; 

    public Localizacao(int xInicio, int tamanho, int y) {
        this.x = xInicio;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moverX(int deslocamento) {
        this.x += deslocamento;
    }
}
