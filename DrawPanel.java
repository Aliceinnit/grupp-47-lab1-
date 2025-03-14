package grupp47_lab1;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;


// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel implements Observer{
    private final WorkshopHandler workshopHandler;
    private final CarModel model;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarModel model) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);
        this.model = model;
        this.workshopHandler = model.getWorkshopHandler();
        model.addObserver(this);
    }

    @Override
    public void update() {
        repaint();
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        //clears the screen
        super.paintComponent(g);
        //loops through all the cars in the hashmap carPositions
        for (Car car : model.getCars()) {
            //gets the car image based on its model name
            BufferedImage image = ImageLoader.getInstance().getImage(car.getModelName());
            if (image != null){
                //draws the car at the position
                g.drawImage(image, (int) car.getX(), (int) car.getY(), null);
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

