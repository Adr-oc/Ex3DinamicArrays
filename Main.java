import controller.TallerMecanicoController;
import model.TallerMecanicoModel;
import view.TallerMecanicoView;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        TallerMecanicoModel modelo = new TallerMecanicoModel();
        TallerMecanicoView vista = new TallerMecanicoView();
        TallerMecanicoController controller = new TallerMecanicoController(modelo, vista);
        controller.iniciar();
    }
}
