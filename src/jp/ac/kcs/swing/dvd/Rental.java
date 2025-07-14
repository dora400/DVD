package jp.ac.kcs.swing.dvd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Rental {
    //DBアクセス＆ユーザー名とパスワード
	private final static String URL = "jdbc:mysql://localhost/library";
	private final static String USER = "root";
	private final static String PASS = "";

    //会員の登録
	public static void insertMember(String id, String name) {
		System.out.println(id + name);
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO member (id, name) VALUES (?,?)")){
			ps.setString(1,id);
			ps.setString(2,name);
			ps.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

    //本の登録
	public static void insertBook(String code, String title) {
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO book (code, title, is_lent) VALUES (?,?,false)")){
			ps.setString(1,code);
			ps.setString(2,title);
			ps.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
    
    //本を貸出状態に更新する処理 
	public static void lendBook(String memberid, String bookCode) {
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement("UPDATE book SET is_lent = true WHERE code = ?")){
			ps.setString(1,bookCode);
			ps.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}



    //本の返却済み
	public static void returnBook(String code) {
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement("UPDATE book SET is_lent = false WHERE code = ?")){
			ps.setString(1,code);
			ps.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}



    //貸し出し中の本リスト
	public static List<String> getLentBooks() {
		List<String> books =new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT code, title FROM book WHERE is_lent = true")){
			while(rs.next()) {
				books.add(rs.getString("code") + "-" + rs.getString("title"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}


}
