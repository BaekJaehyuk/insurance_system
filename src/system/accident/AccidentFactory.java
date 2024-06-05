package src.system.accident;

import src.system.Driver;
import src.system.Insurance;
import src.system.OwnCar;
import src.system.user.Customer;

public class AccidentFactory {
    public static Accident createAccident(String type, long accidentId, String accidentDetails, String date, String location, Customer customer, String[] additionalParams) {
        boolean hasDriverInsurance = false;
        boolean hasAutoInsurance = false;

        for (Insurance insurance : customer.getInsuranceList()) {
            if (insurance instanceof Driver) {
                hasDriverInsurance = true;
            } else if (insurance instanceof OwnCar) {
                hasAutoInsurance = true;
            }
        }

        if ("PersonalInjury".equals(type)) {
            if (additionalParams.length < 2) {
                throw new IllegalArgumentException("Invalid parameters for Personal Injury Accident");
            }
            if (!hasDriverInsurance) {
                return new PersonalInjuryAccident(accidentId, accidentDetails, date, location, customer.getCustomerID(), Integer.parseInt(additionalParams[0]), Integer.parseInt(additionalParams[1]), "Rejected");
            }
            return new PersonalInjuryAccident(accidentId, accidentDetails, date, location, customer.getCustomerID(), Integer.parseInt(additionalParams[0]), Integer.parseInt(additionalParams[1]), "Pending");
        } else if ("Liability".equals(type)) {
            if (additionalParams.length < 4) {
                throw new IllegalArgumentException("Invalid parameters for Liability Accident");
            }
            if (!hasAutoInsurance) {
                return new LiabilityAccident(accidentId, accidentDetails, date, location, customer.getCustomerID(), additionalParams[0], Integer.parseInt(additionalParams[1]), additionalParams[2], additionalParams[3], "Rejected");
            }
            return new LiabilityAccident(accidentId, accidentDetails, date, location, customer.getCustomerID(), additionalParams[0], Integer.parseInt(additionalParams[1]), additionalParams[2], additionalParams[3], "Pending");
        } else if ("PropertyDamage".equals(type)) {
            if (additionalParams.length < 1) {
                throw new IllegalArgumentException("Invalid parameters for Property Damage Accident");
            }
            if (!hasAutoInsurance) {
                return new PropertyDamageAccident(accidentId, accidentDetails, date, location, customer.getCustomerID(), additionalParams[0], "Rejected");
            }
            return new PropertyDamageAccident(accidentId, accidentDetails, date, location, customer.getCustomerID(), additionalParams[0], "Pending");
        } else {
            throw new IllegalArgumentException("Unknown accident type");
        }
    }
}
