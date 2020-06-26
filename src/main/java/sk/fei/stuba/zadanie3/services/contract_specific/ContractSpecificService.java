package sk.fei.stuba.zadanie3.services.contract_specific;

import org.springframework.stereotype.Service;
import sk.fei.stuba.zadanie3.domain.contracts.Contract;
import sk.fei.stuba.zadanie3.domain.user.User;

import java.util.List;

@Service
public interface ContractSpecificService {

    Contract findContract(int contract_id);
    void listAssurerContracts(List<User> userList, int id);
}
