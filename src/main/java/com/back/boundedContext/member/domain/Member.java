package com.back.boundedContext.member.domain;

import com.back.shared.member.domain.SourceMember;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Member extends SourceMember {
    public Member(String username, String password, String nickname) {
        super(username, password, nickname);
    }

    public int increaseActivityScore(int amount) {
        setActivityScore(getActivityScore() + amount);
        return getActivityScore();
    }
}