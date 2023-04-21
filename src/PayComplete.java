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
		
		CardInsert.lbltimer.setBounds(335, 540, 50, 50); // 절대 위치 지정
		CardInsert.lbltimer.setForeground(new Color(0,105,92)); // 폰트색 지정
		add(CardInsert.lbltimer);
		
		CheckDB.lbltimer.setBounds(335, 540, 50, 50); // 절대 위치 지정
		CheckDB.lbltimer.setForeground(new Color(0,105,92)); // 폰트색 지정
		add(CheckDB.lbltimer);

		lbl1 = new JLabel("결제가 완료되었습니다."); // 라벨 추가
		lbl1.setFont(new Font("맑은 고딕", Font.PLAIN, 18)); // 폰트 설정
		lbl1.setBounds(265, 250, 200, 50);
		add(lbl1);

		lbl2 = new JLabel("해당 번호로 불러드리겠습니다.");
		lbl2.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		lbl2.setBounds(230, 290, 300, 50);
		add(lbl2);

		// 대기 번호 출력
		lblWaitNumber = new JLabel(waitNum+ "번");
		lblWaitNumber.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		lblWaitNumber.setBounds(325, 350, 100, 50);
		add(lblWaitNumber);

		btnReset = new JButton("처음화면으로 돌아가기");
		// 버튼이 눌렸을 때 이벤트 지정
		btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	String sql = "UPDATE mjc_info SET payment=? WHERE id='"+CheckDB.tfid+"'";
            		try {
            			// 동적으로 MySQL의 JDBC 드라이버 클래스 로딩
            			Class.forName("com.mysql.cj.jdbc.Driver");
            			// 자바 어플리케이션을 JDBC 드라이버에 연결시켜주는 클래스
            			connection = DriverManager.getConnection(url, "root","1111");
            			System.out.println(CheckDB.tfid);
            			// SQL문을 실행하여 실행 결과를 넘겨줌
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
            		
            	// 대기 번호가 1번이면 
            	if(waitNum==1) {
            		// 대기 번호가 1씩 증가함
            		waitNum++;
            		// 대기 번호를 출력함
            		lblWaitNumber.setText(waitNum+ "번");
            	}
            	// 타이머 스레드 강제 종료
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
            	
            	// 처음 패널로 넘어감
            	F.nextPanel();
            }
        });
		btnReset.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnReset.setBackground(new Color(0,105,92));
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setBounds(200, 610, 300, 60);
		add(btnReset);

		setVisible(true);		
	}
}
