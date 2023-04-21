import java.awt.*; // �׷��� ó���� ���� Ŭ�������� ��θ�
import javax.swing.*;

public class MainFrame extends JFrame {
	private CardLayout layout = new CardLayout();
	
	public MainFrame() {
		setTitle("GreenPot"); //Ÿ��Ʋ
		setSize(720, 770); // ������ ũ��
		setResizable(false); // ������ ������ ����
		setLocationRelativeTo(null); // ����� ȭ���� ������� ����
		Toolkit toolkit = getToolkit();
		Image image = toolkit.createImage("C:\\Java_space\\GreenPot_Kiosk\\image\\idea.png");
		setIconImage(image);
		getContentPane().setLayout(layout);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������ �ݰ� ���� ���α׷��� ����
		
		// �����ӿ� ����� ����Ʈ���� �˾Ƴ� �г��� ������
		getContentPane().add("FirstPage", new Welcome_GreenPot(this));
		getContentPane().add("MenuPage", new Menu(this));
		getContentPane().add("SelectPage", new MenuInformation(this));
		getContentPane().add("Menu2Page", new Menu2(this));
		getContentPane().add("Select2Page", new MenuInformation2(this));
		getContentPane().add("PayPage", new SelectMenuList(this));
		getContentPane().add("PayWayPage", new PaymentWay(this));
		getContentPane().add("MembershipPage", new Membership(this));
		getContentPane().add("SKTPage", new SKT_PayTotal(this));
		getContentPane().add("LGPage", new LG_PayTotal(this));
		getContentPane().add("KTPage", new KT_PayTotal(this));
		getContentPane().add("CardPage", new Card_PayTotal(this));
		getContentPane().add("MembershipCheckPage", new Membership_CheckDB(this));
		getContentPane().add("CardInsertPage", new CardInsert(this));
		getContentPane().add("CheckPayPage", new PayTotal(this));
		getContentPane().add("CheckDBPage", new CheckDB(this));
		getContentPane().add("CompletePage", new PayComplete(this));
		
		setVisible(true); // ������ ���
	}
	
	public void nextPanel() {
		// ���� �гη� �Ѿ
		layout.next(this.getContentPane());
	}

	public void jumpPanel() { 
		// �ΰ��� �г��� �Ѿ
		layout.next(this.getContentPane());
		layout.next(this.getContentPane());
	}
	
	public void triplePanel() { 
		// ������ �г��� �Ѿ
		layout.next(this.getContentPane());
		layout.next(this.getContentPane());
		layout.next(this.getContentPane());
	}
	
	public void jump2Panel() { 
		// �װ��� �г��� �Ѿ
		layout.next(this.getContentPane());
		layout.next(this.getContentPane());
		layout.next(this.getContentPane());
		layout.next(this.getContentPane());
	}
	
	public void jumpTriplePanel() { 
		// �ټ����� �г��� �Ѿ
		layout.next(this.getContentPane());
		layout.next(this.getContentPane());
		layout.next(this.getContentPane());
		layout.next(this.getContentPane());
		layout.next(this.getContentPane());
	}

	public void previousPanel() {
		// ���� �гη� �Ѿ
		layout.previous(this.getContentPane());
	}
	
	public void jumpPreviousPanel() {
		// �ΰ� �� �гη� �Ѿ
		layout.previous(this.getContentPane());
		layout.previous(this.getContentPane());
	}
	
	public void triplePreviousPanel() {
		// ���� �� �гη� �Ѿ
		layout.previous(this.getContentPane());
		layout.previous(this.getContentPane());
		layout.previous(this.getContentPane());
	}
	
	public void jump2PreviousPanel() {
		// �װ� �� �гη� �Ѿ
		layout.previous(this.getContentPane());
		layout.previous(this.getContentPane());
		layout.previous(this.getContentPane());
		layout.previous(this.getContentPane());
	}
	
	public void sevenPreviousPanel() {
		// �ϰ��� �� �гη� �Ѿ
		layout.previous(this.getContentPane());
		layout.previous(this.getContentPane());
		layout.previous(this.getContentPane());
		layout.previous(this.getContentPane());
		layout.previous(this.getContentPane());
		layout.previous(this.getContentPane());
		layout.previous(this.getContentPane());
	}
	
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
	}

}
