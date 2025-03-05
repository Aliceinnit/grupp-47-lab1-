package grupp47_lab1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ImageLoader {
    private static ImageLoader instance; // Singleton-instans
    private static final Map<String, BufferedImage> imageMap = new HashMap<>();

    private ImageLoader() { // Privat konstruktor för Singleton
        loadImages();
    }

    public static ImageLoader getInstance() {
        if (instance == null) {
            instance = new ImageLoader();
        }
        return instance;
    }

    private void loadImages() {
        try {
            imageMap.put("Volvo240", loadImage("pics/Volvo240.jpg"));
            imageMap.put("Saab95", loadImage("pics/Saab95.jpg"));
            imageMap.put("Scania", loadImage("pics/Scania.jpg"));
            imageMap.put("VolvoWorkshop", loadImage("pics/VolvoBrand.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedImage loadImage(String path) throws IOException {
        return ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream(path), "Image not found: " + path));
    }

    public BufferedImage getImage(String modelName) {
        return imageMap.get(modelName);
    }
}

