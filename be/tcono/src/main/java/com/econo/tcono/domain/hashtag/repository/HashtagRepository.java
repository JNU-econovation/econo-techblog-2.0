package com.econo.tcono.domain.hashtag.repository;

import com.econo.tcono.domain.hashtag.domain.Hashtag;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface HashtagRepository extends Repository<Hashtag, Long> {
    Optional<Hashtag> findByName(String name);

    Hashtag save(Hashtag hashtag);

    Hashtag findHashtagById(Long id);
}
