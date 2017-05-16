package cn.guitar.dao;

import java.util.List;
import cn.guitar.domain.Guitar;

public interface GuitarSpecDao {

   	List<Guitar> Search(Guitar searchGuitar); 

}
