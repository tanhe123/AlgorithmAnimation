import java.awt.BorderLayout;

import javax.swing.JFrame;


public class AnimationFrame extends JFrame{
	public AnimationFrame() {
		ArrayComponent comp = new ArrayComponent();
		add(comp, BorderLayout.CENTER);
		
		Double[] values = new Double[20];
		for (int i=0; i<values.length; i++) {
			values[i] = new Double(Math.random());
			comp.setValues(values, values[0], values[1]);
		}
			
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("AnimationFrame");
	}
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
}
