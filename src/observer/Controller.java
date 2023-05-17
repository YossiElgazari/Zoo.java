package observer;

import java.util.Observable;
import java.util.Observer;

import graphics.ZooPanel;

/**
 * class that holds and manages zoo panel
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 * @see Oberver
 */
public class Controller implements Observer {

	private ZooPanel zoo;

	/**
	 * Constructor for controller
	 * 
	 * @param zoo - zoo panel
	 */
	public Controller(ZooPanel zoo) {
		this.zoo = zoo;
	}

	/**
	 * 
	 */
	@Override
	public void update(Observable o, Object arg) {
		zoo.manageZoo();
	}

}
