package models.managers;
import java.sql.*;

public abstract class BDDManager {
    protected Connection db = null;
    protected Statement st = null;
    protected ResultSet rs = null;

    /* CONFIG BDD */
    private String url = "jdbc:mysql://localhost/";
    private String user = "root";
    private String password = "";

    /**
     * Test la connection à la bdd
     * @throws SQLException renvoie une erreur si la connection est dead
     */
    public void checkConnection() throws SQLException{
        this.start();
        this.stop();
    }

    /**
     * Demarre la connection a la bdd
     * @throws SQLException
     */
    public void start() throws SQLException{
            db = DriverManager.getConnection(url, user, password);
    }

    /**
     * Stop la connection a la bdd
     * @throws SQLException
     */
    public void stop() throws SQLException{
            if(db != null){
                db.close();
            }
            if(st != null) {
                st.close();
            }
            if(rs != null){
                rs.close();
            }
    }
}
