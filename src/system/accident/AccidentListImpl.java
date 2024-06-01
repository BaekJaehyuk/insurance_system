package src.system.accident;

import java.util.ArrayList;
import java.util.List;

public class AccidentListImpl implements AccidentList {

	private List<Accident> accidentList;

	public AccidentListImpl() {
		this.accidentList = new ArrayList<>();
	}

	@Override
	public void add(Accident accident) {
		accidentList.add(accident);
	}

	@Override
	public void delete(int accidentId) {
		accidentList.removeIf(accident -> accident.accidentId == accidentId);
	}

	@Override
	public Accident get(int accidentId) {
		return accidentList.stream()
				.filter(accident -> accident.accidentId == accidentId)
				.findFirst()
				.orElse(null);
	}

	@Override
	public void update(int accidentId, Accident updatedAccident) {
		for (int i = 0; i < accidentList.size(); i++) {
			if (accidentList.get(i).accidentId == accidentId) {
				accidentList.set(i, updatedAccident);
				return;
			}
		}
	}
}
