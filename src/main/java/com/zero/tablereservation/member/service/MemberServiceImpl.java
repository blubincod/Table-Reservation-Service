package com.zero.tablereservation.member.service;

import com.zero.tablereservation.member.entity.Member;
import com.zero.tablereservation.member.model.MemberInput;
import com.zero.tablereservation.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     */
    @Override
    public boolean signup(MemberInput parameter) {

        //username 중복 확인
        Optional<Member> optionalMember = memberRepository.findById(parameter.getUserId());
        if (optionalMember.isPresent()) {
            return false;
        }

        // 비밀번호 해시화
        String encPassword = BCrypt.hashpw(parameter.getPassword(), BCrypt.gensalt());

        // member 테이블에 저장
        Member member = Member.builder()
                .userId(parameter.getUserId())
                .username(parameter.getUsername())
                .password(encPassword)
                .phone(parameter.getPhone())
                .isManager(false)
                .regDt(LocalDateTime.now())
                .build();
        memberRepository.save(member);

        return true;
    }

    /**
     * 사용자 권한 부여
     * ROLE_CLIENT -> 고객
     * ROLE_MANAGER -> 매니저/점장
     */
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        Optional<Member> optionalMember = memberRepository.findById(userId);
        if (!optionalMember.isPresent()) {
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다.");
        }

        Member member = optionalMember.get();

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_CLIENT"));

        if (member.isManager()) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
        }

        return new User(member.getUserId(), member.getPassword(), grantedAuthorities);
    }
}
