package src.system.compensation;
import java.util.ArrayList;

public interface CompensationList {

    public boolean add(Compensation compensation);

    public boolean delete(long compensationId);

    public Compensation get(long compensationId);

    public ArrayList<Compensation> get();

    public void update(long compensationId, Compensation updatedCompensation);
}
