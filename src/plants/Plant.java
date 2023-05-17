package plants;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import food.EFoodType;
import food.IEdible;
import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.ILocatable;
import mobility.Point;

/**
 * @author baroh
 *
 */
public abstract class Plant implements IEdible, ILocatable, IDrawable {
	private double height;
	private Point location;
	private double weight;
	private BufferedImage img;

	/**
	 * 
	 */
	public Plant() {
		Random rand = new Random();
		int x = rand.nextInt(40);
		int y = rand.nextInt(12);
		this.location = new Point(x, y);
		this.height = rand.nextInt(30);
		this.weight = rand.nextInt(12);
		
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see food.IFood#getFoodtype()
	 */
	@Override
	public EFoodType getFoodtype() {
		return EFoodType.VEGETABLE;
	}

	/**
	 * @return
	 */
	public double getHeight() {
		return this.height;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mobility.ILocatable#getLocation()
	 */
	@Override
	public Point getLocation() {
		return this.location;
	}

	/**
	 * @return
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param height
	 * @return
	 */
	public boolean setHeight(double height) {

		boolean isSuccess = (height >= 0);
		if (isSuccess) {
			this.height = height;
		} else {
			this.height = 0;
		}
		return isSuccess;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mobility.ILocatable#setLocation(mobility.Point)
	 */
	@Override
	public boolean setLocation(Point newLocation) {
		boolean isSuccess = Point.cheackBounderies(newLocation);
		if (isSuccess) {
			this.location = newLocation;
		}
		return isSuccess;
	}

	/**
	 * @param weight
	 * @return
	 */
	public boolean setWeight(double weight) {
		boolean isSuccess = (weight >= 0);
		if (isSuccess) {
			this.weight = weight;
		} else {
			this.weight = 0;
		}

		return isSuccess;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + this.getClass().getSimpleName() + "] ";
	}

	@Override
	public String getColor() {
		return "";
	}

	@Override
	public void drawObject(Graphics g) {
		g.drawImage(this.img, 355, 265, 40, 40, null);
	}

	@Override
	public void loadImages(String nm) {
		try {
			this.img = ImageIO.read(new File(IDrawable.PICTURE_PATH + nm + ".png"));
		} catch (IOException ex) {
			System.out.println("Cannot find image");
		}
	}

}
