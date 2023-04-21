import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardInsert extends LogoFix {

	private JLabel lbl1, lbl2, cardlbl;
	private JButton btnPay, btnCancle;
	String nothing = "no";
	String nothing2 = "no";

	public static Thread thread;
	public static int delayTime;
	public static JLabel lbltimer;
	public static int card;

	void nothing() {
		if(nothing.equals(nothing2)) {
			thread.start();
		}
	}

	public CardInsert(MainFrame f) {

		super(f);

		lbltimer = new JLabel(); // 라벨 생성
		lbltimer.setFont(new Font("함초롬돋움", Font.ITALIC, 30)); // 폰트 설정

		TimerRunnable runnable = new TimerRunnable(lbltimer); // 스레드 객체 생성

		lbl1 = new JLabel("카드를 삽입하거나"); // 라벨 추가
		lbl1.setFont(new Font("맑은 고딕", Font.PLAIN, 23)); // 폰트 설정
		lbl1.setBounds(250, 150, 300, 50);
		add(lbl1);
		
		lbl2 = new JLabel("아래 QR코드를 스캔하시면 결제가 진행됩니다."); // 라벨 추가
		lbl2.setFont(new Font("맑은 고딕", Font.PLAIN, 23)); // 폰트 설정
		lbl2.setBounds(110, 200, 500, 50);
		add(lbl2);
		
		ImageIcon QR = new ImageIcon("image\\QR.jpg");
		
		cardlbl = new JLabel(QR);
		cardlbl.setBounds(65, 170, 570, 480);
		add(cardlbl);

		btnCancle = new JButton("취소");
		// 버튼이 눌렸을 때 이벤트 지정
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// 이전 패널로 넘어감
				F.sevenPreviousPanel();
			}
		});

		btnCancle.setBorderPainted(false);
		btnCancle.setFocusPainted(false);
		btnCancle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnCancle.setBackground(new Color(0, 105, 92));
		btnCancle.setForeground(new Color(255, 255, 255));
		btnCancle.setBounds(210, 610, 120, 50);
		add(btnCancle);

		btnPay = new JButton("확인");
		// 버튼이 눌렸을 때 이벤트 지정
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				for(int i=1; i<2; i++) {
            		thread = new Thread(runnable); // 스레드 생성
            	}
				
				delayTime = 1;
				nothing();
				card = 1;
				CheckDB.lbltimer.setText("");
				
				// 다음 패널로 넘어감
				F.triplePanel();
			}
		});

		btnPay.setBorderPainted(false);
		btnPay.setFocusPainted(false);
		btnPay.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnPay.setBackground(new Color(0, 105, 92));
		btnPay.setForeground(new Color(255, 255, 255));
		btnPay.setBounds(370, 610, 120, 50);
		add(btnPay);

		setVisible(true);
	}

	class TimerRunnable implements Runnable {

		private JLabel lblTimer;

		public TimerRunnable(JLabel lblTimer) {
			this.lblTimer = lblTimer;
		}

		@Override
		public void run() {

			delayTime = 1;

			while (true) {
				lblTimer.setText(Integer.toString(delayTime));
				delayTime++;

				try {
					Thread.sleep(1000); // 스레드가 1초 단위로 동작
				} catch (InterruptedException e) {
					return; // 예외가 발생하면 스레드 종료함
				}

				// 대기시간이 10가 되면
				if (delayTime == 10) {
					// PayComplete의 대기 번호가 1씩 증가함
					PayComplete.waitNum++;
					// PayComplete의 대기 번호 출력
					PayComplete.lblWaitNumber.setText(PayComplete.waitNum + "번");
					// 타이머 스레드 강제 종료
					thread.interrupt();
					MenuInformation.count = 1;
					MenuInformation2.count = 1;
					for (int i = 0; i < MenuInformation.num; i++) {
						Menu.lblList[i].setText("");
					}
					MenuInformation.num = 0;
					for (int i = 0; i < MenuInformation2.num; i++) {
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
					// 다음 패널로 넘어감
					F.nextPanel();
				}
			}
		}
	}

}
