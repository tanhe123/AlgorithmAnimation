import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class AnimationFrame extends JFrame{
	public AnimationFrame() {
		ArrayComponent comp = new ArrayComponent();
		add(comp, BorderLayout.CENTER);
					
		final Sorter sorter = new Sorter(comp);
		
		JButton runButton = new JButton("Run");
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sorter.setRun();
			}
		});
		
		JButton stepButton = new JButton("Step");
		stepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sorter.setStep();
			}
		});
		
		JPanel buttons = new JPanel();
		buttons.add(runButton);
		buttons.add(stepButton);
		add(buttons, BorderLayout.NORTH);
				
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		//setTitle("AnimationFrame");
		new Thread(sorter).start();
	}
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
}
