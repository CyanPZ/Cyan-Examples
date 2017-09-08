package test;

import cyan.App;
import cyan.dao.DepartmentsDAO;
import cyan.dao.EmployeesDAO;
import cyan.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CPZ on 2017/6/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class AppTest {

    @Autowired
    EmployeesDAO employeesDAO;

    @Test
    public void employeesDAOTest(){

        final String firstName="%S%";
        final String lastName="%s%";
        final String hireDate="%08%";
        List<Employees> emps = employeesDAO.findAll(new Specification<Employees>() {
            @Override
            public Predicate toPredicate(Root<Employees> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                if (!StringUtils.isEmpty(firstName)) {
                    predicates.add(cb.like(root.get("firstName").as(String.class), firstName));
                }
                if (!StringUtils.isEmpty(lastName)) {
                    predicates.add(cb.like(root.get("lastName").as(String.class), lastName));
                }
                if (!StringUtils.isEmpty(hireDate)) {
                    predicates.add(cb.like(root.get("hireDate").as(String.class), hireDate));
                }
                Predicate[] pre = new Predicate[predicates.size()];
                return query.where(predicates.toArray(pre)).getRestriction();
            }
        });

        System.out.println(emps);

    }
}
