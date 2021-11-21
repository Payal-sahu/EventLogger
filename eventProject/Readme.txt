(1)To create a database use this command --> java -cp lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:testdb --dbname.0 testdb
(2)To view the database use this command --> java -cp lib/hsqldb.jar org.hsqldb.util.DatabaseManagerSwing
       to connect with HSQL database Manager,
      (i) Driver link --> org.hsqldb.jdbc.JDBCDriver
      (ii) URL --> jdbc:hsqldb:hsql://localhost/testdb

(3)To start this app, run the main method in App.java Class