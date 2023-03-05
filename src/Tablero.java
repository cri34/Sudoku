public class Tablero {
   private final int minLInd =0;
    private final int maxLInd =8;
    private final int maxCasillas;
    private final int minN=1;
    private final int maxN=9;
    private final int unsN=0;
    private final int maxSquareAtLine = 3;
    private int lastValue;
    private int lastRow;
    private int lastCol;
  private final int [][] tab;
  public Tablero(int[][] tab){
      if (tab.length == maxLInd + 1 && tab[0].length == maxLInd + 1){
          this.tab = tab;
          maxCasillas = (maxLInd + 1) * (maxLInd + 1);
          return;
      }
     OutputSudoku.msgArrayTabInvalido(maxLInd);
      this.tab = new int [maxLInd+1][maxLInd+1];
      maxCasillas = (maxLInd + 1) * (maxLInd + 1);
  }
  public Tablero(){
      tab= new int [maxLInd+1][maxLInd+1];
      maxCasillas = (maxLInd + 1) * (maxLInd + 1);
  }
  public int[][] getTablero(){
      return this.tab;
  }
  public int getMaxCasillas(){
      return this.maxCasillas;
  }
  public int getCurrentCasillas(){
      return retNCasillasOcupadas();
  }
  public int getMaxSquareAtLine(){
      return maxSquareAtLine;
  }

    public boolean validateTab(){
        return checkValidLine() && checkValidSquare();
    }
    private boolean checkValidLine(){
            for (int i = minLInd ; i <= maxLInd; i++) {
                for (int actN = minN ;actN <= maxN;actN++) {
                    if (!checkValidSecNumbersInLine(actN,i))
                        return false;
                }
        }
            return true;
    }
    private boolean checkValidSquare(){
      for (int actSquareRow = 1; actSquareRow <=maxSquareAtLine;actSquareRow++){
          for (int actualSquareCol=1; actualSquareCol <= maxSquareAtLine;actualSquareCol++){
              for (int actN=minN;actN <= maxN;actN++){
                  if(!checkValidSecNumbersInSquare(actN,maxSquareAtLine * actSquareRow -1,maxSquareAtLine * actualSquareCol -1))
                      return false;
              }
          }
      }
      return true;
    }
    private boolean checkValidSecNumbersInSquare(int actN,int indexRow, int indexCol){
      int count=0;
      final int firstposInterval=2;
      final int maxOcurr=1;
      for (int r =indexRow ;r  >= indexRow - firstposInterval;r--){
          for (int c =indexCol; c >= indexCol - firstposInterval;c--){
              if (tab[r][c]==actN)
                  count++;
              if (count > maxOcurr)
                  return false;

          }
      }
      return  true;
    }
    private boolean checkValidSecNumbersInLine(int actN, int index){
        int c = 0;
        int row , col;
        final int maxNOcurr=1;
        for (int dir = 0; dir <= 1;dir++) {
            for (int i = minLInd; i <= maxLInd; i++) {
                row = (dir == 0) ? i : index;
                col = (dir == 0) ? index : i;
                if (tab[row][col] == actN) {
                    c++;
                    if (c > maxNOcurr)
                        return false;
                }
            }
            c=0;
        }
        return true;
    }
    public void addValueToCasilla(){
      insertValue();
      insertPosition();
      tab[lastRow][lastCol] = lastValue;
    }
    private void insertValue(){
       insertValueStatement();
      while (!checkValitValue(lastValue)) {
         insertValueStatement();
      }
    }
    private void insertValueStatement(){
        OutputSudoku.msgInsertValue(unsN, maxN);
        lastValue = Input.inpNumber();
    }
    private void insertPosition(){
       insertPositionStatement();
        while(!checkValitPos(lastRow,lastCol)){
            insertPositionStatement();
        }
    }
    private void insertPositionStatement(){
        OutputSudoku.msgInsertRow(minLInd,maxLInd);
        lastRow=Input.inpNumber()-1;
        OutputSudoku.msgInsertCol(minLInd,maxLInd);
        lastCol=Input.inpNumber()-1;
    }
    private boolean checkValitPos(int row, int col){
        boolean valitPos = row <= maxLInd && row >= minLInd & col <= maxLInd && col >= minLInd;
        if (!valitPos)
            OutputSudoku.msgInvalitePos(minLInd,maxLInd,lastRow,lastCol);
      return valitPos;
    }
    private boolean checkValitValue(int value){
        boolean valitValue = value >= unsN && value <= maxN;
        if (!valitValue)
            OutputSudoku.msgInvaliteValue(value,unsN,maxN);
        return valitValue;
    }
    private int retNCasillasOcupadas() {
      int nCasillas=0;
        for (int r = minLInd; r <= maxLInd; r++) {
            for (int c = minLInd; c <= maxLInd; c++) {
                if (tab[r][c]!= unsN){
                    nCasillas++;
                }
            }
        }
        return nCasillas;
    }
}
