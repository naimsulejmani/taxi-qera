package cacttus.education.taxiqera.repositories;

import cacttus.education.taxiqera.entities.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<DriverEntity, Long> {

    // SELECT * FROM Driver where Name = :name AND Surname = :surname
    public List<DriverEntity> findAllByNameOrSurnameOrderByNameAscSurnameAsc(String name, String surname);

//  //  @Query(value = "SELECT * FROM drivers WHERE active = :isActive", nativeQuery = true)
//    @Query(value = "FROM DriverEntity WHERE ")
//    public List<DriverEntity> getByPalidhje(boolean isActive);


    @Query("SELECT d FROM DriverEntity d WHERE d.name=?1 OR d.surname=?2 ORDER BY d.name, d.surname")
    List<DriverEntity> getRaporti1(String name, String surname);

}








