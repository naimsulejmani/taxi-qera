package cacttus.education.taxiqera.controllers;

import cacttus.education.taxiqera.infrastructure.validations.groups.OnPost;
import cacttus.education.taxiqera.infrastructure.validations.groups.OnPut;
import cacttus.education.taxiqera.models.DriverChangeStatusDto;
import cacttus.education.taxiqera.models.DriverDto;
import cacttus.education.taxiqera.services.DriverService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/drivers")
@CrossOrigin(origins = "*")
@Validated
public class DriverController {
    private final DriverService driverService;

    public DriverController(DriverService service) {
        this.driverService = service;
    }

    @GetMapping
    public List<DriverDto> getAllDrivers() {

        return driverService.getAll();
    }

    @GetMapping("/{id}")
    public DriverDto getDriverById(@Valid @PathVariable @Min(1) long id) {
        return driverService.getById(id);
    }

    @Validated(OnPost.class)
    @PostMapping
    public void addDriver( @Valid @RequestBody DriverDto driverDto) {
        if (driverDto.getId() < 0) {
            throw new RuntimeException("GABIM");
        }

        driverService.add(driverDto);
    }

    @Validated(OnPut.class)
    @PutMapping("/{id}")
    public void updateDriver(@PathVariable long id, @RequestBody DriverDto driverDto) {
        driverService.update(id, driverDto);

    }

    @PatchMapping("/{id}")
    public void updateDriverStatus(@PathVariable long id, @RequestBody DriverChangeStatusDto driverDto) {
        driverService.changeStatus(id, driverDto);

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        driverService.deleteById(id);
    }

}









