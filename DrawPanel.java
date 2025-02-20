package grupp47_lab1;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;


// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage Volvo240Image;
    BufferedImage Saab95Image;
    BufferedImage ScaniaImage;

    // To keep track of a single car's position
    Point CarPoint = new Point();
    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);

    public void hm(String[] args) {
        HashMap<Image, Integer> hashMap = new HashMap<>();

        hashMap.put(Volvo240Image, CarPoint.y);
        hashMap.put(ScaniaImage, CarPoint.y);
        hashMap.put(Saab95Image, CarPoint.y);
    }


    // TODO: Make this general for all cars
    void moveit(int x, int y){
        CarPoint.x = x;
        CarPoint.y = y;

    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);
        // Print an error message in case file is not found with a try/catch block
        try {
            Volvo240Image = ImageIO.read(new File("pics/Volvo240.jpg"));

            // Remember to right-click src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            Volvo240Image = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            Saab95Image = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            ScaniaImage = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));

            volvoWorkshopImage = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg")));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Volvo240Image, CarPoint.x, CarPoint.y, null); // see javadoc for more info on the parameters
        //g.drawImage(Saab95Image, CarPoint.x, CarPoint.y+100, null); // see javadoc for more info on the parameters
        //g.drawImage(ScaniaImage, CarPoint.x, CarPoint.y+200, null); // see javadoc for more info on the parameters

        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}

