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

		lbltimer = new JLabel(); // �� ����
		lbltimer.setFont(new Font("���ʷҵ���", Font.ITALIC, 30)); // ��Ʈ ����

		TimerRunnable runnable = new TimerRunnable(lbltimer); // ������ ��ü ����

		lbl1 = new JLabel("ī�带 �����ϰų�"); // �� �߰�
		lbl1.setFont(new Font("���� ���", Font.PLAIN, 23)); // ��Ʈ ����
		lbl1.setBounds(250, 150, 300, 50);
		add(lbl1);
		
		lbl2 = new JLabel("�Ʒ� QR�ڵ带 ��ĵ�Ͻø� ������ ����˴ϴ�."); // �� �߰�
		lbl2.setFont(new Font("���� ���", Font.PLAIN, 23)); // ��Ʈ ����
		lbl2.setBounds(110, 200, 500, 50);
		add(lbl2);
		
		ImageIcon QR = new ImageIcon("image\\QR.jpg");
		
		cardlbl = new JLabel(QR);
		cardlbl.setBounds(65, 170, 570, 480);
		add(cardlbl);

		btnCancle = new JButton("���");
		// ��ư�� ������ �� �̺�Ʈ ����
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// ���� �гη� �Ѿ
				F.sevenPreviousPanel();
			}
		});

		btnCancle.setBorderPainted(false);
		btnCancle.setFocusPainted(false);
		btnCancle.setFont(new Font("���� ���", Font.BOLD, 20));
		btnCancle.setBackground(new Color(0, 105, 92));
		btnCancle.setForeground(new Color(255, 255, 255));
		btnCancle.setBounds(210, 610, 120, 50);
		add(btnCancle);

		btnPay = new JButton("Ȯ��");
		// ��ư�� ������ �� �̺�Ʈ ����
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				for(int i=1; i<2; i++) {
            		thread = new Thread(runnable); // ������ ����
            	}
				
				delayTime = 1;
				nothing();
				card = 1;
				CheckDB.lbltimer.setText("");
				
				// ���� �гη� �Ѿ
				F.triplePanel();
			}
		});

		btnPay.setBorderPainted(false);
		btnPay.setFocusPainted(false);
		btnPay.setFont(new Font("���� ���", Font.BOLD, 20));
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
					Thread.sleep(1000); // �����尡 1�� ������ ����
				} catch (InterruptedException e) {
					return; // ���ܰ� �߻��ϸ� ������ ������
				}

				// ���ð��� 10�� �Ǹ�
				if (delayTime == 10) {
					// PayComplete�� ��� ��ȣ�� 1�� ������
					PayComplete.waitNum++;
					// PayComplete�� ��� ��ȣ ���
					PayComplete.lblWaitNumber.setText(PayComplete.waitNum + "��");
					// Ÿ�̸� ������ ���� ����
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
					// ���� �гη� �Ѿ
					F.nextPanel();
				}
			}
		}
	}

}
