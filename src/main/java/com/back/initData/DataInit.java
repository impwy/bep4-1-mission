package com.back.initData;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import com.back.entity.Member;
import com.back.entity.Post;
import com.back.service.MemberService;
import com.back.service.PostService;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class DataInit {
    private final DataInit self;
    private final MemberService memberService;
    private final PostService postService;

    public DataInit(
            @Lazy DataInit self,
            MemberService memberService,
            PostService postService
    ) {
        this.self = self;
        this.memberService = memberService;
        this.postService = postService;
    }

    @Bean
    public ApplicationRunner baseInitDataRunner() {
        return args -> {
            self.makeBaseMembers();
            self.makeBasePosts();
        };
    }

    @Transactional
    public void makeBaseMembers() {
        for (int i = 1; i <= 3; i++) {
            String username = "user" + i;
            if (memberService.findByUsername(username).isEmpty()) {
                memberService.join(username, "1234", "유저" + i);
            }
        }
    }

    @Transactional
    public void makeBasePosts() {
        if (postService.count() > 0) {return;}

        Member user1Member = memberService.findByUsername("user1").get();
        Member user2Member = memberService.findByUsername("user2").get();
        Member user3Member = memberService.findByUsername("user3").get();

        Post post1 = postService.write(user1Member, "제목1", "내용1");
        Post post2 = postService.write(user1Member, "제목2", "내용2");
        Post post3 = postService.write(user1Member, "제목3", "내용3");
        Post post4 = postService.write(user2Member, "제목4", "내용4");
        Post post5 = postService.write(user2Member, "제목5", "내용5");
        Post post6 = postService.write(user3Member, "제목6", "내용6");
    }
}
