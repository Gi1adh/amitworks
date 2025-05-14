import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ResizeImage {
    public static void main(String[] args) {
        try {
            // Load the original image
            File inputFile = new File("C:/Users/gilad/Desktop/Avishai.jpeg");
            BufferedImage originalImage = ImageIO.read(inputFile);

            // Calculate new width and height (50% scale)
            int newWidth = originalImage.getWidth() / 2;
            int newHeight = originalImage.getHeight() / 2;

            // Create a new image with the new size
            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

            // Draw the original image into the new image
            Graphics2D g = resizedImage.createGraphics();
            g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
            g.dispose();

            // Convert to grayscale (black and white)
            for (int y = 0; y < newHeight; y++) {
                for (int x = 0; x < newWidth; x++) {
                    int rgb = resizedImage.getRGB(x, y);

                    int r = (rgb >> 16) & 0xFF;
                    int gVal = (rgb >> 8) & 0xFF;
                    int b = rgb & 0xFF;

                    // Calculate average for grayscale
                    int gray = (r + gVal + b) / 3;

                    // Set new pixel color
                    int grayRGB = (gray << 16) | (gray << 8) | gray;
                    resizedImage.setRGB(x, y, grayRGB);
                }
            }

            // Save the resized and grayscale image
            File outputFile = new File("C:/Users/gilad/Desktop/pic1_resized_bw.jpg");
            ImageIO.write(resizedImage, "jpg", outputFile);

            System.out.println("Resizing and grayscale conversion complete.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
