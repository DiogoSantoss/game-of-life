public class Cell {
    
    //A cell can be either dead (0) or alive (1)
    private int state;

    public Cell(int state){
        this.state = state;
    }

    public int getState(){
        return this.state;
    }

    public void setState(int state){
        this.state = state;
    }
}
