package cyan.dao;

import cyan.entity.Employees;
import cyan.entity.projection.NoBirthDate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by CPZ on 2017/6/28.
 */
@Repository
public interface EmployeesDAO extends CrudRepository<Employees,Integer> {

    Long countByGender(String gender);

    List<Employees> findByFirstNameLike(String firstName);

    List<NoBirthDate> findByFirstName(String firstName);

}
