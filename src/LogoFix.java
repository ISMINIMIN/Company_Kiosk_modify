import java.awt.*;
import javax.swing.*;

public class LogoFix extends JPanel {
	protected MainFrame F;
	protected JLabel lbltitle, logoLabel, welcomeLabel;
	
	public LogoFix(MainFrame f) {
		ImageIcon logo = new ImageIcon("image\\logo_2.png");
		
		setSize(700, 650); // 패널 크기
		setLayout(null);
		setBackground(new Color(189,215,238)); // 배경색 지정

		F = f;
		
		logoLabel = new JLabel(logo);
		logoLabel.setBounds(150, 20, 400, 100);
		add(logoLabel);
	} 
}
