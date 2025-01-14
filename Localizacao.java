public class Localizacao {
    private int x;
    private int y; 

    public Localizacao(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void moverY(int deslocamento) {
        this.y += deslocamento;
    }
}
