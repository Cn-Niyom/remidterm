package sit.remidterm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sit.remidterm.model.Offices;
import sit.remidterm.repository.OfficesRepository;

import java.util.List;

@Service
public class OfficesService {
    @Autowired
    private OfficesRepository officesRepository;

    public List<Offices> getOffices() {
        return officesRepository.findAll();
    }

    public Offices getOffices(String officeCode) {
        return officesRepository.findById(officeCode).orElseThrow();
    }

    public List<Offices> getOffices(Integer page, Integer size, String sort, String sortDirection) {
        Sort.Direction direction = Sort.Direction.ASC;
        if (sortDirection.equalsIgnoreCase("DESC")) {
            direction = Sort.Direction.DESC;
        }
        return officesRepository.findAll(PageRequest.of(page, size, Sort.by(direction, sort))).getContent();
    }

    public Offices addOffices(Offices offices) {
        return officesRepository.saveAndFlush(offices);
    }

    public Offices updateOffices(String id, Offices offices) {
        Offices oldOffices = officesRepository.findById(id).orElseThrow();
        if (offices.getOfficeCode() != null) {
            oldOffices.setOfficeCode(offices.getOfficeCode());
        }
        if (offices.getCity() != null) {
            oldOffices.setCity(offices.getCity());
        }
        if (offices.getPhone() != null) {
            oldOffices.setPhone(offices.getPhone());
        }
        if (offices.getAddressLine1() != null) {
            oldOffices.setAddressLine1(offices.getAddressLine1());
        }
        if (offices.getAddressLine2() != null) {
            oldOffices.setAddressLine2(offices.getAddressLine2());
        }
        if (offices.getState() != null) {
            oldOffices.setState(offices.getState());
        }
        if (offices.getCountry() != null) {
            oldOffices.setCountry(offices.getCountry());
        }
        if (offices.getPostalCode() != null) {
            oldOffices.setPostalCode(offices.getPostalCode());
        }
        if (offices.getTerritory() != null) {
            oldOffices.setTerritory(offices.getTerritory());
        }
        return officesRepository.saveAndFlush(oldOffices);

    }

    public void deleteOfficesById(String id) {
        officesRepository.deleteById(id);
        officesRepository.flush();
    }

}
