package jp.ac.kcs.swing.dvd;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RentPanel extends JPanel {
    public RentPanel(MainFrame frame) {
    	setLayout(new GridLayout(4, 2));
        //ボタンとかフィールド作成
    	JTextField memberidField = new JTextField(); 
    	JTextField DVDCodeField = new JTextField(); 
    	JButton rental = new JButton("レンタル");
    	JButton top = new JButton("TOPへ");


        //DB実行
    	rental.addActionListener(e -> {
    		DB.insertBook(memberidField.getText(), DVDCodeField.getText());
    		JOptionPane.showMessageDialog(this, "貸出しました。");
    	});


        //TOP戻る
    	top.addActionListener(e -> frame.showPanel("TOP"));

        //部品追加
    	add(new JLabel("会員ID"));
    	add(memberidField);
    	add(new JLabel("書籍コード"));
    	add(DVDCodeField);
    	add(rental);
    	add(top);
    }
}
