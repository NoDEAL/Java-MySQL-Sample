import java.sql.*;

public class MySQL {

    private Statement mStatment;
    private ResultSet mResultSet;
    private Connection mConnection;

    public MySQL(final String url, final String port, final String databaseName, final String id, final String password) throws SQLException, ClassNotFoundException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage().toString());
        }

        mConnection = DriverManager.getConnection("jdbc:mysql://" + url + ":" + port + "/" + databaseName, id, password);
        mStatment = mConnection.createStatement();
    }

    public final void query(String query) throws SQLException {
        mResultSet = mStatment.executeQuery(query);

        if (mStatment.execute(query)) mResultSet = mStatment.getResultSet();

        while (mResultSet.next()) {
            String str = mResultSet.getNString(1);
            System.out.println(str);
        }
    }
}
