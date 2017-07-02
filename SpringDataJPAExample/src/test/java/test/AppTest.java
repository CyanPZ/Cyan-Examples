package test;

import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import cyan.App;
import cyan.dao.DepartmentsDAO;
import cyan.dao.EmployeesDAO;
import cyan.dao.TitleRepository;
import cyan.entity.*;
import cyan.entity.projection.NoBirthDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CPZ on 2017/6/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class AppTest {

    @Autowired
    DepartmentsDAO departmentsDAO;
    @Autowired
    EmployeesDAO employeesDAO;
    @Autowired
    TitleRepository titleRepository;
    @Autowired
    EntityManager em;


    @Test
    public void departmentsTest() {
//        Departments sales = departmentsDAO.findByDeptName("Sales");
//        System.out.println(sales);

//        System.out.println(departmentsDAO.findDeptNoByDeptName("Sales"));

        Departments sales = departmentsDAO.findByDeptName("Sales");
        System.out.println("==before update ===");
        System.out.println(sales);

        departmentsDAO.updateDeptNameByDeptNo("New Sales", sales.getDeptNo());

        System.out.println("===after update===");
        System.out.println(departmentsDAO.findByDeptName("New Sales"));

    }


    @Test
    public void employeesTest() {
//        List<Employees> byFirstNameLike = employeesDAO.findByFirstNameLike("S%");
//        System.out.println(byFirstNameLike.size());

//        List<NoBirthDate> mary = employeesDAO.findByFirstName("Mary");
//        for (int i = 0; i < mary.size(); i++) {
//            NoBirthDate noBirthDate = mary.get(i);
//            System.out.println(noBirthDate.getLastName());
//        }

        Employees one = employeesDAO.findOne(10001);
        System.out.println(one.getTitle());
        System.out.println(one);
    }

    @Transactional
    @Test
    @Rollback(false)
    public void titleTest() {
                JPAQueryFactory queryFactory = new JPAQueryFactory(em);


//        Predicate predicate = QTitles.titles.empNo.eq(10001);
//        Titles one = titleRepository.findOne(predicate);
//        System.out.println(one);
//        Iterable<Titles> all = titleRepository.findAll(predicate);
//        System.out.println(all);

//        QTitles titles = QTitles.titles;
//        QueryResults<Tuple> results = queryFactory.select(titles, QEmployees.employees)
//                .from(titles, QEmployees.employees)
//                .where(titles.empNo.eq(10001).and(QEmployees.employees.empNo.eq(titles.empNo)))
//                .fetchResults();
//        for (Tuple t : results.getResults()) {
//            Employees employees = t.get(QEmployees.employees);
//            Titles titles1 = t.get(QTitles.titles);
//            System.out.println(employees);
//            System.out.println(titles1);
//
//        }
//        System.out.println(results);

//        QEmployees employees = QEmployees.employees;
//        queryFactory.update(employees)
//                .where(employees.empNo.eq(10001))
//                .set(employees.firstName,"Chen")
//                .set(employees.lastName,"Pengzhou")
//                .execute();

        QEmployees employees = QEmployees.employees;

        queryFactory.update(employees)
                .where(employees.empNo.eq(10001))
                .set(employees.title,JPAExpressions.select(QTitles.titles.title)
                        .from(QTitles.titles).where(QTitles.titles.empNo.eq(10001)))
                .execute();



    }


}
