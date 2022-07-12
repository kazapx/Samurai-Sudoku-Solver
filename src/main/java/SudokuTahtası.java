
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.swing.JPanel;


public class SudokuTahtası extends JPanel{
    
   
    int oran = 25;
    int ince_kenar = 1;
    int kalın_kenar = 2;
    Color kalın_renk = new Color(20,20,130);
    Color ince_renk = new Color(220,50,100);
    public SudokuTahtası() throws IOException{
    super();
        
       
        setBackground(Color.white);
     
        
    repaint();
    }

    @Override
    
   public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);
        
        
        for (int i = 1; i <11 ; i++) {
         if((i-1) % 3 == 0)
         {g2.setStroke(new BasicStroke(kalın_kenar)); g.setColor(kalın_renk);}
         else
         {g2.setStroke(new BasicStroke(ince_kenar));  g.setColor(ince_renk);}
          
            g.drawLine(oran, i*oran, 10*oran, i*oran);
            g.drawLine(i*oran, oran, i*oran, 10*oran);
        }
        
        for (int i = 1; i <11 ; i++) {
         if((i-1) % 3 == 0)
         {g2.setStroke(new BasicStroke(kalın_kenar)); g.setColor(kalın_renk);}
         else
          {g2.setStroke(new BasicStroke(ince_kenar));  g.setColor(ince_renk);}  
          
            g.drawLine(13*oran, i*oran, 22*oran, i*oran);
            g.drawLine((i+12)*oran, oran, (i+12)*oran, 10*oran);
        }
        
        for (int i = 1; i <11 ; i++) {
         if((i-1) % 3 == 0)
         {g2.setStroke(new BasicStroke(kalın_kenar)); g.setColor(kalın_renk);}
         else
          {g2.setStroke(new BasicStroke(ince_kenar));  g.setColor(ince_renk);} 
          
            g.drawLine(oran, (i+12)*oran, 10*oran, (i+12)*oran);
            g.drawLine(i*oran, 13*oran, i*oran, 22*oran);
        }
        
        for (int i = 1; i <11 ; i++) {
         if((i-1) % 3 == 0)
         {g2.setStroke(new BasicStroke(kalın_kenar)); g.setColor(kalın_renk);}
         else
          {g2.setStroke(new BasicStroke(ince_kenar));  g.setColor(ince_renk);}  
          
            g.drawLine(13*oran, (i+12)*oran, 22*oran, (i+12)*oran);
            g.drawLine((i+12)*oran, 13*oran, (i+12)*oran, 22*oran);
        }
        
         for (int i = 1; i <11 ; i++) {
         if((i-1) % 3 == 0)
         {g2.setStroke(new BasicStroke(kalın_kenar)); g.setColor(kalın_renk);}
         else
         {g2.setStroke(new BasicStroke(ince_kenar));  g.setColor(ince_renk);} 
          
            g.drawLine(7*oran, (i+6)*oran, 16*oran, (i+6)*oran);
            g.drawLine((i+6)*oran, 7*oran, (i+6)*oran, 16*oran);
        }
         
        
         
        
 
         
    
    }
    
    
}
