package sk.fei.stuba.zadanie3.services.adress_specific;

import org.springframework.stereotype.Service;
import sk.fei.stuba.zadanie3.domain.Address;

@Service
public class BasicAddressService implements AddressSpecificService {

    public Address createAddress(int zipCode, String town, String street, String houseNumber){

        return new Address(zipCode,town,street,houseNumber);
    }

    public void modifyAddress(Address address, int zipCode, String town, String street, String houseNumber){

        address.setZipCode(zipCode);
        address.setTown(town);
        address.setStreet(street);
        address.setHouseNumber(houseNumber);
    }

}
