import javax.swing.*;
import java.awt.*;

public class App{
      public static void main(String[] args){

            //window size and pixel size
            int width = 100;
            int height = 100;
            int size = 9;

            JFrame frame = new JFrame("Teste");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setResizable(false);

            Screen screen = new Screen(width*size, height*size);
            screen.reset();
            frame.getContentPane().add(screen, BorderLayout.CENTER);

            frame.pack();
            frame.setVisible(true);

            //Creates map with all dead Cells
            Simulation simulation = new Simulation(width,height);

            simulation.randomSimulation();
            //simulation.insertBlinker();
            //simulation.insertGosperGliderGun();


            //game loop
            while(true){
                  simulation.showSimulation(screen, size);
                  simulation = simulation.evolveSimulation();
            }
      }
}
