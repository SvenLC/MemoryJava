package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import memory.Couleur;
import memory.Etat;
import memory.Symbole;
import memory.cartes.carte.CarteMemory;

public class CarteDAO extends DAO<CarteMemory> {

    private static final String DB = "[dbo].[Carte]";
    private static CarteDAO instance = null;

    public static CarteDAO getInstance() {

        if (instance == null) {

            instance = new CarteDAO();

        }

        return instance;
    }

    private CarteDAO() {
        super();
    }

    @Override
    public boolean create(CarteMemory obj) {

        Connection c = Connexion.getInstance();
        boolean rep = true;

        try {
            PreparedStatement pst = c.prepareStatement(
                    "INSERT INTO " + DB + " (couleur ,motif ,etat, imageId) VALUES(? , ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, obj.getCouleur().toString());
            pst.setString(2, Symbole.getStringFromSymbole(obj.getMotif()));
            pst.setString(3, obj.getEtat().toString());
            pst.setString(4, obj.getImage().toString());
            pst.executeUpdate();
            ResultSet res = pst.getGeneratedKeys();
            res.next();

            obj.setID(res.getInt(1));

        } catch (Exception e) {

            rep = false;
        }

        return rep;
    }

    @Override
    public CarteMemory read(int id) {

        Connection c = Connexion.getInstance();
        CarteMemory carte = new CarteMemory();

        try {
            PreparedStatement pst = c.prepareStatement("SELECT * FROM " + DB + " WHERE ID = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();

            res.next();
            carte.setID(res.getInt(1));
            carte.setCouleur(Couleur.getCouleurFromString(res.getString(2)));
            carte.setMotif(Symbole.getSymboleFromString(res.getString(3)));
            carte.setEtat(Etat.getEtatFromString(res.getString(4)));
            carte.setImage(res.getString(5));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return carte;
    }

    @Override
    public boolean update(CarteMemory obj) {

        Connection c = Connexion.getInstance();

        try {

            PreparedStatement pst = c.prepareStatement(
                    "UPDATE " + DB + "SET couleur = ?, motif = ?, etat = ?, imageId = ?, WHERE ID = ?");
            pst.setString(1, obj.getCouleur().toString());
            pst.setString(2, Symbole.getStringFromSymbole(obj.getMotif()));
            pst.setString(3, obj.getEtat().toString());
            pst.setString(4, obj.getImage().toString());
            pst.setInt(5, obj.getId());
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean delete(CarteMemory obj) {

        Connection c = Connexion.getInstance();
        int id = obj.getId();

        try {
            PreparedStatement pst = c.prepareStatement("DELETE FROM " + DB + "WHERE ID = ?");
            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}