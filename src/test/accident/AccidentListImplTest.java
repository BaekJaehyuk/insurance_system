/*package src.test.accident;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.system.accident.Accident;
import src.system.accident.AccidentFactory;
import src.system.accident.AccidentListImpl;

import static org.junit.jupiter.api.Assertions.*;

class AccidentListImplTest {

    private AccidentListImpl accidentList;
    private Accident personalInjuryAccident;
    private Accident liabilityAccident;
    private Accident propertyDamageAccident;

    @BeforeEach
    void setUp() {
        accidentList = new AccidentListImpl();
        personalInjuryAccident = AccidentFactory.createAccident("PersonalInjury", 1, "Car accident", "2024-05-29", "Seoul", 101, new String[]{"3", "2"});
        liabilityAccident = AccidentFactory.createAccident("Liability", 2, "House fire", "2024-06-01", "Busan", 102, new String[]{"record1", "4", "Jane Doe", "010-8765-4321"});
        propertyDamageAccident = AccidentFactory.createAccident("PropertyDamage", 3, "Tree fall on car", "2024-06-15", "Incheon", 103, new String[]{"Car"});

        accidentList.add(personalInjuryAccident);
        accidentList.add(liabilityAccident);
        accidentList.add(propertyDamageAccident);
    }

    @Test
    void testAddAndGet() {
        assertEquals(personalInjuryAccident, accidentList.get(1));
        assertEquals(liabilityAccident, accidentList.get(2));
        assertEquals(propertyDamageAccident, accidentList.get(3));
    }

    @Test
    void testDelete() {
        accidentList.delete(2);
        assertNull(accidentList.get(2));
    }

    @Test
    void testUpdate() {
        Accident updatedAccident = AccidentFactory.createAccident("PersonalInjury", 1, "Updated car accident", "2024-05-29", "Seoul", 101, new String[]{"4", "3"});
        accidentList.update(1, updatedAccident);
        assertEquals(updatedAccident, accidentList.get(1));
    }
}*/
