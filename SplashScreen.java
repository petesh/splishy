import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;

public class SplashScreen extends JWindow
{
    /**
     * Numéro de série
     */
    private static final long serialVersionUID = 1592663893301307318L;

    /**
     * Constructeur par initialisation
     * @param p_Frame Frame
     * @param p_TempsAffichage Temps d'affichage en millisecondes
     */
    public SplashScreen()
    {
        BufferedImage img = null;
        try {
            img = ImageIO.read(this.getClass().getResource("splash.png"));
        } catch (Exception ex) {
        }

        ImgPanel panel = new ImgPanel(img);
        Container container = this.getContentPane();
        container.add(panel);
        pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screenSize.width/2 - (img.getWidth()/2), screenSize.height/2 - (img.getHeight()/2));

        this.setVisible(true);
    }


    class ImgPanel extends JPanel {
        private BufferedImage img;

        public ImgPanel(BufferedImage img) {
            this.img = img;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(img.getWidth(), img.getHeight());
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, null);
        }
    }

}
