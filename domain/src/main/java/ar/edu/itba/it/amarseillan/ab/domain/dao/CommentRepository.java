package ar.edu.itba.it.amarseillan.ab.domain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.edu.itba.it.amarseillan.ab.domain.model.Comment;

public class CommentRepository extends PostgresRepository<Comment> {

	private static CommentRepository instance;

	public static synchronized CommentRepository getInstance() {
		if (instance == null) {
			instance = new CommentRepository();
		}
		return instance;
	}

	private CommentRepository() {
		super();
	}
	
	public Comment get(Long id) {
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = source.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM COMMENTS WHERE ID=?");

			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				Comment comment = new Comment();
				comment.setId(id);
				comment.setPostId(rs.getLong("POSTID"));
				comment.setUserId(rs.getLong("USERID"));
				comment.setText(rs.getString("TEXT"));
				return comment;
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

	public List<Comment> getAll() {
		Connection connection = null;
		ResultSet rs = null;
		List<Comment> comments = new ArrayList<Comment>();
		try {
			connection = source.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM COMMENTS");

			rs = ps.executeQuery();
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setId(rs.getLong("ID"));
				comment.setPostId(rs.getLong("POSTID"));
				comment.setUserId(rs.getLong("USERID"));
				comment.setText(rs.getString("TEXT"));
				comments.add(comment);
			}
			return comments;
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

	public Long save(Comment elem) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long update(Comment elem) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
