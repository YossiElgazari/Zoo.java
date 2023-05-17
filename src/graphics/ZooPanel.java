package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import animals.Animal;
import decorator.BluePaintAnimal;
import decorator.NaturalPaintAnimal;
import decorator.RedPaintAnimal;
import memento.CareTaker;
import memento.Originator;
import memento.ZooStateMemento;
import mobility.Point;
import observer.Controller;
import plants.Cabbage;
import plants.Lettuce;
import plants.Meat;
import plants.Plant;

/**
 * A class for the Zoo Panel which inherited from JPanel
 * 
 * @version 1.10 27 Apr 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 * @see JPanel
 *
 */
@SuppressWarnings("serial")
public class ZooPanel extends JPanel implements Cloneable {

	public static final int screenwidth = 355;
	public static final int screenheight = 265;
	private static ZooPanel zooPanelInstance = null;
	private ArrayList<Animal> animals;
	private Meat m;
	private Plant p;
	boolean foodExist = false;
	private ZooScreenPanel screen;
	private JPanel zButtons;
	private JButton addanimal;
	private JButton changecolor;
	private JButton wakeup;
	private JButton sleep;
	private JButton savestate;
	private JButton restorestate;
	private JButton clear;
	private JButton food;
	private JButton info;
	private JButton exit;
	private final Point center = new Point(355, 265);
	private ThreadPoolExecutor executor;
	private Originator originator;
	private CareTaker careTaker;
	private int saveCount;
	protected ZooStateMemento state;
	public Controller con;

	/**
	 * Contractor for zoo panel
	 */
	private ZooPanel() {
		super();
		executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
		animals = new ArrayList<Animal>(); // creating empty array list
		screen = new ZooScreenPanel(animals);
		screen.setLayout(null);
		zButtons = new JPanel();
		this.m = screen.getMeat();
		this.p = screen.getPlant();
		this.setLayout(new BorderLayout());
		careTaker = new CareTaker();
		originator = new Originator();
		con = new Controller(this);

		// Buttons
		zButtons.setLayout(new FlowLayout());
		addanimal = new JButton("<html><center>Add<br>Animal</center></html>");
		changecolor = new JButton("<html><center>Change<br>Color</center></html>");
		wakeup = new JButton("<html><center>Wake<br>Up</center></html>");
		sleep = new JButton("Sleep");
		savestate = new JButton("<html><center>Save<br>State</center></html>");
		restorestate = new JButton("<html><center>Restore<br>State</center></html>");
		clear = new JButton("Clear");
		food = new JButton("Food");
		info = new JButton("Info");
		exit = new JButton("Exit");

		addanimal.setFocusable(false);
		changecolor.setFocusable(false);
		wakeup.setFocusable(false);
		sleep.setFocusable(false);
		savestate.setFocusable(false);
		restorestate.setFocusable(false);
		clear.setFocusable(false);
		food.setFocusable(false);
		info.setFocusable(false);
		exit.setFocusable(false);

		addanimal.setPreferredSize(new Dimension(70, 40));
		changecolor.setPreferredSize(new Dimension(75, 40));
		wakeup.setPreferredSize(new Dimension(70, 40));
		sleep.setPreferredSize(new Dimension(70, 40));
		savestate.setPreferredSize(new Dimension(70, 40));
		restorestate.setPreferredSize(new Dimension(75, 40));
		clear.setPreferredSize(new Dimension(70, 40));
		food.setPreferredSize(new Dimension(70, 40));
		info.setPreferredSize(new Dimension(70, 40));
		exit.setPreferredSize(new Dimension(70, 40));

		zButtons.add(addanimal);
		zButtons.add(changecolor);
		zButtons.add(sleep);
		zButtons.add(wakeup);
		zButtons.add(savestate);
		zButtons.add(restorestate);
		zButtons.add(clear);
		zButtons.add(food);
		zButtons.add(info);
		zButtons.add(exit);

		/*
		 * action listener for add animal dialog
		 */
		addanimal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (animals.size() < 15) {
					String[] diets = { "Carnivore", "Herbivore", "Omnivore" };
					int choice = JOptionPane.showOptionDialog(screen, "Please Choose Animal Type:", "Animals Types",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, diets, null);
					if (choice != JOptionPane.CLOSED_OPTION)
						new AddAnimalDialog(animals, returnThis(), diets[choice], executor, con);
				} else {
					JOptionPane.showMessageDialog(returnThis(), "You cannot add more than 10 animals", "Message",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		/*
		 * action listener for changing color
		 */
		changecolor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (animals.size() > 0) {
					Animal selectedAnimal = selectAnimal();
					String[] colors = { "Natural", "Red", "Blue" };
					int choice = JOptionPane.showOptionDialog(screen, "Please Choose Color:", "Change Color",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, colors, null);
					if (choice != JOptionPane.CLOSED_OPTION) {
						if (colors[choice].equals("Red")) {
							new RedPaintAnimal(selectedAnimal);

						} else if (colors[choice].equals("Blue")) {
							new BluePaintAnimal(selectedAnimal);

						} else if (colors[choice].equals("Natural")) {
							new NaturalPaintAnimal(selectedAnimal);

						}
					}
				} else
					JOptionPane.showMessageDialog(screen, "Add Animals First!", "Message",
							JOptionPane.INFORMATION_MESSAGE);
			}
		});

