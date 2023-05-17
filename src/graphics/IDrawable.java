package graphics;

import java.awt.Graphics;


/**
 * An interface for Animal Drawing 
 * 
 * @version 1.10 27 Apr 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 *
 */
public interface IDrawable {
	public final static String PICTURE_PATH = "C:/Zoo/src/graphics/images/"; // need to change to your path!!

	public void loadImages(String nm);

	public void drawObject(Graphics g);

	public String getColor();
}
