package implementazionePostgresDAO;

import dao.ListinoDAO;
import database.ConnessioneDatabase;

import java.sql.*;
import java.util.ArrayList;

/**
 * The type Listino implementazione postgres dao.
 */
public class ListinoImplementazionePostgresDAO implements ListinoDAO {

    private Connection connection;

    /**
     * Instantiates a new Listino implementazione postgres dao.
     */
    public ListinoImplementazionePostgresDAO() {
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    public void leggiListinoDB(String citta, ArrayList<String> nomiSocieta, ArrayList<Float> prezziSocieta) {
        // TODO Auto-generated method stub
        try {
            PreparedStatement leggiListinoPS = connection.prepareStatement(
                    "SELECT * FROM \"Societa\" WHERE \"CittaBorsa\"='"+citta+"'");
            ResultSet rs = leggiListinoPS.executeQuery();

            while (rs.next()) {
                nomiSocieta.add(rs.getString("Nome"));
                prezziSocieta.add(rs.getFloat("PrezzoAzione"));
            }
            rs.close();
            leggiListinoPS.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
