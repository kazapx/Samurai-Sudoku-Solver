

import java.awt.*;
import java.io.*;
import javax.swing.JComponent;



public class Mapp extends JComponent{

    int kactanesicozuldu = 0;
    
	 int oran = 25;
	private char[][] matris = new char[21][21];
boolean cozuldumu = true;
    
        int[][] matrisint = new int[21][21];    
       
	public Mapp() throws IOException, InterruptedException{
            
		openFile();
                
                intecevir();
               
             

              
	}

        
    public Mapp getMap(){
    return this;
    }    
     public int[][] getMatrisint() {
        return matrisint;
    }

    public void setMatrisint(int[][] matrisint) {
        this.matrisint = matrisint;
    } 
    
    public void setmatris(char[][] matris) {
        this.matris = matris;
    }
    public void setmatrisxy(int x,int y, char c){
	this.matris[x][y] = c ;
    }
     public char[][] getmatris(){
		return matris;
    }
    
    public char getmatrisxy(int x,int y){
		return matris[x][y];
    }
	
        	
	 public void paintComponent(Graphics g)
    {
        
        super.paintComponent(g);
       
         g.setFont(new Font("Helvetica", Font.PLAIN, oran-(oran/5)));
        
        for (int i = 0; i < 21; i++) {
            
            for (int j = 0; j < 21; j++) {
              if(getmatrisxy(j, i) == '*')
                  continue;
                g.drawString(String.valueOf(getmatrisxy(j, i)), (i+1)*oran+(oran/4), (j+2)*oran-(oran/5));
                
            }
            
        }
    } 
        
        
        
public void openFile() throws IOException{
	
     
        File filesudoku=new File("sudoku.txt");     //Creation of File Descriptor for input file
        if (!filesudoku.exists()) {
            filesudoku.createNewFile();
        }

        FileReader fr=new FileReader(filesudoku);   //Creation of File Reader object
        BufferedReader br=new BufferedReader(fr);  //Creation of BufferedReader object






        int c = 0;

        int k=0; //ilk satırda ilk kelimeyi atlamaması için

        char character;

        for (int i=0; i < 21; i++){

            if(k!=0){
            c = br.read();   //satır sonunu atlaması için
            character = (char) c;}

            k=1;

            for(int j=0;j<21;j++)         //Read char by Char
            {
                if (i>=9 && i<=11 || j>=9 && j<=11){
                    if(!(i>=6 && i<=8 || i>=12 && i<=14 || j>=6 && j<=8 || j>=12 && j<=14 || i>=9 && i<=11 && j>=9 && j<=11)){
                        matris[i][j] =' ';
                        continue;
                    }
                }

                c = br.read();
                character = (char) c;          //converting integer to char

                 if(character=='\n'){c = br.read();}
                 character = (char) c;


             //System.out.println(character);

                if (character=='*') {
                    matris[i][j]='*';
                }
               else if (Character.isDigit(character)){

                    matris[i][j] = character;
                }
            }
            //Display the Character
        }
/*
        System.out.println("* degeri="+Character.getNumericValue(matris[0][0]));

        for (int i=0; i < 21; i++)
        {
            for (int j=0; j < 21; j++)
            {
             System.out.print(matris[i][j]);
             System.out.print(" ");
            }
            System.out.println();
        }*/

}

    private void intecevir() {
        for (int i = 0; i < 21; i++) {
            
            for (int j = 0; j < 21; j++) {
              if(getmatrisxy(j, i) == '*')
                  matrisint[j][i] = 0;
              else if(getmatrisxy(j, i) == ' ')
                  matrisint[j][i] = -1;
              else
                  matrisint[j][i] = Character.getNumericValue(getmatrisxy(j, i));
              
              
            }
            
        }

    
    }

     public void characevir(int[][] board) {
	
        for (int i = 0; i < 21; i++) {
           
            for (int j = 0; j < 21; j++) {
                if((board[j][i]) == -1 || (board[j][i]) ==  0 )
                {  matris[j][i] = ' '; continue;}
                             
              matris[j][i] = (char) (board[j][i]+48); 
              
              
              
            }
            
        } 
    
    }

}

