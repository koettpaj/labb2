import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ViewControl extends JFrame{

    private Boardgame game;
    private int size;
    private beautyButton[][] board;        // Square är subklass till JButton
    private JLabel mess = new JLabel();
    public JTextArea txtArea;

    ViewControl(Boardgame game,int size,String name) {
        super(name);

        this.size=size;
        this.board= new beautyButton[size][size];
        /*
        while(game.getStatus(0,0).equals("1") || game.getStatus(3,3).equals("") || game.getStatus(2,2).equals("11")) {
            int randomX = (int) (Math.random() * 4);
            int randomY = (int) (Math.random() * 4);
            System.out.println(randomX);
            game.move(randomX, randomY);
            System.out.println(game.getStatus(0, 0));
        }
        */
        Handler handler = new Handler();
        ImageIcon img = new ImageIcon("C:\\Users\\calle\\IdeaProjects\\prutth\\labb2\\src\\icon.png");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();
        container.setBackground(new Color(43,43,43));
        setLayout(null);

        int randomColor = (int )(Math.random() * 180 + 1);
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){

                beautyButton button = new beautyButton(new Color(randomColor,27+10*i,80+10*j),i,j);
                button.addActionListener(handler);
                add(button);
                button.setLocation(25+i*115, 25+j*115);
                board[i][j]=button;
            }
        }



        setSize(50+size*115,125+size*115);
        setIconImage(img.getImage());

        setResizable(false);
        txtArea = new JTextArea();
        txtArea.setBounds(0, 25+size*115, 50+size*115, 100);
        txtArea.setText("           Let's play");
        txtArea.setBackground(new Color(35,35,35));
        txtArea.setFont(new Font("Courier", Font.BOLD,45));
        add(txtArea);
        setVisible(true);//
        this.game=game;
        updateButtons();

    }

    public Boardgame givegameplz(){
        return this.game;
    }

    private void updateButtons(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                this.board[i][j].setText(this.game.getStatus(i,j));
            }
        }
    }

    private class Handler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            beautyButton buttonpressed = (beautyButton) event.getSource();
            int xpressed=buttonpressed.returnX();
            int ypressed=buttonpressed.returnY();
            givegameplz().move(xpressed,ypressed);
            txtArea.setText(givegameplz().getMessage());
            updateButtons();

        }
    }
}


class beautyButton extends JButton {
    private int indexX;
    private int indexY;
    private String s1,s2;
    private Boolean toggled = false;
    public beautyButton(Color color,int indexX,int indexY) {

        setText("1");

        setFont(new Font("Courier", Font.BOLD,45));
        setSize(100,100);
        setBackground(color);
        setForeground(Color.WHITE);
        this.indexX=indexX;
        this.indexY=indexY;



    }
    public int returnX(){
        return this.indexX;
    }
    public int returnY(){
        return this.indexY;
    }



}





class test {
    public static void main(String[] args) {
        System.out.println("hej");
        Boardgame thegame = new T3Model(8);
        ViewControl thiscontrol= new ViewControl(thegame,8,"Puzzle my dudes");
    }
}