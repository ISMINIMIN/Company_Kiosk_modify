import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SelectMenuList extends LogoFix {
	
	public static JLabel lblDiscount;
	private JLabel lbl1, lbl2, lbl3, lbl4;
	private JButton btnCancle, btnPay;

	public SelectMenuList(MainFrame f) {

		super(f);
		

		lbl1 = new JLabel("�ֹ�����"); // �� ����
		lbl1.setFont(new Font("���ʷҵ���", Font.BOLD, 33)); // ��Ʈ ����
		lbl1.setBounds(280, 130, 270, 50); // ���� ��ġ ����
        add(lbl1);
        
        // ������ �޴��� ������ ����ϴ� ��
     	for (int i=0,j=0 ; i < 10 ; i++, j++) {
     		Menu.lblList[i] = new JLabel("");
     		Menu2.lblList[j] = new JLabel("");
     		Menu.lblList[i].setFont(new Font("���� ���", Font.PLAIN, 25));
     		Menu2.lblList[j].setFont(new Font("���� ���", Font.PLAIN, 25));
     		Menu.lblList[i].setBounds(190, 210+(i*30), 370, 60);
     		Menu2.lblList[j].setBounds(190, 400+(j*30), 370, 60);
     		Menu.lblList[i].setForeground(new Color(0,105,92));
     		Menu2.lblList[j].setForeground(new Color(0,105,92));
     		add(Menu.lblList[i]);
     		add(Menu2.lblList[j]);
     	}
     	
     	lbl3 = new JLabel("Yes-coffee");
     	lbl3.setFont(new Font("���ʷҵ���", Font.BOLD, 25));
     	lbl3.setBounds(140, 180, 270, 50);
     	add(lbl3);
     	
     	lbl4 = new JLabel("Non-coffee");
     	lbl4.setFont(new Font("���ʷҵ���", Font.BOLD, 25));
     	lbl4.setBounds(140, 370, 270, 50);
     	add(lbl4);
		
		btnCancle = new JButton("���");
		// ��ư�� ������ �� �̺�Ʈ ����
		btnCancle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	
            	// ���� �гη� �Ѿ
            	F.jumpPreviousPanel();
            }
        });
		
		btnCancle.setBorderPainted(false);
		btnCancle.setFocusPainted(false);
		btnCancle.setFont(new Font("���� ���", Font.BOLD, 20));
		btnCancle.setBackground(new Color(0,105,92));
		btnCancle.setForeground(new Color(255,255,255));
		btnCancle.setBounds(210, 610, 120, 50);
		add(btnCancle);
		
		btnPay = new JButton("Ȯ��");
		// ��ư�� ������ �� �̺�Ʈ ����
		btnPay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	// ���� �гη� �Ѿ
            	F.nextPanel();
            }
        });
		
		btnPay.setBorderPainted(false);
		btnPay.setFocusPainted(false);
		btnPay.setFont(new Font("���� ���", Font.BOLD, 20));
		btnPay.setBackground(new Color(0,105,92));
		btnPay.setForeground(new Color(255,255,255));
		btnPay.setBounds(370, 610, 120, 50);
		add(btnPay);
		
		setVisible(true);
	}
}