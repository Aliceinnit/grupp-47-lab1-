package grupp47_lab1;

import grupp47_lab1.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.Color;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Car testCar;

    // En anonym subklass av Car eftersom Car är abstrakt
    @BeforeEach
    void setUp() {
        testCar = new Volvo240();
    }

    @Test
    void testStartEngine() {
        testCar.startEngine();
        assertEquals(0.1, testCar.getCurrentSpeed(), 0.001);
    }

    @Test
    void testStopEngine() {
        testCar.startEngine();
        testCar.stopEngine();
        assertEquals(0.0, testCar.getCurrentSpeed(), 0.001);
    }

    @Test
    void testMoveNorth() {
        testCar.startEngine();
        testCar.move();
        assertTrue(testCar.getY() > 0); // Bilen ska röra sig uppåt
    }

    @Test
    void testTurnLeft() {
        testCar.startEngine();
        testCar.turnLeft(); // Från NORTH → WEST
        testCar.move();
        assertTrue(testCar.getX() < 0); // Bilen ska röra sig vänster
    }

    @Test
    void testTurnRight() {
        testCar.startEngine();
        testCar.turnRight(); // Från NORTH → EAST
        testCar.move();
        assertTrue(testCar.getX() > 0); // Bilen ska röra sig höger
    }
}
