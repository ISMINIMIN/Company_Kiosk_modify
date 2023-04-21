import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class PayComplete extends LogoFix {

	private JLabel lbl1, lbl2;
	private JButton btnReset;
	public static int waitNum = 1;
	public static int num = 0;
	public static JLabel lblWaitNumber;
	
	Connection connection;
	ResultSet resultset;
	Statement statement;
	PreparedStatement preparedstatment;
	
	String url = "jdbc:mysql://localhost:3306/greenpot_db?characterEncoding=UTF-8&serverTimezone=UTC";
	
	public PayComplete(MainFrame f) {

		super(f);
		
		CardInsert.lbltimer.setBounds(335, 540, 50, 50); // ���� ��ġ ����
		CardInsert.lbltimer.setForeground(new Color(0,105,92)); // ��Ʈ�� ����
		add(CardInsert.lbltimer);
		
		CheckDB.lbltimer.setBounds(335, 540, 50, 50); // ���� ��ġ ����
		CheckDB.lbltimer.setForeground(new Color(0,105,92)); // ��Ʈ�� ����
		add(CheckDB.lbltimer);

		lbl1 = new JLabel("������ �Ϸ�Ǿ����ϴ�."); // �� �߰�
		lbl1.setFont(new Font("���� ���", Font.PLAIN, 18)); // ��Ʈ ����
		lbl1.setBounds(265, 250, 200, 50);
		add(lbl1);

		lbl2 = new JLabel("�ش� ��ȣ�� �ҷ��帮�ڽ��ϴ�.");
		lbl2.setFont(new Font("���� ���", Font.PLAIN, 18));
		lbl2.setBounds(230, 290, 300, 50);
		add(lbl2);

		// ��� ��ȣ ���
		lblWaitNumber = new JLabel(waitNum+ "��");
		lblWaitNumber.setFont(new Font("���� ���", Font.BOLD, 40));
		lblWaitNumber.setBounds(325, 350, 100, 50);
		add(lblWaitNumber);

		btnReset = new JButton("ó��ȭ������ ���ư���");
		// ��ư�� ������ �� �̺�Ʈ ����
		btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	String sql = "UPDATE mjc_info SET payment=? WHERE id='"+CheckDB.tfid+"'";
            		try {
            			// �������� MySQL�� JDBC ����̹� Ŭ���� �ε�
            			Class.forName("com.mysql.cj.jdbc.Driver");
            			// �ڹ� ���ø����̼��� JDBC ����̹��� ��������ִ� Ŭ����
            			connection = DriverManager.getConnection(url, "root","1111");
            			System.out.println(CheckDB.tfid);
            			// SQL���� �����Ͽ� ���� ����� �Ѱ���
            			System.out.println(CheckDB.pay);
            			preparedstatment = connection.prepareStatement(sql);
            			CheckDB.pay = CheckDB.pay + (int)(Menu.sum*0.9) + (int)(Menu2.sum*0.9);
            			System.out.println(CheckDB.pay);
            			preparedstatment.setInt(1, CheckDB.pay);
            			int cnt = preparedstatment.executeUpdate();		
            		} catch (Exception e) {
            			System.out.print(e);
            		} finally {
            			try {
            				if (preparedstatment != null) preparedstatment.close();
            				if (connection != null) connection.close();
            			} catch (Exception e2) {
            				
            			}
            		}
            		
            	// ��� ��ȣ�� 1���̸� 
            	if(waitNum==1) {
            		// ��� ��ȣ�� 1�� ������
            		waitNum++;
            		// ��� ��ȣ�� �����
            		lblWaitNumber.setText(waitNum+ "��");
            	}
            	// Ÿ�̸� ������ ���� ����
            	if(CardInsert.card == 1) {
            		CardInsert.thread.interrupt();
            	} else if(CheckDB.stack == 1) {
            		CheckDB.thread.interrupt();
            	}
            	
            	MenuInformation.count = 1;
            	MenuInformation2.count = 1;
            	for (int i=0; i < MenuInformation.num ; i++) {
            		Menu.lblList[i].setText("");
            	}
            	MenuInformation.num = 0;
            	for (int i=0; i < MenuInformation2.num ; i++) {
            		Menu2.lblList[i].setText("");
            	}
            	MenuInformation2.num = 0;
            	Menu.sum1 = 0;
            	Menu.sum2 = 0;
            	Menu.sum3 = 0;
            	Menu.sum4 = 0;
            	Menu.sum5 = 0;
            	Menu.sum6 = 0;
            	Menu2.sum7 = 0;
            	Menu2.sum8 = 0;
            	Menu2.sum9 = 0;
            	Menu2.sum10 = 0;
            	Menu2.sum11 = 0;
            	Menu2.sum12 = 0;
            	CheckDB.lbl2.setText("");
            	Membership_CheckDB.lbl2.setText("");
            	
            	// ó�� �гη� �Ѿ
            	F.nextPanel();
            }
        });
		btnReset.setFont(new Font("���� ���", Font.BOLD, 17));
		btnReset.setBackground(new Color(0,105,92));
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setBounds(200, 610, 300, 60);
		add(btnReset);

		setVisible(true);		
	}
}
