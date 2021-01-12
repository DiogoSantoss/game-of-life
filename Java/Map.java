import java.util.List;
import java.util.ArrayList;

public class Map {

    private Cell[][] map;
    private int width;
    private int height;

    public Map(int width,int height){

        this.width = width;
        this.height = height;

        this.map = new Cell[width][height];

        for(int x = 0; x<width; x++){
            for(int y = 0; y<height; y++){
                this.map[x][y] = new Cell(0);
            }
        }

        for(int x = 0; x<width; x++){
            for(int y = 0; y<height; y++){
                
                List<Cell> neighborhood = new ArrayList<Cell>();

                //goes from the left upper corner to right bottom corner
                for(int xi = x-1; xi <= x+1; xi++){
                    for(int yj = y-1; yj <= y+1; yj++){

                        //if its inside the boundaries, add to the list
                        if(xi < x && yj < y && xi >= 0 && yj >= 0){
                            neighborhood.add(this.map[xi][yj]);
                        }
                    }
                }
                this.map[x][y].setNeighborhood(neighborhood);
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

    public void evolveMap(){
        Cell[][] newMap = new Cell[this.width][this.height];

        for(int x = 0; x<width; x++){
            for(int y = 0; y<height; y++){
                this.map[x][y].updateCell();
                newMap[x][y] = this.map[x][y];
            }
        }
        this.map = newMap;
    }
}
