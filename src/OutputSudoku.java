public class OutputSudoku {
    public static void msgInvaliteValue(int value , int unsN, int maxN){
        System.out.printf("invalite value '%d' min valite Value '%d' max Valite Value '%d'\n",value,unsN,maxN);
    }
    public static void msgInvalitePos(int minLInd,int maxLInd,int row,int col){
        System.out.printf("invalite position row '%d' col '%d', min position for Row and Col is %d, max position for Row and Col is %d\n",row+1,col+1,minLInd + 1,maxLInd + 1);
    }
    public static void msgInsertValue(int unsN,int maxN){
        System.out.printf("inserta un valor >= %d y <= %d\n",unsN ,maxN );
    }
    public static void msgInsertRow(int minLInd,int maxLInd){
        System.out.printf("inserta Row >= %d y <= %d\n",minLInd + 1,maxLInd + 1);
    }
    public static void msgInsertCol(int minLInd,int maxLInd){
        System.out.printf("inserta Col >= %d y <= %d\n",minLInd + 1,maxLInd + 1);
    }
    public static void printTablero(Tablero tab){
        int [][] t = tab.getTablero();
        final int maxSquare= tab.getMaxSquareAtLine();
        StringBuilder out= new StringBuilder();
        for (int r =0;r < t.length;r++){
            if (r % maxSquare == 0)
                out.append("\n");
            for (int c =0;c < t[0].length;c++){
                if (c % maxSquare == 0)
                    out.append("  ");
                out.append("[").append(t[r][c]).append("] ");
            }
            out.append("\n");
        }
        System.out.println(out);
    }
    public static void msgTurnoActual(int turno){
        System.out.printf("-turno : %d\n",turno);
    }
    public static void msgNumCasillasOcupadas(Tablero tab){
        System.out.printf("-numero de casillas ocupadas %d / %d\n",tab.getCurrentCasillas(),tab.getMaxCasillas());
    }
    public static void msgValidateTablero(Tablero tab){
        System.out.printf("-tablero valido segun normas de sudoku : %b\n",tab.validateTab());
    }
    public static void msgStatusGame(Tablero tab,int turno){
        System.out.println("STATUS GAME \n --------------------------");
       msgValidateTablero(tab);
       msgTurnoActual(turno);
       msgNumCasillasOcupadas(tab);
        System.out.println("--------------------------");
    }
    public static void msgGameOver(int turno){
        System.out.println("JUEGO COMPLETADO\n________________________");
        msgTurnoActual(turno);
    }
    public static void msgInvaliteDimensionTab(int maxLInd){
        System.out.printf("tablero con dimensiones invalidas, dimension requerida %d X %d\n",maxLInd + 1,maxLInd + 1);
    }
    public static void msgArrayTabInvalido(int maxLInd){
        msgInvaliteDimensionTab(maxLInd);
        System.out.printf("se creara un tablero predeterminado de dimension %d X %d\n",maxLInd + 1,maxLInd + 1);
    }
}
