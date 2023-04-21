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
		
		btnorder = new JButton("�ֹ��ϱ�"); // ��ư ����
		// ��ư�� ������ �� �̺�Ʈ ����
		btnorder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	// ���� �гη� �Ѿ
            	F.nextPanel();
            }
        });
		
		btnorder.setBorderPainted(false);
		btnorder.setFocusPainted(false);
		btnorder.setFont(new Font("���� ���", Font.BOLD, 25));
		btnorder.setBackground(new Color(0,105,92));
		btnorder.setForeground(new Color(255,255,255));
		btnorder.setBounds(350, 567, 220, 50);
		add(btnorder);

		setVisible(true);
	}
}
