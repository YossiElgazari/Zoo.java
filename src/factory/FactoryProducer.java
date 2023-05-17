package factory;

/**
 * Class that "Produces" the specific chosen factory
 * 
 * @version 1.10 30 Mar 2022
 * @author Yossi Elgazari
 * @author Shai Matzliach
 *
 */
public class FactoryProducer {

	/**
	 * Getting the chosen factory
	 * 
	 * @param type - factory type
	 * @return factory
	 */
	public static AnimalFactory getFactory(String type) {
		if ("Omnivore".equals(type)) {
			return new OmnivoreFactory();
		} else if ("Herbivore".equals(type)) {
			return new HerbivoreFactory();
		} else if ("Carnivore".equals(type)) {
			return new CarnivoreFactory();
		}
		return null;
	}

}
