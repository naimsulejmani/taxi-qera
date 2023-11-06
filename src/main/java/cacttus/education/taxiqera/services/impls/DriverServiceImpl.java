package cacttus.education.taxiqera.services.impls;

import cacttus.education.taxiqera.models.Driver;
import cacttus.education.taxiqera.services.DriverService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {
    private List<Driver> drivers;

    public DriverServiceImpl() {
        if (drivers == null) {
            drivers = new ArrayList<>();

            Driver d1 = new Driver(1, "Naim", "Sulejmani", "B",
                    LocalDate.now().minusYears(30), LocalDate.now(), true,
                    LocalDateTime.now(), "admin");
            Driver d2 = new Driver(2, "Nikolin", "Gegaj", "C",
                    LocalDate.now().minusYears(22), LocalDate.now(), false,
                    LocalDateTime.now(), "admin");
            drivers.add(d1);
            drivers.add(d2);
        }
    }

    @Override
    public boolean add(Driver driver) {
        driver.setId((long) (Math.random() * 2_000_000_000));
        return drivers.add(driver);
    }

    @Override
    public List<Driver> getAll() {
                /*
            SELECT *
            FROM drivers AS d
            WHERE d.name = COALESCE(@name, d.name) OR d.surname = ISNULL(@surname, d.surname)
            OR d.licenceCategory = COAELSCE(@licenceCategory, d.licenceCategory)

         */


//        return drivers.stream().filter(
//                driver ->
//                        driver.getName() == (name != null ? name : driver.getName()) ||
//                                driver.getSurname() == (surname != null ? surname : driver.getSurname()) ||
//                                driver.getLicenceCategory() == (licenceCategory != null ? licenceCategory : driver.getLicenceCategory())
//        ).toList();
        return drivers;
    }

    @Override
    public Driver getById(long id) {
        // LOOK JAVA STREAMS API
        return drivers.stream().filter(d -> d.getId() == id).findFirst().get();
    }

    @Override
    public boolean update(long id, Driver updatedDriver) {
        Driver searchDriver = null;
        for (Driver drv : drivers) {
            if (drv.getId() == id) {
                searchDriver = drv;
                break;
            }
        }

        if (searchDriver == null)
            throw new RuntimeException("Driver not found with id: " + id);

        searchDriver.setName(updatedDriver.getName());
        searchDriver.setSurname(updatedDriver.getSurname());
        searchDriver.setActive(updatedDriver.isActive());
        searchDriver.setBirthdate(updatedDriver.getBirthdate());
        searchDriver.setRegisterDate(updatedDriver.getRegisterDate());
        searchDriver.setLicenceCategory(updatedDriver.getLicenceCategory());
        return true;
    }

    @Override
    public boolean deleteById(long id) {
        return drivers.removeIf(driver -> driver.getId() == id);
    }
}
