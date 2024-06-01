package src.system.accident;

public class AccidentFactory {
    public static Accident createAccident(String type, int accidentId, String accidentDetails, String date, String location, int memberId, String[] additionalParams) {
        switch (type) {
            case "PersonalInjury":
                int injuryDegree = Integer.parseInt(additionalParams[0]);
                int vehicleDamageDegree = Integer.parseInt(additionalParams[1]);
                return new PersonalInjuryAccident(accidentId, accidentDetails, date, location, memberId, injuryDegree, vehicleDamageDegree);
            case "Liability":
                String medicalRecords = additionalParams[0];
                int victimInjuryDegree = Integer.parseInt(additionalParams[1]);
                String victimName = additionalParams[2];
                String victimPhoneNumber = additionalParams[3];
                return new LiabilityAccident(accidentId, accidentDetails, date, location, memberId, medicalRecords, victimInjuryDegree, victimName, victimPhoneNumber);
            case "PropertyDamage":
                String damagedPropertyType = additionalParams[0];
                return new PropertyDamageAccident(accidentId, accidentDetails, date, location, memberId, damagedPropertyType);
            default:
                throw new IllegalArgumentException("Unknown accident type");
        }
    }
}
