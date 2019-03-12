package Crud;

import java.util.List;

import com.jdbc.jdbcprograms.jdbc.Comments;

public interface CommentDAO {
	int insert(Comments comments);
	int update(Comments comments);
	int delete(int cid);	
	List<Comments> view();
	//Comments view(int cid);

	
}
