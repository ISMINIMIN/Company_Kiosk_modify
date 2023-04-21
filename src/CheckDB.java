import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class CheckDB extends LogoFix {

	public static String tfid, tfpw, id, pw;
	public static int pay;
	public static int totalprice;
	
	Connection connection = null;
	ResultSet resultset = null;
	Statement statement = null;
	PreparedStatement preparedstatment = null;

	int result = 1;
	
	String url = "jdbc:mysql://localhost:3306/greenpot_db?characterEncoding=UTF-8&serverTimezone=UTC";
	
	String sql = "UPDATE mjc_info SET payment=? WHERE id='"+tfid+"'";
	
	
	void check(String tfid, String tfpw) {
		this.tfid = tfid;
		this.tfpw = tfpw;

		try {
			// �������� MySQL�� JDBC ����̹� Ŭ���� �ε�
			Class.forName("com.mysql.cj.jdbc.Driver");
			// �ڹ� ���ø����̼��� JDBC ����̹��� ��������ִ� Ŭ����
			connection = DriverManager.getConnection(url, "root","1111");
			// SQL���� �����Ͽ� ���� ����� �Ѱ���
			statement = connection.createStatement();
			resultset = statement.executeQuery("SELECT * FROM mjc_info");
			
			while(resultset.next()) { // ���� ������ �̵�
				id = resultset.getString("id");
				pw = resultset.getString("password");
				//pay = resultset.getInt("payment");
				//System.out.println(pay);
				
				// DB�� �й���ȣ�� �Է��� �й��� ��ġ�ϸ�
				if (id.equals(this.tfid)) {
					// DB�� ��й�ȣ�� �Է��� ��й�ȣ�� ��ġ�ϸ�
					if (pw.equals(this.tfpw)) {
						pay = resultset.getInt("payment");
						System.out.println(pay);
						thread.start();
						lbl2.setText("");
						// ���� �гη� �Ѿ
						F.nextPanel();
					} else { // ��й�ȣ�� ��ġ���� ������
						// �˸� �޼��� ���
						lbl2.setText("������ ��ġ���� �ʽ��ϴ�.");
						
					}
				} else { // �й��� ��ġ���� ������
					// �˸� �޼��� ���
					lbl2.setText("������ ��ġ���� �ʽ��ϴ�.");
				} 
			} 
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			try {
				if (preparedstatment != null) preparedstatment.close();
				if (connection != null) connection.close();
			} catch (Exception e2) {
				
			}
		}
	}

	public static Thread thread;
	public static int delayTime;
	public static JLabel lbltimer;
	public static int stack;
	
	private JLabel lbl1, lblID, lblPW;
	private JButton btnOK, btnReInput;
	private JTextField tfID, tfPW;
	public static JLabel lbl2;

	public CheckDB(MainFrame f) {

		super(f);

		lbltimer = new JLabel(); // �� ����
		lbltimer.setFont(new Font("���ʷҵ���", Font.ITALIC, 30)); // ��Ʈ ����

		TimerRunnable runnable = new TimerRunnable(lbltimer); // ������ ��ü ����

		lbl1 = new JLabel("�й���ȣ�� ��й�ȣ�� �Է����ּ���");
		lbl1.setFont(new Font("���� ���", Font.PLAIN, 20));
		lbl1.setBounds(180, 200, 400, 40); // ���� ��ġ ����
		add(lbl1);

		lbl2 = new JLabel();
		lbl2.setFont(new Font("���� ���", Font.PLAIN, 20));
		lbl2.setForeground(new Color(255,0,0));
		lbl2.setBounds(230 , 240, 400, 40);
		add(lbl2);

		lblID = new JLabel("�й�/����");
		lblID.setFont(new Font("���� ���", Font.BOLD, 23));
		lblID.setBounds(150, 300, 120, 70);
		add(lblID);

		lblPW = new JLabel("��й�ȣ");
		lblPW.setFont(new Font("���� ���", Font.BOLD, 23));
		lblPW.setBounds(150, 380, 100, 70);
		add(lblPW);

		tfID = new JTextField(20); // �ؽ�Ʈ �ʵ� ����
		tfID.setFont(new Font("���� ���", Font.PLAIN, 23));
		tfID.setBounds(280, 315, 250, 40);
		add(tfID);

		tfPW = new JTextField(20);
		tfPW.setFont(new Font("���� ���", Font.PLAIN, 23));
		tfPW.setBounds(280, 395, 250, 40);
		add(tfPW);

		btnOK = new JButton("Ȯ��");
		// ��ư�� ������ �� �̺�Ʈ ����
		btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	for(int i=1; i<2; i++) {
            		thread = new Thread(runnable); // ������ ����
            	}
            	// ���� �ð��� 1�� �ʱ�ȭ
            	delayTime=1;
            	stack = 1;

            	tfid = tfID.getText(); // �ؽ�Ʈ �ʵ忡 �Է��� �й��� tfid�� ����
            	tfpw = tfPW.getText(); // �ؽ�Ʈ �ʵ忡 �Է��� ��й�ȣ�� tfpw�� ����
            	
            	check(tfid, tfpw); // check() �޼��� ȣ��
            	
            	// ���Է��� ���� �ؽ�Ʈ �ʵ� �ʱ�ȭ
            	tfID.setText("");
            	tfPW.setText("");
            	CardInsert.lbltimer.setText("");
            }
        });
		btnOK.setFont(new Font("���� ���", Font.BOLD, 17));
		btnOK.setBackground(new Color(0,105,92));
		btnOK.setForeground(new Color(255,255,255));
		btnOK.setBounds(210, 610, 120, 50);
		add(btnOK);

		btnReInput = new JButton("���Է�");
		// ��Ʋ�� ������ �� �̺�Ʈ ����
		btnReInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	// �ؽ�Ʈ �ʵ�� ���� �˸� �� �ʱ�ȭ ��Ŵ
            	tfID.setText("");
            	tfPW.setText("");
            	lbl2.setText("");
            }
        });
		btnReInput.setFont(new Font("���� ���", Font.BOLD, 17));
		btnReInput.setBackground(new Color(0,105,92));
		btnReInput.setForeground(new Color(255, 255, 255));
		btnReInput.setBounds(370, 610, 120, 50);
		add(btnReInput);
		
		setVisible(true);
	}

	class TimerRunnable implements Runnable {

		private JLabel lblTimer;
		
		public TimerRunnable(JLabel lblTimer) {
			this.lblTimer = lblTimer;
		}

		@Override
		public void run( ) {
			
			delayTime = 1;

			while(true) {
				lblTimer.setText(Integer.toString(delayTime));
				delayTime++;

				try {
					Thread.sleep(1000); // �����尡 1�� ������ ����
				} catch(InterruptedException e) {
					return; // ���ܰ� �߻��ϸ� ������ ������
				}
				
				// ���ð��� 10�� �Ǹ�
				if(delayTime==10) {
					//PayComplete�� ��� ��ȣ�� 1�� ������
					PayComplete.waitNum++;
					//PayComplete�� ��� ��ȣ ���
					PayComplete.lblWaitNumber.setText(PayComplete.waitNum+ "��");
					//Ÿ�̸� ������ ���� ����
	        		thread.interrupt();
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
	        		// ���� �гη� �Ѿ
	        		F.nextPanel();
				}
			}
		}
	}
}
