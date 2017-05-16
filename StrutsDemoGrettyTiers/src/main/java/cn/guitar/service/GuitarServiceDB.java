package cn.guitar.service;
import java.util.List;
import cn.guitar.dao.GuitarSpecDao;
import cn.guitar.dao.GuitarSpecDaoImpl;
import cn.guitar.domain.Guitar;
import cn.guitar.service.GuitarService;

public class GuitarServiceDB implements GuitarService{
	private GuitarSpecDao guitarDao;
	public void setGuitarDao(GuitarSpecDao guitarDao) {
		this.guitarDao = guitarDao;
	}
	@Override
	public List<Guitar> Search(Guitar searchGuitar) {
		// TODO Auto-generated method stub
		GuitarSpecDao GuitarDaoimpl=new GuitarSpecDaoImpl();
		setGuitarDao(GuitarDaoimpl);
		return guitarDao.Search(searchGuitar);
	}

}	