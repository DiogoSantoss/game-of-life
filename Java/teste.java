import javax.swing.*;
import java.awt.*;

public class teste{
      public static void main(String[] args){

            int width = 100;
            int height = 100;
            int size = 9;

            JFrame frame = new JFrame("Teste");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setResizable(true);

            Screen screen = new Screen(width*size, height*size);
            screen.reset();
            frame.getContentPane().add(screen, BorderLayout.CENTER);

            frame.pack();
            frame.setVisible(true);

            Map map = new Map(width,height);

            //map.randomGeneration();

            /*
            map.getCell(10,10).setState(1);
            map.getCell(10,11).setState(1);
            map.getCell(10,12).setState(1);
            */

            
            map.getCell(2,1).setState(1);
            map.getCell(3,2).setState(1);
            map.getCell(1,3).setState(1);
            map.getCell(2,3).setState(1);
            map.getCell(3,3).setState(1);

            map.getCell(width-2,height-1).setState(1);
            map.getCell(width-3,height-2).setState(1);
            map.getCell(width-1,height-3).setState(1);
            map.getCell(width-2,height-3).setState(1);
            map.getCell(width-3,height-3).setState(1);
            

            while(true){
                  for(int x = 0; x < width; x++){
                        for(int y = 0; y < height ; y++){

                              //each pixel is scaled by a value of size

                              if(map.getCell(x, y).getState() == 0){
                                    for(int i = 0;i<size;i++){
                                          for(int j = 0; j<size;j++){
                                                screen.drawPixel(x*size+i,y*size+j,new Color(000,000,000));
                                          }
                                    }
                              }
                              else{
                                    for(int i = 0;i<size;i++){
                                          for(int j = 0; j<size;j++){
                                                screen.drawPixel(x*size+i,y*size+j,new Color(255,250,250));
                                          }
                                    }
                              }
                        }
                  }
                  //try{Thread.sleep(0);}catch(InterruptedException ex){}
                  map = map.evolveMap();
            }
      }
}
