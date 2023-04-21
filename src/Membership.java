import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Membership extends LogoFix {

	private JLabel lbl1, lbl2;
	private JButton btnSKT, btnLG, btnKT, btnPay;
	public static double skt, lg, kt;
	public static int discountPrice, price;

	public Membership(MainFrame f) {

		super(f);

		lbl1 = new JLabel("Discount"); // �� ����
		lbl1.setFont(new Font("���ʷҵ���", Font.BOLD, 33)); // ��Ʈ ����
		lbl1.setBounds(290, 165, 270, 40); // ���� ��ġ ����
		add(lbl1);

		lbl2 = new JLabel("�ش� ������ �������ּ���");
		lbl2.setFont(new Font("���� ���", Font.PLAIN, 18));
		lbl2.setBounds(250, 210, 300, 30);
		add(lbl2);

		btnSKT = new JButton("T �����"); // ��ư ����
		// ��ư�� ������ �� �̺�Ʈ ����
		btnSKT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	F.nextPanel();
            }
        });

		btnSKT.setFont(new Font("���� ���", Font.BOLD, 19));
		btnSKT.setBackground(new Color(0,105,92)); // ���� ����
		btnSKT.setForeground(new Color(255,255,255)); // ��Ʈ�� ����
		btnSKT.setBounds(225, 270, 260, 60);
		add(btnSKT);

		btnLG = new JButton("LG U+ �����");
		// ��ư�� ������ �� �̺�Ʈ ����
		btnLG.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {     	
            	F.jumpPanel();
            }
        });

		btnLG.setFont(new Font("���� ���", Font.BOLD, 19));
		btnLG.setBackground(new Color(0,105,92));
		btnLG.setForeground(new Color(255,255,255));
		btnLG.setBounds(225, 370, 260, 60);
		add(btnLG);

		btnKT = new JButton("KT �����");
		// ��ư�� ������ �� �̺�Ʈ ����
		btnKT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {        	
            	F.triplePanel();
            }
        });

		btnKT.setFont(new Font("���� ���", Font.BOLD, 19));
		btnKT.setBackground(new Color(0,105,92));
		btnKT.setForeground(new Color(255,255,255));
		btnKT.setBounds(225, 470, 260, 60);
		add(btnKT);

		btnPay = new JButton("�ٷ� ����");
		// ��ư�� ������ �� �̺�Ʈ ����
		btnPay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	F.jump2Panel();
            }
        });

		btnPay.setFont(new Font("���� ���", Font.BOLD, 19));
		btnPay.setBackground(new Color(0,105,92));
		btnPay.setForeground(new Color(255, 255, 255));
		btnPay.setBounds(225, 570, 260, 60);
		add(btnPay);

		setVisible(true);
	}
}
