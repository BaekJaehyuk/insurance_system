package src.system.accident;

import src.system.insurance.Driver;
import src.system.insurance.Insurance;
import src.system.insurance.OwnCar;
import src.system.user.Customer;

import java.util.concurrent.atomic.AtomicLong;

public class AccidentFactory {
    private static final AtomicLong accidentIdGenerator = new AtomicLong(1);

    public static Accident createAccident(String type, String accidentDetails, String date, String location, Customer customer, String carNumber, String[] additionalParams) {
        long accidentId = accidentIdGenerator.getAndIncrement();
        boolean hasDriverInsurance = false;
        boolean hasAutoInsurance = false;

        for (Insurance insurance : customer.getInsuranceList()) {
            if (insurance instanceof Driver) {
                hasDriverInsurance = true;
            } else if (insurance instanceof OwnCar) {
                hasAutoInsurance = true;
            }
        }

        if ("본인상해".equals(type)) {
            if (additionalParams.length < 4) {
                throw new IllegalArgumentException("Invalid parameters for Personal Injury Accident");
            }
            if (!hasDriverInsurance) {
                return new PersonalInjuryAccident(accidentId, accidentDetails, date, location, customer.getCustomerID(), carNumber, Integer.parseInt(additionalParams[0]), Integer.parseInt(additionalParams[1]), additionalParams[2], additionalParams[3], "Rejected");
            }
            return new PersonalInjuryAccident(accidentId, accidentDetails, date, location, customer.getCustomerID(), carNumber, Integer.parseInt(additionalParams[0]), Integer.parseInt(additionalParams[1]), additionalParams[2], additionalParams[3], "Pending");
        } else if ("대인배상".equals(type)) {
            if (additionalParams.length < 4) {
                throw new IllegalArgumentException("Invalid parameters for Liability Accident");
            }
            if (!hasAutoInsurance) {
                return new LiabilityAccident(accidentId, accidentDetails, date, location, customer.getCustomerID(), carNumber, additionalParams[0], Integer.parseInt(additionalParams[1]), additionalParams[2], additionalParams[3], "Rejected");
            }
            return new LiabilityAccident(accidentId, accidentDetails, date, location, customer.getCustomerID(), carNumber, additionalParams[0], Integer.parseInt(additionalParams[1]), additionalParams[2], additionalParams[3], "Pending");
        } else if ("대물배상".equals(type)) {
            if (additionalParams.length < 3) {
                throw new IllegalArgumentException("Invalid parameters for Property Damage Accident");
            }
            if (!hasAutoInsurance) {
                return new PropertyDamageAccident(accidentId, accidentDetails, date, location, customer.getCustomerID(), carNumber, additionalParams[0], additionalParams[1], additionalParams[2], "Rejected");
            }
            return new PropertyDamageAccident(accidentId, accidentDetails, date, location, customer.getCustomerID(), carNumber, additionalParams[0], additionalParams[1], additionalParams[2], "Pending");
        } else {
            throw new IllegalArgumentException("Unknown accident type");
        }
    }
}
