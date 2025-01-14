import java.awt.*;
import javax.swing.*;

/**
 * Fornece a visualização da simulação.
 */
public class JanelaSimulacao extends JFrame {
    private Mapa mapa;
    private VisaoMapa visaoMapa;
    
    public JanelaSimulacao(Mapa mapa) {
        this.mapa = mapa;
        visaoMapa = new VisaoMapa();
        getContentPane().add(visaoMapa);
        setTitle("Simulador");
        setSize(1000, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    /**
     * Mostra o estado atual do mapa.
     */
    public void executarAcao() {
        visaoMapa.preparePaint();
        for (Veiculo veiculo : mapa.getVeiculos()) {
            Localizacao localizacao = veiculo.getLocalizacaoAtual();
            // Ajusta a escala do desenho, com base nas coordenadas do veículo.
            visaoMapa.desenharImagem(localizacao.getX(), localizacao.getY(), veiculo.getImagem());
        }
        visaoMapa.repaint();
    }

    /**
     * Fornece uma visualização gráfica do mapa.
     */
    private class VisaoMapa extends JPanel {
        
        private int xScale, yScale;
        private Dimension tamanho;
        private Graphics g;
        private Image imagemMapa;

        /**
         * Cria um novo componente VisaoMapa.
         */
        public VisaoMapa() {
            setBackground(Color.white);
            tamanho = new Dimension(0, 0);
        }

        /**
         * Informa ao gerenciador GUI o tamanho preferido.
         */
        public Dimension getPreferredSize() {
            return new Dimension(1000, 500);  // Tamanho fixo para o mapa, pode ser ajustado conforme necessário
        }
        
        /**
         * Prepara para um novo ciclo de exibição.
         */
        public void preparePaint() {
            if (!tamanho.equals(getSize())) {  // Se o tamanho mudou...
                tamanho = getSize();
                imagemMapa = createImage(tamanho.width, tamanho.height);
                g = imagemMapa.getGraphics();

                // Calcula o fator de escala com base no tamanho da janela
                xScale = 1;
                yScale = 1;
            }
            g.setColor(Color.white);
            g.fillRect(0, 0, tamanho.width, tamanho.height);
        }
        
        /**
         * Desenha a imagem para um determinado item.
         */
        public void desenharImagem(int x, int y, Image image) {
            // Desenha a imagem com base nas coordenadas absolutas (x, y)
            g.drawImage(image, x * xScale, y * yScale, 30, 30, this);
        }

        /**
         * O componente VisaoMapa precisa ser reexibido. Copia a
         * imagem interna para a tela.
         */
        public void paintComponent(Graphics g) {
            if (imagemMapa != null) {
                g.drawImage(imagemMapa, 0, 0, null);
            }
        }
    }
}
