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
    	setLayout(new GridLayout(4, 2));


        //ボタンやフィールド作成
    	JButton registerBtn = new JButton("登録");
    	JTextField codeField = new JTextField(); 
    	JTextField titleField = new JTextField(); 

        //登録ボタンが押されたらIDとタイトル
    	registerBtn.addActionListener(e -> {
    		DB.insertBook(codeField.getText(), titleField.getText());
    		JOptionPane.showMessageDialog(this, "登録しました。");
    	});
        //TOPに戻るボタン
    	JButton baeckButton = new JButton("TOPへ");
        baeckButton.addActionListener(e -> frame.showPanel("TOP"));
        //パネルに部品追加
    	add(new JLabel("本のコード"));
    	add(codeField);
    	add(new JLabel("タイトル"));
    	add(titleField);
    	add(registerBtn);
    	add(baeckButton);
    }
}
