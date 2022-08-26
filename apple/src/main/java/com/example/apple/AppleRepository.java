package com.example.apple;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppleRepository extends CrudRepository<AppleTableData, Integer> {

    //@Query(value="select manager from manager_table_data where boss = :bossName", nativeQuery=true)
    //String findManagerbyBossName(String bossName);
}
