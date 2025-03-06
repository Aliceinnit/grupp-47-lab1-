package grupp47_lab1.test;

import grupp47_lab1.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TransporterTest {
    Transporter<PersonCar> transporter;
    PersonCar testCar;
    @BeforeEach
    void setup(){
        transporter = new Transporter<>();
        testCar = new Saab95();
    }
    @Test
    void loadCar() {
        transporter.loadCar(testCar);
        assertEquals(transporter.getCars().size(), 0);

        //transporter.platformSwitch(Transporter.platformState.DOWN);
        //transporter.changeState();

        while (transporter.getCars().size()<9) {
            transporter.loadCar(testCar);
        }
        transporter.loadCar(testCar);
        assertEquals(transporter.getCars().size(), 9);
    }

    @Test
    void unload() {
        //transporter.platformSwitch(Transporter.platformState.DOWN);
        //transporter.changeState();
        transporter.loadCar(testCar);

        //transporter.platformSwitch(Transporter.platformState.UP);
        //transporter.changeState();
        transporter.unloadCar();
        assertEquals(transporter.getCars().size(), 1);

        //transporter.platformSwitch(Transporter.platformState.DOWN);
        //transporter.changeState();
        transporter.unloadCar();
        assertEquals(transporter.getCars().size(), 0);
    }

    @Test
    void testChangeState() {
        //transporter.platformSwitch(Transporter.platformState.DOWN);
        //transporter.changeState();
        assertEquals(transporter.getCurrentAngle(), 70);

        transporter.startEngine();
        assertEquals(transporter.getCurrentSpeed(), 0);

        //transporter.platformSwitch(Transporter.platformState.UP);
        //transporter.changeState();
        assertEquals(transporter.getCurrentAngle(), 0);

        transporter.startEngine();
        transporter.gas(1);
        //transporter.platformSwitch(Transporter.platformState.DOWN);
        //transporter.changeState();
        assertEquals(transporter.getCurrentAngle(), 0);
    }

    @Test
    void move() {
        //transporter.platformSwitch(Transporter.platformState.DOWN);
        //transporter.changeState();
        transporter.loadCar(testCar);
        transporter.move();
        transporter.turnRight();
        for (Car car: transporter.getCars()) {
            assertEquals(car.getY(), transporter.getY());
            assertEquals(car.getX(), transporter.getX());
        }
    }
}
