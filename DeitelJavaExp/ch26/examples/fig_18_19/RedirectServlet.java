// Fig. 26.18: RedirectServlet.java
// Redirecting a user to a different Web page.
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RedirectServlet extends HttpServlet 
{   
   // process "get" request from client
   protected void doGet( HttpServletRequest request, 
      HttpServletResponse response )
         throws ServletException, IOException 
   {
      String location = request.getParameter( "page" );

      if ( location != null ) 
      {
         if ( location.equals( "deitel" ) )
            response.sendRedirect( "http://www.deitel.com" );
         else if ( location.equals( "welcome1" ) )
            response.sendRedirect( "welcome1" );
      } // end if

      // code that executes only if this servlet
      // does not redirect the user to another page
      response.setContentType( "text/html" );
      PrintWriter out = response.getWriter();  

      // start XHTML document
      out.println( "<?xml version = \"1.0\"?>" );

      out.printf( "%s%s%s", "<!DOCTYPE html PUBLIC", 
         " \"-//W3C//DTD XHTML 1.0 Strict//EN\"",
         " \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" );

      out.println( 
         "<html xmlns = \"http://www.w3.org/1999/xhtml\">" );

      // head section of document
      out.println( "<head>" );
      out.println( "<title>Invalid page</title>" );
      out.println( "</head>" );

      // body section of document
      out.println( "<body>" );
      out.println( "<h1>Invalid page requested</h1>" );
      out.println( "<p><a href = " + 
         "\"servlets/RedirectServlet.html\">" );
      out.println( "Click here to choose again</a></p>" );
      out.println( "</body>" );

      // end XHTML document
      out.println( "</html>" );
      out.close();  // close stream to complete the page  
   } // end method doGet
} // end class RedirectServlet

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
