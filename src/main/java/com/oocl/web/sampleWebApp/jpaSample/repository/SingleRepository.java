package com.oocl.web.sampleWebApp.jpaSample.repository;

import com.oocl.web.sampleWebApp.jpaSample.entity.Single;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SingleRepository extends JpaRepository<Single,Long> {
    Single findByName(String name);
    List<Single> findSingleByName(String name);
//    List<Single> findByOrderByAgeDesc();
//    List<String> findDistinctName();
//    List<Single> findUsersByNameIgnoreCase(String name);


    @Override
    void delete(Single entity);

    @Override
    void deleteAll();

    @Override
    void deleteById(Long aLong);
}
