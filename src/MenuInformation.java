import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuInformation extends LogoFix {
	
	public static int num=0;
	public static JLabel lblMenuName, lblMenuCount;
	public static JButton btnAdd;
	private JLabel lblSize, lblHotIce, lblCount;
	public static JRadioButton [] rbtnSize = new JRadioButton[2];
	public static JRadioButton [] rbtnHotIce = new JRadioButton[2];
	private JButton btnMinus, btnPlus, btnCancle;
	int price;

	String[] size = {" Small", " Large"}; 
	String[] hotice = {" HOT", " ICE"};
	
	public static int count = 1;
	public static int sizePay = 0;
	public static String selectedSize, selectedHotIce, selectedMenu;

	public MenuInformation(MainFrame f) {

		super(f);
		
		lblMenuName = new JLabel(); // 라벨 생성
		lblMenuName.setFont(new Font("맑은 고딕", Font.BOLD, 25)); // 폰트 설정
		lblMenuName.setBounds(280, 170, 270, 40); // 절대 위치 지정
		add(lblMenuName);

		lblSize = new JLabel("사이즈 ");
		lblSize.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblSize.setBounds(140, 270, 100, 35);
		add(lblSize);

		ButtonGroup sizeGroup = new ButtonGroup();

		for(int i=0; i<rbtnSize.length; i++) {	
			rbtnSize[i] = new JRadioButton(size[i]);
			// 선택 안 함 방지를 위해 'Small'을 기본 값으로 선택
			rbtnSize[0].setSelected(true);
			sizeGroup.add(rbtnSize[i]);
			rbtnSize[i].setBackground(new Color(189,215,238)); // 배경색 지정
			add(rbtnSize[i]);
			rbtnSize[i].setFont(new Font("함초롬돋움", Font.PLAIN, 18));
		}

		rbtnSize[0].setBounds(300, 270, 160, 35);
		rbtnSize[1].setBounds(460, 270, 160, 35);

		lblHotIce = new JLabel("HOT / ICE ");
		lblHotIce.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblHotIce.setBounds(140, 370, 100, 35);
		add(lblHotIce);

		ButtonGroup hotceGroup = new ButtonGroup();

		for(int i=0; i<rbtnHotIce.length; i++) {
			rbtnHotIce[i] = new JRadioButton(hotice[i]);
			// 선택 안 함 방지를 위해 'HOT'을 기본 값으로 선택
			rbtnHotIce[0].setSelected(true);
			hotceGroup.add(rbtnHotIce[i]);
			rbtnHotIce[i].setBackground(new Color(189,215,238));
			add(rbtnHotIce[i]);
			rbtnHotIce[i].setFont(new Font("함초롬돋움", Font.PLAIN, 18));
		}
		
		rbtnHotIce[0].setBounds(300, 370, 110, 35);
		rbtnHotIce[1].setBounds(460, 370, 110, 35);

		lblCount = new JLabel("수량 ");
		lblCount.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblCount.setBounds(140, 470, 100, 35);
		add(lblCount);

		btnMinus = new JButton(" ▼ "); // 버튼 생성
		// 버튼이 눌렸을 때 이벤트 지정
		btnMinus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	// count가 1이면 변화 없음 (1이 최솟값)
            	if(count==1) {
            		// count 값이 라벨에 출력됨
            		lblMenuCount.setText(count+ "");
            	} else { // count가 2이상이면 count가 1이 될 때까지 1씩 감소
            		count--;
    				lblMenuCount.setText(count+ "");
            	}
            }
        });
		
		btnMinus.setBorderPainted(false);
		btnMinus.setFocusPainted(false);
		btnMinus.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnMinus.setBackground(new Color(189,215,238));
		btnMinus.setBounds(300, 465, 60, 50);
		add(btnMinus);

		btnPlus = new JButton(" ▲ ");
		// 버튼이 눌렸을 때 이벤트 지정
		btnPlus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	// count 값이 1씩 증가
            	count++;
            	// count 값이 라벨에 출력됨
				lblMenuCount.setText(count+ "");
            }
        });
		
		btnPlus.setBorderPainted(false);
		btnPlus.setFocusPainted(false);
		btnPlus.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnPlus.setBackground(new Color(189,215,238));
		btnPlus.setBounds(460, 465, 60, 50);
		add(btnPlus);

		lblMenuCount = new JLabel(""+count);
		lblMenuCount.setFont(new Font("돋음", Font.BOLD, 25));
		lblMenuCount.setBounds(405, 480, 50, 25);
	    add(lblMenuCount);

	    btnAdd = new JButton("추가");
	    // 버튼이 눌렸을 때 이벤트 지정
	    btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	// 'Small'이 선택되었을 때 문자열을 가져옴
            	if (rbtnSize[0].isSelected()) {
            		selectedSize = rbtnSize[0].getText();
            	} else if(rbtnSize[1].isSelected()) { // 'Large'가 선택되었을 때 문자열을 가져옴
            		selectedSize = rbtnSize[1].getText();
            		// 'Large'가 선택되었을 때 sizePay 변수에 1000 저장
            		sizePay = 1000;
            	} else {
            		selectedSize = "no";
            	}
            	
            	// 'HOT'이 선택되었을 때 문자열을 가져옴
            	if (rbtnHotIce[0].isSelected()) {
            		selectedHotIce = rbtnHotIce[0].getText();
            	} else if(rbtnHotIce[1].isSelected()) { // 'ICE'가 선택되었을 때 문자열을 가져옴
            		selectedHotIce = rbtnHotIce[1].getText();
            	} else {
            		selectedHotIce = "no";
            	}            	
            	
            	// MenuSelect 라벨에 선택 값에 따른 주문 내역 출력
            	Menu.lblList[num].setText(selectedMenu+" ("+selectedSize+" /"+selectedHotIce+" ) x "+count);
            	Menu.Array.add(Menu.lblList[num].getText());  
            	
            	if (selectedMenu == "아메리카노") {
            		price = 2500;
            		Menu.totalPrice = (price*count)+(sizePay*count);
            		Menu.sum1 = Menu.totalPrice;
            	} else if (selectedMenu == "카페라떼") {
            		price = 3000;
            		Menu.totalPrice = (price*count)+(sizePay*count);
            		Menu.sum2 = Menu.totalPrice;
            	} else if (selectedMenu == "카페모카") {
            		price = 3500;
            		Menu.totalPrice = (price*count)+(sizePay*count);
            		Menu.sum3 = Menu.totalPrice;
            	} else if (selectedMenu == "에스프레소") {
            		price = 2000;
            		Menu.totalPrice = (price*count)+(sizePay*count);
            		Menu.sum4 = Menu.totalPrice;
            	} else if (selectedMenu == "바닐라라떼") {
            		price = 3500;
            		Menu.totalPrice = (price*count)+(sizePay*count);
            		Menu.sum5 = Menu.totalPrice;
            	} else if (selectedMenu == "아포가토") {
            		price = 3500;
            		Menu.totalPrice = (price*count)+(sizePay*count);
            		Menu.sum6 = Menu.totalPrice;
            	}
            	
            	num++;
            	
            	// 이전 패널로 넘어감
            	F.previousPanel();
            }
        });
	    
	    btnAdd.setBorderPainted(false);
	    btnAdd.setFocusPainted(false);
	    btnAdd.setFont(new Font("맑은 고딕", Font.BOLD, 20));
	    btnAdd.setBackground(new Color(0,105,92));
	    btnAdd.setForeground(new Color(255,255,255));
	    btnAdd.setBounds(210, 610, 120, 50);
		add(btnAdd);

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
		btnCancle.setBounds(370, 610, 120, 50);
		add(btnCancle);

		setVisible(true);
	}
}