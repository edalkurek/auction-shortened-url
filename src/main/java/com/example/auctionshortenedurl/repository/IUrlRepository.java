package com.example.auctionshortenedurl.repository;

import com.example.auctionshortenedurl.entity.UrlEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUrlRepository extends JpaRepository<UrlEntity, Long> {

  @Query("select u.shortenedUrl from UrlEntity u where u.userId = :userId")
  List<String> selectUrlsByUserId(Long userId);

  @Query("select u.shortenedUrl from UrlEntity u where u.userId = :userId and u.id = :urlId")
  Optional<String> selectUrlById(Long userId, Long urlId);

  @Query("select u from UrlEntity u where u.userId = :userId and u.id = :urlId")
  Optional<UrlEntity> selectUrlEntityById(Long userId, Long urlId);

  @Query("select u from UrlEntity u where u.shortenedUrl = :shortenedUrl")
  Optional<UrlEntity> selectUrlEntityByShortenedUrl(String shortenedUrl);
}
