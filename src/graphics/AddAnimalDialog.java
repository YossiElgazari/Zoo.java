package graphics;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import animals.Animal;
import factory.AnimalFactory;
import factory.FactoryProducer;
import observer.Controller;

/**
 * A class for Add Animal Dialog which inherited from JDialog
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 * @see JDialog
 *
 */
@SuppressWarnings("serial")
public class AddAnimalDialog extends JDialog implements ActionListener {

	private ArrayList<Animal> animals;
	private JComboBox cbAnimalType;
	private JSlider sizeSlider;
	private JSlider xSlider;
	private JSlider ySlider;
	private JComboBox cbAnimalColor;
	private JButton subbutton;
	private JButton prebutton;
	private JTextField textField;
	private ZooPanel zooPanel;
	private ZooScreenPanel imageLabel;
	private ThreadPoolExecutor executor;
	private String type;
	private Controller con = new Controller(zooPanel);

	/**
	 * Constructor for Add Animal Dialog
	 * 
	 * @param animals  - animals array list
	 * @param zooPanel - main panel
	 */
	public AddAnimalDialog(ArrayList<Animal> animals, ZooPanel zooPanel, String type, ThreadPoolExecutor executor,
			Controller con) {

		super();
		this.con = con;
		this.animals = animals;
		this.setSize(600, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		this.setTitle("Add New Animal");
		this.setLayout(null);

		// new Instances
		this.type = type;

		ArrayList<String> animaltypes = new ArrayList<String>();
		if ("Omnivore".equals(this.type)) {
			animaltypes.add("Bear");
		} else if ("Herbivore".equals(this.type)) {
			animaltypes.add("Giraffe");
			animaltypes.add("Turtle");
			animaltypes.add("Elephant");
		} else if ("Carnivore".equals(this.type)) {
			animaltypes.add("Lion");
		}
		this.zooPanel = zooPanel;
		this.executor = executor;
		cbAnimalType = new JComboBox(animaltypes.toArray());
		JPanel animalType = new JPanel();
		JPanel animalSize = new JPanel();
		JPanel xSpeed = new JPanel();
		JPanel ySpeed = new JPanel();
		JPanel color = new JPanel();
		JPanel namePanel = new JPanel();
		JLabel textType = new JLabel("Choose Animal Type: ");
		JLabel textSize = new JLabel("Choose Animal Size: ");
		JLabel textxSpeed = new JLabel("Choose X-Axis Speed: ");
		JLabel textySpeed = new JLabel("Choose Y-Axis Speed: ");
		JLabel textcolor = new JLabel("Choose Color: ");
		JLabel sizeView = new JLabel();
		JLabel nameText = new JLabel("Enter Animal Name: ");
		textField = new JTextField();
		imageLabel = new ZooScreenPanel();

		subbutton = new JButton("Add Animal");
		prebutton = new JButton("Preview Animal");
		sizeSlider = new JSlider(50, 300, 50);
		sizeSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				sizeView.setText("Size = " + sizeSlider.getValue() + "px");
			}
		});

		xSlider = new JSlider(1, 10, 5);
		ySlider = new JSlider(1, 10, 5);
		String[] animalcolors = { "Natural", "Blue", "Red" };
		cbAnimalColor = new JComboBox(animalcolors);

		// decorations
		animalType.setLayout(null);
		cbAnimalType.setFocusable(false);
		animalSize.setLayout(null);
		sizeSlider.setPaintTicks(true);
		sizeSlider.setMinorTickSpacing(5);
		sizeSlider.setMajorTickSpacing(25);
		sizeSlider.setPaintLabels(true);
		xSpeed.setLayout(null);
		xSlider.setMinorTickSpacing(1);
		xSlider.setPaintTicks(true);
		xSlider.setMajorTickSpacing(1);
		xSlider.setPaintLabels(true);
		ySpeed.setLayout(null);
		ySlider.setMinorTickSpacing(1);
		ySlider.setPaintTicks(true);
		ySlider.setMajorTickSpacing(1);
		ySlider.setPaintLabels(true);
		color.setLayout(null);
		cbAnimalColor.setFocusable(false);
		subbutton.setFocusable(false);
		prebutton.setFocusable(false);
		subbutton.addActionListener(this);
		prebutton.addActionListener(this);
		namePanel.setLayout(null);
		textField.setFont(new Font("Serif", Font.BOLD, 18));

		// setBounds
		animalType.setBounds(5, 10, 310, 40);
		textType.setBounds(5, 0, 150, 40);
		cbAnimalType.setBounds(155, 0, 150, 40);

		animalSize.setBounds(5, 60, 530, 40);
		textSize.setBounds(5, 0, 150, 40);
		sizeSlider.setBounds(155, 0, 300, 40);
		sizeView.setBounds(455, 0, 80, 40);

		xSpeed.setBounds(5, 110, 500, 40);
		textxSpeed.setBounds(5, 0, 150, 40);
		xSlider.setBounds(155, 0, 300, 40);

		ySpeed.setBounds(5, 160, 500, 40);
		textySpeed.setBounds(5, 0, 150, 40);
		ySlider.setBounds(155, 0, 300, 40);

		color.setBounds(5, 210, 310, 40);
		textcolor.setBounds(5, 0, 150, 40);
		cbAnimalColor.setBounds(155, 0, 150, 40);

		namePanel.setBounds(5, 260, 310, 40);
		nameText.setBounds(5, 0, 150, 40);
		textField.setBounds(155, 0, 150, 40);

		imageLabel.setBounds(300, 300, 190, 190);
		subbutton.setBounds(30, 500, 120, 40);
		prebutton.setBounds(170, 500, 150, 40);

		// Add to frame
		animalType.add(textType);
		animalType.add(cbAnimalType);
		animalSize.add(textSize);
		animalSize.add(sizeSlider);
		animalSize.add(sizeView);
		xSpeed.add(textxSpeed);
		xSpeed.add(xSlider);
		ySpeed.add(textySpeed);
		ySpeed.add(ySlider);
		color.add(textcolor);
		color.add(cbAnimalColor);
		namePanel.add(nameText);
		namePanel.add(textField);

		this.add(animalType);
		this.add(animalSize);
		this.add(xSpeed);
		this.add(ySpeed);
		this.add(color);
		this.add(namePanel);
		this.add(subbutton);
		this.add(prebutton);
		this.add(imageLabel);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * once we clicked on "add animal", the details of the certain animal will pass
		 * and we will add this animal to the array list
		 */
		if (e.getSource() == subbutton) {
			if (animals.size() < 15) {
				String type = cbAnimalType.getSelectedItem().toString(); // get animal type
				int size = sizeSlider.getValue(); // get animal size
				int xspeed = xSlider.getValue();// get animal x speed
				int yspeed = ySlider.getValue();// get animal y speed
				String color = cbAnimalColor.getSelectedItem().toString(); // get animal color
				String name = textField.getText(); // get animal name
				// get animal pictures by taking the first 3 letters in type and taking the
				// first latter of color
				String img = type.substring(0, 3).toLowerCase();
				AnimalFactory factory = FactoryProducer.getFactory(this.type); // gets the chosen factory
				Animal animal = factory.createAnimal(type, name, xspeed, yspeed, color, size, img, zooPanel, con);
				animal.setChanges(true);
				boolean flag = false;
				for (Animal animall : animals) { // checking if animals asleep
					if (animall.isThreadSuspended()) {
						flag = true;
						break;
					}
				}
				if (flag)
					animal.setSuspended();
				executor.submit(animal); // execute animal
				this.animals.add(animal); // add animal to list

			}
			this.dispose(); // dispose frame
		}
		/*
		 * once we clicked on "preview animal", the details of the certain animal will
		 * pass and we will see picture preview of the animal.
		 */
		if (e.getSource() == prebutton) {
			String type = cbAnimalType.getSelectedItem().toString();
			String color = cbAnimalColor.getSelectedItem().toString();
			String img = IDrawable.PICTURE_PATH + type.substring(0, 3).toLowerCase() + "_"
					+ color.substring(0, 1).toLowerCase() + "_1.png";
			BufferedImage previewimg = null;
			try {
				previewimg = ImageIO.read(new File(img));
			} catch (IOException ex) {
				System.out.println("Cannot find image");
			}
			imageLabel.setBg(previewimg);
		}

	}

}
