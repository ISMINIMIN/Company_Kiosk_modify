import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaymentWay extends LogoFix {
	
	private JLabel lblWay, lblTip;
	private JButton btnCard, btnStack;

	public PaymentWay(MainFrame f) {

		super(f);
		

		lblWay = new JLabel("결제수단을 선택해주세요."); // 라벨 생성
		lblWay.setFont(new Font("함초롬돋움", Font.BOLD, 24)); // 폰트 설정
		lblWay.setBounds(230, 200, 400, 50); // 절대 위치 지정
        add(lblWay);
        
        lblTip = new JLabel("누적 결제 시, 명지할인이 자동으로 적용됩니다.");
        lblTip.setFont(new Font("함초롬돋움", Font.BOLD, 20));
        lblTip.setBounds(160, 490, 500, 50);
     	add(lblTip);
		
     	btnCard = new JButton("카드결제");
		// 버튼이 눌렸을 때 이벤트 지정
     	btnCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	// 다음 패널로 넘어감
            	F.nextPanel();
            }
        });
		
     	btnCard.setBorderPainted(false);
     	btnCard.setFocusPainted(false);
     	btnCard.setFont(new Font("맑은 고딕", Font.BOLD, 20));
     	btnCard.setBackground(new Color(0,105,92));
     	btnCard.setForeground(new Color(255,255,255));
     	btnCard.setBounds(260, 290, 200, 70);
		add(btnCard);
		
		btnStack = new JButton("누적결제");
		// 버튼이 눌렸을 때 이벤트 지정
		btnStack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	// 다음 패널로 넘어감
            	F.jump2Panel();
            	F.jump2Panel();
            }
        });
		
		btnStack.setBorderPainted(false);
		btnStack.setFocusPainted(false);
		btnStack.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnStack.setBackground(new Color(0,105,92));
		btnStack.setForeground(new Color(255,255,255));
		btnStack.setBounds(260, 390, 200, 70);
		add(btnStack);


		
		setVisible(true);
	}
}