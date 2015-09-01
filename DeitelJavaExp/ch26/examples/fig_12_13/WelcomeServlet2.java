// Fig. 26.12: WelcomeServlet2.java
// Processing HTTP get requests containing data.
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WelcomeServlet2 extends HttpServlet 
{   
   // process "get" request from client
   protected void doGet( HttpServletRequest request, 
      HttpServletResponse response )
         throws ServletException, IOException 
   {
      String firstName = request.getParameter( "firstname" );
      
      response.setContentType( "text/html" );
      PrintWriter out = response.getWriter();  
      
      // send XHTML document to client

      // start XHTML document
      out.println( "<?xml version = \"1.0\"?>" );

      out.printf( "%s%s%s", "<!DOCTYPE html PUBLIC", 
         " \"-//W3C//DTD XHTML 1.0 Strict//EN\"",
         " \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" );

      out.println( "<html xmlns = \"http://www.w3.org/1999/xhtml\">" );
      
      // head section of document
      out.println( "<head>" );
      out.println( 
         "<title>Processing get requests with data</title>" );
      out.println( "</head>" );
      
      // body section of document
      out.println( "<body>" );
      out.println( "<h1>Hello " + firstName + ",<br />" );
      out.println( "Welcome to Servlets!</h1>" );
      out.println( "</body>" );
      
      // end XHTML document
      out.println( "</html>" );
      out.close();  // close stream to complete the page
   } // end method doGet
} // end class WelcomeServlet2

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
 