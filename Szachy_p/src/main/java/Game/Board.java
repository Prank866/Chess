package Game;


import Shapes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Board extends JPanel implements MouseListener {

    public Square[][] gameBoard = new Square[8][8];

    private final static int WIDTH = 420;
    private final static int HEIGHT = 480;

    String[] alfabet = new String[] {"A","B", "C", "D", "E", "F", "G", "H"};

    private int x,y;

    private int rowBoard, columnBoard;


    Image blackKingImage, whiteKingImage, blackQueenImage, whiteQueenImage, blackBishopImage, whiteBishopImage, blackKnightImage, whiteKnightImage, blackRookImage, whiteRookImage, blackPawnImage, whitePawnImage;



    //BIALE
    Knight whiteKnight1 = new Knight(1,2,"whiteKnight1");
    Knight whiteKnight2 = new Knight(1,7,"whiteKnight2");

    Bishop whiteBishop1 = new Bishop(1,3,"whiteBishop1");
    Bishop whiteBishop2 = new Bishop(1,6,"whiteBishop2");

    Rook whiteRook1 = new Rook(1,1,"whiteRook1");
    Rook whiteRook2 = new Rook(1,8,"whiteRook2");

    King whiteKing = new King(1,5,"whiteKing");

    Queen whiteQueen = new Queen(1,4,"whiteQueen");

    Pawn whitePawn1 = new Pawn(2,1,"whitePawn1");
    Pawn whitePawn2 = new Pawn(2,2,"whitePawn2");
    Pawn whitePawn3 = new Pawn(2,3,"whitePawn3");
    Pawn whitePawn4 = new Pawn(2,4,"whitePawn4");
    Pawn whitePawn5 = new Pawn(2,5,"whitePawn5");
    Pawn whitePawn6 = new Pawn(2,6,"whitePawn6");
    Pawn whitePawn7 = new Pawn(2,7,"whitePawn7");
    Pawn whitePawn8 = new Pawn(2,8,"whitePawn8");

    //CZARNE
    Knight blackKnight1 = new Knight(8,2,"blackKnight1");
    Knight blackKnight2 = new Knight(8,7,"blackKnight2");

    Bishop blackBishop1 = new Bishop(8,3,"balckBishop1");
    Bishop blackBishop2 = new Bishop(8,6,"blackBishop2");

    Rook blackRook1 = new Rook(8,1,"blackRook1");
    Rook blackRook2 = new Rook(8,8,"blackRook2");

    King blackKing = new King(8,5,"blackKing");

    Queen blackQueen = new Queen(8,4,"blackQueen");

    Pawn blackPawn1 = new Pawn(7,1,"blackPawn1");
    Pawn blackPawn2 = new Pawn(7,2,"blackPawn2");
    Pawn blackPawn3 = new Pawn(7,3,"blackPawn3");
    Pawn blackPawn4 = new Pawn(7,4,"blackPawn4");
    Pawn blackPawn5 = new Pawn(7,5,"blackPawn5");
    Pawn blackPawn6 = new Pawn(7,6,"blackPawn6");
    Pawn blackPawn7 = new Pawn(7,7,"blackPawn7");
    Pawn blackPawn8 = new Pawn(7,8,"blackPawn8");


    public Board(){

        setBackground(Color.BLACK);
        addMouseListener(this);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));


        for(int i = 0 ; i < gameBoard.length ; i++)
        {
            for(int j = 0 ; j < gameBoard.length ; j++)
            {
                gameBoard[i][j] = new Square(i,j,""+(i+1)+""+(j+1));
            }

        }

    }

    public void ustawKoloryPol(){
        for(int i = 0 ; i < 8 ; i++)
        {
            for(int j = 0 ; j < 8 ; j++)
            {
                if((i+1) % 2 == 0 && (j+1) % 2 == 0 || (i+1) % 2 != 0 && (j+1) % 2 != 0 ) {
                    //czarne
                    gameBoard[i][j].czarnePole = true;
                    gameBoard[i][j].białePole = false;
                    gameBoard[i][j].kolorPola = "Czarne";

                }

                if((i+1) % 2 != 0 && (j+1) % 2 == 0 || (i+1) % 2 == 0 && (j+1) % 2 != 0) {
                    //biale
                    gameBoard[i][j].białePole = true;
                    gameBoard[i][j].czarnePole = false;
                    gameBoard[i][j].kolorPola = "Białe";
                }
            }
        }
    }



    public void pokazDane()
    {
        for(int i = 0 ; i < gameBoard.length ; i++)
        {
            for(int j = 0 ; j < gameBoard.length ; j++)
            {
                ustawKoloryPol();
                gameBoard[i][j].pokazNazwyPol();
                System.out.print("       ");
            }
            System.out.println();
        }
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        Color bezowy = new Color(245,222,179);
        Color brazowy = new Color(139,69,19);
        Color czarny = new Color(0,0,0);
        Color bialy = new Color(255,255,255);




        //czarne pola
        for(int i = 40 ; i <= 320 ; i=i+40)
        {
            for(int j = 40 ; j <= 320 ; j=j+40)
            {
                g2.setColor(brazowy);
                g2.fillRect(i,j,40,40);
            }
        }
        //biale pola od 1 linii
        for(int i = 80 ; i <= 320 ; i=i+80)
        {
            for(int j = 40 ; j <= 320 ; j=j+80)
            {
                g2.setColor(bezowy);
                g2.fillRect(i,j,40,40);
            }
        }
        //białe pola od 2 linii
        for(int i = 40 ; i <= 320 ; i=i+80)
        {
            for(int j = 80 ; j <= 320 ; j=j+80)
            {
                g2.setColor(bezowy);
                g2.fillRect(i,j,40,40);
            }
        }

        //czarne linie pomiedzy polami
        for(int i = 40 ; i <= 320 ; i=i+40)
        {
            for(int j = 40 ; j <= 320 ; j=j+40)
            {
                g2.setColor(czarny);
                g2.drawRect(i,j,40,40);
            }
        }

        //literki gora
        int k = 0;
        for(int i = 55 ; i <= 340 ; i=i+40)
        {
            g2.setColor(bialy);
            g2.drawString(alfabet[k],i,30);
            k++;
        }
        // literki dol
        k=0;
        for (int i = 55 ; i <= 340 ; i=i+40)
        {
            g2.setColor(bialy);
            g2.drawString(alfabet[k],i,380);
            k++;
        }

        //cyferki
        int l = 1;
        for(int j = 65 ; j <= 360 ; j=j+40)
        {
            g2.setColor(bialy);
            g2.drawString(""+l,25,j);
            l++;

        }

        l = 1;
        for(int j = 65 ; j <= 360 ; j=j+40)
        {
            g2.setColor(bialy);
            g2.drawString(""+l,370,j);
            l++;

        }

        //Scieżki do Ikon
        //Queen
        whiteQueenImage = new ImageIcon(getClass().getClassLoader().getResource("whiteQueen.png")).getImage();
        blackQueenImage = new ImageIcon(getClass().getClassLoader().getResource("blackQueen.png")).getImage();
        //King
        whiteKingImage = new ImageIcon(getClass().getClassLoader().getResource("whiteKing.png")).getImage();
        blackKingImage = new ImageIcon(getClass().getClassLoader().getResource("blackKing.png")).getImage();
        //Pawn
        whitePawnImage = new ImageIcon(getClass().getClassLoader().getResource("whitePawn.png")).getImage();
        blackPawnImage = new ImageIcon(getClass().getClassLoader().getResource("blackPawn.png")).getImage();
        //Rook
        whiteRookImage = new ImageIcon(getClass().getClassLoader().getResource("whiteRook.png")).getImage();
        blackRookImage = new ImageIcon(getClass().getClassLoader().getResource("blackRook.png")).getImage();
        //Bishop
        whiteBishopImage = new ImageIcon(getClass().getClassLoader().getResource("whiteBishop.png")).getImage();
        blackBishopImage = new ImageIcon(getClass().getClassLoader().getResource("blackBishop.png")).getImage();
        //Knight
        whiteKnightImage = new ImageIcon(getClass().getClassLoader().getResource("whiteKnight.png")).getImage();
        blackKnightImage = new ImageIcon(getClass().getClassLoader().getResource("blackKnight.png")).getImage();



        //logoUczelni
        g2.setColor(brazowy);
        g2.drawString("KPU KROSNO - B.SZ.",140,420);

        g2.setColor(bialy);

        whiteKnight1.row = whiteKnight1.row*40;
        whiteKnight1.column = whiteKnight1.column*40;
        g2.drawImage(whiteKnightImage,whiteKnight1.column+8,whiteKnight1.row+8,null);
        //g2.drawRect(whiteKnight1.column+9,whiteKnight1.row+9,20,20);


        whiteKnight2.row = whiteKnight2.row*40;
        whiteKnight2.column = whiteKnight2.column*40;
        g2.drawImage(whiteKnightImage,whiteKnight2.column+8,whiteKnight2.row+8,null);
        //g2.drawRect(whiteKnight2.column+9,whiteKnight2.row+9,20,20);


        whiteBishop1.row = whiteBishop1.row*40;
        whiteBishop1.column = whiteBishop1.column*40;
        g2.drawImage(whiteBishopImage,whiteBishop1.column+8,whiteBishop1.row+8,null);
        //g2.drawRect(whiteBishop1.column+9, whiteBishop1.row+9,20,20);


        whiteBishop2.row = whiteBishop2.row*40;
        whiteBishop2.column = whiteBishop2.column*40;
        g2.drawImage(whiteBishopImage,whiteBishop2.column+8,whiteBishop2.row+8,null);
        //g2.drawRect(whiteBishop2.column+9, whiteBishop2.row+9,20,20);

        whiteRook1.row = whiteRook1.row*40;
        whiteRook1.column = whiteRook1.column*40;
        g2.drawImage(whiteRookImage,whiteRook1.column+8,whiteRook1.row+8,null);
        //g2.drawRect(whiteRook1.column+9, whiteRook1.row+9,20,20);


        whiteRook2.row = whiteRook2.row*40;
        whiteRook2.column = whiteRook2.column*40;
        g2.drawImage(whiteRookImage,whiteRook2.column+8,whiteRook2.row+8,null);
        //g2.drawRect(whiteRook2.column+9, whiteRook2.row+9,20,20);


        whiteKing.row = whiteKing.row*40;
        whiteKing.column = whiteKing.column*40;
        g2.drawImage(whiteKingImage,whiteKing.column+8,whiteKing.row+8,null);
        //g2.drawRect(whiteKing.column+9, whiteKing.row+9,20,20);


        whiteQueen.row = whiteQueen.row*40;
        whiteQueen.column = whiteQueen.column*40;
        g2.drawImage(whiteQueenImage,whiteQueen.column+8,whiteQueen.row+8,null);
        //g2.drawRect(whiteQueen.column+9, whiteQueen.row+9,20,20);

        // PIONKI BIALE
        whitePawn1.row = whitePawn1.row*40;
        whitePawn1.column = whitePawn1.column*40;
        g2.drawImage(whitePawnImage,whitePawn1.column+8,whitePawn1.row+8,null);
        //g2.drawRect(whitePawn1.column+9,whitePawn1.row+9,20,20);


        whitePawn2.row = whitePawn2.row*40;
        whitePawn2.column = whitePawn2.column*40;
        g2.drawImage(whitePawnImage,whitePawn2.column+8,whitePawn2.row+8,null);
        //g2.drawRect(whitePawn2.column+9,whitePawn2.row+9,20,20);


        whitePawn3.row = whitePawn3.row*40;
        whitePawn3.column = whitePawn3.column*40;
        g2.drawImage(whitePawnImage,whitePawn3.column+8,whitePawn3.row+8,null);
        // g2.drawRect(whitePawn3.column+9,whitePawn3.row+9,20,20);


        whitePawn4.row = whitePawn4.row*40;
        whitePawn4.column = whitePawn4.column*40;
        g2.drawImage(whitePawnImage,whitePawn4.column+8,whitePawn4.row+8,null);
        //g2.drawRect(whitePawn4.column+9,whitePawn4.row+9,20,20);


        whitePawn5.row = whitePawn5.row*40;
        whitePawn5.column = whitePawn5.column*40;
        g2.drawImage(whitePawnImage,whitePawn5.column+8,whitePawn5.row+8,null);
        //g2.drawRect(whitePawn5.column+9,whitePawn5.row+9,20,20);


        whitePawn6.row = whitePawn6.row*40;
        whitePawn6.column = whitePawn6.column*40;
        g2.drawImage(whitePawnImage,whitePawn6.column+8,whitePawn6.row+8,null);
        //g2.drawRect(whitePawn6.column+9,whitePawn6.row+9,20,20);


        whitePawn7.row = whitePawn7.row*40;
        whitePawn7.column = whitePawn7.column*40;
        g2.drawImage(whitePawnImage,whitePawn7.column+8,whitePawn7.row+8,null);
        //g2.drawRect(whitePawn7.column+9,whitePawn7.row+9,20,20);


        whitePawn8.row = whitePawn8.row*40;
        whitePawn8.column = whitePawn8.column*40;
        g2.drawImage(whitePawnImage,whitePawn8.column+8,whitePawn8.row+8,null);
        //g2.drawRect(whitePawn8.column+9,whitePawn8.row+9,20,20);
        //PIONKI BIALE







        /////////////////////////////////////////////////////////////////












        blackKnight1.row = blackKnight1.row*40;
        blackKnight1.column = blackKnight1.column*40;
        g2.drawImage(blackKnightImage,blackKnight1.column+8,blackKnight1.row+8,null);
        //g2.drawRect(blackKnight1.column+9,blackKnight1.row+9,20,20);


        blackKnight2.row = blackKnight2.row*40;
        blackKnight2.column = blackKnight2.column*40;
        g2.drawImage(blackKnightImage,blackKnight2.column+8,blackKnight2.row+8,null);
        //g2.drawRect(blackKnight2.column+9,blackKnight2.row+9,20,20);


        blackBishop1.row = blackBishop1.row*40;
        blackBishop1.column = blackBishop1.column*40;
        g2.drawImage(blackBishopImage,blackBishop1.column+8,blackBishop1.row+8,null);
        //g2.drawRect(blackBishop1.column+9, blackBishop1.row+9,20,20);


        blackBishop2.row = blackBishop2.row*40;
        blackBishop2.column = blackBishop2.column*40;
        g2.drawImage(blackBishopImage,blackBishop2.column+8,blackBishop2.row+8,null);
        //g2.drawRect(blackBishop2.column+9, blackBishop2.row+9,20,20);

        blackRook1.row = blackRook1.row*40;
        blackRook1.column = blackRook1.column*40;
        g2.drawImage(blackRookImage,blackRook1.column+8,blackRook1.row+8,null);
        //g2.drawRect(blackRook1.column+9, blackRook1.row+9,20,20);


        blackRook2.row = blackRook2.row*40;
        blackRook2.column = blackRook2.column*40;
        g2.drawImage(blackRookImage,blackRook2.column+8,blackRook2.row+8,null);
        //g2.drawRect(blackRook2.column+9, blackRook2.row+9,20,20);


        blackKing.row = blackKing.row*40;
        blackKing.column = blackKing.column*40;
        g2.drawImage(blackKingImage,blackKing.column+8,blackKing.row+8,null);
        //g2.drawRect(blackKing.column+9, blackKing.row+9,20,20);


        blackQueen.row = blackQueen.row*40;
        blackQueen.column = blackQueen.column*40;
        g2.drawImage(blackQueenImage,blackQueen.column+8,blackQueen.row+8,null);
        //g2.drawRect(blackQueen.column+9, blackQueen.row+9,20,20);

        // PIONKI CZARNE
        blackPawn1.row = blackPawn1.row*40;
        blackPawn1.column = blackPawn1.column*40;
        g2.drawImage(blackPawnImage,blackPawn1.column+8,blackPawn1.row+8,null);
        //g2.drawRect(blackPawn1.column+9,blackPawn1.row+9,20,20);


        blackPawn2.row = blackPawn2.row*40;
        blackPawn2.column = blackPawn2.column*40;
        g2.drawImage(blackPawnImage,blackPawn2.column+8,blackPawn2.row+8,null);
        //g2.drawRect(blackPawn2.column+9,blackPawn2.row+9,20,20);


        blackPawn3.row = blackPawn3.row*40;
        blackPawn3.column = blackPawn3.column*40;
        g2.drawImage(blackPawnImage,blackPawn3.column+8,blackPawn3.row+8,null);
        //g2.drawRect(blackPawn3.column+9,blackPawn3.row+9,20,20);


        blackPawn4.row = blackPawn4.row*40;
        blackPawn4.column = blackPawn4.column*40;
        g2.drawImage(blackPawnImage,blackPawn4.column+8,blackPawn4.row+8,null);
        //g2.drawRect(blackPawn4.column+9,blackPawn4.row+9,20,20);


        blackPawn5.row = blackPawn5.row*40;
        blackPawn5.column = blackPawn5.column*40;
        g2.drawImage(blackPawnImage,blackPawn5.column+8,blackPawn5.row+8,null);
        //g2.drawRect(blackPawn5.column+9,blackPawn5.row+9,20,20);


        blackPawn6.row = blackPawn6.row*40;
        blackPawn6.column = blackPawn6.column*40;
        g2.drawImage(blackPawnImage,blackPawn6.column+8,blackPawn6.row+8,null);
        //g2.drawRect(blackPawn6.column+9,blackPawn6.row+9,20,20);


        blackPawn7.row = blackPawn7.row*40;
        blackPawn7.column = blackPawn7.column*40;
        g2.drawImage(blackPawnImage,blackPawn7.column+8,blackPawn7.row+8,null);
        //g2.drawRect(blackPawn7.column+9,blackPawn7.row+9,20,20);


        blackPawn8.row = blackPawn8.row*40;
        blackPawn8.column = blackPawn8.column*40;
        g2.drawImage(blackPawnImage,blackPawn8.column+8,blackPawn8.row+8,null);
        //g2.drawRect(blackPawn8.column+9,blackPawn8.row+9,20,20);
        //PIONKI CZARNE




    }



    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("MOUSE CLICK");
        x = e.getX();
        y = e.getY();

        //System.out.println(""+x+""+y);

        rowBoard = x/40;
        columnBoard = y/40;

        System.out.println(rowBoard+" "+ columnBoard);

    }

    @Override
    public void mousePressed(MouseEvent e) {

        System.out.println("MOUSE PRESSED");

        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("MOUSE RELEASED");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.println("MOUSE ENTERED");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //System.out.println("MOUSE EXITED");
    }
}
