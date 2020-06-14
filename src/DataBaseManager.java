import java.sql.*;
import java.util.ArrayList;


public class DataBaseManager {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;

    public DataBaseManager() {

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:obiective.db");
            statement = connection.createStatement();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }


    //returneaza o lista cu toate obiectivele care nu sunt gata
    public ArrayList<Obiectiv> getAllObjectifs(int optionDone) {
        ArrayList<Obiectiv> lista = new ArrayList<>();
        ResultSet rez;
        String querry;
        String nume, descriptie;
        boolean done;
        String data;

        if (optionDone == 1)
            querry = "select * from Obiective";
        else
            querry = "select * from Obiective where Done=0 ";


        try {
            rez = statement.executeQuery(querry);

            while (rez.next()) {
                nume = rez.getString(2);
                done = rez.getBoolean(3);
                data = rez.getString(4);
                descriptie = rez.getString(5);
                lista.add(new Obiectiv(nume, done, descriptie, data));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void insertObiectif(Obiectiv obiectiv) {
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("insert into Obiective (Nume,Done,Data,Descriere) values(?,?,?,?)");
            preparedStatement.setString(1, obiectiv.getNumeObiectiv());
            preparedStatement.setBoolean(2, obiectiv.isDone());
            preparedStatement.setString(3, obiectiv.getDate());
            preparedStatement.setString(4, obiectiv.getDescription());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public void updateStatus(String nume) {

        try {
            PreparedStatement statement = connection.prepareStatement("update Obiective set Done=1 where Nume=?");
            statement.setString(1, nume);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
