import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.SliderUI;

import SortAlgorithm.Sort;


public class AnimationFrame extends JFrame{
	public AnimationFrame() {
		final ArrayComponent comp = new ArrayComponent();
		add(comp, BorderLayout.CENTER);

		JSlider slider = new JSlider();
		slider.setMaximum(1000);
		slider.setMinimum(3);
		slider.setValue(500);
		final JLabel label =  new JLabel("数据量: " + slider.getValue());
				
		sorter = new Sorter(comp);
		
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

		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider)e.getSource();
				if (!source.getValueIsAdjusting()) {
					label.setText("数据量: " + source.getValue());
					
					sorter.stop();
					sorter.setLength(source.getValue());
					sorter = new Sorter(comp);
					new Thread(sorter).start();
				}
			}
		});

		
		JPanel buttons = new JPanel();
		buttons.add(runButton);
		buttons.add(stepButton);
		add(buttons, BorderLayout.NORTH);
		
		// 组合框
		final JComboBox<String> combox = new JComboBox<>();
		combox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String algorithmName = (String)combox.getSelectedItem();
				
				sorter.stop();
				sorter.setAlgorhm(algorithmName);
				sorter = new Sorter(comp);
				new Thread(sorter).start();
			}
		});
		
		// 为组合框添加元素
		for (Sort e : Sorter.algorithms)
			combox.addItem(e.getName());

		JPanel selectPanel = new JPanel();
		add(selectPanel, BorderLayout.SOUTH);
		selectPanel.add(label);
		selectPanel.add(slider);
		selectPanel.add(combox);
		
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		//setTitle("AnimationFrame");
		new Thread(sorter).start();
	}
	
	private Sorter sorter;
	
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 500;
}
