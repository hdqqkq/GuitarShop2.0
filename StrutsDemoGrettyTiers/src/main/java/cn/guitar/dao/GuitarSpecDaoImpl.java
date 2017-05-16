package cn.guitar.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import cn.guitar.dbutil.DBUtil;
import cn.guitar.domain.Guitar;
import cn.guitar.domain.GuitarSpec;


public class GuitarSpecDaoImpl implements GuitarSpecDao {

	private List<Guitar> guitars;
	private String sql;
	private PreparedStatement pstmt;
	public GuitarSpecDaoImpl() {
		guitars=new LinkedList<Guitar>();
	}
	public List<Guitar> getGuitarLinkedList(){
		sql="select * from guitar;"; 
			try {
				pstmt =DBUtil.getConnection().prepareStatement(sql);      			
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()){
					String serialNumber = rs.getString("serialNumber");
			        Double price = rs.getDouble("price");
			        String builder = rs.getString("builder");
			        String model = rs.getString("model");
			        String type = rs.getString("type");
			        String backWood = rs.getString("backWood");
			        String topWood = rs.getString("topWood");
			        Guitar guitar=new Guitar(serialNumber,price,new GuitarSpec(builder,model,type,backWood,topWood));
			        guitars.add(guitar);
				}
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return guitars;
		
	}

	@Override
	public List<Guitar> Search(Guitar searchGuitar) {
		// TODO Auto-generated method stub
		guitars=getGuitarLinkedList();
		List<Guitar> matchingGuitars = new LinkedList<Guitar>();
	    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
	      Guitar guitar = (Guitar)i.next();
	      if (guitar.getSpec().matches(searchGuitar.getSpec()))
	        matchingGuitars.add(guitar);
	    }
	    return matchingGuitars;
	  
}
}
