import java.util.*;
import java.io.*;

public class Filter extends Thread
{  public Filter(PipedInputStream is, PipedOutputStream os)
   {  in =  new DataInputStream(is);
      out = new DataOutputStream(os);
   }

   public void run()
   {  for (;;)
      {  try
         {  double x = in.readDouble();
            total += x;
            count++;
            if (count != 0) out.writeDouble(total / count);
         }
         catch(IOException e)
         {  System.out.println("Error: " + e);
         }
      }
   }

   private DataInputStream in;
   private DataOutputStream out;
   private double total = 0;
   private int count = 0;
}


