import java.awt.*;

public class Simulation {

    private Cell[][] map;
    private int width;
    private int height;

    public Simulation(int width,int height){

        this.width = width;
        this.height = height;

        this.map = new Cell[width][height];

        for(int x = 0; x<width; x++){
            for(int y = 0; y<height; y++){
                this.map[x][y] = new Cell(0);
            }
        }
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public Cell getCell(int x, int y){
        return this.map[x][y];
    }

    public void setCell(int x, int y, Cell cell){
        this.map[x][y] = cell;
    }

    public void showSimulation(Screen screen, int size){
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height ; y++){

                  //each pixel is scaled by a value of size

                  if(this.getCell(x, y).getState() == 0){
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
    }

    public Simulation evolveSimulation(){

        Simulation newSimulation = new Simulation(this.width,this.height);

        for(int x = 0; x<width; x++){
            for(int y = 0; y<height; y++){
                
                int N = 0;

                //goes from the left upper corner to right bottom corner
                for(int xi = x-1; xi <= x+1; xi++){
                    for(int yj = y-1; yj <= y+1; yj++){

                        //if its inside the boundaries and its not itself, increment neighborhood counter
                        if(xi < width && yj < height && xi >= 0 && yj >= 0){
                            if(this.getCell(xi, yj).getState() == 1){
                                if(xi != x || yj != y){
                                    N++;
                                }
                            }
                        }
                    }
                }
                if(N == 3 || (N == 2 && this.getCell(x,y).getState() == 1))    
                    newSimulation.setCell(x, y, new Cell(1));
            }
        }
        return newSimulation;
    }

    public void randomSimulation(){
        for(int x = 0; x<width; x++){
            for(int y = 0; y<height; y++){
                if(Math.random() > 0.5)
                    this.getCell(x,y).setState(1);
            }
        }
    }

    public void insertBlinker(){
        this.getCell(13,10).setState(1);
        this.getCell(13,11).setState(1);
        this.getCell(13,12).setState(1);
    }

    public void insertGosperGliderGun(){
       this.getCell(1,5).setState(1);
       this.getCell(1,6).setState(1);
       this.getCell(2,5).setState(1);
       this.getCell(2,6).setState(1);

       this.getCell(11,5).setState(1);
       this.getCell(11,6).setState(1);
       this.getCell(11,7).setState(1);
       this.getCell(12,4).setState(1);
       this.getCell(12,8).setState(1);
       this.getCell(13,3).setState(1);
       this.getCell(13,9).setState(1);
       this.getCell(14,3).setState(1);
       this.getCell(14,9).setState(1);
       this.getCell(15,6).setState(1);
       this.getCell(16,4).setState(1);
       this.getCell(16,8).setState(1);
       this.getCell(17,5).setState(1);
       this.getCell(17,6).setState(1);
       this.getCell(17,7).setState(1);
       this.getCell(18,6).setState(1);

       this.getCell(21,3).setState(1);
       this.getCell(21,4).setState(1);
       this.getCell(21,5).setState(1);
       this.getCell(22,3).setState(1);
       this.getCell(22,4).setState(1);
       this.getCell(22,5).setState(1);
       this.getCell(23,2).setState(1);
       this.getCell(23,6).setState(1);
       this.getCell(25,1).setState(1);
       this.getCell(25,2).setState(1);
       this.getCell(25,6).setState(1);
       this.getCell(25,7).setState(1);

       this.getCell(35,3).setState(1);
       this.getCell(35,4).setState(1);
       this.getCell(36,3).setState(1);
       this.getCell(36,4).setState(1);
    }
}
