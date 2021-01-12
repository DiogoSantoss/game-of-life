import java.util.List;
import java.util.ArrayList;

public class Map {

    //FIXME

    private List<List<Cell>> map = new ArrayList<List<Cell>>();

    public Map(int width,int height){
        for(int i = 0; i < width; i++){
            this.map.add(new ArrayList<Cell>());
            for(int j = 0; j < height; j++){
                this.map.get(i).add(new Cell(0));
            }
        }
    
}
