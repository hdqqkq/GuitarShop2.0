
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import cn.guitar.dao.GuitarSpecDao;
import cn.guitar.dao.GuitarSpecDaoImpl;
import cn.guitar.dbutil.DBUtil;
import cn.guitar.domain.Guitar;
import cn.guitar.domain.GuitarSpec;

public class FindGuitarTester {
	
	private String sql;
	private PreparedStatement pstmt;

      @Test
      public void getGuitarLinkedList(){
  			sql="select * from guitar;";  
  			List<Guitar> guitars=new LinkedList<Guitar>();
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
  			
  	    	System.out.println(guitars.get(0).getSerialNumber());

  	}
      @Test
      public void getGuitarLinkedList2(){
      	GuitarSpecDaoImpl gsp=new GuitarSpecDaoImpl();      	
      	System.out.println(gsp.getGuitarLinkedList().get(0).getSerialNumber());
      }
      @Test
      public void matches(){
    	
    	GuitarSpec gs=new GuitarSpec("1", "1", "1","1", "1");
    	GuitarSpec sh=new GuitarSpec("2", "1", "1","1", "1");

      	System.out.println(gs.matches(sh));
    	}
      @Test
      public void Search(){
      	GuitarSpecDao gd=new GuitarSpecDaoImpl(); 
		Guitar searchGuitar=new Guitar("11277", 1499.95,new GuitarSpec("Collings", "CJ", "acoustic","Indian Rosewood", "Sitka")); 
		gd.Search(searchGuitar);
      	System.out.println(gd.Search(searchGuitar).get(0).getSerialNumber());
      }

	
		
}
 
