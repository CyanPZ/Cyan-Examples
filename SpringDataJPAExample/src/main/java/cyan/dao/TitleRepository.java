package cyan.dao;

import cyan.entity.Titles;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by CPZ on 2017/7/2.
 */
public interface TitleRepository extends CrudRepository<Titles,Integer>,QueryDslPredicateExecutor<Titles> {


}