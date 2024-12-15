import java.util.*;
import java.io.*;

public class Consumer extends Thread
{  public Consumer(PipedInputStream is)
   {   in = new DataInputStream(is);
   }

   public void run()
   {  for(;;)
      {  try
         {  double avg = in.readDouble();
            System.out.println("Current average is " + avg);
            old_avg = avg;
         }
         catch(IOException e)
         {  System.out.println("Error: " + e);
         }
      }
   }

   private double old_avg = 0;
   private DataInputStream in;
}

