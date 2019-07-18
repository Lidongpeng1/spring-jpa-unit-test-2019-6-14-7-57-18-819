package com.oocl.web.sampleWebApp.jpaSample.repository;

import com.oocl.web.sampleWebApp.jpaSample.entity.Single;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    @Query(nativeQuery = true, value = "update Single set name = :#{#single.name} where id = :#{#Single.id}")
    @Modifying
    void updateName(@Param(value = "single") Integer single);
}
