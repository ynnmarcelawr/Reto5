import java.awt.*;

import view.VistaRequerimientosReto4;

/**
 * Persistencia Proyectos Construcción
 *
 */
public class App {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {

                try {
                    VistaRequerimientosReto4 Frame = new VistaRequerimientosReto4();
                    Frame.setVisible(true);
                } catch (Exception e) {
                    //TODO: handle exception
                    e.printStackTrace();
                }
            }
            
        });

    }
}