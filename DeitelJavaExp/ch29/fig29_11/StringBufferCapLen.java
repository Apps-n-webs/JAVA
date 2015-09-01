// Fig. 29.11: StringBufferCapLen.java
// StringBuffer length, setLength, capacity and ensureCapacity methods.

public class StringBufferCapLen 
{
   public static void main( String args[] )
   {
      StringBuffer buffer = new StringBuffer( "Hello, how are you?" );

      System.out.printf( "buffer = %s\nlength = %d\ncapacity = %d\n\n",
         buffer.toString(), buffer.length(), buffer.capacity() );

      buffer.ensureCapacity( 75 );
      System.out.printf( "New capacity = %d\n\n", buffer.capacity() );

      buffer.setLength( 10 );
      System.out.printf( "New length = %d\nbuf = %s\n", 
         buffer.length(), buffer.toString() );
   } // end main
} // end class StringBufferCapLen


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
