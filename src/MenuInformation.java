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
		
		lblMenuName = new JLabel(); // �� ����
		lblMenuName.setFont(new Font("���� ���", Font.BOLD, 25)); // ��Ʈ ����
		lblMenuName.setBounds(280, 170, 270, 40); // ���� ��ġ ����
		add(lblMenuName);

		lblSize = new JLabel("������ ");
		lblSize.setFont(new Font("���� ���", Font.BOLD, 18));
		lblSize.setBounds(140, 270, 100, 35);
		add(lblSize);

		ButtonGroup sizeGroup = new ButtonGroup();

		for(int i=0; i<rbtnSize.length; i++) {	
			rbtnSize[i] = new JRadioButton(size[i]);
			// ���� �� �� ������ ���� 'Small'�� �⺻ ������ ����
			rbtnSize[0].setSelected(true);
			sizeGroup.add(rbtnSize[i]);
			rbtnSize[i].setBackground(new Color(189,215,238)); // ���� ����
			add(rbtnSize[i]);
			rbtnSize[i].setFont(new Font("���ʷҵ���", Font.PLAIN, 18));
		}

		rbtnSize[0].setBounds(300, 270, 160, 35);
		rbtnSize[1].setBounds(460, 270, 160, 35);

		lblHotIce = new JLabel("HOT / ICE ");
		lblHotIce.setFont(new Font("���� ���", Font.BOLD, 18));
		lblHotIce.setBounds(140, 370, 100, 35);
		add(lblHotIce);

		ButtonGroup hotceGroup = new ButtonGroup();

		for(int i=0; i<rbtnHotIce.length; i++) {
			rbtnHotIce[i] = new JRadioButton(hotice[i]);
			// ���� �� �� ������ ���� 'HOT'�� �⺻ ������ ����
			rbtnHotIce[0].setSelected(true);
			hotceGroup.add(rbtnHotIce[i]);
			rbtnHotIce[i].setBackground(new Color(189,215,238));
			add(rbtnHotIce[i]);
			rbtnHotIce[i].setFont(new Font("���ʷҵ���", Font.PLAIN, 18));
		}
		
		rbtnHotIce[0].setBounds(300, 370, 110, 35);
		rbtnHotIce[1].setBounds(460, 370, 110, 35);

		lblCount = new JLabel("���� ");
		lblCount.setFont(new Font("���� ���", Font.BOLD, 18));
		lblCount.setBounds(140, 470, 100, 35);
		add(lblCount);

		btnMinus = new JButton(" �� "); // ��ư ����
		// ��ư�� ������ �� �̺�Ʈ ����
		btnMinus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	// count�� 1�̸� ��ȭ ���� (1�� �ּڰ�)
            	if(count==1) {
            		// count ���� �󺧿� ��µ�
            		lblMenuCount.setText(count+ "");
            	} else { // count�� 2�̻��̸� count�� 1�� �� ������ 1�� ����
            		count--;
    				lblMenuCount.setText(count+ "");
            	}
            }
        });
		
		btnMinus.setBorderPainted(false);
		btnMinus.setFocusPainted(false);
		btnMinus.setFont(new Font("���� ���", Font.PLAIN, 14));
		btnMinus.setBackground(new Color(189,215,238));
		btnMinus.setBounds(300, 465, 60, 50);
		add(btnMinus);

		btnPlus = new JButton(" �� ");
		// ��ư�� ������ �� �̺�Ʈ ����
		btnPlus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	// count ���� 1�� ����
            	count++;
            	// count ���� �󺧿� ��µ�
				lblMenuCount.setText(count+ "");
            }
        });
		
		btnPlus.setBorderPainted(false);
		btnPlus.setFocusPainted(false);
		btnPlus.setFont(new Font("���� ���", Font.BOLD, 14));
		btnPlus.setBackground(new Color(189,215,238));
		btnPlus.setBounds(460, 465, 60, 50);
		add(btnPlus);

		lblMenuCount = new JLabel(""+count);
		lblMenuCount.setFont(new Font("����", Font.BOLD, 25));
		lblMenuCount.setBounds(405, 480, 50, 25);
	    add(lblMenuCount);

	    btnAdd = new JButton("�߰�");
	    // ��ư�� ������ �� �̺�Ʈ ����
	    btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	// 'Small'�� ���õǾ��� �� ���ڿ��� ������
            	if (rbtnSize[0].isSelected()) {
            		selectedSize = rbtnSize[0].getText();
            	} else if(rbtnSize[1].isSelected()) { // 'Large'�� ���õǾ��� �� ���ڿ��� ������
            		selectedSize = rbtnSize[1].getText();
            		// 'Large'�� ���õǾ��� �� sizePay ������ 1000 ����
            		sizePay = 1000;
            	} else {
            		selectedSize = "no";
            	}
            	
            	// 'HOT'�� ���õǾ��� �� ���ڿ��� ������
            	if (rbtnHotIce[0].isSelected()) {
            		selectedHotIce = rbtnHotIce[0].getText();
            	} else if(rbtnHotIce[1].isSelected()) { // 'ICE'�� ���õǾ��� �� ���ڿ��� ������
            		selectedHotIce = rbtnHotIce[1].getText();
            	} else {
            		selectedHotIce = "no";
            	}            	
            	
            	// MenuSelect �󺧿� ���� ���� ���� �ֹ� ���� ���
            	Menu.lblList[num].setText(selectedMenu+" ("+selectedSize+" /"+selectedHotIce+" ) x "+count);
            	Menu.Array.add(Menu.lblList[num].getText());  
            	
            	if (selectedMenu == "�Ƹ޸�ī��") {
            		price = 2500;
            		Menu.totalPrice = (price*count)+(sizePay*count);
            		Menu.sum1 = Menu.totalPrice;
            	} else if (selectedMenu == "ī���") {
            		price = 3000;
            		Menu.totalPrice = (price*count)+(sizePay*count);
            		Menu.sum2 = Menu.totalPrice;
            	} else if (selectedMenu == "ī���ī") {
            		price = 3500;
            		Menu.totalPrice = (price*count)+(sizePay*count);
            		Menu.sum3 = Menu.totalPrice;
            	} else if (selectedMenu == "����������") {
            		price = 2000;
            		Menu.totalPrice = (price*count)+(sizePay*count);
            		Menu.sum4 = Menu.totalPrice;
            	} else if (selectedMenu == "�ٴҶ��") {
            		price = 3500;
            		Menu.totalPrice = (price*count)+(sizePay*count);
            		Menu.sum5 = Menu.totalPrice;
            	} else if (selectedMenu == "��������") {
            		price = 3500;
            		Menu.totalPrice = (price*count)+(sizePay*count);
            		Menu.sum6 = Menu.totalPrice;
            	}
            	
            	num++;
            	
            	// ���� �гη� �Ѿ
            	F.previousPanel();
            }
        });
	    
	    btnAdd.setBorderPainted(false);
	    btnAdd.setFocusPainted(false);
	    btnAdd.setFont(new Font("���� ���", Font.BOLD, 20));
	    btnAdd.setBackground(new Color(0,105,92));
	    btnAdd.setForeground(new Color(255,255,255));
	    btnAdd.setBounds(210, 610, 120, 50);
		add(btnAdd);

		btnCancle = new JButton("���");
		// ��ư�� ������ �� �̺�Ʈ ����
		btnCancle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	
            	// ���� �гη� �Ѿ
            	F.previousPanel();
            }
        });
		
		btnCancle.setBorderPainted(false);
		btnCancle.setFocusPainted(false);
		btnCancle.setFont(new Font("���� ���", Font.BOLD, 20));
		btnCancle.setBackground(new Color(0,105,92));
		btnCancle.setForeground(new Color(255,255,255));
		btnCancle.setBounds(370, 610, 120, 50);
		add(btnCancle);

		setVisible(true);
	}
}