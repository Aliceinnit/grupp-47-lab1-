package grupp47_lab1;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;


// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    //static Map<String, Point> carPositions = new HashMap<>();
    Map<String, BufferedImage> carImages = new HashMap<>();
    private final CarPositionHandler positionHandler;


    // To keep track of a single car's position
    BufferedImage volvoWorkshopImage;
    static Point volvoWorkshopPoint = new Point(300,300);



    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);
        // Print an error message in case file is not found with a try/catch block
        try {
            //Volvo240Image = ImageIO.read(new File("pics/Volvo240.jpg"));
            //Saab95Image = ImageIO.read(new File("pics/Saab95.jpg"));
            //ScaniaImage = ImageIO.read(new File("pics/Scania.jpg"));

            // Remember to right-click src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            carImages.put("Volvo240", ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"))));
            carImages.put("Saab95", ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"))));
            carImages.put("Scania", ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"))));
            volvoWorkshopImage = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg")));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        //clears the screen
        super.paintComponent(g);
        Map<String, Point> carPositions = positionHandler.getCarPositions();
        //loops through all the cars in the hashmap carPositions
        for (Map.Entry<String, Point> entry : carPositions.entrySet()) {
            //gets the car image based on its model name
            BufferedImage image = carImages.get(entry.getKey());
            //gets the stored position (x,y) of the car
            Point pos = entry.getValue();

            if (image != null){
                //draws the car at the position
                g.drawImage(image, pos.x, pos.y, null);
            }
        }
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}

