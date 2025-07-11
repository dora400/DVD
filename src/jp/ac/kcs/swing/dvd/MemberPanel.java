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
    	setLayout(new GridLayout(4, 2));
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
    		DB.insertMember(idField.getText(), nameField.getText());
    		JOptionPane.showMessageDialog(this, "会員登録が完了しました。");
    	});
        

        //TOPに戻るボタン
        baeckButton.addActionListener(e -> frame.showPanel("TOP"));

        //カードに部品を追加
        add(new JLabel("ID"));
    	add(idField);
    	add(new JLabel("名前"));
    	add(nameField);
    	add(registerBtn);
    	add(baeckButton);







    }
}
