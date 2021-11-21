package com.example.eventproject.eventProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import com.example.eventproject.eventProject.Models.Event;
import com.example.eventproject.eventProject.Util.DBUtil;
import com.example.eventproject.eventProject.Util.Util;


class App{
	
    static int result = 1;
    static Connection connection = null;
    static Statement statement = null;
    
	public static void main(String[]args) throws Exception{
		
		String fileName = "logfile.txt";
		String filePath = System.getProperty("user.dir") +
				"/src/main/java/com/example/eventproject/eventProject/" + fileName;

        try {
        	ArrayList<Event> events = Util.preProcess(filePath);
        	initializeConnection();
            
            statement.executeUpdate(DBUtil.createTableStatement());
            System.out.println("table with name events successfully created into DB");
            
            for(Event event : events) {
                result = statement.executeUpdate(DBUtil.insertEventQuery(event));
            }
            System.out.println("All events pushed successfully into DB");
        }  catch (Exception e) {
            e.printStackTrace(System.out);
        }
	}

	private static void initializeConnection() throws Exception{
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
        statement = connection.createStatement();
	}
}