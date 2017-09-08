package cyan.dao;

import cyan.entity.Employees;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by CPZ on 2017/6/28.
 */
@Repository
public interface EmployeesDAO extends PagingAndSortingRepository<Employees,Integer>,JpaSpecificationExecutor<Employees> {

    Long countByGender(String gender);

    List<Employees> findByFirstNameLike(String firstName);


}
