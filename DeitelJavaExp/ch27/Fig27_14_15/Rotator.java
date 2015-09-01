// Fig. 27.14: Rotator.java
// A JavaBean that rotates advertisements.
package com.deitel.jhtp6.jsp.beans;

public class Rotator 
{
   private String images[] = { "images/advjHTP1.jpg",
      "images/cppHTP4.jpg", "images/iw3HTP2.jpg",
      "images/jwsFEP1.jpg", "images/vbnetHTP2.jpg" };
      
   private String links[] = {
      "http://www.amazon.com/exec/obidos/ASIN/0130895601/" + 
         "deitelassociatin",
      "http://www.amazon.com/exec/obidos/ASIN/0130384747/" + 
         "deitelassociatin",
      "http://www.amazon.com/exec/obidos/ASIN/0130308978/" + 
         "deitelassociatin",
      "http://www.amazon.com/exec/obidos/ASIN/0130461342/" + 
         "deitelassociatin",
      "http://www.amazon.com/exec/obidos/ASIN/0130293636/" + 
         "deitelassociatin" };
         
   private int selectedIndex = 0;

   // returns image file name for current ad  
   public String getImage()
   {
      return images[ selectedIndex ];
   } // end method getImage

   // returns the URL for ad's corresponding Web site
   public String getLink()
   {
      return links[ selectedIndex ];
   } // end method getLink

   // update selectedIndex so next calls to getImage and 
   // getLink return a different advertisement
   public void nextAd()
   {
      selectedIndex = ( selectedIndex + 1 ) % images.length;
   } // end method nextAd
} // end class Rotator


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
