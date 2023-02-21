package com.econo.tcono.domain.hashtag.repository;


import com.econo.tcono.domain.hashtag.domain.PostHashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostHashtagRepository extends JpaRepository<PostHashtag, Long> {
}
