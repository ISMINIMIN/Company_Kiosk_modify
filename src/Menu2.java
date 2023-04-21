import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.List;

public class Menu2 extends LogoFix {
	
	public static List<Object> Array = new ArrayList<Object>();
	public static JLabel lblList[]= new JLabel [10];
	private JLabel lblMenu1, lblMenu2, lblMenu3, lblMenu4, lblMenu5, lblMenu6;
	private JButton btCoffee, btNonCoffee, btnMenu1, btnMenu2, btnMenu3, btnMenu4, btnMenu5, btnMenu6, btnPay;
	private int price; // 해당 메뉴의 가격
	public static int totalPrice;
	public static int sum, sum7, sum8, sum9, sum10, sum11, sum12;

	public Menu2(MainFrame f) {
		super(f);
		
		ImageIcon coffeeCategory = new ImageIcon("image/coffeecategory.png");
		ImageIcon nonCoffeeCategory = new ImageIcon("image/noncoffeecategory.png");
		
		btCoffee = new JButton(coffeeCategory);
		btCoffee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	f.jumpPreviousPanel();
            }
        });
		btCoffee.setBorderPainted(false);
		btCoffee.setFocusPainted(false);
		btCoffee.setBackground(new Color(189,215,238));
		btCoffee.setBounds(67, 120, 150, 70);
		add(btCoffee);
		
		btNonCoffee = new JButton(nonCoffeeCategory);
		btNonCoffee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	
            }
        });
		btNonCoffee.setBorderPainted(false);
		btNonCoffee.setFocusPainted(false);
		btNonCoffee.setBackground(new Color(189,215,238));
		btNonCoffee.setBounds(215, 120, 150, 70);
		add(btNonCoffee);
		
		// 버튼에 이미지 삽입을 위한 객체 생성
		ImageIcon americano = new ImageIcon("image/chocolatte.png");
		ImageIcon cafelatte = new ImageIcon("image/strawberrylatte.png");
		ImageIcon cafemoca = new ImageIcon("image/greentealatte.png");
		ImageIcon espresso = new ImageIcon("image/blacksugarlatte.png");
		ImageIcon greentealatte = new ImageIcon("image/hubtea.png");
		ImageIcon chocolatte = new ImageIcon("image/jamongtea.png");

		btnMenu1 = new JButton(americano); // 버튼 생성
		// 버튼이 눌렸을 때 이벤트 지정
		btnMenu1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
            	// MenuInformation의 라벨에 선택된 메뉴명 출력
            	MenuInformation2.count = 1;
            	MenuInformation2.sizePay = 0;
            	MenuInformation2.lblMenuName.setText("초코라떼");
            	MenuInformation2.selectedMenu="초코라떼";
            	// 재주문을 위해 초기화함
            	MenuInformation2.lblMenuCount.setText("1");
            	MenuInformation2.rbtnSize[0].setSelected(true);
            	MenuInformation2.rbtnHotIce[0].setSelected(true);
            	// 다음 패널로 넘어감
            	F.nextPanel();
            }
        });
		btnMenu1.setBorderPainted(false);
		btnMenu1.setFocusPainted(false);
		btnMenu1.setBackground(new Color(255,255,255)); // 배경색 지정
		btnMenu1.setBounds(70, 190, 150, 150); // 절대 위치 지정
		add(btnMenu1);

		lblMenu1 = new JLabel("<html>초코라떼<br>&nbsp;3000원</html>"); // 라벨 생성
		lblMenu1.setFont(new Font("맑은 고딕", Font.BOLD, 18)); // 폰트 설정
		lblMenu1.setBounds(110, 350, 100, 50); // 절대 위치 지정
		add(lblMenu1);

		btnMenu2 = new JButton(cafelatte);
		btnMenu2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	MenuInformation2.count = 1;
            	MenuInformation2.sizePay = 0;
            	MenuInformation2.lblMenuName.setText("딸기라떼");
            	MenuInformation2.selectedMenu="딸기라떼";
            	MenuInformation2.lblMenuCount.setText("1");
            	MenuInformation2.rbtnSize[0].setSelected(true);
            	MenuInformation2.rbtnHotIce[0].setSelected(true);
            	F.nextPanel();
            }
        });
		btnMenu2.setBorderPainted(false);
		btnMenu2.setFocusPainted(false);
		btnMenu2.setBackground(new Color(255,255,255));
		btnMenu2.setBounds(280, 190, 150, 150);
		add(btnMenu2);

		lblMenu2 = new JLabel("<html>딸기라떼<br> &nbsp;3500원</html>");
		lblMenu2.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblMenu2.setBounds(320, 350, 100, 50);
		add(lblMenu2);

		btnMenu3 = new JButton(cafemoca);		
		btnMenu3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	MenuInformation2.count = 1;
            	MenuInformation2.sizePay = 0;
            	MenuInformation2.lblMenuName.setText("녹차라떼");
            	MenuInformation2.selectedMenu="녹차라떼";          	
            	MenuInformation2.lblMenuCount.setText("1");
            	MenuInformation2.rbtnSize[0].setSelected(true);
            	MenuInformation2.rbtnHotIce[0].setSelected(true);
            	F.nextPanel();
            }
        });
		btnMenu3.setBorderPainted(false);
		btnMenu3.setFocusPainted(false);
		btnMenu3.setBackground(new Color(255,255,255));
		btnMenu3.setBounds(490, 190, 150, 150);
		add(btnMenu3);

		lblMenu3 = new JLabel("<html>녹차라떼<br> &nbsp;3500원</html>");
		lblMenu3.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblMenu3.setBounds(530, 350, 100, 50);
		add(lblMenu3);

		btnMenu4 = new JButton(espresso);		
		btnMenu4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	MenuInformation2.count = 1;
            	MenuInformation2.sizePay = 0;
            	MenuInformation2.lblMenuName.setText("흑당버블티");
            	MenuInformation2.selectedMenu="흑당버블티";
            	MenuInformation2.lblMenuCount.setText("1");
            	MenuInformation2.rbtnSize[0].setSelected(true);
            	MenuInformation2.rbtnHotIce[0].setSelected(true);
            	F.nextPanel();
            }
        });
		btnMenu4.setBorderPainted(false);
		btnMenu4.setFocusPainted(false);
		btnMenu4.setBackground(new Color(255,255,255));
		btnMenu4.setBounds(70, 420, 150, 150);
		add(btnMenu4);

		lblMenu4 = new JLabel("<html>흑당버블티<br> &nbsp; 4000원</html>");
		lblMenu4.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblMenu4.setBounds(103, 580, 100, 50);
		add(lblMenu4);

		btnMenu5 = new JButton(greentealatte);		
		btnMenu5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {  
            	MenuInformation2.count = 1;
            	MenuInformation2.sizePay = 0;
            	MenuInformation2.lblMenuName.setText("허브티");
            	MenuInformation2.selectedMenu="허브티";          	
            	MenuInformation2.lblMenuCount.setText("1");
            	MenuInformation2.rbtnSize[0].setSelected(true);
            	MenuInformation2.rbtnHotIce[0].setSelected(true);           	
            	F.nextPanel();
            }
        });
		btnMenu5.setBorderPainted(false);
		btnMenu5.setFocusPainted(false);
		btnMenu5.setBackground(new Color(255,255,255));
		btnMenu5.setBounds(280, 420, 150, 150);
		add(btnMenu5);

		lblMenu5 = new JLabel("<html>허브티<br>3500원</html>");
		lblMenu5.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblMenu5.setBounds(330, 580, 100, 50);
		add(lblMenu5);

		btnMenu6 = new JButton(chocolatte);		
		btnMenu6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	MenuInformation2.count = 1;
            	MenuInformation2.sizePay = 0;
            	MenuInformation2.lblMenuName.setText("자몽티");
            	MenuInformation2.selectedMenu="자몽티";
            	MenuInformation2.lblMenuCount.setText("1");
            	MenuInformation2.rbtnSize[0].setSelected(true);
            	MenuInformation2.rbtnHotIce[0].setSelected(true);
            	F.nextPanel();
            }
        });
		btnMenu6.setBorderPainted(false);
		btnMenu6.setFocusPainted(false);
		btnMenu6.setBackground(new Color(255,255,255));
		btnMenu6.setBounds(490, 420, 150, 150);
		add(btnMenu6);	

		lblMenu6 = new JLabel("<html>자몽티<br>3500원</html>");
		lblMenu6.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblMenu6.setBounds(540, 580, 100, 50);
		add(lblMenu6);
		
		
		btnPay = new JButton("결제하기");
		// '결제하기' 버튼이 눌렸을 때 이벤트 지정
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// 결제 금액을 계산해서 저장함
				//totalPrice = (price*MenuInformation.count)+(MenuInformation.sizePay*MenuInformation.count);
				// PaymentHistory의 라벨에 결제 금액 출력함
				sum = Menu.sum1 + Menu.sum2+ Menu.sum3+ Menu.sum4+ Menu.sum5 + Menu.sum6 + + sum7 + sum8+ sum9 + sum10 + sum11 + sum12;
				PayTotal.lblTotal.setText(sum + "원");
				SKT_PayTotal.lblTotal.setText(sum + "원");
				LG_PayTotal.lblTotal.setText(sum + "원");
				KT_PayTotal.lblTotal.setText(sum + "원");
				Card_PayTotal.lblTotal.setText(sum + "원");
				
				PayTotal.MJDiscount.setText((int)(sum*0.1) + "원");
				PayTotal.MJlblTotal.setText((int)(sum*0.9) + "원");
				
				SKT_PayTotal.SKTDiscount.setText((int)(sum*0.15) + "원");
				SKT_PayTotal.SKTlblTotal.setText((int)(sum*0.85) + "원");
				
				LG_PayTotal.LGDiscount.setText((int)(sum*0.07) + "원");
				LG_PayTotal.LGlblTotal.setText((int)(sum*0.93) + "원");
				
				KT_PayTotal.KTDiscount.setText((int)(sum*0.05) + "원");
				KT_PayTotal.KTlblTotal.setText((int)(sum*0.95) + "원");
				
				Card_PayTotal.CARDDiscount.setText("0원");
				Card_PayTotal.CARDlblTotal.setText(sum + "원");
            	// 재주문을 위해 주문내역 초기화 시킴
            	//lblList.setText("");
            	// 두개의 패널이 넘어감 (MenuInformation 패널을 출력하지 않음)
            	F.jumpPanel();
            }
        });
		btnPay.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnPay.setBorderPainted(false);
		btnPay.setFocusPainted(false);
		btnPay.setBackground(new Color(0,105,92));
		btnPay.setForeground(new Color(255,255,255));
		btnPay.setBounds(280, 650, 150, 50);
		add(btnPay);
		
		
		
		setVisible(true);
	}
}