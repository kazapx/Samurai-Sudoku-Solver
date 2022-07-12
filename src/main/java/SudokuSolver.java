

 public class SudokuSolver {
  
  private static final int GRID_SIZE = 9;
  

  Mapp sayilar;
  int k;
  int[][] board;
  
  int[] krow = {0,0,6,12,12};
  int[] kcolumn = {0,12,6,0,12};
  int[] specialrow = {6,7,8,12,13,14};
  int[] specialcolumn = {6,7,8,12,13,14};
  
  
  public   SudokuSolver(int i, Mapp sayilar){
    
   this.sayilar = sayilar;
    k = i;
    //  System.out.println(k);
    //  System.out.println(krow[k]+" "+kcolumn[k]);
    
    board = sayilar.getMatrisint();
   
    
    basla();
   
    
    
  }
  
  
   private  void printBoard(int[][] board) {
    for (int row = krow[k]; row < krow[k]+GRID_SIZE; row++) {
      if (row % 3 == 0 && row != 0) {
        System.out.println("-----------");
      }
      for (int column = kcolumn[k]; column < kcolumn[k]+GRID_SIZE; column++) {
        if (column % 3 == 0 && column != 0) {
          System.out.print("|");
        }
        System.out.print(board[row][column]);
      }
      System.out.println();
    }
  }


   private  boolean isNumberInRow(int[][] board, int number, int row, int column) {
    
        for (int i = 0; i < specialcolumn.length; i++) {
           if(specialcolumn[i] == column)
           {
               for (int j = 0; j < specialrow.length; j++) {
                    if(specialrow[j] == row)
                    {
                        if((column == 6 || column == 7 || column == 8) && (row == 6 || row == 7 || row == 8) && k == 0)
                        {  
                            if (board[row][9] == number) {return true;}
                            else if (board[row][10] == number) {return true;}
                            else if (board[row][11] == number) {return true;}
                            else if (board[row][12] == number) {return true;}
                            else if (board[row][13] == number) {return true;}
                            else if (board[row][14] == number) {return true;} break;
                        }
                        if((column == 6 || column == 7 || column == 8) && (row == 6 || row == 7 || row == 8) && k == 2)
                        {
                            if (board[row][0] == number) {return true;}
                            else if (board[row][1] == number) {return true;}
                            else if (board[row][2] == number) {return true;}
                            else if (board[row][3] == number) {return true;}
                            else if (board[row][4] == number) {return true;}
                            else if (board[row][5] == number) {return true;}break;
                        }
                        if((column == 12 || column == 13 || column == 14) && (row == 6 || row == 7 || row == 8) && k == 1)
                        {
                            if (board[row][6] == number) {return true;}
                            else if (board[row][7] == number) {return true;}
                            else if (board[row][8] == number) {return true;}
                            else if (board[row][9] == number) {return true;}
                            else if (board[row][10] == number) {return true;}
                            else if (board[row][11] == number) {return true;}break;
                        }
                        if((column == 12 || column == 13 || column == 14) && (row == 6 || row == 7 || row == 8) && k == 2)
                        {
                            if (board[row][15] == number) {return true;}
                            else if (board[row][16] == number) {return true;}
                            else if (board[row][17] == number) {return true;}
                            else if (board[row][18] == number) {return true;}
                            else if (board[row][19] == number) {return true;}
                            else if (board[row][20] == number) {return true;}break;
                        }
                        if((column == 6 || column == 7 || column == 8) && (row == 12 || row == 13 || row == 14) && k == 3)
                        {
                            if (board[row][9] == number) {return true;}
                            else if (board[row][10] == number) {return true;}
                            else if (board[row][11] == number) {return true;}
                            else if (board[row][12] == number) {return true;}
                            else if (board[row][13] == number) {return true;}
                            else if (board[row][14] == number) {return true;}break;
                        }
                        if((column == 6 || column == 7 || column == 8) && (row == 12 || row == 13 || row == 14) && k == 2)
                        {
                            if (board[row][0] == number) {return true;}
                            else if (board[row][1] == number) {return true;}
                            else if (board[row][2] == number) {return true;}
                            else if (board[row][3] == number) {return true;}
                            else if (board[row][4] == number) {return true;}
                            else if (board[row][5] == number) {return true;}break;
                        }
                         if((column == 12 || column == 13 || column == 14) && (row == 12 || row == 13 || row == 14) && k == 4)
                        {
                            if (board[row][6] == number) {return true;}
                            else if (board[row][7] == number) {return true;}
                            else if (board[row][8] == number) {return true;}
                            else if (board[row][9] == number) {return true;}
                            else if (board[row][10] == number) {return true;}
                            else if (board[row][11] == number) {return true;}break;
                        }
                        if((column == 12 || column == 13 || column == 14) && (row == 12 || row == 13 || row == 14) && k == 2)
                        {
                            if (board[row][15] == number) {return true;}
                            else if (board[row][16] == number) {return true;}
                            else if (board[row][17] == number) {return true;}
                            else if (board[row][18] == number) {return true;}
                            else if (board[row][19] == number) {return true;}
                            else if (board[row][20] == number) {return true;}break;
                        }
                    }
                }    
            }     
       }
       
       for (int i = kcolumn[k]; i < GRID_SIZE+kcolumn[k]; i++) {
      if (board[row][i] == number) {
        return true;
      }
    }
    return false;
  }
  
   private  boolean isNumberInColumn(int[][] board, int number, int column, int row) {
   
      
       for (int i = 0; i < specialcolumn.length; i++) {
           if(specialcolumn[i] == column)
           {
               for (int j = 0; j < specialrow.length; j++) {
                    if(specialrow[j] == row)
                    {
                        if((column == 6 || column == 7 || column == 8) && (row == 6 || row == 7 || row == 8) && k == 0)
                        {   
                            if (board[9][column] == number) {return true;}
                            else if (board[10][column] == number) {return true;}
                            else if (board[11][column] == number) {return true;}
                            else if (board[12][column] == number) {return true;}
                            else if (board[13][column] == number) {return true;}
                            else if (board[14][column] == number) {return true;}break;
                        }
                        if((column == 6 || column == 7 || column == 8) && (row == 6 || row == 7 || row == 8) && k == 2)
                        {
                            if (board[0][column] == number) {return true;}
                            else if (board[1][column] == number) {return true;}
                            else if (board[2][column] == number) {return true;}
                            else if (board[3][column] == number) {return true;}
                            else if (board[4][column] == number) {return true;}
                            else if (board[5][column] == number) {return true;}break;
                        }
                        if((column == 12 || column == 13 || column == 14) && (row == 6 || row == 7 || row == 8) && k == 1)
                        {
                            if (board[9][column] == number) {return true;}
                            else if (board[10][column] == number) {return true;}
                            else if (board[11][column] == number) {return true;}
                            else if (board[12][column] == number) {return true;}
                            else if (board[13][column] == number) {return true;}
                            else if (board[14][column] == number) {return true;}break;
                        }
                        if((column == 12 || column == 13 || column == 14) && (row == 6 || row == 7 || row == 8) && k == 2)
                        {
                            if (board[0][column] == number) {return true;}
                            else if (board[1][column] == number) {return true;}
                            else if (board[2][column] == number) {return true;}
                            else if (board[3][column] == number) {return true;}
                            else if (board[4][column] == number) {return true;}
                            else if (board[5][column] == number) {return true;}break;
                        }
                        if((column == 6 || column == 7 || column == 8) && (row == 12 || row == 13 || row == 14) && k == 3)
                        {
                            if (board[6][column] == number) {return true;}
                            else if (board[7][column] == number) {return true;}
                            else if (board[8][column] == number) {return true;}
                            else if (board[9][column] == number) {return true;}
                            else if (board[10][column] == number) {return true;}
                            else if (board[11][column] == number) {return true;}break;
                        }
                        if((column == 6 || column == 7 || column == 8) && (row == 12 || row == 13 || row == 14) && k == 2)
                        {
                            if (board[15][column] == number) {return true;}
                            else if (board[16][column] == number) {return true;}
                            else if (board[17][column] == number) {return true;}
                            else if (board[18][column] == number) {return true;}
                            else if (board[19][column] == number) {return true;}
                            else if (board[20][column] == number) {return true;}break;
                        }
                         if((column == 12 || column == 13 || column == 14) && (row == 12 || row == 13 || row == 14) && k == 4)
                        {
                            if (board[6][column] == number) {return true;}
                            else if (board[7][column] == number) {return true;}
                            else if (board[8][column] == number) {return true;}
                            else if (board[9][column] == number) {return true;}
                            else if (board[10][column] == number) {return true;}
                            else if (board[11][column] == number) {return true;}break;
                        }
                        if((column == 12 || column == 13 || column == 14) && (row == 12 || row == 13 || row == 14) && k == 2)
                        {
                            if (board[15][column] == number) {return true;}
                            else if (board[16][column] == number) {return true;}
                            else if (board[17][column] == number) {return true;}
                            else if (board[18][column] == number) {return true;}
                            else if (board[19][column] == number) {return true;}
                            else if (board[20][column] == number) {return true;}break;
                        }
                    }
                }    
            }     
       }
           
      for (int i = krow[k]; i < GRID_SIZE+krow[k]; i++) {
      if (board[i][column] == number) {
        return true;
      }
    }      
    return false;
  }
  
   private  boolean isNumberInBox(int[][] board, int number, int row, int column) {
    int localBoxRow = row - row % 3;
    int localBoxColumn = column - column % 3;
    
    for (int i = localBoxRow; i < localBoxRow + 3; i++) {
      for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
        if (board[i][j] == number) {
          return true;
        }
      }
    }
    return false;
  }
  
   private  boolean isValidPlacement(int[][] board, int number, int row, int column) {
    return !isNumberInRow(board, number, row, column) &&
        !isNumberInColumn(board, number, column, row) &&
        !isNumberInBox(board, number, row, column);
  }
  
   private  boolean solveBoard(int[][] board) {  
    for (int row = 0; row < GRID_SIZE; row++) {
      for (int column = 0; column < GRID_SIZE; column++) {
        if (board[row+krow[k]][column+kcolumn[k]] == 0) {
          for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
            if (isValidPlacement(board, numberToTry, row+krow[k], column+kcolumn[k])) {
              board[row+krow[k]][column+kcolumn[k]] =  numberToTry;
                   
            /*  
              sayilar.characevir(board);
                    sayilar.repaint();
              
      
               try {
                    TimeUnit.MILLISECONDS.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SudokuSolver.class.getName()).log(Level.SEVERE, null, ex);
                }*/
              
              if (solveBoard(board)) {
                return true;
                
              }
              else {
                board[row+krow[k]][column+kcolumn[k]] = 0;
              }
            }
          }
          return false;
        }
      }
    }
    
    
    return true;
  }

    synchronized void basla() {
        if (solveBoard(board)) {
    System.out.println("Solved successfully!");
      sayilar.characevir(board);
     sayilar.repaint();
     sayilar.kactanesicozuldu++;
     
     if(sayilar.kactanesicozuldu == 5)
         sayilar.cozuldumu = false;
    
    }
    else {
     System.out.println("Unsolvable board :(");
      sayilar.cozuldumu = true;
    
      
      
    }
    
    }
  
  
  
}


