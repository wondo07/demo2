package com.example.demo10.Member.Repository;


import com.example.demo10.Member.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
