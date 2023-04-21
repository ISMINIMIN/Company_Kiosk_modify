import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaymentWay extends LogoFix {
	
	private JLabel lblWay, lblTip;
	private JButton btnCard, btnStack;

	public PaymentWay(MainFrame f) {

		super(f);
		

		lblWay = new JLabel("���������� �������ּ���."); // �� ����
		lblWay.setFont(new Font("���ʷҵ���", Font.BOLD, 24)); // ��Ʈ ����
		lblWay.setBounds(230, 200, 400, 50); // ���� ��ġ ����
        add(lblWay);
        
        lblTip = new JLabel("���� ���� ��, ���������� �ڵ����� ����˴ϴ�.");
        lblTip.setFont(new Font("���ʷҵ���", Font.BOLD, 20));
        lblTip.setBounds(160, 490, 500, 50);
     	add(lblTip);
		
     	btnCard = new JButton("ī�����");
		// ��ư�� ������ �� �̺�Ʈ ����
     	btnCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	// ���� �гη� �Ѿ
            	F.nextPanel();
            }
        });
		
     	btnCard.setBorderPainted(false);
     	btnCard.setFocusPainted(false);
     	btnCard.setFont(new Font("���� ���", Font.BOLD, 20));
     	btnCard.setBackground(new Color(0,105,92));
     	btnCard.setForeground(new Color(255,255,255));
     	btnCard.setBounds(260, 290, 200, 70);
		add(btnCard);
		
		btnStack = new JButton("��������");
		// ��ư�� ������ �� �̺�Ʈ ����
		btnStack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	// ���� �гη� �Ѿ
            	F.jump2Panel();
            	F.jump2Panel();
            }
        });
		
		btnStack.setBorderPainted(false);
		btnStack.setFocusPainted(false);
		btnStack.setFont(new Font("���� ���", Font.BOLD, 20));
		btnStack.setBackground(new Color(0,105,92));
		btnStack.setForeground(new Color(255,255,255));
		btnStack.setBounds(260, 390, 200, 70);
		add(btnStack);


		
		setVisible(true);
	}
}