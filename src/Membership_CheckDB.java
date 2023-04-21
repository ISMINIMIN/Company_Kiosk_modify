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
			// 동적으로 MySQL의 JDBC 드라이버 클래스 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 자바 어플리케이션을 JDBC 드라이버에 연결시켜주는 클래스
			connection = DriverManager.getConnection(url, "root","1111");
			// SQL문을 실행하여 실행 결과를 넘겨줌
			statement = connection.createStatement();
			resultset = statement.executeQuery("SELECT * FROM greenpot_db.mjc_info;");
			
			while(resultset.next()) { // 다음 행으로 이동
				mb = resultset.getString("membershipNumber");
				// DB의 멤버십넘버가 일치하면
				if (mb.equals(this.tfmb)) {
					lbl2.setText("");
					// 다음 패널로 넘어감
					F.nextPanel();
				} else { // 멤버십넘버가 일치하지 않으면
					// 알림 메세지 출력
					lbl2.setText("정보가 일치하지 않습니다.");
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("SQL 실행 에러");
		}
	}

	private JLabel lbl1, lblMB;
	private JButton btnOK, btnReInput;
	private JTextField tfMB;
	public static JLabel lbl2;

	public Membership_CheckDB(MainFrame f) {

		super(f);

		lbl1 = new JLabel("멤버십 번호를 입력해주세요");
		lbl1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbl1.setBounds(230, 200, 400, 40); // 절대 위치 설정
		add(lbl1);

		lbl2 = new JLabel();
		lbl2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbl2.setForeground(new Color(255,0,0));
		lbl2.setBounds(230 , 295, 400, 40);
		add(lbl2);

		lblMB = new JLabel("멤버십");
		lblMB.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		lblMB.setBounds(150, 340, 120, 70);
		add(lblMB);

		tfMB = new JTextField(20);
		tfMB.setFont(new Font("맑은 고딕", Font.PLAIN, 23));
		tfMB.setBounds(280, 355, 250, 40);
		add(tfMB);

		btnOK = new JButton("확인");
		// 버튼이 눌렸을 때 이벤트 지정
		btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

            	tfmb = tfMB.getText(); // 텍스트 필드에 입력한 학번를 tfmb에 저장
            	
            	check(tfmb); // check() 메서드 호출
            	
            	// 재입력을 위한 텍스트 필드 초기화
            	tfMB.setText("");
            }
        });
		btnOK.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnOK.setBackground(new Color(0,105,92));
		btnOK.setForeground(new Color(255,255,255));
		btnOK.setBounds(210, 610, 120, 50);
		add(btnOK);

		btnReInput = new JButton("재입력");
		// 버틀이 눌렸을 때 이벤트 지정
		btnReInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	// 텍스트 필드와 오류 알림 라벨 초기화 시킴
            	tfMB.setText("");
            	lbl2.setText("");
            }
        });
		btnReInput.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnReInput.setBackground(new Color(0,105,92));
		btnReInput.setForeground(new Color(255, 255, 255));
		btnReInput.setBounds(370, 610, 120, 50);
		add(btnReInput);
		
		setVisible(true);
	}

}