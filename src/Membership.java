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

		lbl1 = new JLabel("Discount"); // 라벨 생성
		lbl1.setFont(new Font("함초롬돋움", Font.BOLD, 33)); // 폰트 설정
		lbl1.setBounds(290, 165, 270, 40); // 절대 위치 지정
		add(lbl1);

		lbl2 = new JLabel("해당 할인을 선택해주세요");
		lbl2.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		lbl2.setBounds(250, 210, 300, 30);
		add(lbl2);

		btnSKT = new JButton("T 멤버십"); // 버튼 생성
		// 버튼이 눌렸을 때 이벤트 생성
		btnSKT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	F.nextPanel();
            }
        });

		btnSKT.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		btnSKT.setBackground(new Color(0,105,92)); // 배경색 지정
		btnSKT.setForeground(new Color(255,255,255)); // 폰트색 지정
		btnSKT.setBounds(225, 270, 260, 60);
		add(btnSKT);

		btnLG = new JButton("LG U+ 멤버십");
		// 버튼이 눌렸을 때 이벤트 생성
		btnLG.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {     	
            	F.jumpPanel();
            }
        });

		btnLG.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		btnLG.setBackground(new Color(0,105,92));
		btnLG.setForeground(new Color(255,255,255));
		btnLG.setBounds(225, 370, 260, 60);
		add(btnLG);

		btnKT = new JButton("KT 멤버십");
		// 버튼이 눌렸을 때 이벤트 생성
		btnKT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {        	
            	F.triplePanel();
            }
        });

		btnKT.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		btnKT.setBackground(new Color(0,105,92));
		btnKT.setForeground(new Color(255,255,255));
		btnKT.setBounds(225, 470, 260, 60);
		add(btnKT);

		btnPay = new JButton("바로 결제");
		// 버튼이 눌렸을 때 이벤트 생성
		btnPay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	F.jump2Panel();
            }
        });

		btnPay.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		btnPay.setBackground(new Color(0,105,92));
		btnPay.setForeground(new Color(255, 255, 255));
		btnPay.setBounds(225, 570, 260, 60);
		add(btnPay);

		setVisible(true);
	}
}
