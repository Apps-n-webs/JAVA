// Fig. 13.9: AssertTest.java
// Uses assert to check that an absolute value is positive
import java.util.Scanner;

public class AssertTest
{
   public static void main( String args[] )
   {
      Scanner input = new Scanner( System.in );
      
      System.out.print( "Enter a number between 0 and 10: " );
      int number = input.nextInt();
      
      // assert that the absolute value is >= 0
      assert ( number >= 0 && number <= 10 ) : "bad number: " + number;
      
      System.out.printf( "You entered %d\n", number );
   } // end main
} // end class AssertTest

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