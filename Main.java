import javax.swing.*;

public class Main {

public static void main(String[] args)
{
    SplashScreen splSplashScreen = new SplashScreen();
    //Main window
    FenetrePrincipale fenetrePrincipale = new FenetrePrincipale();
    worker w = new worker(splSplashScreen, fenetrePrincipale);
    w.execute();
}

}

class worker extends SwingWorker<String, Object> {
    private final static long TEMP_AFFICHAGE = 4000;
    private SplashScreen splash;
    private FenetrePrincipale principale;

    public worker(SplashScreen splash, FenetrePrincipale principale) {
        this.splash = splash;
        this.principale = principale;
        this.splash.setVisible(true);
    }

    @Override
    public String doInBackground() {
        try
        {
            Thread.sleep(TEMP_AFFICHAGE);
        }
        catch (InterruptedException ex)
        {
            //ApplicationLogger.getInstance().severe(ex.getLocalizedMessage());
        }
        return "";
    }

    @Override
    protected void done() {
        splash.setVisible(false);
        principale.setVisible(true);
    }
};

class FenetrePrincipale extends JFrame {
}
