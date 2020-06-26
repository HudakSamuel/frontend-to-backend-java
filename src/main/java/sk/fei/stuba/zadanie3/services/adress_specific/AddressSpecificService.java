package sk.fei.stuba.zadanie3.services.adress_specific;

import org.springframework.stereotype.Service;
import sk.fei.stuba.zadanie3.domain.Address;

@Service
public interface AddressSpecificService {

    Address createAddress(int zipCode, String town, String street, String houseNumber);
    void modifyAddress(Address address, int zipCode, String town, String street, String houseNumber);
}
