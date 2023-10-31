package cacttus.education.taxiqera.services;

import cacttus.education.taxiqera.models.Driver;

import java.util.List;

public interface DriverService {

    boolean add(Driver driver);

    List<Driver> getAll();

    Driver getById(long id);

    boolean update(long id, Driver updatedDriver);

    boolean deleteById(long id);
}
