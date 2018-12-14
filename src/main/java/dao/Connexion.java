package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class Connexion {

	private static Connection connect = null;

	private static final String ID = "svenlc";
	private static final String MDP = "DUMMYPASS";
	private static final String NOM_SERVEUR = "DESKTOP-RJ5OP06";
	private static final String NOM_BD = "Memory";

	public static Connection getInstance() {
		if (connect == null) {
			try {

				SQLServerDataSource ds = new SQLServerDataSource();
				ds.setUser(ID);
				ds.setPassword(MDP);
				ds.setServerName(NOM_SERVEUR);
				ds.setDatabaseName(NOM_BD);
				connect = ds.getConnection();
				System.out.println("Connecté.  Serveur : " + NOM_SERVEUR + ". Base de donnée : " + NOM_BD);
			} catch (SQLException e) {
				System.out.println("Echec connexion. Serveur : " + NOM_SERVEUR + ". Base de donnée : " + NOM_BD + ". " + e.getMessage() + e.getStackTrace());
			}
		}
		return connect;
	}

	public static ResultSet executeQuery(String requete) {
		Statement st = null;
		ResultSet rs = null;
		// System.out.println("requete = "+requete);
		try {
			st = getInstance().createStatement();
			rs = st.executeQuery(requete);
		} catch (SQLException e) {
			System.out
					.println("Echec de la tentative d'exécution de requete : " + requete + " [" + e.getMessage() + "]");
		}
		return rs;
	}

	public static boolean executeUpdate(String requete) {
		boolean succes = true;
		// System.out.println(requete);
		Statement st = null;
		try {
			st = getInstance().createStatement();
			st.executeUpdate(requete);
		} catch (SQLException e) {
			succes = false;
			System.out.println(
					"Echec de la tentative d'exécution de Mise à Jour : " + requete + " [" + e.getMessage() + "]");
		}
		return succes;
	}

	public static void fermer() {
		try {
			getInstance().close();
			System.out.println("deconnexion ok");
		} catch (SQLException e) {
			connect = null;
			System.out.println("echec de la fermeture");
		}
	}

	public static void afficheSelectEtoile(String table, String clauseWhere) {
		Statement st = null;
		ResultSet rs = null;

		String requete = ("SELECT * FROM [dbo].[" + table + "]" + clauseWhere);

		try {

			st = getInstance().createStatement();
			rs = st.executeQuery(requete);
			while (rs.next()) {
				System.out.println(rs.getString(1) + " : " + rs.getString(2) + " |");
			}
		} catch (SQLException e) {
			System.out.println("Echec de la tentative d'interrogation Select * : " + e.getMessage());
		}

	}

}
