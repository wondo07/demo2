package com.example.demo10.Member.Service;


\
import com.example.demo10.Member.Dto.MemberResponseDto;
import com.example.demo10.Member.Entity.Member;
import com.example.demo10.Member.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponseDto get(Long memberId) {
        Member member = verifiedMember(memberId);
        return toResponseDto(member);
    }

    private Member verifiedMember(Long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        Member member = optionalMember.orElseThrow(
                () -> new BusinessException(ErrorCode.MEMBER_NOT_FOUND));
        return member;
    }

    public MemberResponseDto toResponseDto(Member member){
        return new MemberResponseDto(member);
    }

    public Member save(Member member){
        return memberRepository.save(member);
    }
}
