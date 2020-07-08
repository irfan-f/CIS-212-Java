import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Painter
{	
	public static void main(String[] args)
	{
		JButton colorButtonBlack = new JButton("Black");
		JButton colorButtonGreen = new JButton("Green");
		JButton colorButtonYellow = new JButton("Yellow");
		JButton colorButtonBlue = new JButton("Blue");
		JButton penButtonLarge = new JButton("Large");
		JButton penButtonMedium = new JButton("Medium");
		JButton penButtonSmall = new JButton("Small");
		JButton clearButton = new JButton("Clear");
		JFrame application = new JFrame("A simple paint program");
		application.add(new JLabel("Drag the mouse to draw"), BorderLayout.SOUTH);
		
		
		MainPanel mainPanel = new MainPanel();
		application.add(mainPanel, BorderLayout.CENTER);
		
		penButtonLarge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				mainPanel.changePenSize(11);
			}
		});
		
		penButtonMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				mainPanel.changePenSize(7);
			}
		});
		
		penButtonSmall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				mainPanel.changePenSize(3);
			}
		});
		
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				mainPanel.clearCanvas();
			}
		});
			colorButtonBlack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				mainPanel.changePenColor(Color.black);
			}
		});
		
		colorButtonGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				mainPanel.changePenColor(Color.green);
			}
		});
		
		colorButtonYellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				mainPanel.changePenColor(Color.yellow);
			}
		});
		
		colorButtonBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				mainPanel.changePenColor(Color.blue);
			}
		});
		JPanel colorButtons = new JPanel();
		JPanel penButtons = new JPanel();
		
		GridLayout singleColumnLayout = new GridLayout(4,1);
		GridLayout singleRowLayout = new GridLayout(1,4);
		colorButtons.setLayout(singleColumnLayout);
		penButtons.setLayout(singleRowLayout);
		colorButtons.add(colorButtonBlack);
		colorButtons.add(colorButtonGreen);
		colorButtons.add(colorButtonYellow);
		colorButtons.add(colorButtonBlue);
		penButtons.add(penButtonLarge);
		penButtons.add(penButtonMedium);
		penButtons.add(penButtonSmall);
		penButtons.add(clearButton);
		
		application.add(colorButtons, BorderLayout.WEST);
		application.add(penButtons, BorderLayout.NORTH);
		
		//get screen dimensions
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		//set window size to 50% of width, height of screen and place in center
		application.setSize(screenWidth / 2, screenHeight / 2);
		application.setLocation(screenWidth / 4, screenHeight / 4);
		
		application.setVisible(true);
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
