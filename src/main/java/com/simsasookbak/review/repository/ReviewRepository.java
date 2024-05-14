package com.simsasookbak.review.repository;

import com.simsasookbak.review.domain.Review;
import com.simsasookbak.review.dto.ScoreAverageDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    @Query("SELECT a.summary FROM ExternalSummary a WHERE a.accommodation.id = :acom_id")
    String findExSummaryByAcomId(@Param("acom_id") Long acom_id);

    @Query("SELECT a.summary FROM InternalSummary a WHERE a.accommodation.id = :acom_id")
    String findInSummaryByAcomId(@Param("acom_id") Long acom_id);

    @Query("SELECT a FROM Review a WHERE a.accommodation.id = :acomId")
    public List<Review> findAllReviewByAcomId(Long acomId);

    @Query("SELECT NEW com.simsasookbak.review.dto.ScoreAverageDto(r.accommodation.id, AVG(r.score)) " +
            "FROM Review r " +
            "GROUP BY r.accommodation.id " +
            "ORDER BY AVG(r.score) DESC, r.accommodation.id DESC")
    List<ScoreAverageDto> findAverageScoreByAccommodationId();

    List<Review> findAllByMember_Id(Long memberId);

    Review findByIdAndMemberIdAndIsDeletedFalse(Long reviewId, Long memberId);

}
