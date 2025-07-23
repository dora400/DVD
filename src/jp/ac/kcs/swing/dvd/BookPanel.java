package jp.ac.kcs.swing.dvd;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookPanel extends JPanel {
    public BookPanel(MainFrame frame) {
        //レイアウトに新しいGridLayout(3, 2)
    	//レイアウトに新しいGridLayout(3, 2)
    	setLayout (new GridLayout(3,2));
        //ボタンやフィールド作成
        JTextField codeFiled=new JTextField();
        JTextField titleFiled=new JTextField();
        JButton registerBtn=new JButton("登録");
        JButton backBtn=new JButton("TOPへ戻る");
    	//登録ボタンが押されたらIDとタイトル
        registerBtn.addActionListener(e->{
  		DB.insertDvd(codeFiled.getText(), titleFiled.getText());
	    JOptionPane.showMessageDialog(this,"登録しました。");
        });
    	//TOPに戻るボタン
    	backBtn.addActionListener(e->frame.showPanel("TOP"));
    	//パネルに部品追加
    	add(new JLabel("DVDコード"));
    	add(codeFiled);
    	add(new JLabel("タイトル"));
    	add(titleFiled);
    	add(registerBtn);
    	add(backBtn);
    }
}