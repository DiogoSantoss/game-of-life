import java.util.List;
import java.util.ArrayList;

public class Cell {
    
    private int state;
    private List<Cell> neighborhood = new ArrayList<Cell>();

    public Cell(int state){
        this.state = state;
    }

    public int getState(){
        return this.state;
    }

    public void setState(int state){
        this.state = state;
    }

    public Cell getNeighborhood(int position){
        return this.neighborhood.get(position);
    }

    public int getNeighborhoodValue(){
        int N = 0;
        for(Cell cell: this.neighborhood){
            N += cell.getState();
        }
        return N;
    }

    public void updateCell(){

        int N = this.getNeighborhoodValue();

        switch(this.getState()){
            case 0:
                if(N==3)
                    this.setState(1);
            case 1:
                if(!(N==2 || N==3))
                    this.setState(0);          
        }
    }
}
