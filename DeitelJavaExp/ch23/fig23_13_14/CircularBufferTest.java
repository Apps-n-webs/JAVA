// Fig 23.14: CircularBufferTest.java
// Application shows two threads manipulating a circular buffer.
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CircularBufferTest
{
   public static void main( String[] args )
   {
      // create new thread pool with two threads
      ExecutorService application = Executors.newFixedThreadPool( 2 );

      // create CircularBuffer to store ints
      Buffer sharedLocation = new CircularBuffer();

      try // try to start producer and consumer
      {
         application.execute( new Producer( sharedLocation ) );
         application.execute( new Consumer( sharedLocation ) );
      } // end try
      catch ( Exception exception )
      {
         exception.printStackTrace();
      } // end catch

      application.shutdown();
   } // end main
} // end class CircularBufferTest



/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/