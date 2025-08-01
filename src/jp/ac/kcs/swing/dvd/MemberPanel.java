package jp.ac.kcs.swing.dvd;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberPanel extends JPanel {
    public MemberPanel(MainFrame frame) {
        //レイアウトに新しいGridLayout(3, 2)
    	setLayout(new GridLayout(3, 2));
        //IDのテキストフィールド
    	JTextField idField = new JTextField(); 
        //名前のテキストフィールド
    	JTextField nameField = new JTextField(); 
        //登録ボタン
    	JButton registerBtn = new JButton("登録");
        //TOPに戻るボタン
    	JButton baeckButton = new JButton("TOPへ");
        //登録ボタンリスナーで押されたらDBのインサート発動
        registerBtn.addActionListener(e -> {
        	//半角のみ使える（全角だとエラー）
        String id   = idField.getText();
        String name = nameField.getText();
        	if(!id.matches("\\p{ASCII}*")) {
        		JOptionPane.showMessageDialog(this, "半角英数字で入力してください。");
        		return;
        	}
        	Rental.insertMember(id, name);
        	JOptionPane.showMessageDialog(this, "会員登録が完了しました。");
        });
        
        //TOPに戻るボタン
        baeckButton.addActionListener(e -> frame.showPanel("TOP"));
        //コメント	
        //カードに部品を追加
        add(new JLabel("ID"));
    	add(idField);
    	add(new JLabel("名前"));
    	add(nameField);
    	add(registerBtn);
    	add(baeckButton);
    }
}
