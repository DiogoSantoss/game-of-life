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

            Map map = new Map(400,400);
            int x = map.getWidth();
            int y = map.getHeight();

            //bug somewhere

            for(; x < 500; x++){
                  for(; y < 500 ; y++){
                        if(map.getCell(x, y).getState() == 0)
                              screen.drawPixel(x,y,new Color(020000));
                        else
                              screen.drawPixel(x,y,new Color(222222));
                  }
            }
            screen.reset();
      }
}
