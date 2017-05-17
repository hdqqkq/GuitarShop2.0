
import org.junit.Test;
import cn.guitar.dao.GuitarSpecDaoImpl;
import cn.guitar.domain.Guitar;
import cn.guitar.domain.GuitarSpec;
import cn.guitar.service.GuitarService;
import cn.guitar.service.GuitarServiceDB;



	public class GuitarSpecServiceimplTest {
		@Test
		public void Search(){
			Guitar searchGuitar=new Guitar("11277", 1499.95,new GuitarSpec("collings", "CJ", "acoustic", "indian rosewood", "sitka")); 
			GuitarService GuitarService=new GuitarServiceDB();
			GuitarService.Search(searchGuitar);		
			System.out.println(GuitarService.Search(searchGuitar).get(0).getPrice());
		}
		@Test
		public void Search2(){
			Guitar searchGuitar=new Guitar("11277", 1499.95,new GuitarSpec("collings", "CJ", "acoustic", "indian rosewood", "sitka")); 
			GuitarServiceDB GuitarServiceimpl=new GuitarServiceDB();
			GuitarSpecDaoImpl GuitarDaoimpl=new GuitarSpecDaoImpl();
			GuitarServiceimpl.setGuitarDao(GuitarDaoimpl);
			GuitarServiceimpl.Search(searchGuitar);		
			System.out.println(GuitarServiceimpl.Search(searchGuitar).get(0).getPrice());
			System.out.println("serialNumber: "+GuitarServiceimpl.Search(searchGuitar).get(0).getSerialNumber());
			System.out.println("price: "+GuitarServiceimpl.Search(searchGuitar).get(0).getPrice());
			System.out.println("builder: "+GuitarServiceimpl.Search(searchGuitar).get(0).getSpec().getBuilder());
			System.out.println("model: "+GuitarServiceimpl.Search(searchGuitar).get(0).getSpec().getModel());
			System.out.println("type: "+GuitarServiceimpl.Search(searchGuitar).get(0).getSpec().getType());
			System.out.println("backWood: "+GuitarServiceimpl.Search(searchGuitar).get(0).getSpec().getBackWood());
			System.out.println("topWood: "+GuitarServiceimpl.Search(searchGuitar).get(0).getSpec().getTopWood());
		}
		
			
	}


