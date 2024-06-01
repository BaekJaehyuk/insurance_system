package src.system.accident;

import java.util.ArrayList;

/**
 * @author SW
 * @version 1.0
 * @created 29-5-2024
 */
public class AccidentListImpl implements AccidentList {

	private ArrayList<Accident> AccidentList;
	public Accident m_Accident;

	public AccidentListImpl() {
		this.AccidentList = new ArrayList<>();
	}

	public void finalize() throws Throwable {

	}

	public void add(Accident accident) {
		AccidentList.add(accident);
	}

	public void delete(int accidentId) {
		AccidentList.removeIf(accident -> accident.getAccidentId() == accidentId);
	}

	public Accident get(int accidentId) {
		for (Accident accident : AccidentList) {
			if (accident.getAccidentId() == accidentId) {
				return accident;
			}
		}
		return null;
	}

	public void update(int accidentId, Accident updatedAccident) {
		for (int i = 0; i < AccidentList.size(); i++) {
			if (AccidentList.get(i).getAccidentId() == accidentId) {
				AccidentList.set(i, updatedAccident);
				break;
			}
		}
	}
}
