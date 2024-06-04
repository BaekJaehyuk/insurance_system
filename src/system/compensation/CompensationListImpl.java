package src.system.compensation;

import java.util.ArrayList;

public class CompensationListImpl implements CompensationList {

    private ArrayList<Compensation> compensationList;

    public CompensationListImpl() {
        this.compensationList = new ArrayList<Compensation>();
    }

    @Override
    public boolean add(Compensation compensation) {
        return this.compensationList.add(compensation);
    }

    @Override
    public boolean delete(long compensationId) {
        for (Compensation compensation : this.compensationList) {
            if (compensation.getCompensationId() == compensationId) {
                this.compensationList.remove(compensation);
                return true;
            }
        }
        return false;
    }

    @Override
    public Compensation get(long compensationId) {
        for (Compensation compensation : this.compensationList) {
            if (compensation.getCompensationId() == compensationId)
                return compensation;
        }
        return null;
    }

    @Override
    public ArrayList<Compensation> get() {
        return compensationList;
    }

    @Override
    public void update(long compensationId, Compensation updatedCompensation) {

    }
}
