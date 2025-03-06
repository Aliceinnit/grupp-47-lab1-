package grupp47_lab1;

public class TurboOnState implements SaabTurboState{
    @Override
    public void activateTurbo(Saab95 saab95) {
        System.out.println("Turbo is already ON!");
    }

    @Override
    public void deactivateTurbo(Saab95 saab95) {
        System.out.println("Deactiviting turbo...");
        saab95.setTurboState(new TurboOffState());
    }
}
