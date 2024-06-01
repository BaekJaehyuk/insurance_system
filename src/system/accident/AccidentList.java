package src.system.accident;

/**
 * @author tiemo
 * @version 1.0
 * @created 29-5-2024
 */
public interface AccidentList {

	public void add(Accident accident);

	public void delete(int accidentId);

	public Accident get(int accidentId);

	public void update(int accidentId, Accident updatedAccident);
}
