import java.util.*;
import java.io.*;

public class Producer extends Thread
{  public Producer(PipedOutputStream os)
   {  out = new DataOutputStream(os);
   }

   public void run()
   {  while (true)
      {  try
         {  double num = rand.nextDouble();
            out.writeDouble(num);
            out.flush();
            sleep(Math.abs(rand.nextInt() % 1000));
         }
         catch(Exception e)
         {  System.out.println("Error: " + e);
         }
      }
   }

   private DataOutputStream out;
   private Random rand = new Random();
}
