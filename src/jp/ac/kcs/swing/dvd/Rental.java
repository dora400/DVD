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

    //DVDの登録
	public static void insertDvd(String code, String title) {
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO dvd (code, title, is_lent) VALUES (?,?,false)")){
			ps.setString(1,code);
			ps.setString(2,title);
			ps.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
    
    //DVDを貸出状態に更新する処理 
	public static void lendDvd(String memberid, String DVDCode) {
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement("UPDATE dvd SET is_lent = true WHERE code = ?")){
			ps.setString(1,DVDCode);
			ps.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}



    //DVDの返却済み
	public static void returnDvd(String code) {
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement("UPDATE dvd SET is_lent = false WHERE code = ?")){
			ps.setString(1,code);
			ps.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}



    //貸し出し中のDVDリスト
	public static List<String> getLentDvds() {
		List<String> dvds =new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT code, title FROM dvd WHERE is_lent = true")){
			while(rs.next()) {
				dvds.add(rs.getString("code") + "-" + rs.getString("title"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dvds;
	}


}
