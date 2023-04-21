import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Welcome_GreenPot extends LogoFix {
	private JLabel lbl1, lbl2;
	private JButton btnorder;	

	public Welcome_GreenPot(MainFrame f) {
		super(f);
		
		ImageIcon welcome = new ImageIcon("image\\welcome.png");
		
		welcomeLabel = new JLabel(welcome);
		welcomeLabel.setBounds(80, 140, 570, 480);
		add(welcomeLabel);
		
		btnorder = new JButton("주문하기"); // 버튼 생성
		// 버튼이 눌렸을 때 이벤트 지정
		btnorder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	// 다음 패널로 넘어감
            	F.nextPanel();
            }
        });
		
		btnorder.setBorderPainted(false);
		btnorder.setFocusPainted(false);
		btnorder.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btnorder.setBackground(new Color(0,105,92));
		btnorder.setForeground(new Color(255,255,255));
		btnorder.setBounds(350, 567, 220, 50);
		add(btnorder);

		setVisible(true);
	}
}
