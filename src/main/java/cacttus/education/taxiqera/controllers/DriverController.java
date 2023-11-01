package cacttus.education.taxiqera.controllers;

import cacttus.education.taxiqera.models.Driver;
import cacttus.education.taxiqera.services.DriverService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/drivers")
@CrossOrigin(origins = "*")
public class DriverController {
    private final DriverService driverService;

    public DriverController(DriverService service) {
        this.driverService = service;
    }

    @GetMapping
    public List<Driver> getAllDrivers() {

        return driverService.getAll();
    }

    @GetMapping("/{id}")
    public Driver getDriverById(@PathVariable long id) {
        return driverService.getById(id);
    }

    @PostMapping
    public void addDriver(@RequestBody Driver driver) {

        driverService.add(driver);
    }

    @PutMapping("/{id}")
    public void updateDriver(@PathVariable long id, @RequestBody Driver driver) {
        driverService.update(id, driver);

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        driverService.deleteById(id);
    }

}









