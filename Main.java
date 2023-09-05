import controller.TallerMecanicoController;
import model.TallerMecanicoModel;
import view.TallerMecanicoView;

public class Main {
    public static void main(String[] args) {
        TallerMecanicoModel modelo = new TallerMecanicoModel();
        TallerMecanicoView vista = new TallerMecanicoView();
        TallerMecanicoController controller = new TallerMecanicoController(modelo, vista);
        controller.iniciar();
    }
}
