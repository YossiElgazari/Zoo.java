package graphics;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import animals.Animal;

/**
 * A class for Animal Information Table which inherited from JFrame
 * 
 * @version 1.10 27 Apr 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 * @see JFrame
 *
 */
@SuppressWarnings("serial")
public class AnimalsInfoTable extends JFrame {

	/**
	 * Constructor for Animals Information Table
	 * 
	 * @param animals - animals array list
	 */
	public AnimalsInfoTable(ArrayList<Animal> animals) {
		super();
		Animal[] animalsArray = animals.toArray(new Animal[0]);
		int eatCounter = 0;
		String[] cols = { "Animal", "Color", "Weight", "Hor.speed", "Ver.speed", "Eat counter" };
		String[][] data = new String[animals.size() + 1][6];
		for (int i = 0; i < animalsArray.length; i++) {
			data[i][0] = String.format("%s", animalsArray[i].getAnimalName() + " : " + animalsArray[i].getName());
			data[i][1] = String.format("%s", animalsArray[i].getColor());
			data[i][2] = String.format("%.5f", animalsArray[i].getWeight());
			data[i][3] = String.format("%d", animalsArray[i].getHorSpeed());
			data[i][4] = String.format("%d", animalsArray[i].getVerSpeed());
			data[i][5] = String.format("%d", animalsArray[i].getEatCount());
			eatCounter += animalsArray[i].getEatCount();
		}
		data[data.length - 1][0] = "Total:";
		data[data.length - 1][5] = String.format("%d", eatCounter);
		JTable j = new JTable(data, cols);
		JScrollPane sp = new JScrollPane(j);
		this.add(sp);
		this.pack();
		this.setVisible(true);

	}

}
