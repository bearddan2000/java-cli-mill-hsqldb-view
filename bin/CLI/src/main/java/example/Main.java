package example;

import example.dto.*;

import org.apache.log4j.PropertyConfigurator;

public class Main {

  private static void printTables(Generic opt, String conn)
  {
    example.db.print.output.IOutput output = new example.db.print.output.ToConsole();
    for ( String tbl : opt.getTableNames())
      example.db.DBQuery.query(conn, tbl, output);
  }

  private static void sqlOperations(String driver, String conn)
  {
    Generic opt = new Generic(driver, conn);

    // dog tbl 0, 1, 6, 6

    // breedLookup tbl 2, 3

    // colorLookup tbl 4, 5

    // dog_expanded view 8

    for (int i=0;i<6;i+=2 ) {
      opt.operation("0"+i, SQLOPT.CREATE);
      opt.operation("0"+(i+1), SQLOPT.INSERT);
    }

    opt.operation("06", SQLOPT.INDEX);
    opt.operation("07", SQLOPT.INDEX);

    opt.operation("08", SQLOPT.VIEW);

    printTables(opt, conn);
  }

  public static void main(String[] args) {
    PropertyConfigurator.configure("/tmp/src/main/resources/log4j.xml");
    String databaseName = "test";

    // Create a variable for the connection string.
    String connectionStr = "jdbc:hsqldb:mem:" + databaseName;

    sqlOperations("org.hsqldb.jdbcDriver", connectionStr);
  }
}
