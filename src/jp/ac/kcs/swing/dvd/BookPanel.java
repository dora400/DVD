package jp.ac.kcs.swing.dvd;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookPanel extends JPanel {
  
        
    	
        //ボタンやフィールド作成
        private JTextField codeFiled;
        private JTextField titleFiled;
        private JButton registerBtn;
        private JButton backBtn;
        private MainFrame parentFrame;
        public BookPanel(MainFrame frame) {
        	this.parentFrame=frame;
        	setLayout (new GridLayout(3,2));
        	codeFiled=new JTextField(10);
        	titleFiled=new JTextField(20);
        	registerBtn=new JButton("登録");
        	backBtn=new JButton("TOPへ戻る");
    	//登録ボタンが押されたらIDとタイトル
       
        	
        registerBtn.addActionListener(e->{
        	String code =  codeFiled.getText();
        	String title = titleFiled.getText();
        	 if(!code.matches("\\+")) {
             	JOptionPane.showMessageDialog(this,"DVDコードは数字で入力してください。","入力エラー",JOptionPane.ERROR_MESSAGE);
        	 }else {
             	Rental.insertDvd(code,title);
             	JOptionPane.showMessageDialog(this,"DVDコードとタイトルを登録しました。","登録完了",
             	JOptionPane.INFORMATION_MESSAGE);
        	 }	
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