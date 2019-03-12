package Crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.jdbcprograms.jdbc.Comments;

import DAO.PostDAO;

public class CommentDAOImpl implements CommentDAO {

	private static Connection con;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int insert(Comments comments) {
		int res = -1;
		try {
			PreparedStatement pst = con.prepareStatement("insert into Comments (cmtbody) values(?)");

			pst.setString(1, comments.getCmtBody());
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public int update(Comments comments) {
		int res = -1;
		try {
			PreparedStatement pst = con.prepareStatement("update Comments set cmtbody = ? where Cid = ?");

			pst.setString(1, comments.getCmtBody());
			pst.setInt(2, comments.getCid());
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public int delete(int cid) {
		int res = -1;
		try {
			PreparedStatement pst = con.prepareStatement("delete from Comments where id = ?");
			pst.setInt(1, cid);
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
		}
	
	public List<Comments> view() {

		ArrayList<Comments> list = new ArrayList<Comments>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from Comments");
			while (rs.next()) {
				list.add(new Comments(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

//	public Comments view(int cid) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
