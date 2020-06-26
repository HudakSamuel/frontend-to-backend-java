package sk.fei.stuba.zadanie3.services.contract_specific;

import org.springframework.stereotype.Service;
import sk.fei.stuba.zadanie3.domain.Address;
import sk.fei.stuba.zadanie3.domain.user.User;

import java.time.LocalDateTime;

@Service
public interface CreateContractService {

    void createInjuryInsuranceContract(LocalDateTime dateOfCreation, User assurer, String dateOfBegginingOfInsurance, String dateOfEndOfInsurance, double insuranceAmount,
                                       double monthlyPayment, User assured, double permanentInjury, double death, double dailyHospitalizationAmount, int validArea);

    void createTravelInsuranceContract(LocalDateTime dateOfCreation, User assurer, String dateOfBegginingOfInsurance, String dateOfEndOfInsurance, double insuranceAmount,
                                       double monthlyPayment, User assured, boolean inEU, int tripPurpouse);

    void createHouseAndFlatInsuranceContract(LocalDateTime dateOfCreation, User assurer, String dateOfBegginingOfInsurance, String dateOfEndOfInsurance, double insuranceAmount,
                                             double monthlyPayment, int propertyType, Address propertyAddress, double propertyValue, boolean garageInsurance);

    void createHouseholdInsuranceContract(LocalDateTime dateOfCreation, User assurer, String dateOfBegginingOfInsurance, String dateOfEndOfInsurance, double insuranceAmount,
                                          double monthlyPayment, int propertyType, Address propertyAddress, double propertyValue, double furnitureValue);

    void modifyInjuryInsuranceContract(int contract_id, LocalDateTime dateOfCreation, User assurer, String dateOfBegginingOfInsurance,
                                       String dateOfEndOfInsurance, double insuranceAmount, double monthlyPayment, User assured, double permanentInjury,
                                       double death, double dailyHospitalizationAmount, int validArea);

    void modifyTravelInsuranceContract(int contract_id, LocalDateTime dateOfCreation, User assurer, String dateOfBegginingOfInsurance,
                                       String dateOfEndOfInsurance, double insuranceAmount, double monthlyPayment, User assured, boolean inEU, int tripPurpouse);

    void modifyHouseAndFlatInsuranceContract(int contract_id, LocalDateTime dateOfCreation, User assurer, String dateOfBegginingOfInsurance,
                                             String dateOfEndOfInsurance, double insuranceAmount, double monthlyPayment, int propertyType, Address propertyAddress,
                                             double propertyValue, boolean garageInsurance);

    void modifyHouseholdInsuranceContract(int contract_id, LocalDateTime dateOfCreation, User assurer, String dateOfBegginingOfInsurance,
                                          String dateOfEndOfInsurance, double insuranceAmount, double monthlyPayment, int propertyType, Address propertyAddress,
                                          double propertyValue, double furnitureValue);
}
