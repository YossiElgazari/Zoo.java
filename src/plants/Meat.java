package plants;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import food.EFoodType;
import food.IEdible;
import graphics.IDrawable;
import graphics.ZooPanel;

/**
 * A class for Meat (Food)
 * 
 * @version 1.10 27 Apr 2022
 * @author Yossi Elgazari
 *
 */
public class Meat implements IEdible, IDrawable {

	private BufferedImage img;
	private static Meat MeatInstance = null;

	/**
	 * Constructor for meat
	 * 
	 */
	private Meat() {
		this.img = null;
	}

	public static Meat getInstance() {
		if (MeatInstance == null)
			MeatInstance = new Meat();
		return MeatInstance;
	}

	@Override
	public EFoodType getFoodtype() {
		return EFoodType.MEAT;
	}

	/**
	 * Draws image of Meat on the middle of the screen
	 * 
	 */
	@Override
	public void drawObject(Graphics g) {
		g.drawImage(this.img, 355, 265, 40, 40, null);
	}

	/**
	 * functions that loads image of meat
	 */
	@Override
	public void loadImages(String nm) {
		try {
			this.img = ImageIO.read(new File(IDrawable.PICTURE_PATH + nm + ".gif"));
		} catch (IOException ex) {
			System.out.println("Cannot find image");
		}
	}

	@Override
	public String getColor() {
		return "Natural";
	}

}
