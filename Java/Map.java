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
