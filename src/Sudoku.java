public class Sudoku {
    private final Tablero tab;
    private int turno=0;
    public Sudoku(){
        tab = new Tablero();
        startGame();
    }
    public Sudoku(int [][] tablero){
        tab = new Tablero(tablero);
        validacionSudoku();
    }
    private void validacionSudoku(){
        OutputSudoku.printTablero(tab);
        OutputSudoku.msgValidateTablero(tab);
    }

    private void startGame(){
        OutputSudoku.printTablero(tab);
        while (!endGame()){
            turno++;
            tab.addValueToCasilla();
            OutputSudoku.printTablero(tab);
            OutputSudoku.msgStatusGame(tab,turno);
        }
        OutputSudoku.msgGameOver(turno);
    }
    private boolean endGame(){
        return tab.getCurrentCasillas() == tab.getMaxCasillas() && tab.validateTab();
    }
}
