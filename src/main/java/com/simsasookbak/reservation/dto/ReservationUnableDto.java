package com.simsasookbak.reservation.dto;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationUnableDto {

    private List<Date> CheckInUnselectableDate;
    private List<Date> CheckOutUnselectableDate;

}
