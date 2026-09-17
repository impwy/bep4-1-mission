package com.back;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.back.initData.DataInit;
import com.back.repository.MemberRepository;
import com.back.repository.PostRepository;

@SpringBootTest(properties = {
        "spring.datasource.url=jdbc:h2:mem:init_test;MODE=MySQL;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE",
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
class BackApplicationTests {
    @Autowired DataInit dataInit;
    @Autowired MemberRepository memberRepository;
    @Autowired PostRepository postRepository;

    @Test
    void initializationCanRunAgainWithoutDuplicates() {
        dataInit.makeBaseMembers();
        dataInit.makeBasePosts();

        assertThat(memberRepository.count()).isEqualTo(3);
        assertThat(postRepository.count()).isEqualTo(6);
        assertThat(memberRepository.findByUsername("user1")).isPresent();
    }

    @Test
    @Transactional
    void initializationFillsMissingMembers() {
        postRepository.deleteAll();
        memberRepository.deleteAll();
        memberRepository.saveAndFlush(new com.back.entity.Member("user2", "existing-password", "existing"));

        dataInit.makeBaseMembers();
        dataInit.makeBasePosts();

        assertThat(memberRepository.count()).isEqualTo(3);
        assertThat(postRepository.count()).isEqualTo(6);
    }

}
