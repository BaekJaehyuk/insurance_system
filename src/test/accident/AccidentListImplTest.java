package src.test.accident;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.system.accident.Accident;
import src.system.accident.AccidentListImpl;

import static org.junit.jupiter.api.Assertions.*;

class AccidentListImplTest {

    private AccidentListImpl accidentList;
    private Accident accident1;
    private Accident accident2;

    @BeforeEach
    void setUp() {
        accidentList = new AccidentListImpl();
        accident1 = new Accident(1, 101, 5000, 20240529, "photo1.jpg", 3, 1001, 2001, 1, 1230, 2, 3, "John Doe", "010-1234-5678", 2);
        accident2 = new Accident(2, 102, 7000, 20240530, "photo2.jpg", 4, 1002, 2002, 2, 1240, 3, 4, "Jane Doe", "010-8765-4321", 3);
    }

    @Test
    void testAdd() {
        accidentList.add(accident1);
        assertEquals(accident1, accidentList.get(1));
    }

    @Test
    void testDelete() {
        accidentList.add(accident1);
        accidentList.delete(1);
        assertNull(accidentList.get(1));
    }

    @Test
    void testGet() {
        accidentList.add(accident1);
        assertEquals(accident1, accidentList.get(1));
    }

    @Test
    void testUpdate() {
        accidentList.add(accident2);
        Accident updatedAccident = new Accident(2, 102, 8000, 20240530, "photo2_updated.jpg", 5, 1002, 2002, 2, 1245, 3, 4, "Jane Doe", "010-8765-4321", 3);
        accidentList.update(2, updatedAccident);
        assertEquals(updatedAccident, accidentList.get(2));
    }
}