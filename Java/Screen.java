import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Screen extends JPanel {

    public static final Color TRANSPARENT = new Color(0, 0, 0, 0);

    private BufferedImage canvas;
    private int[] canvasPixels;

    private int[][] pixels;

    public Screen(int width, int height) {
        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        canvasPixels = ((DataBufferInt) canvas.getRaster().getDataBuffer()).getData();
        pixels = new int[canvas.getHeight()][canvas.getWidth()];
    }

    public Dimension getPreferredSize() {
        return new Dimension(canvas.getWidth(), canvas.getHeight());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(int y = 0; y < canvas.getHeight(); y++) {
            for(int x = 0; x < canvas.getWidth(); x++) {
                canvasPixels[x + y * canvas.getWidth()] = pixels[y][x];
            }
        }

        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(canvas, null, null);
    }


    public void fillCanvas(Color c) {
        int color = c.getRGB();
        for (int y = 0; y < canvas.getHeight(); y++) {
            for (int x = 0; x < canvas.getWidth(); x++) {
                pixels[y][x] = color;
            }
        }
    }

    public void drawPixel(int x, int y, Color color) {
        pixels[y][x] = color.getRGB();
        repaint();
    }

    public void drawPixels(Point topLeftCorner, int[][] figurePixels) {
        for (int y = 0; y < figurePixels.length; y++) {
            for (int x = 0; x < figurePixels[y].length; x++) {
                if (figurePixels[y][x] != TRANSPARENT.getRGB()) {
                    pixels[topLeftCorner.y + y][topLeftCorner.x + x] = figurePixels[y][x];
                }
            }
        }

        repaint();
    }

    public void reset() {
        fillCanvas(Color.WHITE);
    }
}
