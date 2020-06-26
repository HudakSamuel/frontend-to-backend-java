package sk.fei.stuba.zadanie3.services.contract_specific;

import org.springframework.stereotype.Service;
import sk.fei.stuba.zadanie3.domain.contracts.Contract;
import sk.fei.stuba.zadanie3.domain.contracts.life.InjuryInsurance;
import sk.fei.stuba.zadanie3.domain.contracts.life.LifeInsurance;
import sk.fei.stuba.zadanie3.domain.contracts.life.TravelInsurance;
import sk.fei.stuba.zadanie3.domain.contracts.non_life.HouseAndFlatInsurance;
import sk.fei.stuba.zadanie3.domain.contracts.non_life.HouseholdInsurance;
import sk.fei.stuba.zadanie3.domain.contracts.non_life.Non_lifeInsurance;
import sk.fei.stuba.zadanie3.services.ListOperationsService;
import sk.fei.stuba.zadanie3.domain.Address;
import sk.fei.stuba.zadanie3.domain.user.User;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class BasicContractService implements ListOperationsService, CreateContractService, ContractSpecificService {

    private List<Contract> contractList;

    public BasicContractService(){
        this.contractList = new LinkedList<Contract>();
    }

    public void createInjuryInsuranceContract(LocalDateTime dateOfCreation, User assurer, String dateOfBegginingOfInsurance, String dateOfEndOfInsurance, double insuranceAmount,
                                              double monthlyPayment, User assured, double permanentInjury, double death, double dailyHospitalizationAmount, int validArea){

        int prevID = findLastID();
        InjuryInsurance contract = new InjuryInsurance(prevID,dateOfCreation,assurer,dateOfBegginingOfInsurance,dateOfEndOfInsurance,insuranceAmount,monthlyPayment,
                                                       assured,permanentInjury, death,dailyHospitalizationAmount,validArea);

        this.contractList.add(contract);
        if (assured != assurer) {
            assured.getContractList().add(contract);
        }
        assurer.getContractList().add(contract);
    }

    public void createTravelInsuranceContract(LocalDateTime dateOfCreation, User assurer, String dateOfBegginingOfInsurance, String dateOfEndOfInsurance, double insuranceAmount,
                                              double monthlyPayment, User assured, boolean inEU, int tripPurpouse) {

        int prevID = findLastID();
        TravelInsurance contract = new TravelInsurance(prevID,dateOfCreation,assurer,dateOfBegginingOfInsurance,dateOfEndOfInsurance,insuranceAmount,monthlyPayment,
                                                       assured,inEU,tripPurpouse);

        this.contractList.add(contract);
        if (assured != assurer) {
            assured.getContractList().add(contract);
        }
        assurer.getContractList().add(contract);
    }

    public void createHouseAndFlatInsuranceContract(LocalDateTime dateOfCreation, User assurer, String dateOfBegginingOfInsurance, String dateOfEndOfInsurance, double insuranceAmount,
                                                    double monthlyPayment, int propertyType, Address propertyAddress, double propertyValue, boolean garageInsurance) {

        int prevID = findLastID();
        HouseAndFlatInsurance contract = new HouseAndFlatInsurance(prevID,garageInsurance,dateOfCreation,assurer,dateOfBegginingOfInsurance,dateOfEndOfInsurance,insuranceAmount,
                                                                   monthlyPayment,propertyType,propertyAddress,propertyValue);

        this.contractList.add(contract);
        assurer.getContractList().add(contract);
    }

    public void createHouseholdInsuranceContract(LocalDateTime dateOfCreation, User assurer, String dateOfBegginingOfInsurance, String dateOfEndOfInsurance, double insuranceAmount,
                                                 double monthlyPayment, int propertyType, Address propertyAddress, double propertyValue, double furnitureValue) {

        int prevID = findLastID();
        HouseholdInsurance contract = new HouseholdInsurance(prevID,furnitureValue,dateOfCreation,assurer,dateOfBegginingOfInsurance,dateOfEndOfInsurance,insuranceAmount,
                                                             monthlyPayment,propertyType,propertyAddress,propertyValue);

        this.contractList.add(contract);
        assurer.getContractList().add(contract);
    }

    public void modifyInjuryInsuranceContract(int contract_id, LocalDateTime dateOfCreation, User assurer, String dateOfBegginingOfInsurance, String dateOfEndOfInsurance,
                                              double insuranceAmount, double monthlyPayment, User assured, double permanentInjury, double death, double dailyHospitalizationAmount,
                                              int validArea){

        Contract maybeInjuryContract = findContract(contract_id);
        if (maybeInjuryContract instanceof InjuryInsurance){

            InjuryInsurance injuryContract = (InjuryInsurance) maybeInjuryContract;

            setGeneralContractInfo(injuryContract,dateOfCreation,assurer,dateOfBegginingOfInsurance,dateOfEndOfInsurance,insuranceAmount,monthlyPayment);
            setGeneralLifeInfo(injuryContract,assured);
            injuryContract.setPermanentInjury(permanentInjury);
            injuryContract.setDeath(death);
            injuryContract.setDailyHospitalizationAmount(dailyHospitalizationAmount);
            injuryContract.setValidArea(validArea);
        }
        else { System.out.println("Invalid contract type" + "\n"); }
    }

    public void modifyTravelInsuranceContract(int contract_id, LocalDateTime dateOfCreation, User assurer, String dateOfBegginingOfInsurance, String dateOfEndOfInsurance,
                                              double insuranceAmount, double monthlyPayment, User assured, boolean inEU, int tripPurpouse){

        Contract maybeTravelContract = findContract(contract_id);
        if (maybeTravelContract instanceof TravelInsurance){

            TravelInsurance travelContract = (TravelInsurance) maybeTravelContract;

            setGeneralContractInfo(travelContract,dateOfCreation,assurer,dateOfBegginingOfInsurance,dateOfEndOfInsurance,insuranceAmount,monthlyPayment);
            setGeneralLifeInfo(travelContract,assured);
            travelContract.setInEU(inEU);
            travelContract.setTripPurpouse(tripPurpouse);
        }
        else { System.out.println("Invalid contract type" + "\n"); }
    }

    public void modifyHouseAndFlatInsuranceContract(int contract_id, LocalDateTime dateOfCreation, User assurer, String dateOfBegginingOfInsurance, String dateOfEndOfInsurance,
                                                    double insuranceAmount, double monthlyPayment, int propertyType, Address propertyAddress, double propertyValue, boolean garageInsurance){

        Contract maybeHouseAndFlatContract = findContract(contract_id);
        if (maybeHouseAndFlatContract instanceof HouseAndFlatInsurance){

            HouseAndFlatInsurance houseAndFlatContract = (HouseAndFlatInsurance) maybeHouseAndFlatContract;

            setGeneralContractInfo(houseAndFlatContract,dateOfCreation,assurer,dateOfBegginingOfInsurance,dateOfEndOfInsurance,insuranceAmount,monthlyPayment);
            setGeneralNonLifeInfo(houseAndFlatContract,propertyType,propertyAddress,propertyValue);
            houseAndFlatContract.setGarageInsurance(garageInsurance);
        }
        else { System.out.println("Invalid contract type" + "\n"); }
    }

    public void modifyHouseholdInsuranceContract(int contract_id, LocalDateTime dateOfCreation, User assurer, String dateOfBegginingOfInsurance, String dateOfEndOfInsurance,
                                                 double insuranceAmount, double monthlyPayment, int propertyType, Address propertyAddress, double propertyValue, double furnitureValue){

        Contract maybeHouseholdContract = findContract(contract_id);
        if (maybeHouseholdContract instanceof HouseholdInsurance){

            HouseholdInsurance householdContract = (HouseholdInsurance) maybeHouseholdContract;

            setGeneralContractInfo(householdContract,dateOfCreation,assurer,dateOfBegginingOfInsurance,dateOfEndOfInsurance,insuranceAmount,monthlyPayment);
            setGeneralNonLifeInfo(householdContract,propertyType,propertyAddress,propertyValue);
            householdContract.setFurnitureValue(furnitureValue);
        }
        else { System.out.println("Invalid contract type" + "\n"); }
    }

    public int findLastID(){

        if (this.contractList.size() == 0){
            return 0;
        }
        Iterator<Contract> iterator = this.contractList.iterator();
        Iterator<Contract> tempIterator = this.contractList.iterator();

        while(iterator.hasNext()){
            tempIterator.next();
            if (!tempIterator.hasNext()){
                Contract contract = iterator.next();
                return contract.getId();
            }
            iterator.next();
        }

        return 0;
    }

    public void listAll(){

        if (this.contractList.size() > 0){
            for (int index = 0; index < this.contractList.size(); index++) {
                System.out.println(this.contractList.get(index).getId() + " - " + this.contractList.get(index).getDateOfCreation() + " - " + this.contractList.get(index).getAssurer().getLastName());
            }
        }
        System.out.println("\n");
    }

    public void listAssurerContracts(List<User> userList, int id){

        if (userList.size() > 0){

            for (int index = 0; index < userList.size(); index++){
                if (userList.get(index).getId() == id){

                    List<Contract> userContractList = userList.get(index).getContractList();
                    for(int contractIndex = 0; contractIndex < userContractList.size(); contractIndex++){

                        User ContractAssurer = userContractList.get(contractIndex).getAssurer();
                        if(ContractAssurer.getId() == id){
                            System.out.println(userContractList.get(contractIndex));
                        }

                    }

                }
            }
            System.out.println("\n");
        }
    }

    public Contract findContract(int contract_id){
        if (this.contractList.size() > 0){
            for (int index = 0; index < this.contractList.size(); index++){
                if (this.contractList.get(index).getId() == contract_id){
                    return this.contractList.get(index);
                }
            }
        }
        System.out.println("Contract not found" + "\n");
        return null;
    }

    private void setGeneralContractInfo(Contract contract, LocalDateTime dateOfCreation, User assurer, String dateOfBegginingOfInsurance, String dateOfEndOfInsurance, double insuranceAmount,
                                       double monthlyPayment){

        contract.setDateOfCreation(dateOfCreation);
        contract.setAssurer(assurer);
        contract.setDateOfBegginingOfInsurance(dateOfBegginingOfInsurance);
        contract.setDateOfEndOfInsurance(dateOfEndOfInsurance);
        contract.setInsuranceAmount(insuranceAmount);
        contract.setMonthlyPayment(monthlyPayment);
    }

    private void setGeneralNonLifeInfo(Non_lifeInsurance contract, int propertyType, Address propertyAddress, double propertyValue){

        contract.setPropertyType(propertyType);
        contract.setPropertyAddress(propertyAddress);
        contract.setPropertyValue(propertyValue);
    }

    private void setGeneralLifeInfo(LifeInsurance contract, User assured){
        contract.setAssured(assured);
    }
}
