package com.kwang.posts;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kwang.entity.PostsEntity;
import com.kwang.repository.PostsRepository;

@SpringBootTest
public class PostsRepositoryTest {

	@Autowired
	PostsRepository postsRepository;
	
	@Test
	public void getData() {
		LocalDateTime now = LocalDateTime.now();
		postsRepository.save(PostsEntity.builder()
				.title("제목입니다.")
				.content("내용입니다.")
				.author("작성자입니다.")
				.build());
		
		List<PostsEntity> postsList = postsRepository.findAll();
		
		PostsEntity posts = postsList.get(0);

	       System.out.println(">>>>>>>>>>> createDate="+posts.getCreateDate()
           +", modeifeidDate="+posts.getModifiedDate());		

		
        assertThat(posts.getTitle(), is("제목입니다."));
        assertThat(posts.getContent(), is("내용입니다."));
		
		
	}
}
