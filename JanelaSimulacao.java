import java.awt.*;
import javax.swing.*;

/**
 * Representa a janela principal da simulação, que exibe o estado do mapa e os elementos gráficos.
 */
public class JanelaSimulacao extends JFrame {
    private Mapa mapa; 
    private VisaoMapa visaoMapa;

    /**
     * Construtor da classe JanelaSimulacao.
     * 
     * Inicializa a janela principal e configura a interface gráfica.
     * 
     * @param mapa o mapa que será exibido na janela.
     */
    public JanelaSimulacao(Mapa mapa) {
        this.mapa = mapa;
        visaoMapa = new VisaoMapa();
        getContentPane().add(visaoMapa);
        setTitle("Simulador");
        setSize(1000, 700);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    /**
     * Atualiza a exibição gráfica com o estado atual do mapa.
     * 
     * Exibe os veículos e estacionamentos no mapa, além de suas atualizações.
     */
    public void executarAcao() {
        visaoMapa.preparePaint();
        
        for (Estacionamento estacionamento : mapa.getEstacionamento()) {
            String atualizacao = estacionamento.verAtualizacao();
            Localizacao localizacao = estacionamento.getLocalizacaoAtual();
            if (atualizacao == null) {
                atualizacao = "Sem atualização";
            }
            visaoMapa.escrever(atualizacao, estacionamento.getPosicao());
            visaoMapa.desenharImagem(localizacao.getX(), localizacao.getY(), 
                                      estacionamento.getImagem(), estacionamento.getTamanho(), 200);
        }

        for (Veiculo veiculo : mapa.getVeiculos()) {
            Localizacao localizacao = veiculo.getLocalizacaoAtual();
            visaoMapa.desenharImagem(localizacao.getX(), localizacao.getY(), 
                                      veiculo.getImagem(), veiculo.getTamanho(), 30);
        }

        visaoMapa.repaint();
    }

    /**
     * Classe interna responsável por renderizar graficamente o mapa e seus elementos.
     */
    private class VisaoMapa extends JPanel {
        
        private int xScale, yScale; 
        private Dimension tamanho; 
        private Graphics g; 
        private Image imagemMapa; 

        /**
         * Construtor da classe VisaoMapa.
         * 
         * Inicializa o painel com configurações padrão.
         */
        public VisaoMapa() {
            setBackground(Color.white);
            tamanho = new Dimension(0, 0);
        }

        /**
         * Retorna o tamanho preferido do painel.
         * 
         * @return as dimensões preferidas do painel.
         */
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(1000, 700); 
        }
        
        /**
         * Prepara o painel para um novo ciclo de renderização.
         * 
         * Inicializa o buffer de imagem e limpa o contexto gráfico.
         */
        public void preparePaint() {
            if (!tamanho.equals(getSize())) { 
                tamanho = getSize();
                imagemMapa = createImage(tamanho.width, tamanho.height);
                g = imagemMapa.getGraphics();
                xScale = 1;
                yScale = 1;
            }
            g.setColor(Color.white);
            g.fillRect(0, 0, tamanho.width, tamanho.height);
        }
        
        /**
         * Desenha uma imagem na posição especificada.
         * 
         * @param x a coordenada X onde a imagem será desenhada.
         * @param y a coordenada Y onde a imagem será desenhada.
         * @param image a imagem a ser desenhada.
         * @param tamanho a altura da imagem.
         * @param width a largura da imagem.
         */
        public void desenharImagem(int x, int y, Image image, int tamanho, int width) {
            if (y < AreaDeEstacionamento.POSICAO_ESTACIONADO) {
                g.drawImage(image, x * xScale, y * yScale, width, tamanho, this);
            }
        }

        /**
         * Renderiza o painel, exibindo a imagem armazenada no buffer.
         * 
         * @param g o contexto gráfico usado para desenhar.
         */
        @Override
        public void paintComponent(Graphics g) {
            if (imagemMapa != null) {
                g.drawImage(imagemMapa, 0, 0, null);
            }
        }

        /**
         * Escreve texto na tela.
         * 
         * @param escrever o texto a ser exibido.
         * @param width a posição X onde o texto será escrito.
         */
        public void escrever(String escrever, int width) {
            g.setFont(new Font("Arial", Font.PLAIN, 18));
            g.setColor(Color.BLUE);
            g.drawString("Ultima atualização:", width - 50, 500);
            g.setColor(Color.RED);
            g.drawString(escrever, width - 50, 520);
        }
    }
}