package cyan.dao;

import cyan.entity.Departments;
import oracle.jrockit.jfr.StringConstantPool;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by CPZ on 2017/6/28.
 */
@Repository
public interface DepartmentsDAO extends PagingAndSortingRepository<Departments,String>,JpaSpecificationExecutor<Departments>{

    Departments findByDeptName(String departName);

    @Query("select d.deptNo from Departments d where d.deptName=?1")
    String findDeptNoByDeptName(String deptName);

    @Transactional
    @Modifying()
    @Query("update Departments d set d.deptName=:deptName where d.deptNo=:deptNo")
    int updateDeptNameByDeptNo(@Param("deptName") String deptName,@Param("deptNo") String deptNo);

}
