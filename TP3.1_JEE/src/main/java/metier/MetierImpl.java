package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetierImpl  implements ImetierCatalogue {

	@Override
	public List<Boisson> getBoissonsParMotCle(String mc) {
		List<Boisson> bois= new ArrayList<Boisson>();
		 Connection conn=SingletonConnection.getConnection();
		 try {
		PreparedStatement ps= conn.prepareStatement("select * from boissons where NOM_Boisson LIKE ?");
		ps.setString(1, "%"+mc+"%");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		Boisson b= new Boisson();
		b.setIdBoisson(rs.getLong("ID_Boisson"));
		b.setNomBoisson(rs.getString("NOM_Boisson"));
		b.setPrix(rs.getDouble("PRIX"));
		bois.add(b);
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return bois;
	}

	@Override
	public void addBoisson(Boisson b) {
		// TODO Auto-generated method stub
		
	}

}
