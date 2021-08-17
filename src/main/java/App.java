import java.awt.EventQueue;
import view.VistaRequerimientosReto5;


public class App {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                try{
                    VistaRequerimientosReto5 frame = new VistaRequerimientosReto5();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}






/*
                    VistaRequerimientosReto5.requerimiento1(); frame = new VistaRequerimientosReto5();
                    VistaRequerimientosReto5.requerimiento3(); 
                    VistaRequerimientosReto5.requerimiento4();

*/
// Casos de prueba: Requerimientos 1, 3 y 4