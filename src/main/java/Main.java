
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import java.lang.reflect.Array;
import java.util.*;
import javax.swing.SwingUtilities;

public class Main extends JFrame{
    
    

    
	private static int ekranX = 620;
	private static int ekranY = 620;
      static  public int[][] permforRandom = new int[120][5];
        
    public static void main(String[] args) throws IOException, InterruptedException {
    
    
        
        Main frame = new Main();
    frame.setSize(ekranX, ekranY);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    
    
    
    SudokuTahtası tahta = new SudokuTahtası();
    frame.add(tahta);
    
    
    frame.setTitle("Samuray Sudoku Cozucu");
     
        frame.setVisible(true);
        
             Mapp sayilar = new Mapp();
    frame.getRootPane().setGlassPane(sayilar);
    frame.getGlassPane().setVisible(true);
        
        /*
                    TimeUnit.MILLISECONDS.sleep(3000);
           
            
            myThread object1 = new myThread(0,sayilar.getMap());
            object1.start(); 
            object1.join();
           
            myThread object2 = new myThread(1,sayilar.getMap());
            object2.start(); 
           object2.join();
           
            myThread object3 = new myThread(2,sayilar.getMap());
            object3.start(); 
           object3.join();
           
            myThread object4 = new myThread(3,sayilar.getMap());
            object4.start(); 
           object4.join();
           
            myThread object5 = new myThread(4,sayilar.getMap());
            object5.start(); 
           object5.join();
           
             // sayilar.kactanesicozuldu = 0;
        */
        
        
         Permutations<Integer> perm = new Permutations<Integer>(new Integer[]{0,1,2,3,4});
   /* int count = 0;
    while(perm.hasNext()){
        System.out.println(Arrays.toString(perm.next()).charAt(count));
        count++;
    }
    System.out.println("total: " + count);
        
          
    */
   

  


        for (int i = 0; i < 120; i++) {
            int asdf = 1;
              String ax;
    ax = Arrays.toString(perm.next());
            for (int j = 0; j < 5; j++) {
                   permforRandom[i][j] = Character.getNumericValue(ax.charAt(asdf));
                    asdf = asdf +3;
            }
        
            
        }
     
        
        
   
        int qwe = 0;
        while(sayilar.cozuldumu){
            System.out.println(qwe);
            
             frame.getRootPane().getGlassPane().repaint();
            
            myThread object1 = new myThread(permforRandom[qwe][0],sayilar.getMap());
            object1.start(); 
           object1.join();
           
            myThread object2 = new myThread(permforRandom[qwe][1],sayilar.getMap());
            object2.start(); 
           object2.join();
           
            myThread object3 = new myThread(permforRandom[qwe][2],sayilar.getMap());
            object3.start(); 
           object3.join();
           
            myThread object4 = new myThread(permforRandom[qwe][3],sayilar.getMap());
            object4.start(); 
           object4.join();
           
            myThread object5 = new myThread(permforRandom[qwe][4],sayilar.getMap());
            object5.start(); 
           object5.join();
               
           qwe++;
           if(qwe == 120)
           break;
           
                   sayilar.kactanesicozuldu = 0;
                  
                   if(sayilar.cozuldumu)
                   {sayilar = new Mapp();
           
                 SwingUtilities.updateComponentTreeUI(frame);
                 frame.repaint();
                 sayilar.repaint();
                 frame.getRootPane().setGlassPane(sayilar);
                 frame.getGlassPane().setVisible(true);
                 sayilar.repaint();
                 frame.repaint();
             
          
                   }
                   else
                   {   
                     
                       break;
                   
                   }
       
        }
   
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
   static class Permutations<E> implements  Iterator<E[]>{

    private E[] arr;
    private int[] ind;
    private boolean has_next;

    public E[] output;//next() returns this array, make it public

    Permutations(E[] arr){
        this.arr = arr.clone();
        ind = new int[arr.length];
        //convert an array of any elements into array of integers - first occurrence is used to enumerate
        Map<E, Integer> hm = new HashMap<E, Integer>();
        for(int i = 0; i < arr.length; i++){
            Integer n = hm.get(arr[i]);
            if (n == null){
                hm.put(arr[i], i);
                n = i;
            }
            ind[i] = n.intValue();
        }
        Arrays.sort(ind);//start with ascending sequence of integers


        //output = new E[arr.length]; <-- cannot do in Java with generics, so use reflection
        output = (E[]) Array.newInstance(arr.getClass().getComponentType(), arr.length);
        has_next = true;
    }

    public boolean hasNext() {
        return has_next;
    }

    /**
     * Computes next permutations. Same array instance is returned every time!
     * @return
     */
    public E[] next() {
        if (!has_next)
            throw new NoSuchElementException();

        for(int i = 0; i < ind.length; i++){
            output[i] = arr[ind[i]];
        }


        //get next permutation
        has_next = false;
        for(int tail = ind.length - 1;tail > 0;tail--){
            if (ind[tail - 1] < ind[tail]){//still increasing

                //find last element which does not exceed ind[tail-1]
                int s = ind.length - 1;
                while(ind[tail-1] >= ind[s])
                    s--;

                swap(ind, tail-1, s);

                //reverse order of elements in the tail
                for(int i = tail, j = ind.length - 1; i < j; i++, j--){
                    swap(ind, i, j);
                }
                has_next = true;
                break;
            }

        }
        return output;
    }

    private void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public void remove() {

    }
}
    
    
          }
          
          
           
           
           
        
     
  
     

    
    