		/*
		 * action listener for waking up animal
		 */
		sleep.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (animals.size() > 0) {
					for (Animal animal : animals) {
						animal.setSuspended();
					}
				} else
					JOptionPane.showMessageDialog(screen, "Add Animals First!", "Message",
							JOptionPane.INFORMATION_MESSAGE);
			}
		});

		/*
		 * action listener for waking up animal
		 */
		wakeup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (animals.size() > 0) {
					for (Animal animal : animals) {
						animal.setResumed();
					}
				} else
					JOptionPane.showMessageDialog(screen, "Add Animals First!", "Message",
							JOptionPane.INFORMATION_MESSAGE);
			}
		});

		/*
		 * action listener for saving the state of the zoo
		 */
		savestate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				originator.setAnimals(animals);
				originator.setImg(screen.getBg());
				originator.setBackground(screen.getBackground());
				if (foodExist)
					if (m != null)
						originator.setFood("Meat");
					else
						originator.setFood(p.getClass().getSimpleName());
				careTaker.save(originator.saveState());
				if (saveCount < 3)
					saveCount++;
			}
		});

		/*
		 * action listener for restore the state of the zoo
		 */
		restorestate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (saveCount > 0) {
					state = careTaker.restore();
					animals.clear();
					animals = new ArrayList<Animal>(state.getAnimals().size());
					executor.shutdown();
					executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
					for (int i = 0; i < state.getAnimals().size(); i++) {
						try {
							Animal animal = (Animal) state.getAnimals().get(i).clone();
							animals.add(animal);
							executor.submit(animal);
						} catch (CloneNotSupportedException e1) {
							System.out.println("Cant copy " + animals.get(i).toString());
						}
					}
					screen.setAnimalslist(animals);
					if (state.getImg() == null)
						screen.setColorBG(state.getBackground());
					else
						screen.setBg(state.getImg());
					if (state.getFood() != null) {
						if (state.getFood().equals("Meat"))
							createFood(2);
						else if (state.getFood().equals("Cabbage"))
							createFood(1);
						else if (state.getFood().equals("Lettuce"))
							createFood(0);
						else
							createFood(3);
					}
					saveCount--;
					repaint();
				} else
					JOptionPane.showMessageDialog(screen, "Save state first!", "Message",
							JOptionPane.INFORMATION_MESSAGE);

			}
		});

		/*
		 * clearing all animals
		 */
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (animals.size() > 0) {
					for (Animal animal : animals)
						animal.stop();
					animals.clear();
					repaint();
				} else
					JOptionPane.showMessageDialog(screen, "No Animals To Clear!", "Message",
							JOptionPane.INFORMATION_MESSAGE);
			}
		});

		/*
		 * action listener for adding food on the screen
		 */
		food.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] foods = { "Lettuce", "Cabbage", "Meat" };
				int choice = JOptionPane.showOptionDialog(screen, "Please Choose Food:", "Food For Animals",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, foods, foods[0]);
				if (choice != -1)
					createFood(choice);
				repaint();
			}
		});
		/*
		 * Action Listener for animal information table
		 */
		info.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (animals.size() > 0)
					new AnimalsInfoTable(animals);
				else
					JOptionPane.showMessageDialog(screen, "Add Animals First!", "Message",
							JOptionPane.INFORMATION_MESSAGE);
			}
		});
		/*
		 * exit program
		 */
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exitProgram();
				System.exit(0);
			}
		});

		zButtons.setBackground(Color.black);
		this.add(screen, BorderLayout.CENTER);
		this.add(zButtons, BorderLayout.SOUTH);
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public static ZooPanel getInstance() {
		if (zooPanelInstance == null) {
			zooPanelInstance = new ZooPanel();
		}
		return zooPanelInstance;
	}

	/**
	 * setting background as the color received
	 * 
	 * @param c - color
	 */
	public void setBg(Color c) {
		this.screen.setColorBG(c);
	}

	/**
	 * setting savanna background
	 * 
	 */
	public void setBG() {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(IDrawable.PICTURE_PATH + "savanna.png"));
		} catch (IOException ex) {
			System.out.println("Cannot find image");
		}

		this.screen.setBg(img);
	}

	public void exitProgram() {
		this.executor.shutdown();
	}

	/**
	 * @return this instance
	 */
	public ZooPanel returnThis() {
		return this;
	}

	public void createFood(int choice) {
		if (foodExist) {
			p = null;
			m = null;
			screen.setMeat(null);
			screen.setPlant(null);
		}
		if (choice == 0) {

			p = Lettuce.getInstance(); // creating instance of lettuce
			p.loadImages("lettuce");
			screen.setPlant(p);
			foodExist = true;
		} else if (choice == 1) {
			p = Cabbage.getInstance(); // creating instance of cabbage
			p.loadImages("cabbage");
			screen.setPlant(p);
			foodExist = true;
		} else if (choice == 2) {
			m = Meat.getInstance(); // creating instance of meat
			m.loadImages("meat");
			screen.setMeat(m);
			foodExist = true;
		} else if (choice == 3) {
			p = null;
			m = null;
			screen.setMeat(null);
			screen.setPlant(null);
			foodExist = false;
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.screen.repaint();
	}

	/**
	 * checking if there's is a change in animal location
	 * 
	 * @return change in animal location
	 */
	private boolean isChange() {
		for (int i = 0; i < animals.size(); i++)
			if (animals.get(i).getChanges()) {
				animals.get(i).setChanges(false);
				return true;
			}
		return false;
	}

	/**
	 * getter for meat
	 * 
	 * @return meat
	 */
	public Meat getMeat() {
		return this.m;
	}

	/**
	 * setter for meat
	 * 
	 */
	public void setMeat(Meat m) {
		this.m = m;
	}

	/**
	 * getter for Plant
	 * 
	 * @return Plant
	 */
	public Plant getPlant() {
		return this.p;
	}

	/**
	 * setter for Plant
	 * 
	 */
	public void setPlant(Plant p) {
		this.p = p;
	}

	/**
	 *  Manages the zoo, checking whether animal can eat another or if there is food on the screen and which animal can or should eat it.
	 */
	public synchronized void manageZoo() {
		if(isChange()) {
			repaint();
		}
		if (animals.size() > 0) {
			if (animals.size() > 1) {
				for (int i = 0; i < animals.size(); i++) {
					for (int j = 0; j < animals.size(); j++) {
						if (i != j) {
							if (animals.get(i).getDiet().canEat(animals.get(j).getFoodtype())) {
								if (animals.get(i).getWeight() > 2 * animals.get(j).getWeight()) {
									if (animals.get(i).calcDistance(animals.get(j).getLocation()) < animals.get(j)
											.getSize()) {
										animals.get(i).eat(animals.get(j));
										animals.get(j).stop();
										animals.remove(j);
									}
								}
							}
						}
					}
				}
			}

			if (foodExist && !animals.get(0).isThreadSuspended()) {
				for (int i = 0; i < animals.size(); i++) {
					if (this.m != null) {
						if (animals.get(i).getDiet().canEat(m.getFoodtype())) {
							if (animals.get(i).calcDistance(center) > Animal.EAT_DISTANCE) {
								animals.get(i).setEatflag(true);
							} else if (this.m != null) {
								animals.get(i).eat(m);
								foodExist = false;
								this.m = null;
								screen.setMeat(null);
								for (int j = 0; j < animals.size(); j++)
									animals.get(j).setEatflag(false);
							}
						}
					} else if (this.p != null) {
						if (animals.get(i).getDiet().canEat(p.getFoodtype())) {
							if (animals.get(i).calcDistance(center) > Animal.EAT_DISTANCE) {
								animals.get(i).setEatflag(true);
							} else if (this.p != null) {
								animals.get(i).eat(p);
								foodExist = false;
								this.p = null;
								screen.setPlant(null);
								for (int j = 0; j < animals.size(); j++)
									animals.get(j).setEatflag(false);
							}
						}
					}

				}

			}

		}
		repaint();
	}


	/**
	 * Selects animal from list of the active animals on the scren
	 * 
	 * @return selected animal
	 */
	public Animal selectAnimal() {
		JFrame frame = new JFrame();
		frame.setAlwaysOnTop(true);
		Object[] options = animals.toArray();
		Animal selectionObject = (Animal) JOptionPane.showInputDialog(this, "Choose", "Menu", JOptionPane.PLAIN_MESSAGE,
				null, options, null);
		return selectionObject;
	}

}
