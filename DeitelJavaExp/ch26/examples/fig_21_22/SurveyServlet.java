// Fig. 26.21: SurveyServlet.java
// A Web-based survey that uses JDBC from a servlet.
package com.deitel.jhtp6.servlets;

import java.io.PrintWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SurveyServlet extends HttpServlet 
{
   private Connection connection;
   private Statement statement;

   // set up database connection and create SQL statement
   public void init( ServletConfig config ) throws ServletException
   {
      // attempt database connection and create Statement
      try 
      {
         Class.forName( config.getInitParameter( "databaseDriver" ) );
         connection = DriverManager.getConnection( 
            config.getInitParameter( "databaseName" ),
            config.getInitParameter( "username" ),
            config.getInitParameter( "password" ) );

         // create Statement to query database
         statement = connection.createStatement();
      } // end try
      // for any exception throw an UnavailableException to 
      // indicate that the servlet is not currently available
      catch ( Exception exception ) 
      {
         exception.printStackTrace();
         throw new UnavailableException( exception.getMessage() );
      } // end catch
   }  // end method init 

   // process survey response
   protected void doPost( HttpServletRequest request,
      HttpServletResponse response )
         throws ServletException, IOException
   {
      // set up response to client
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
      
      // read current survey response
      int value = 
         Integer.parseInt( request.getParameter( "animal" ) );
      String sql;

      // attempt to process a vote and display current results
      try 
      {
         // update total for current survey response
         sql = "UPDATE surveyresults SET votes = votes + 1 " +
               "WHERE id = " + value;
         statement.executeUpdate( sql );

         // get total of all survey responses
         sql = "SELECT sum( votes ) FROM surveyresults";
         ResultSet totalRS = statement.executeQuery( sql );
         totalRS.next(); // position to first record
         int total = totalRS.getInt( 1 );

         // get results
         sql = "SELECT surveyoption, votes, id FROM surveyresults " + 
            "ORDER BY id";
         ResultSet resultsRS = statement.executeQuery( sql );
         out.println( "<title>Thank you!</title>" );
         out.println( "</head>" );  
         
         out.println( "<body>" );  
         out.println( "<p>Thank you for participating." );
         out.println( "<br />Results:</p><pre>" );
         
         // process results
         int votes;
         
         while ( resultsRS.next() ) 
         {
            out.print( resultsRS.getString( 1 ) );
            out.print( ": " );
            votes = resultsRS.getInt( 2 );
            out.printf( "%.2f", ( double ) votes / total * 100 );
            out.print( "%  responses: " );
            out.println( votes );
         } // end while

         resultsRS.close();
         
         out.print( "Total responses: " );
         out.print( total );
         
         // end XHTML document
         out.println( "</pre></body></html>" );         
         out.close();
      } // end try
      // if database exception occurs, return error page
      catch ( SQLException sqlException ) 
      {
         sqlException.printStackTrace();
         out.println( "<title>Error</title>" );
         out.println( "</head>" );  
         out.println( "<body><p>Database error occurred. " );
         out.println( "Try again later.</p></body></html>" );
         out.close();
      } // end catch
   } // end method doPost

   // close SQL statements and database when servlet terminates
   public void destroy()
   {
      // attempt to close statements and database connection
      try 
      {
         statement.close();
         connection.close();
      } // end try
      // handle database exceptions by returning error to client
      catch( SQLException sqlException ) 
      {
         sqlException.printStackTrace();
      } // end catch
   } // end method destroy
} // end class SurveyServlet

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