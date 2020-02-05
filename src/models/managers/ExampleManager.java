package models.managers;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExampleManager extends BDDManager {

    public ArrayList<?> getAll() throws SQLException {
        // <-- initialiser une liste d'objet vide ici
        String query = ""; // <-- Requêtes ici
        this.start();
        st = db.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            // <-- Hydrater un objet ici et le mettre dans la liste d'objet
            // Ex: list.add(new Objet(rs.getString(ID_COLONNE_DANS_LA_BDD));
        }
        this.stop();
        return null; // <-- Renvoyer la liste d'objet ici
    }
}