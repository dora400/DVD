package jp.ac.kcs.swing.dvd;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LendPanel extends JPanel {
    public LendPanel(MainFrame frame) {
    	setLayout(new GridLayout(4, 2));
        //ボタンとかフィールド作成
    	JTextField memberidField = new JTextField(); 
    	JTextField bookCodeField = new JTextField(); 
    	JButton lendBtn = new JButton("貸出");
    	JButton backBtn = new JButton("TOPへ");


        //DB実行
    	lendBtn.addActionListener(e -> {
    		DB.lendBook(memberidField.getText(), bookCodeField.getText());
    		JOptionPane.showMessageDialog(this, "貸出しました。");
    	});


        //TOP戻る
    	backBtn.addActionListener(e -> frame.showPanel("TOP"));

        //部品追加
    	add(new JLabel("会員ID"));
    	add(memberidField);
    	add(new JLabel("書籍コード"));
    	add(bookCodeField);
    	add(lendBtn);
    	add(backBtn);

    }
}
