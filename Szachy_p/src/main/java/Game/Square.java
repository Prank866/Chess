package Game;

public class Square {

    private String name;

    private int row, column;

    public String kolorPola;

    private boolean isTherePawn, isThereBlackPawn;

    public boolean białePole, czarnePole;



    public Square(int row,int column,String name){
        this.row = row;
        this.column = column;
        this.name = name;


    }



    public void pokazNazwyPol()
    {
        System.out.print(name);
        System.out.print(kolorPola);
    }
}
