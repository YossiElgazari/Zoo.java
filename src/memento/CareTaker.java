package memento;

import java.util.Stack;

/**
 * class that holds stack of states to back up
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 *
 */
public class CareTaker {
	private Stack<ZooStateMemento> states;

	/**
	 * Constructor for care taker
	 * 
	 */
	public CareTaker() {
		states = new Stack<ZooStateMemento>();
	}

	/**
	 * save the current state and push it to the stack
	 * 
	 * @param state - state
	 */
	public void save(ZooStateMemento state) {

		if (states.size() > 3)
			states.removeElementAt(0);
		states.push(state);
	}

	/**
	 * restoring previous state by popping from stack
	 * 
	 * @return state
	 */
	public ZooStateMemento restore() {
		return states.pop();
	}
}
