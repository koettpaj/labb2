class T3Model implements Boardgame {
    private String[][] board;
    int counter=0;
    int latestX,latestY,player=0;
    String symbols[] = {"X","O"};
    String feedback[] = {"Amazing","Inspiring","Make Puzzles Great Again","What a move","Insane!","IQ>140","Nice!","Wow!"};
    boolean firstpress=true;
    String latestMessage;
    public T3Model (int size) {
        this.board= new String[size][size];

    }



    public boolean move(int i, int j) {
        if(counter>5){
            return endGameMove(i,j);
        }
        if(this.board[i][j]!=null){
            this.latestMessage="Press any empty square";
            return false;
        }



        this.board[i][j]=this.symbols[player];

        changePlayer();

        this.counter+=1;
        int randomMsg=(int )(Math.random() * 8 );
        this.latestMessage=this.feedback[randomMsg]+" "+this.symbols[this.player]+" is next.";
        return true;
    }

    private boolean endGameMove(int i, int j){
        if(firstpress){
            if(this.board[i][j]!=this.symbols[this.player]){
                this.latestMessage="You can only move "+this.symbols[player];
                return false;
            }
            else{
                this.latestX=i;
                this.latestY=j;
                this.firstpress=false;
                this.latestMessage="Press any empty square";
            }
        }
        else{
            if(this.board[i][j]==null){
                this.board[i][j]=this.symbols[player];
                this.board[latestX][latestY]=null;
                this.firstpress=true;
                changePlayer();
                int randomMsg=(int )(Math.random() * 8 );
                this.latestMessage=this.feedback[randomMsg]+" "+this.symbols[this.player]+" is next.";
                return true;

            }

        } this.latestMessage="Press any empty square";
        return false;
    }




    private void changePlayer(){
        if(player==0){
            this.player=1;
        }
        else{
            this.player=0;
        }

    }



    public String getStatus(int i, int j){
        return this.board[i][j];
    }
    public String getMessage(){
        return this.latestMessage;
    }
}