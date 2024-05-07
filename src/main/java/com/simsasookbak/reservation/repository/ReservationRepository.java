package com.simsasookbak.reservation.repository;

import com.simsasookbak.reservation.domain.Reservation;
import com.simsasookbak.reservation.dto.response.ReservationView;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r JOIN r.accommodation a " +
            "WHERE r.status <> '완료' AND (r.startDate <= :endDate AND r.endDate >= :startDate) " +
            "AND (a.region LIKE %:keyword% OR a.name LIKE %:keyword%)")
    List<Reservation> findNotCompleteStatus(@Param("keyword") String keyword, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(
          "select reservation.accommodation.region as region "
        + "from Reservation reservation "
        + "join reservation.member member "
        + "join reservation.accommodation accommodation "
        + "where accommodation.isDeleted = false "
        + "and reservation.createdAt > :diffDatetime "
        + "group by region "
    )
    List<ReservationView> findPopularRegionsByCreatedAt(
            @Param("diffDatetime") LocalDateTime diffDatetime,
            Pageable pageable
    );
}