package grupp47_lab1;

public class App {
    public static void main(String[] args) {
        CarModel model = new CarModel();
        CarController controller = new CarController(model);
        CarView view = new CarView("CarSim 1.0", model);

        controller.setView(view);
        controller.startTimer(); // Starta spelets uppdateringsloop
    }
}
