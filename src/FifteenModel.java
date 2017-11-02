import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class FifteenModel implements Boardgame {
    private String[][] board = new String[4][4];
    private int emptyX,emptyY;
    private String latestMove;
    public FifteenModel() {

        List<String> rangeArray = new ArrayList<>();



        int arrayIndex=1;
        for(int x=0;x<4;x++){
            for(int y=0;y<4;y++){
                this.board[x][y]=Integer.toString(arrayIndex);
                arrayIndex+=1;
                }
            }
        this.board[3][3]="X";
        this.emptyX=3;
        this.emptyY=3;
        }





    public boolean move(int i, int j){
        if(i<0 || i>3 || j<0 || j>3){
            this.latestMove="Not Allowed!";
            return false;
        }
        else if(Math.abs(this.emptyX-i)==1  ){
            if(Math.abs(this.emptyY-j)!=0  ){
                this.latestMove="Not Allowed!";
                return false;
            }
        }
        else if(Math.abs(this.emptyY-j)==1  ){
            if(Math.abs(this.emptyX-i)!=0  ){
                this.latestMove="Not Allowed!";
                return false;
            }
        }
        else{
            this.latestMove="Not Allowed!";
            return false;
        }

        this.board[this.emptyX][this.emptyY]=this.board[i][j];
        this.emptyX=i;
        this.emptyY=j;
        this.board[this.emptyX][this.emptyY]="X";
        this.latestMove="OK";




    return true;
    }


    //ger true om draget gick bra, annars false

    public String getStatus(int i,int j){


        return(this.board[i][j]);



    };
     // returnera innehåll på ruta (i,j)
    public String getMessage(){

        return this.latestMove;

    }


    // returnera OK (eller liknande) eller felmeddelande avseende senaste drag







    // Implementera Boardgame-metoderna
    // Deklarera variabler och övriga metoder som ni
    // tycker behövs för ett femtonspel
}

class Text15 {
    public static void main(String[] u) {
        Scanner scan = new Scanner(System.in);
        Boardgame thegame = new FifteenModel();                 // Model object is created
        System.out.println("\nWelcome to fifteen puzzle\n");
        while (true) {
            // Print the current board
            for (int i=0; i<4; i++) {
                for (int j=0; j<4; j++)
                    System.out.print("  " + thegame.getStatus(i,j)); // getStatus
                System.out.println();
            }
            System.out.println();
            System.out.print("Your move: ");
            int i = scan.nextInt();  // get an int number from terminal window
            int j = scan.nextInt();
            thegame.move(i,j);	                             // move
            System.out.println(thegame.getMessage());	     // getMessage
        }
    }
}