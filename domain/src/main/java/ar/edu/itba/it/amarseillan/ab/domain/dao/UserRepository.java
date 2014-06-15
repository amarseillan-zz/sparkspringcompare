package ar.edu.itba.it.amarseillan.ab.domain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.edu.itba.it.amarseillan.ab.domain.model.User;

public class UserRepository extends PostgresRepository<User> {

	private static UserRepository instance;

	public static synchronized UserRepository getInstance() {
		if (instance == null) {
			instance = new UserRepository();
		}
		return instance;
	}

	private UserRepository() {
		super();
	}

	public User get(Long id) {
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = source.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM POSTS WHERE ID=?");

			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setId(id);
				user.setEmail(rs.getString("EMAIL"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<User> getAll() {
		Connection connection = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();
		try {
			connection = source.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM USERS");

			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getLong("ID"));
				user.setEmail(rs.getString("EMAIL"));
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Long save(User elem) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long update(User elem) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
