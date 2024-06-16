package src.system.accident;
import java.util.*;

/**
 * @author tiemo
 * @version 1.0
 * @created 29-5-2024
 */
public interface AccidentList {

	public void add(Accident accident);

	public void delete(long accidentId);

	public Accident get(long accidentId);

	public ArrayList<Accident> get();

	public ArrayList<Accident> getReportedAccidentList();

	public void update(long accidentId, Accident updatedAccident);
}
