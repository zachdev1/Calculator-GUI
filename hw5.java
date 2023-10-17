package cop2805;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class hw5 {
	private static void constructGUI() {
	JFrame.setDefaultLookAndFeelDecorated(true);
	TestFrame frame = new TestFrame();
	frame.setVisible(true);
}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				constructGUI();
			}	
		});
	}
}


class TestFrame extends JFrame {
	public JTextField firstNum;
	public JTextField secondNum;
	public JComboBox mathSigns;
	public JButton calculate;
	public JLabel result;
	
	public TestFrame() {
		super();
		init();
	}
	private void init() {
		
		firstNum = new JTextField();
		secondNum = new JTextField();
		String[] signs = { "Add" , "Subtract" , "Multiply" , "Divide"};
		mathSigns = new JComboBox(signs);
		calculate = new JButton("Calculate");
		result = new JLabel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Simple Calculator");
		this.setLayout(new GridLayout(5, 2));
		
		this.add(new JLabel("First Number: "));
		this.add(firstNum);

		this.add(new JLabel("Second Number:"));
		this.add(secondNum);

		this.add(new JLabel(""));
		this.add(mathSigns);

		
		this.add(new JLabel(""));
		this.add(calculate);
		calculate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();
				String buttonText = source.getText();
				double firstNumS = Double.parseDouble(firstNum.getText());
				double secondNumS = Double.parseDouble(secondNum.getText());
				String mathSignSelected = (String) mathSigns.getSelectedItem();
				if(mathSignSelected == "Add") {
					double addResult = firstNumS + secondNumS;
					result.setText(String.valueOf(addResult)); 
				}
				else if(mathSignSelected == "Subtract") {
					double subtractionResult = firstNumS - secondNumS;
					result.setText(String.valueOf(subtractionResult));
				}
				else if(mathSignSelected == "Multiply") {
					double multiplyResult = firstNumS * secondNumS;
					result.setText(String.valueOf(multiplyResult));
				}
				else if(mathSignSelected == "Divide") {
					double divideResult = firstNumS / secondNumS;
					result.setText(String.valueOf(divideResult));
				}
			}
		});
		this.add(new JLabel("Result:"));
		this.add(result);
		int frameWidth = 500;
		int frameHeight = 200;
		Dimension screenSize =
			Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((int) screenSize.getWidth() - frameWidth, 0,
		frameWidth, frameHeight);
	}
}