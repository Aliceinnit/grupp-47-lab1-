package grupp47_lab1;

public class TurboOffState implements SaabTurboState{
    @Override
    public void activateTurbo(Saab95 saab95) {
        System.out.println("Activating turbo...");
        saab95.setTurboState(new TurboOnState());
    }

    @Override
    public void deactivateTurbo(Saab95 saab95) {
        System.out.println("Turbo is already OFF!");
    }
}
