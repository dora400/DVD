package jp.ac.kcs.swing.dvd;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public MainFrame() {
        setTitle("DVD管理システム");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // すべての機能パネルを登録
        cardPanel.add(new SelectOptPanel(this), "TOP");
        cardPanel.add(new BookPanel(this), "DVD");
        cardPanel.add(new MemberPanel(this), "MEMBER");
        cardPanel.add(new RentPanel(this), "LEND");
        cardPanel.add(new BiveBackPanel(this), "RETURN");
        cardPanel.add(new ListPanel(this), "LIST");

        add(cardPanel);
        setVisible(true);
    }

    public void showPanel(String name) {
        cardLayout.show(cardPanel, name);
    }
}
