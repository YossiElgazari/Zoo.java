package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * A class for the Zoo Frame which inherited from JFrame
 * 
 * @version 1.10 27 Apr 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 * @see JFrame
 *
 */
@SuppressWarnings("serial")
public class ZooFrame extends JFrame implements ActionListener {

	private ZooPanel zPanel;
	private JMenuBar menubar;
	private JMenu filemenu;
	private JMenu bgMenu;
	private JMenu helpmenu;
	private JMenuItem exitItem;
	private JMenuItem imageItem;
	private JMenuItem greenItem;
	private JMenuItem noneItem;
	private JMenuItem helpItem;

	/**
	 * Constructor for zoo frame
	 * 
	 */
	public ZooFrame() {
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(800, 630);
		this.setResizable(false);
		this.setTitle("Zoo");

		// Menu bar
		menubar = new JMenuBar();

		filemenu = new JMenu("File");
		bgMenu = new JMenu("Background");
		helpmenu = new JMenu("Help");

		exitItem = new JMenuItem("Exit");
		imageItem = new JMenuItem("Image");
		greenItem = new JMenuItem("Green");
		noneItem = new JMenuItem("None");
		helpItem = new JMenuItem("Help");

		exitItem.addActionListener(this);
		imageItem.addActionListener(this);
		greenItem.addActionListener(this);
		noneItem.addActionListener(this);
		helpItem.addActionListener(this);

		menubar.add(filemenu);
		menubar.add(bgMenu);
		menubar.add(helpmenu);

		filemenu.add(exitItem);

		bgMenu.add(imageItem);
		bgMenu.add(greenItem);
		bgMenu.add(noneItem);

		helpmenu.add(helpItem);

		zPanel = ZooPanel.getInstance();
		this.setJMenuBar(menubar);
		this.add(zPanel);
		this.setVisible(true);

	}

	/**
	 * Action listener for menu item
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == imageItem)
			zPanel.setBG();

		if (e.getSource() == greenItem)
			zPanel.setBg(Color.green);

		if (e.getSource() == noneItem)
			zPanel.setBg(null);

		if (e.getSource() == helpItem)
			JOptionPane.showMessageDialog(zPanel, "Home Work 2\nGUI", "Message", JOptionPane.INFORMATION_MESSAGE);

		if (e.getSource() == exitItem) {
			zPanel.exitProgram();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new ZooFrame();

	}

}
