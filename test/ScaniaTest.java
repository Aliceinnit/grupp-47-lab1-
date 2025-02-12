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
        scania.lowerPlatform();
        double speedBefore = scania.getCurrentSpeed();
        scania.gas(1);
        assertEquals(speedBefore, scania.getCurrentSpeed()); //Tests the gas function when flatbed angle != 0
    }

    @Test
    void testFlatbed() {
        scania.lowerPlatform();
        assertTrue(scania.getCurrentAngle() > 0, "Platform is not lowered");

        double angleBefore = scania.getCurrentAngle();
        scania.raisePlatform();
        scania.raisePlatform();

        assertTrue(scania.getCurrentAngle()< angleBefore, "Platform is not raised.");

        scania.startEngine();
        scania.lowerPlatform();
        assertEquals(0,scania.getCurrentAngle(), "Platform is lowered even while in motion.");
    }
}
