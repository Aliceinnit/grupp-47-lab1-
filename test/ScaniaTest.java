package grupp47_lab1.test;

import grupp47_lab1.Scania;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class ScaniaTest {
    @BeforeEach
    void setUp() {
        scania = new Scania();
    }

    private Scania scania;
    @Test
    void testGas() {
        scania.raiseFlatbed();
        double speedBefore = scania.getCurrentSpeed();
        scania.gas(1);
        assertEquals(speedBefore, scania.getCurrentSpeed()); //Tests the gas function when flatbed angle != 0
    }

    @Test
    void testFlatbed() {
        scania.raiseFlatbed();
        assertTrue(scania.getCurrentAngle() > 0, "Flatbed is not raised");

        double angleBefore = scania.getCurrentAngle();
        scania.lowerFlatbed();
        scania.lowerFlatbed();

        assertTrue(scania.getCurrentAngle()< angleBefore, "Flatbed is not lowered.");

        scania.startEngine();
        scania.raiseFlatbed();
        assertEquals(0,scania.getCurrentAngle(), "Flatbed is raised even while in motion.");
    }
}
