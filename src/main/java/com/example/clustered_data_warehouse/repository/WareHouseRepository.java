package com.example.clustered_data_warehouse.repository;

import com.example.clustered_data_warehouse.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WareHouseRepository extends JpaRepository<Warehouse, Long> {

    @Query(value = "SELECT TO_CHAR(CURRENT_DATE, 'DD-MON-YY')", nativeQuery = true)
    String getCurrentDate();

    @Query(value = "SELECT TO_CHAR(CURRENT_TIMESTAMP, 'DD-MON-YY HH24:MI:SS')", nativeQuery = true)
    String getCurrentDateAndTime();

}
