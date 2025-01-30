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
    void testIncrementSpeed() {
        double currentSpeed = volvo.getCurrentSpeed();
        volvo.incrementSpeed(1);
        double newSpeed = volvo.getCurrentSpeed();
        assertTrue(newSpeed >= currentSpeed);
        //assertTrue(newSpeed <= volvo.getEnginePower());
    }

    @Test
    void testDecrementSpeed() {
        double currentSpeed = volvo.getCurrentSpeed();
        volvo.decrementSpeed(1);
        double newSpeed = volvo.getCurrentSpeed();
        assertTrue(newSpeed <= currentSpeed);
        //assertTrue(newSpeed >= 0);
    }

    @Test
    void testGas() {
        double currentSpeed = volvo.getCurrentSpeed();
        volvo.gas(2); //Amount parameter set to 2
        double newSpeed = volvo.getCurrentSpeed();
        assertEquals(newSpeed, currentSpeed); //Should be equal since amount: 2 is invalid
    }

    @Test
    void testBrake() {
        double currentSpeed = volvo.getCurrentSpeed();
        volvo.brake(2); //Amount parameter set to 2
        double newSpeed = volvo.getCurrentSpeed();
        assertEquals(newSpeed, currentSpeed); //Should be equal since amount: 2 is invalid
    }
}
