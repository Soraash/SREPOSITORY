package com.jdbc.jdbcprograms.jdbc;

import java.util.List;
import java.util.Scanner;

import Crud.CommentDAOImpl;
import DAO.PostDAOImpl;

public class CommentsCrud {
	public static void main(String[] args) {

		CommentDAOImpl dao1 = new CommentDAOImpl();

		Scanner s = new Scanner(System.in);

		int doFlag = -1;

		do {
			System.out.println("1.Insert\n2.Update\n3.Delete\n4.View All Posts");
			int ch1 = s.nextInt();
			s.nextLine();
			switch (ch1) {
			case 1:

				System.out.println("Enter Comment body");
				Comments cmt = new Comments(0, s.nextLine());

				int res = dao1.insert(cmt);

				System.out.println("Rows inserted=" + res);

				break;

			case 2:
				System.out.println("Enter id of the Comments to be updated");
				int id = s.nextInt();
				s.nextLine();
				System.out.println("Enter new body of the Comments to be edited");

				res = dao1.update(new Comments(id, s.nextLine()));

				System.out.println("Rows updated=" + res);
				break;

			case 3:
				System.out.println("Enter id of the Comments to be deleted");
				id = s.nextInt();
				s.nextLine();
				res = dao1.delete(id);
				System.out.println("Comments deleted=" + res);
				break;

			case 4:

				List<Comments> list = dao1.view();

				for (Comments p : list) {
					System.out.println(p);
				}

				break;

			default:
				System.out.println("Invalid Input Choice");
			}

			System.out.println("RE RUN ? 1.YES\t2.NO");
			doFlag = s.nextInt();
			s.nextLine();

		} while (doFlag == 1);

	}

}
