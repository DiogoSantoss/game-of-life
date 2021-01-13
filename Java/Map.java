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

    public Map evolveMap(){

        Map newMap = new Map(this.width,this.height);

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
                    newMap.setCell(x, y, new Cell(1));
            }
        }
        return newMap;
    }

    public void randomGeneration(){
        for(int x = 0; x<width; x++){
            for(int y = 0; y<height; y++){
                if(Math.random() > 0.5)
                    this.getCell(x,y).setState(1);
            }
        }
    }
}
