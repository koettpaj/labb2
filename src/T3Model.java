class T3Model implements Boardgame {
    private String[][] board;
    int counter=0;
    public T3Model (int size) {
        this.board= new String[size][size];

    }



    public boolean move(int i, int j){
        if(this.counter % 2 ==0){
            this.board[i][j]="X";
        }
        else{
            this.board[i][j]="O";
        }
        this.counter+=1;
        return true;
    }
    public String getStatus(int i, int j){
        return this.board[i][j];
    }
    public String getMessage(){
        return "cool stuff!";
    }
}