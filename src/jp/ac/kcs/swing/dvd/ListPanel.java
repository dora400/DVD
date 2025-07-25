package jp.ac.kcs.swing.dvd;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ListPanel extends JPanel {
    public ListPanel(MainFrame frame) {
        //レイアウト追加
        setLayout(new BorderLayout());

        //表示フィールド追加
        JTextArea area =new JTextArea();
        area.setEditable(false);
        //Listを作成string型
        List<String> books = Rental.getLentBooks();
        for(String book:books) {
        	area.append(book + "\n");
        }
        //TOP戻るボタン
        JButton backBtn = new JButton("TOPへ");
    	backBtn.addActionListener(e -> frame.showPanel("TOP"));

        //パネルに部品の追加
    	add(new JScrollPane(area),BorderLayout.CENTER);
    	add(backBtn, BorderLayout.SOUTH);
    	

    }
}
