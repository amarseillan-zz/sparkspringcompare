package ar.edu.itba.it.amarseillan.ab.domain.dao;

import org.postgresql.jdbc2.optional.PoolingDataSource;

public abstract class PostgresRepository<T> implements Repository<T> {

	protected static PoolingDataSource source;

	public PostgresRepository() {
		setSource();
	}
	
	private static synchronized void setSource() {
		if (source == null) {
			source = new PoolingDataSource();
			source.setDataSourceName("A Data Source");
			source.setServerName("localhost");
			source.setPortNumber(5432);
			source.setDatabaseName("blog");
			source.setUser("postgres");
			source.setPassword("postgres");
			source.setMaxConnections(20);
		}
	}
}
