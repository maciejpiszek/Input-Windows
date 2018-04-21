import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class WindowView extends JFrame {
	
	
	 private final WindowController windowController;
	 private JFrame startWindow = new JFrame();
	 private JFrame childWindow = new JFrame();
	 private JPanel panelStart = new JPanel();
	 private JPanel textPanelStart = new JPanel();
	 private JPanel buttonPanelStart = new JPanel();
	 private JPanel panelChildInput = new JPanel();
	 private JLabel text0 = new JLabel("Hello in my GUI");
	 private JLabel text1 = new JLabel("application");
	 private JButton jOpenStart = new JButton("Open window"); 
	 private JButton jAddChild = new JButton("Add"); 
	 private JTextArea textAreaChild = new JTextArea();
	 private JTextField textInputChild = new JTextField();
	 private JScrollPane jScrollPanel = new JScrollPane();
		
	
	 public WindowView (WindowController windowController) {
		 
		this.windowController = windowController;

	 }
	  
	 
	 public void startWindow() {
		 		
		 
		startWindow.setTitle("Start Window");
		panelStart.setLayout(new BoxLayout(panelStart, BoxLayout.Y_AXIS));
		startWindow.add(panelStart);						
		panelStart.add(textPanelStart);
		textPanelStart.setBackground(Color.WHITE);
		panelStart.add(buttonPanelStart);
		buttonPanelStart.setBackground(Color.WHITE);		
		textPanelStart.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 35));
		text0.setFont(new Font("Arial", Font.PLAIN, 17));
		text1.setFont(new Font("Arial", Font.PLAIN, 17));
		textPanelStart.add(text0);
		textPanelStart.add(text1);							
		buttonPanelStart.add(jOpenStart);
		jOpenStart.addActionListener (new ActionListener() {
	          
			public void actionPerformed(ActionEvent e) {
		
				windowController.onButtonClickStart(e);
					
			}
	    });
	
		startWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);		
		startWindow.setPreferredSize (new Dimension (300,200));		
		startWindow.pack();
		startWindow.setVisible(true);
		
	 }
	 	  		 

	 public void childWindow() {
		

		childWindow.setTitle("Child Window");		
		childWindow.setLayout(new BorderLayout());		
		jScrollPanel = new JScrollPane(textAreaChild);
		textAreaChild.setEditable(false);
		textAreaChild.setFont(new Font("Arial", Font.PLAIN, 18));		
		childWindow.add(jScrollPanel, BorderLayout.CENTER);
		childWindow.add(panelChildInput, BorderLayout.SOUTH);		
		panelChildInput.setLayout(new BoxLayout(panelChildInput, BoxLayout.X_AXIS));
		panelChildInput.add(textInputChild);
		textInputChild.setFont(new Font("Arial", Font.PLAIN, 18));	
		textInputChild.setToolTipText("Enter data here");
		panelChildInput.add(jAddChild);		
		textInputChild.addActionListener(new ActionListener() {
	          
			public void actionPerformed(ActionEvent e) {
	
				windowController.onButtonClickChild(e);
			  
			}
		});
		
		jAddChild.addActionListener (new ActionListener() {
		          
			public void actionPerformed(ActionEvent e) {
				  
				windowController.onButtonClickChild(e);
				  
				  
			}
		});
		 
		childWindow.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		childWindow.setPreferredSize (new Dimension (350,350));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		childWindow.setLocation ((int) (Math.random()*(width-350)), (int) (Math.random()*(height-350)));
		childWindow.pack();
		childWindow.setVisible(true);
			 
	 }
		 
	 
	 public String getData() {
		 
		return textInputChild.getText();

	 }

	 
	 public void resetInput() {
		 
		textInputChild.setText("");
		 
	 }


	 public void setData (String data) {
		
		textAreaChild.setText(data);
	
	 }
}
