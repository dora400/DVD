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
            String id =  memberidField.getText();
        	String code = DVDCodeField.getText();
        	 if(!code.matches("\\d+")) {
             	JOptionPane.showMessageDialog(this,"DVDコードは数字で入力してください。","入力エラー",JOptionPane.ERROR_MESSAGE);
        	 }else {
             	Rental.lendBook(id,code);
             	JOptionPane.showMessageDialog(this,"貸出しました。","会員IDとDVDコードを受け取りました。",
             	JOptionPane.INFORMATION_MESSAGE);
        	 }
    		
    		
    	});


        //TOP戻る
    	top.addActionListener(e -> frame.showPanel("TOP"));

        //部品追加
    	add(new JLabel("会員ID"));
    	add(memberidField);

    	add(new JLabel("DVDコード"));
    	add(DVDCodeField);
        
    	add(rental);
    	add(top);
    }
}
