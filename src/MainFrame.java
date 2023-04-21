import java.awt.*; // 그래픽 처리를 위한 클래스들의 경로명
import javax.swing.*;

public class MainFrame extends JFrame {
	private CardLayout layout = new CardLayout();
	
	public MainFrame() {
		setTitle("GreenPot"); //타이틀
		setSize(720, 770); // 프레임 크기
		setResizable(false); // 프레임 사이즈 고정
		setLocationRelativeTo(null); // 사용자 화면의 가운데에서 실행
		Toolkit toolkit = getToolkit();
		Image image = toolkit.createImage("C:\\Java_space\\GreenPot_Kiosk\\image\\idea.png");
		setIconImage(image);
		getContentPane().setLayout(layout);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 닫고 응용 프로그램이 종료
		
		// 프레임에 연결된 컨텐트팬을 알아내 패널을 삽입함
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
		
		setVisible(true); // 프레임 출력
	}
	
	public void nextPanel() {
		// 다음 패널로 넘어감
		layout.next(this.getContentPane());
	}

	public void jumpPanel() { 
		// 두개의 패널이 넘어감
		layout.next(this.getContentPane());
		layout.next(this.getContentPane());
	}
	
	public void triplePanel() { 
		// 세개의 패널이 넘어감
		layout.next(this.getContentPane());
		layout.next(this.getContentPane());
		layout.next(this.getContentPane());
	}
	
	public void jump2Panel() { 
		// 네개의 패널이 넘어감
		layout.next(this.getContentPane());
		layout.next(this.getContentPane());
		layout.next(this.getContentPane());
		layout.next(this.getContentPane());
	}
	
	public void jumpTriplePanel() { 
		// 다섯개의 패널이 넘어감
		layout.next(this.getContentPane());
		layout.next(this.getContentPane());
		layout.next(this.getContentPane());
		layout.next(this.getContentPane());
		layout.next(this.getContentPane());
	}

	public void previousPanel() {
		// 이전 패널로 넘어감
		layout.previous(this.getContentPane());
	}
	
	public void jumpPreviousPanel() {
		// 두개 전 패널로 넘어감
		layout.previous(this.getContentPane());
		layout.previous(this.getContentPane());
	}
	
	public void triplePreviousPanel() {
		// 세개 전 패널로 넘어감
		layout.previous(this.getContentPane());
		layout.previous(this.getContentPane());
		layout.previous(this.getContentPane());
	}
	
	public void jump2PreviousPanel() {
		// 네개 전 패널로 넘어감
		layout.previous(this.getContentPane());
		layout.previous(this.getContentPane());
		layout.previous(this.getContentPane());
		layout.previous(this.getContentPane());
	}
	
	public void sevenPreviousPanel() {
		// 일곱개 전 패널로 넘어감
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
