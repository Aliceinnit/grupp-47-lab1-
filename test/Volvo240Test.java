package grupp47_lab1.test;
import grupp47_lab1.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {
    Volvo240 volvo;

    @BeforeEach
    void setUp() {
        volvo = new Volvo240();
        volvo.startEngine();
    }

    @Test
    void testGas() {
        double speedBefore = volvo.getCurrentSpeed();
        volvo.gas(1);
        assertTrue(volvo.getCurrentSpeed() >= speedBefore);

        speedBefore = volvo.getCurrentSpeed();
        volvo.gas(-1);
        assertEquals(volvo.getCurrentSpeed(), speedBefore);

        volvo.gas(2);
        assertEquals(volvo.getCurrentSpeed(), speedBefore);

        while (volvo.getCurrentSpeed() < volvo.getEnginePower()) {
            volvo.gas(1);
        }
        speedBefore = volvo.getCurrentSpeed();
        volvo.gas(0.34);
        assertEquals(volvo.getCurrentSpeed(), speedBefore);
    }

    @Test
    void testBrake() {
        double speedBefore = volvo.getCurrentSpeed();
        volvo.brake(1);
        assertTrue(volvo.getCurrentSpeed() <= speedBefore);

        speedBefore = volvo.getCurrentSpeed();
        volvo.brake(-1);
        assertEquals(volvo.getCurrentSpeed(), speedBefore);

        volvo.brake(2);
        assertEquals(volvo.getCurrentSpeed(), speedBefore);

        volvo.stopEngine();
        speedBefore = volvo.getCurrentSpeed();
        volvo.brake(0.65);
        assertEquals(volvo.getCurrentSpeed(), speedBefore);
    }
}
