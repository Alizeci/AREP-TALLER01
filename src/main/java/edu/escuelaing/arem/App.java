package edu.escuelaing.arem;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Server is starting..." );
        get("/hello", (req, res) -> "Hello Heroku");
    }
}
