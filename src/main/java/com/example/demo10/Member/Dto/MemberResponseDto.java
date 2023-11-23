package com.example.demo10.Member.Dto;


import com.example.demo10.Member.Entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MemberResponseDto {

    private Long memberId;

    private String name;

    private String address;

    public MemberResponseDto(Member member) {
        this.memberId = member.getMemberId();
        this.name = member.getName();
        this.address = member.getAddress();
    }
}
