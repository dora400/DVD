package jp.ac.kcs.swing.dvd;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectOptPanel extends JPanel {
    public SelectOptPanel(MainFrame frame) {
       frame.setLayout(new GridLayout(6, 1, 10, 10));

       // 「DVDの登録」ボタンを作成し、クリックされたら "BOOK" パネルに切り替える
       //  インスタンス名bookButton
       JButton dvdButton = new JButton("DVDの登録");
       dvdButton.addActionListener(e -> frame.showPanel("DVD"));
       
       // 「会員登録」ボタンの設定　インスタンス名memberButton 
       JButton memberButton = new JButton("会員登録");
       memberButton.addActionListener(e -> frame.showPanel("MEMBER"));

      // 「貸出処理」ボタンの設定　インスタンス名lendButton 
       JButton lendButton = new JButton("貸出処理");
       lendButton.addActionListener(e -> frame.showPanel("LEND"));

      // 「返却処理」ボタンの設定　インスタンス名returnButton
       JButton returnButton = new JButton("返却処理");
       returnButton.addActionListener(e -> frame.showPanel("RETURN"));

      // 「貸出中一覧」ボタンの設定　インスタンス名listButton 
       JButton listButton = new JButton("貸出中一覧");
       listButton.addActionListener(e -> frame.showPanel("LIST"));

        add(dvdButton);
        add(memberButton);
        add(lendButton);
        add(returnButton);
        add(listButton);
    }
}
