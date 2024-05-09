package com.simsasookbak.accommodation.controller;

import com.simsasookbak.accommodation.dto.AccommodationDto;

import com.simsasookbak.accommodation.dto.request.AccommodationAddRequestDto;
import com.simsasookbak.accommodation.dto.request.AccommodationRequest;
import com.simsasookbak.accommodation.dto.response.AccommodationAddResponseDto;
import com.simsasookbak.accommodation.dto.response.AccommodationResponse;

import com.simsasookbak.member.domain.Member;
import com.simsasookbak.member.domain.MemberDto;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.simsasookbak.accommodation.service.AccommodationService;
import com.simsasookbak.review.dto.ReviewDto;
import com.simsasookbak.review.service.ReviewService;
import java.util.List;
import com.simsasookbak.room.dto.RoomDto;
import com.simsasookbak.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
@RequestMapping("accommodation") // 앞에  / 없어도 되나
@Slf4j
public class AccommodationController {

    private final AccommodationService accommodationService;
    private final RoomService roomService;
    private final ReviewService reviewService;


    @GetMapping
    public String showAccommodations(
            @ModelAttribute AccommodationRequest request,
            @RequestParam(value="page", defaultValue="0") int pageNum,
            Model model
    ) {
        Page<AccommodationResponse> response = accommodationService.searchAccommodations(request, pageNum);
        model.addAttribute("currentPage", response.getNumber());
        model.addAttribute("totalPages", response.getTotalPages());

        model.addAttribute("request", request);
        model.addAttribute("accommodations", response);

        return "list-page";
    }

    //상세 페이지 조회 (영석)
    @GetMapping("/{acom_id}")
    public String details(@PathVariable Long acom_id, Model model) {

        AccommodationDto accommodation = accommodationService.findAccommodationById(acom_id);
        List<RoomDto> roomList = roomService.findRoomByAcomId(acom_id);
//        String exSummary = reviewService.findExSummaryByAcomId(acom_id);
        String inSummary = reviewService.findInSummaryByAcomId(acom_id);
        List<ReviewDto> reviewList = reviewService.findAllReviewByAcomId(acom_id);
        List<String> imgList = accommodationService.findImgByAcomId(acom_id);

        model.addAttribute("accommodation", accommodation);
        model.addAttribute("roomList", roomList);
//        model.addAttribute("exSummary", exSummary);
        model.addAttribute("inSummary", inSummary);
        model.addAttribute("reviewList",reviewList);
        model.addAttribute("imgList",imgList);

        return "details";
    }

    //예약 성공 메세지 전송 (상형)
    @PostMapping("/reservation/message")
    public void reservationMessage(){

    }

    //리뷰 등록 페이지 이동
    @GetMapping("/{acom_id}/comment")
    public String review(@PathVariable Integer acom_id) {
        return "review-register";
    }

    @PostMapping("/registerPage/register")
    public ResponseEntity<AccommodationAddResponseDto> register(@AuthenticationPrincipal Member member, @RequestBody
                                              AccommodationAddRequestDto accommodationAddRequestDto) {
        AccommodationAddResponseDto response = accommodationService.save(member, accommodationAddRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
