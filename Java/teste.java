import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class teste{
      public static void main(String[] args){

            JFrame frame = new JFrame("Teste");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setResizable(false);

            Screen screen = new Screen(500, 500);
            screen.reset();
            frame.getContentPane().add(screen, BorderLayout.CENTER);

            frame.pack();
            frame.setVisible(true);

            /*
            for(int i = 0; i < 500; i++){
                  for(int k = 0; k < 500 ; k++){
                        screen.drawPixel(i,k,new Color(new Random().nextInt(0xFFFFFF)));
                  }
            }
            screen.reset();
            */
      }
}
