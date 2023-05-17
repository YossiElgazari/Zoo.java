package graphics;


/**
 * An interface for Animal Behavior 
 * 
 * @version 1.10 27 Apr 2022
 * @author Yossi Elgazari
 * @author Shai Matzliah
 *
 */
public interface IAnimalBehavior {
	public String getAnimalName();

	public int getSize();

	public void eatInc();

	public int getEatCount();

	public boolean getChanges();

	public void setChanges(boolean state);
	
	public void setResumed();
	
	public void setSuspended();
}
