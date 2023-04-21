import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Membership_CheckDB extends LogoFix {

	String tfmb, mb;
	
	Connection connection = null;
	PreparedStatement preparedstatment = null;
	ResultSet resultset = null;
	Statement statement = null;

	int result = 1;

	String url = "jdbc:mysql://localhost:3306/greenpot_db?characterEncoding=UTF-8&serverTimezone=UTC";

	void check(String tfmb) {

		this.tfmb = tfmb;

		try {
			// �������� MySQL�� JDBC ����̹� Ŭ���� �ε�
			Class.forName("com.mysql.cj.jdbc.Driver");
			// �ڹ� ���ø����̼��� JDBC ����̹��� ��������ִ� Ŭ����
			connection = DriverManager.getConnection(url, "root","1111");
			// SQL���� �����Ͽ� ���� ����� �Ѱ���
			statement = connection.createStatement();
			resultset = statement.executeQuery("SELECT * FROM greenpot_db.mjc_info;");
			
			while(resultset.next()) { // ���� ������ �̵�
				mb = resultset.getString("membershipNumber");
				// DB�� ����ʳѹ��� ��ġ�ϸ�
				if (mb.equals(this.tfmb)) {
					lbl2.setText("");
					// ���� �гη� �Ѿ
					F.nextPanel();
				} else { // ����ʳѹ��� ��ġ���� ������
					// �˸� �޼��� ���
					lbl2.setText("������ ��ġ���� �ʽ��ϴ�.");
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC ����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("SQL ���� ����");
		}
	}

	private JLabel lbl1, lblMB;
	private JButton btnOK, btnReInput;
	private JTextField tfMB;
	public static JLabel lbl2;

	public Membership_CheckDB(MainFrame f) {

		super(f);

		lbl1 = new JLabel("����� ��ȣ�� �Է����ּ���");
		lbl1.setFont(new Font("���� ���", Font.PLAIN, 20));
		lbl1.setBounds(230, 200, 400, 40); // ���� ��ġ ����
		add(lbl1);

		lbl2 = new JLabel();
		lbl2.setFont(new Font("���� ���", Font.PLAIN, 20));
		lbl2.setForeground(new Color(255,0,0));
		lbl2.setBounds(230 , 295, 400, 40);
		add(lbl2);

		lblMB = new JLabel("�����");
		lblMB.setFont(new Font("���� ���", Font.BOLD, 23));
		lblMB.setBounds(150, 340, 120, 70);
		add(lblMB);

		tfMB = new JTextField(20);
		tfMB.setFont(new Font("���� ���", Font.PLAIN, 23));
		tfMB.setBounds(280, 355, 250, 40);
		add(tfMB);

		btnOK = new JButton("Ȯ��");
		// ��ư�� ������ �� �̺�Ʈ ����
		btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

            	tfmb = tfMB.getText(); // �ؽ�Ʈ �ʵ忡 �Է��� �й��� tfmb�� ����
            	
            	check(tfmb); // check() �޼��� ȣ��
            	
            	// ���Է��� ���� �ؽ�Ʈ �ʵ� �ʱ�ȭ
            	tfMB.setText("");
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
            	tfMB.setText("");
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

}