package ar.edu.itba.it.amarseillan.ab.domain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.edu.itba.it.amarseillan.ab.domain.model.Post;

public class PostRepository extends PostgresRepository<Post> {

	private static PostRepository instance;
	
	public static synchronized PostRepository getInstance() {
		if (instance == null) {
			instance = new PostRepository();
		}
		return instance;
	}
	
	private PostRepository() {
		super();
	}
	
	public Post get(Long id) {
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = source.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM POSTS WHERE ID=?");

			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				Post post = new Post();
				post.setId(id);
				post.setTitle(rs.getString("TITLE"));
				post.setDescription("DESCRIPTION");
				return post;
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

	public List<Post> getAll() {
		Connection connection = null;
		ResultSet rs = null;
		List<Post> posts = new ArrayList<Post>();
		try {
			connection = source.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM POSTS");

			rs = ps.executeQuery();
			while (rs.next()) {
				Post post = new Post();
				post.setId(rs.getLong("ID"));
				post.setTitle(rs.getString("TITLE"));
				post.setDescription(rs.getString("DESCRIPTION"));
				posts.add(post);
			}
			return posts;
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

	public Long save(Post elem) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long update(Post elem) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
