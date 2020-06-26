package sk.fei.stuba.zadanie3.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sk.fei.stuba.zadanie3.domain.contracts.Contract;
import sk.fei.stuba.zadanie3.domain.contracts.life.InjuryInsurance;
import sk.fei.stuba.zadanie3.domain.contracts.life.TravelInsurance;
import sk.fei.stuba.zadanie3.domain.contracts.non_life.HouseAndFlatInsurance;
import sk.fei.stuba.zadanie3.domain.contracts.non_life.HouseholdInsurance;
import sk.fei.stuba.zadanie3.web.domain_models.*;
import sk.fei.stuba.zadanie3.domain.user.User;
import sk.fei.stuba.zadanie3.web.domain_models.UserModel;
import sk.fei.stuba.zadanie3.services.contract_specific.BasicContractService;
import sk.fei.stuba.zadanie3.services.user_specific.BasicUserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private BasicUserService userService;
    private BasicContractService contractService;

    @Autowired
    public UserController(BasicUserService userService, BasicContractService contractService) {
        this.userService = userService;
        this.contractService = contractService;
    }

    @GetMapping("/")
    public String menu(){
        return "user/menu";
    }

    @GetMapping("/list_users")
    public String printAll(Model model){
        model.addAttribute("users", userService.getList());
        return "user/all";
    }

    @GetMapping("/details/{id}")
    public String userDetails(@PathVariable int id, Model model){
        User user = userService.getUser(id);
        model.addAttribute("user",user);
        return "user/details";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("nestAddress", new NestAddress());
        model.addAttribute("user", new UserModel());
        return "user/add";
    }

    @PostMapping("/add")
    public String addSubmit(@ModelAttribute("user") @Valid UserModel frontEndUser, BindingResult bindingResult,
                            @ModelAttribute("nestAddress") @Valid NestAddress nestAddress,
                            BindingResult bindingResult2){

        if (bindingResult.hasErrors() || bindingResult2.hasErrors()){
            return "user/add";
        }
        userService.addUser(frontEndUser.getSurName(),frontEndUser.getLastName(),frontEndUser.getPid(),frontEndUser.getE_mail(),nestAddress.getPermanentAddress(),nestAddress.getPostalAddress());

        return "redirect:/user/";
    }

    @GetMapping("/update/{id}")
    public String updateUserForm(@PathVariable int id, Model model){
        User user = userService.getUser(id);
        NestAddress nestAddress = new NestAddress(user.getPermanentAddress(),user.getPostalAddress());

        model.addAttribute("user",user);
        model.addAttribute("nestAddress", nestAddress);
        return "user/edit";
    }

    @PostMapping("/update/{id}")
    public String updateUserSubmit(@PathVariable(value="id") int id, @ModelAttribute("user") @Valid User frontEndUser, BindingResult bindingResult,
                                   @ModelAttribute("nestAddress") @Valid NestAddress nestAddress, BindingResult bindingResult2){

        frontEndUser.setUserID(id);
        if (bindingResult.hasErrors() | bindingResult2.hasErrors()){
            return "user/edit";
        }

        userService.modifyUser(frontEndUser.getId(),frontEndUser.getSurName(),frontEndUser.getLastName(),frontEndUser.getPid(),frontEndUser.getE_mail(),
                                nestAddress.getPermanentAddress(),nestAddress.getPostalAddress());

        return "redirect:/user/list_users";
    }

    @GetMapping("/contract_menu/{id}")
    public String contractMenu(@PathVariable int id){
        return "contract/menu";
    }

    @GetMapping("/add/injury_insurance/{id}")
    public String addInjuryInsuranceForm(@PathVariable int id, Model model){

        model.addAttribute("assuredID", new UserModel());
        model.addAttribute("insurance", new InjuryInsuranceModel());
        return "contract/add/injury_insurance";
    }

    @PostMapping("/add/injury_insurance/{id}")
    public String addInjuryInsuranceSubmit(@PathVariable int id, @ModelAttribute("insurance") @Valid InjuryInsuranceModel injuryInsurance, BindingResult bindingResult,
                                           @ModelAttribute("assuredID") UserModel assuredID, BindingResult bindingResult2){

        User assured = userService.getUser(assuredID.getUserID());
        User assurer = userService.getUser(id);
        if(bindingResult.hasErrors() | bindingResult2.hasErrors() | assured == null){
            return "contract/add/injury_insurance";
        }

        contractService.createInjuryInsuranceContract(injuryInsurance.getDateOfCreation(),assurer,injuryInsurance.getDateOfBegginingOfInsurance(),
                injuryInsurance.getDateOfEndOfInsurance(),injuryInsurance.getInsuranceAmount(),injuryInsurance.getMonthlyPayment(),
                assured,injuryInsurance.getPermanentInjury(),injuryInsurance.getDeath(),injuryInsurance.getDailyHospitalizationAmount(),
                injuryInsurance.getValidArea());

        return "redirect:/user/details/{id}";
    }

    @GetMapping("/add/travel_insurance/{id}")
    public String addTravelInsuranceForm(@PathVariable int id, Model model){

        model.addAttribute("assuredID", new UserModel());
        model.addAttribute("insurance", new TravelInsuranceModel());
        return "contract/add/travel_insurance";
    }

    @PostMapping("/add/travel_insurance/{id}")
    public String addTravelInsuranceSubmit(@PathVariable int id, @ModelAttribute("insurance") @Valid TravelInsuranceModel travelInsurance, BindingResult bindingResult,
                                           @ModelAttribute("assuredID") UserModel assuredID, BindingResult bindingResult2){

        User assured = userService.getUser(assuredID.getUserID());
        User assurer = userService.getUser(id);
        if(bindingResult.hasErrors() | bindingResult2.hasErrors() | assured == null){
            return "contract/add/travel_insurance";
        }

        contractService.createTravelInsuranceContract(travelInsurance.getDateOfCreation(),assurer,travelInsurance.getDateOfBegginingOfInsurance(),
                travelInsurance.getDateOfEndOfInsurance(),travelInsurance.getInsuranceAmount(),travelInsurance.getMonthlyPayment(),
                assured,travelInsurance.isInEU(),travelInsurance.getTripPurpouse());

        return "redirect:/user/details/{id}";
    }

    @GetMapping("/add/household_insurance/{id}")
    public String addHouseholdInsuranceForm(@PathVariable int id, Model model){

        model.addAttribute("nestAddress", new NestAddress());
        model.addAttribute("insurance", new HouseholdInsuranceModel());
        return "contract/add/household_insurance";
    }

    @PostMapping("/add/household_insurance/{id}")
    public String addHouseholdInsuranceSubmit(@PathVariable int id, @ModelAttribute("insurance") @Valid HouseholdInsuranceModel householdInsurance, BindingResult bindingResult,
                                              @ModelAttribute("nestAddress") @Valid NestAddress nestAddress, BindingResult bindingResult2){

        User assurer = userService.getUser(id);
        if(bindingResult.hasErrors() | bindingResult2.hasErrors()){
            return "contract/add/household_insurance";
        }

        contractService.createHouseholdInsuranceContract(householdInsurance.getDateOfCreation(),assurer,householdInsurance.getDateOfBegginingOfInsurance(),
                householdInsurance.getDateOfEndOfInsurance(),householdInsurance.getInsuranceAmount(),householdInsurance.getMonthlyPayment(),householdInsurance.getPropertyType(),
                nestAddress.getPermanentAddress(),householdInsurance.getPropertyValue(),householdInsurance.getFurnitureValue());

        return "redirect:/user/details/{id}";
    }

    @GetMapping("/add/houseandflat_insurance/{id}")
    public String addHouseAndFlatInsuranceForm(@PathVariable int id, Model model){

        model.addAttribute("nestAddress", new NestAddress());
        model.addAttribute("insurance", new HouseAndFlatInsuranceModel());
        return "contract/add/houseandflat_insurance";
    }

    @PostMapping("/add/houseandflat_insurance/{id}")
    public String addHouseholdInsuranceSubmit(@PathVariable int id, @ModelAttribute("insurance") @Valid HouseAndFlatInsuranceModel houseAndFlatInsurance, BindingResult bindingResult,
                                              @ModelAttribute("nestAddress") @Valid NestAddress nestAddress, BindingResult bindingResult2){

        User assurer = userService.getUser(id);
        if(bindingResult.hasErrors() || bindingResult2.hasErrors()){
            return "contract/add/houseandflat_insurance";
        }

        contractService.createHouseAndFlatInsuranceContract(houseAndFlatInsurance.getDateOfCreation(),assurer,houseAndFlatInsurance.getDateOfBegginingOfInsurance(),
                houseAndFlatInsurance.getDateOfEndOfInsurance(),houseAndFlatInsurance.getInsuranceAmount(),houseAndFlatInsurance.getMonthlyPayment(),houseAndFlatInsurance.getPropertyType(),
                nestAddress.getPermanentAddress(),houseAndFlatInsurance.getPropertyValue(),houseAndFlatInsurance.isGarageInsurance());

        return "redirect:/user/details/{id}";
    }

    @GetMapping("/details/injury_insurance/{contractID}")
    public String injuryInsuranceDetails(@PathVariable int contractID, Model model){
        Contract maybeinjuryInsurance = contractService.findContract(contractID);
        InjuryInsurance injuryInsurance = (InjuryInsurance) maybeinjuryInsurance;

        model.addAttribute("insurance", injuryInsurance);

        return "contract/details/injury_insurance";
    }

    @GetMapping("/details/travel_insurance/{contractID}")
    public String travelInsuranceDetails(@PathVariable int contractID, Model model){
        Contract maybeTravelInsurance = contractService.findContract(contractID);
        TravelInsurance travelInsurance = (TravelInsurance) maybeTravelInsurance;

        model.addAttribute("insurance", travelInsurance);

        return "contract/details/travel_insurance";
    }

    @GetMapping("/details/household_insurance/{contractID}")
    public String householdInsuranceDetails(@PathVariable int contractID, Model model){
        Contract maybeHouseholdInsurance = contractService.findContract(contractID);
        HouseholdInsurance householdInsurance = (HouseholdInsurance) maybeHouseholdInsurance;

        model.addAttribute("insurance", householdInsurance);

        return "contract/details/household_insurance";
    }

    @GetMapping("/details/houseandflat_insurance/{contractID}")
    public String houseAndFlatInsuranceDetails(@PathVariable int contractID, Model model){
        Contract maybeHouseAndFlatInsurance = contractService.findContract(contractID);
        HouseAndFlatInsurance houseAndFlatInsurance = (HouseAndFlatInsurance) maybeHouseAndFlatInsurance;

        model.addAttribute("insurance", houseAndFlatInsurance);

        return "contract/details/houseandflat_insurance";
    }

    @GetMapping("/update/contract/injury_insurance/{contractID}")
    public String updateInjuryInsuranceForm(@PathVariable int contractID, Model model){

        InjuryInsurance injuryInsurance = (InjuryInsurance) contractService.findContract(contractID);
        InjuryInsuranceModel injuryInsuranceModel = new InjuryInsuranceModel(injuryInsurance);

        UserModel assuredID = new UserModel(injuryInsuranceModel.getAssured());

        model.addAttribute("insurance", injuryInsuranceModel);
        model.addAttribute("assured", assuredID);

        return "contract/edit/injury_insurance";
    }

    @PostMapping("/update/contract/injury_insurance/{contractID}")
    public String updateInjuryInsuranceSubmit(@PathVariable(value="contractID") int contractID,
                                              @ModelAttribute("insurance") @Valid InjuryInsuranceModel injuryInsuranceModel, BindingResult bindingResult,
                                              @ModelAttribute("assured") UserModel assuredID){

        User assurer = contractService.findContract(contractID).getAssurer();
        User assured = userService.getUser(assuredID.getUserID());
        if (bindingResult.hasErrors() | assured == null){
            return "contract/edit/injury_insurance";
        }

        contractService.modifyInjuryInsuranceContract(injuryInsuranceModel.getId(),injuryInsuranceModel.getDateOfCreation(),assurer,
                injuryInsuranceModel.getDateOfBegginingOfInsurance(),injuryInsuranceModel.getDateOfEndOfInsurance(),injuryInsuranceModel.getInsuranceAmount(), injuryInsuranceModel.getMonthlyPayment(),
                assured,injuryInsuranceModel.getPermanentInjury(),injuryInsuranceModel.getDeath(),injuryInsuranceModel.getDailyHospitalizationAmount(), injuryInsuranceModel.getValidArea());

        return "redirect:/user/list_users";
    }

    @GetMapping("/update/contract/travel_insurance/{contractID}")
    public String updateTravelInsuranceForm(@PathVariable int contractID, Model model){

        TravelInsurance travelInsurance = (TravelInsurance) contractService.findContract(contractID);
        TravelInsuranceModel travelInsuranceModel = new TravelInsuranceModel(travelInsurance);

        UserModel assuredID = new UserModel(travelInsuranceModel.getAssured());

        model.addAttribute("insurance", travelInsuranceModel);
        model.addAttribute("assured", assuredID);

        return "contract/edit/travel_insurance";
    }

    @PostMapping("/update/contract/travel_insurance/{contractID}")
    public String updateTravelInsuranceSubmit(@PathVariable(value="contractID") int contractID,
                                              @ModelAttribute("insurance") @Valid TravelInsuranceModel travelInsuranceModel, BindingResult bindingResult,
                                              @ModelAttribute("assured") UserModel assuredID){

        User assurer = contractService.findContract(contractID).getAssurer();
        User assured = userService.getUser(assuredID.getUserID());
        if (bindingResult.hasErrors() | assured == null){
            return "contract/edit/travel_insurance";
        }

        contractService.modifyTravelInsuranceContract(travelInsuranceModel.getId(),travelInsuranceModel.getDateOfCreation(),assurer,
                travelInsuranceModel.getDateOfBegginingOfInsurance(),travelInsuranceModel.getDateOfEndOfInsurance(),travelInsuranceModel.getInsuranceAmount(), travelInsuranceModel.getMonthlyPayment(),
                assured,travelInsuranceModel.isInEU(),travelInsuranceModel.getTripPurpouse());

        return "redirect:/user/list_users";
    }

    @GetMapping("/update/contract/household_insurance/{contractID}")
    public String updateHouseholdInsuranceForm(@PathVariable int contractID, Model model){

        HouseholdInsurance houseHoldInsurance = (HouseholdInsurance) contractService.findContract(contractID);
        HouseholdInsuranceModel householdInsuranceModel = new HouseholdInsuranceModel(houseHoldInsurance);

        NestAddress nestAddress = new NestAddress(householdInsuranceModel.getPropertyAddress(),null);

        model.addAttribute("insurance", householdInsuranceModel);
        model.addAttribute("address", nestAddress);

        return "contract/edit/household_insurance";
    }

    @PostMapping("/update/contract/household_insurance/{contractID}")
    public String updateHouseholdInsuranceSubmit(@PathVariable(value="contractID") int contractID,
                                              @ModelAttribute("insurance") @Valid HouseholdInsuranceModel householdInsuranceModel, BindingResult bindingResult,
                                              @ModelAttribute("address") @Valid NestAddress address, BindingResult bindingResult2){

        User assurer = contractService.findContract(contractID).getAssurer();
        if (bindingResult.hasErrors() | bindingResult2.hasErrors()){
            return "contract/edit/household_insurance";
        }

        contractService.modifyHouseholdInsuranceContract(householdInsuranceModel.getId(),householdInsuranceModel.getDateOfCreation(),assurer,
                householdInsuranceModel.getDateOfBegginingOfInsurance(),householdInsuranceModel.getDateOfEndOfInsurance(),householdInsuranceModel.getInsuranceAmount(),
                householdInsuranceModel.getMonthlyPayment(),householdInsuranceModel.getPropertyType(),address.getPermanentAddress(),householdInsuranceModel.getPropertyValue(),
                householdInsuranceModel.getFurnitureValue());

        return "redirect:/user/list_users";
    }

    @GetMapping("/update/contract/houseandflat_insurance/{contractID}")
    public String updateHouseAndFlatInsuranceForm(@PathVariable int contractID, Model model){

        HouseAndFlatInsurance houseAndFlatInsurance = (HouseAndFlatInsurance) contractService.findContract(contractID);
        HouseAndFlatInsuranceModel houseAndFlatInsuranceModel = new HouseAndFlatInsuranceModel(houseAndFlatInsurance);

        NestAddress nestAddress = new NestAddress(houseAndFlatInsuranceModel.getPropertyAddress(),null);

        model.addAttribute("insurance", houseAndFlatInsuranceModel);
        model.addAttribute("address", nestAddress);

        return "contract/edit/houseandflat_insurance";
    }

    @PostMapping("/update/contract/houseandflat_insurance/{contractID}")
    public String updateHouseAndFlatInsuranceSubmit(@PathVariable(value="contractID") int contractID,
                                                 @ModelAttribute("insurance") @Valid HouseAndFlatInsuranceModel houseAndFlatInsurance, BindingResult bindingResult,
                                                 @ModelAttribute("address") @Valid NestAddress address, BindingResult bindingResult2){

        User assurer = contractService.findContract(contractID).getAssurer();
        if (bindingResult.hasErrors() | bindingResult2.hasErrors()){
            return "contract/edit/houseandflat_insurance";
        }

        contractService.modifyHouseAndFlatInsuranceContract(houseAndFlatInsurance.getId(),houseAndFlatInsurance.getDateOfCreation(),assurer,
                houseAndFlatInsurance.getDateOfBegginingOfInsurance(),houseAndFlatInsurance.getDateOfEndOfInsurance(),houseAndFlatInsurance.getInsuranceAmount(),
                houseAndFlatInsurance.getMonthlyPayment(),houseAndFlatInsurance.getPropertyType(),address.getPermanentAddress(),houseAndFlatInsurance.getPropertyValue(),
                houseAndFlatInsurance.isGarageInsurance());

        return "redirect:/user/list_users";
    }

}
