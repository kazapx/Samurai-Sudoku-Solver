
public class myThread extends Thread{
    
    int i;
    Mapp sayilar;
    
    public myThread(int i, Mapp sayilar){
    this.i = i;
    this.sayilar = sayilar;
    }
    
     @Override
    public void run() {
       
         SudokuSolver solver = new SudokuSolver(i,sayilar);
        //repaint();
    }
}
