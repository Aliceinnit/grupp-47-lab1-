package grupp47_lab1.test;

import grupp47_lab1.Transporter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransporterTest {
    Transporter transporter;

    @BeforeEach
    void setup(){
        transporter = new Transporter<>();
    }
    @Test
    void loadCar() {

    }

    @Test
    void unload() {

    }

    @Test
    void platformSwitch() {
        transporter.getPlatformState();
    }

    @Test
    void changeState() {

    }

    @Test
    void move() {
    }
}