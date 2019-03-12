package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.jdbcprograms.jdbc.Post;

public class PostDAOImpl implements PostDAO {

	private static Connection con;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

	public int insert(Post post) {
		int res = -1;
		try {
			PreparedStatement pst = con.prepareStatement("insert into post (title,body) values(?,?)");
			pst.setString(1, post.getTitle());
			pst.setString(2, post.getBody());
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public int update(Post post) {
		int res = -1;
		try {
			PreparedStatement pst = con.prepareStatement("update post set title = ?, body = ? where id = ?");
			pst.setString(1, post.getTitle());
			pst.setString(2, post.getBody());
			pst.setInt(3, post.getId());
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public int delete(int id) {
		int res = -1;
		try {
			PreparedStatement pst = con.prepareStatement("delete from post where id = ?");
			pst.setInt(1, id);
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public List<Post> view() {

		ArrayList<Post> list = new ArrayList<Post>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from posts");
			while (rs.next()) {
				list.add(new Post(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public Post view(int id) {
		Post post = new Post();
		try {
			PreparedStatement pst = con.prepareStatement("select * from posts where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				post = new Post(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return post;
	}

}
