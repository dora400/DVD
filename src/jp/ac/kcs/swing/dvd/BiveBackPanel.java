package jp.ac.kcs.swing.dvd;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BiveBackPanel extends JPanel {
    public BiveBackPanel(MainFrame frame) {
    	setLayout(new GridLayout(4, 2));
        //ボタンとか作成
    	JTextField codeField = new JTextField(); 
    	JButton returnBtn = new JButton("返却");
    	JButton backBtn = new JButton("TOPへ");



        //DB返却処理
    	returnBtn.addActionListener(e -> {
    		Rental.returnBook(codeField.getText());
    		JOptionPane.showMessageDialog(this, "返却が完了しました。");
    	});



        //TOPに戻るボタン
    	backBtn.addActionListener(e -> frame.showPanel("TOP"));
    	


        //パネルに部品の追加
    	add(new JLabel("書籍コード"));
    	add(codeField);
    	add(returnBtn);
    	add(backBtn);


    }
}
