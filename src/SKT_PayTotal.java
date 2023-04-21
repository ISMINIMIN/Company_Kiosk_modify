import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SKT_PayTotal extends LogoFix {
	
	public static JLabel lblTotal, SKTlblTotal, SKTDiscount;
	private JLabel lbl1, lbl2, lbl3, lbl4;
	private JButton btnCancle, btnPay;

	public SKT_PayTotal(MainFrame f) {

		super(f);
		
		lbl1 = new JLabel("결제금액을 확인해주세요.");
		lbl1.setFont(new Font("함초롬돋움", Font.BOLD, 24));
		lbl1.setBounds(215, 220, 400, 50);
     	add(lbl1);
		
		lbl2 = new JLabel("합계금액");
		lbl2.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		lbl2.setBounds(245, 300, 270, 50);
     	add(lbl2);
     	
     	lblTotal = new JLabel(); // 총 금액이 출력됨
     	lblTotal.setFont(new Font("맑은 고딕", Font.BOLD, 25));
     	lblTotal.setBounds(360, 310, 200, 30);
		add(lblTotal);
		
		lbl3 = new JLabel("할인금액");
		lbl3.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		lbl3.setBounds(245, 360, 270, 50);
     	add(lbl3);
     	
     	SKTDiscount = new JLabel(); // 할인 금액이 출력됨
     	SKTDiscount.setFont(new Font("맑은 고딕", Font.BOLD, 25));
     	SKTDiscount.setBounds(360, 370, 200, 30);
		add(SKTDiscount);
		
		lbl4 = new JLabel("결제금액");
		lbl4.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		lbl4.setForeground(new Color(0,105,92));
		lbl4.setBounds(245, 420, 270, 50);
     	add(lbl4);
     	
     	SKTlblTotal = new JLabel(); // 할인 금액이 출력됨
     	SKTlblTotal.setFont(new Font("맑은 고딕", Font.BOLD, 25));
     	SKTlblTotal.setBounds(360, 430, 200, 30);
     	SKTlblTotal.setForeground(new Color(0,105,92));
		add(SKTlblTotal);
		
		btnCancle = new JButton("취소");
		// 버튼이 눌렸을 때 이벤트 지정
		btnCancle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	
            	// 이전 패널로 넘어감
            	F.previousPanel();
            }
        });
		
		btnCancle.setBorderPainted(false);
		btnCancle.setFocusPainted(false);
		btnCancle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnCancle.setBackground(new Color(0,105,92));
		btnCancle.setForeground(new Color(255,255,255));
		btnCancle.setBounds(210, 610, 120, 50);
		add(btnCancle);
		
		btnPay = new JButton("확인");
		// 버튼이 눌렸을 때 이벤트 지정
		btnPay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	// 다음 패널로 넘어감
            	F.jump2Panel();
            }
        });
		
		btnPay.setBorderPainted(false);
		btnPay.setFocusPainted(false);
		btnPay.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnPay.setBackground(new Color(0,105,92));
		btnPay.setForeground(new Color(255,255,255));
		btnPay.setBounds(370, 610, 120, 50);
		add(btnPay);


		
		setVisible(true);
	}
}
