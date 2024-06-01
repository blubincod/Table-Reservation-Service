package com.zero.tablereservation;

import com.zero.tablereservation.member.entity.Member;
import com.zero.tablereservation.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void createUserTest() {
        //given
        Member member = new Member(11, "123");

        //when
        memberRepository.save(member);

        //then
        List<Member> memberList = memberRepository.findAll();
        assertTrue(memberList.size() > 0 );
    }
}
