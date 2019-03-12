package DAO;

import java.util.List;

import com.jdbc.jdbcprograms.jdbc.Post;

public interface PostDAO {
		
		int insert(Post post);
		int update(Post post);
		int delete(int id);
		List<Post> view();
		Post view(int id);

}
