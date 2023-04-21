import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SelectMenuList extends LogoFix {
	
	public static JLabel lblDiscount;
	private JLabel lbl1, lbl2, lbl3, lbl4;
	private JButton btnCancle, btnPay;

	public SelectMenuList(MainFrame f) {

		super(f);
		

		lbl1 = new JLabel("주문내역"); // 라벨 생성
		lbl1.setFont(new Font("함초롬돋움", Font.BOLD, 33)); // 폰트 설정
		lbl1.setBounds(280, 130, 270, 50); // 절대 위치 지정
        add(lbl1);
        
        // 선택한 메뉴와 정보를 출력하는 라벨
     	for (int i=0,j=0 ; i < 10 ; i++, j++) {
     		Menu.lblList[i] = new JLabel("");
     		Menu2.lblList[j] = new JLabel("");
     		Menu.lblList[i].setFont(new Font("맑은 고딕", Font.PLAIN, 25));
     		Menu2.lblList[j].setFont(new Font("맑은 고딕", Font.PLAIN, 25));
     		Menu.lblList[i].setBounds(190, 210+(i*30), 370, 60);
     		Menu2.lblList[j].setBounds(190, 400+(j*30), 370, 60);
     		Menu.lblList[i].setForeground(new Color(0,105,92));
     		Menu2.lblList[j].setForeground(new Color(0,105,92));
     		add(Menu.lblList[i]);
     		add(Menu2.lblList[j]);
     	}
     	
     	lbl3 = new JLabel("Yes-coffee");
     	lbl3.setFont(new Font("함초롬돋움", Font.BOLD, 25));
     	lbl3.setBounds(140, 180, 270, 50);
     	add(lbl3);
     	
     	lbl4 = new JLabel("Non-coffee");
     	lbl4.setFont(new Font("함초롬돋움", Font.BOLD, 25));
     	lbl4.setBounds(140, 370, 270, 50);
     	add(lbl4);
		
		btnCancle = new JButton("취소");
		// 버튼이 눌렸을 때 이벤트 지정
		btnCancle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	
            	// 이전 패널로 넘어감
            	F.jumpPreviousPanel();
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
            	F.nextPanel();
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