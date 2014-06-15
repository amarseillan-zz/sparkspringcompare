package ar.edu.itba.it.amarseillan.ab.domain.dao;

import java.util.List;

public interface Repository<T> {

	T get(Long id);
	
	List<T> getAll();
	
	Long save(T elem);
	
	Long update(T elem);
	
	boolean delete(Long id);
}
