package grupp47_lab1;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.swing.*;


// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    //static Map<String, Point> carPositions = new HashMap<>();
    private final CarPositionHandler positionHandler;
    private final WorkshopHandler workshopHandler;


    // To keep track of a single car's position
    //static Point volvoWorkshopPoint = new Point(300,300);


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, Stack<Car> cars, CarPositionHandler positionHandler, WorkshopHandler workshopHandler) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);
        this.positionHandler = positionHandler;
        this.workshopHandler = workshopHandler;
    }

    public void updateCarPosition(int x, int y, Car car) {
        positionHandler.moveit(x,y, car);
    }


    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        //clears the screen
        super.paintComponent(g);
        Map<Car, Point> carPositions = positionHandler.getCarPositions();
        //loops through all the cars in the hashmap carPositions
        for (Map.Entry<Car, Point> entry : carPositions.entrySet()) {
            //gets the car image based on its model name
            BufferedImage image = ImageLoader.getInstance().getImage(entry.getKey().getModelName());
            //System.out.println(entry.getKey());
            //gets the stored position (x,y) of the car
            Point pos = entry.getValue();

            if (image != null){
                //draws the car at the position
                g.drawImage(image, pos.x, pos.y, null);
            }
        }
        for (String modelName : workshopHandler.getAllWorkshopModels()){
            Point workshopPos = workshopHandler.getWorkshopPosition(modelName);
            BufferedImage workshopImage = ImageLoader.getInstance().getImage(modelName + "Workshop");

            if (workshopImage != null) {
                g.drawImage(workshopImage, workshopPos.x, workshopPos.y, null);

            }
        }
    }
}

