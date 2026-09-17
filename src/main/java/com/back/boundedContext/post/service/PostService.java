package com.back.boundedContext.post.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.back.boundedContext.member.entity.Member;
import com.back.boundedContext.post.entity.Post;
import com.back.boundedContext.post.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public long count() {
        return postRepository.count();
    }

    public Post write(Member author, String title, String content) {
        Post post = new Post(author, title, content);

        author.increaseActivityScore(3);

        return postRepository.save(post);
    }

    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }
}