package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import animals.Animal;
import plants.Meat;
import plants.Plant;

/**
 * A class for the Zoo Screen Panel which inherited from JPanel
 * 
 * @version 1.10 27 Apr 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 * @see JPanel
 *
 */
@SuppressWarnings("serial")
public class ZooScreenPanel extends JPanel {

	private BufferedImage img;
	private ArrayList<Animal> animalslist;
	private Plant p;
	private Meat m;

	/**
	 * Constructor for zoo screen panel
	 * 
	 * @param animals - array list animals
	 */
	public ZooScreenPanel(ArrayList<Animal> animals) {
		this.setAnimalslist(animals);
		this.setBackground(null);
	}

	/**
	 * Constructor for zoo screen panel
	 * 
	 */
	public ZooScreenPanel() {
		setAnimalslist(new ArrayList<Animal>());
		this.setBackground(null);
	}

	/**
	 * Method that sets background as color received
	 * 
	 * @param c - color
	 */
	public void setColorBG(Color c) {
		this.setBg(null);
		this.setBackground(c);
		this.repaint();
	}

	/**
	 * setter for plant
	 * 
	 * @param p - plant
	 */
	public void setPlant(Plant p) {
		this.p = p;
	}

	/**
	 * Setter for meat
	 * 
	 * @param m - meat
	 */
	public void setMeat(Meat m) {
		this.m = m;
	}

	/**
	 * getter for plant
	 * 
	 * @return plant
	 */
	public Plant getPlant() {
		return this.p;
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
	 * sets background as img received
	 * 
	 * @param img
	 */
	public void setBg(BufferedImage img) {
		this.img = img;
		this.repaint();
	}

	/**
	 * Getter for img
	 * 
	 * @return img
	 */
	public BufferedImage getBg() {
		return this.img;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
		if (this.getAnimalslist() != null) {
			for (int i = 0; i < getAnimalslist().size(); i++) {
				if (getAnimalslist().get(i) != null) {
					if (getAnimalslist().get(i).isDrawable())
						getAnimalslist().get(i).drawObject(g);
				}
			}
		}
		if (this.p != null)
			p.drawObject(g);
		if (this.m != null)
			m.drawObject(g);
	}

	/**
	 * getter for animal list
	 * 
	 * @return animal list
	 */
	public ArrayList<Animal> getAnimalslist() {
		return animalslist;
	}

	/**
	 * setter for animal list
	 * 
	 * @param animalslist - animal list
	 */
	public void setAnimalslist(ArrayList<Animal> animalslist) {
		this.animalslist = animalslist;
	}

}
