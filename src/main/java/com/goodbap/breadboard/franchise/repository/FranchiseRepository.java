package com.goodbap.breadboard.franchise.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.goodbap.breadboard.franchise.domain.Franchise;

public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {
    // :name을 %:name%으로 하면 스테이 -> 스테이크에서 여러개가 걸리는 이슈 발생
    @Query(value = "select frcs from Franchise frcs where name like :name")
    Optional<Franchise> findByBrandName(@Param("name") String brandName);
}
