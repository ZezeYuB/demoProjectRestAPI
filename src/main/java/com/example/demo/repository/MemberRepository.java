package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Member;
import org.springframework.stereotype.Repository;
// The JpaRepository is an interface provided by Spring Data JPA. It provides CRUD (Create, Read, Update, Delete) operations and other methods for interacting with a database, such as finding entities by specific criteria.


@Repository
public interface MemberRepository extends JpaRepository <Member, Long> {
}
