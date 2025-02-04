package grupp47_lab1.test;

import grupp47_lab1.Saab95;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {
    private Saab95 saab;
    @BeforeEach
    void setup(){
        saab = new Saab95(); //Creats new instance before each test.
    }


    @Test
    void setTurboOn() {
        saab.setTurboOn();
        assertTrue(saab.isTurboOn(), "Turbo should be on.");
    }

    @Test
    void setTurboOff() {
        saab.setTurboOn();
        saab.setTurboOff();
        assertFalse(saab.isTurboOn(),"Turbo should be off.");
    }

/*  @Test
    void incrementSpeed() {
        double startSpeed = saab.getCurrentSpeed();
        saab.incrementSpeed(1);
        assertTrue(saab.getCurrentSpeed() > startSpeed, "Speed should increase.");
    }

    @Test
    void decrementSpeed() {
        saab.incrementSpeed(1);
        double startSpeed = saab.getCurrentSpeed();
        saab.decrementSpeed(1);
        assertTrue(saab.getCurrentSpeed() < startSpeed, "Speed should decrease.");
    } */

}
