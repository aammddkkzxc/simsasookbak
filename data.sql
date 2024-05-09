-- Insert dummy data for Member
INSERT INTO member (email, name, role, birth_date, password, status, phone)
VALUES ('test1@gmail.com', '김상형', '이용자', '1900-05-01', '1234', '일반', '010-1234-1234');
SET @member_id_kim = LAST_INSERT_ID();

INSERT INTO member (email, name, role, birth_date, password, status, phone)
VALUES ('test2@gmail.com', '박지은', '사업자', '1920-06-02', '12345', '일반', '010-2345-1735');
SET @member_id_park = LAST_INSERT_ID();

INSERT INTO member (email, name, role, birth_date, password, status, phone)
VALUES ('test3@gmail.com', '송찬혁', '관리자', '1950-02-03', '123456', '일반', '010-3716-5576');
SET @member_id_song = LAST_INSERT_ID();

INSERT INTO member (email, name, role, birth_date, password, status, phone)
VALUES ('test4@gmail.com', '이영석', '이용자', '1970-12-21', '1234567', '일반', '010-3742-9985');
SET @member_id_lee = LAST_INSERT_ID();

INSERT INTO member (email, name, role, birth_date, password, status, phone)
VALUES ('test5@gmail.com', '정민석', '이용자', '1985-12-21', '12345678', '일반', '010-7324-5421');
SET @member_id_jeong = LAST_INSERT_ID();


INSERT INTO member (email, name, role, birth_date, password, status, phone)
VALUES ('test6@gmail.com', '최보현', '사업자', '2000-08-01', '123456789', '일반', '010-6785-3452');
SET @member_id_choi = LAST_INSERT_ID();


--member end

--accommodation start

INSERT INTO accommodation (member_id, name, content, region, check_in, check_out, is_deleted)
VALUES (@member_id_park, '숙소1', '숙소 설명 1', '서울', '08:00:00', '12:00:00', false);
SET @accommodation_id_seoul = LAST_INSERT_ID();

INSERT INTO accommodation (member_id, name, content, region, check_in, check_out, is_deleted)
VALUES (@member_id_park, '숙소2', '숙소 설명 2', '청주', '10:00:00', '14:00:00', false);
SET @accommodation_id_cheongju = LAST_INSERT_ID();

INSERT INTO accommodation (member_id, name, content, region, check_in, check_out, is_deleted)
VALUES (@member_id_choi, '숙소3', '숙소 설명 3', '대전', '14:00:00', '18:00:00', false);
SET @accommodation_id_daejeon = LAST_INSERT_ID();

--accommodation end

--room start

INSERT INTO room (accommodation_id, name, cost, content, use_guide)
VALUES (@accommodation_id_seoul, '일방', 10000, '일방', '창문을 닫아주세요');
SET @room_id_one = LAST_INSERT_ID();

INSERT INTO room (accommodation_id, name, cost, content, use_guide)
VALUES (@accommodation_id_cheongju, '이방', 20000, '이방이방', '창문을 닫아주세요');
SET @room_id_two = LAST_INSERT_ID();

INSERT INTO room (accommodation_id, name, cost, content, use_guide)
VALUES (@accommodation_id_daejeon, '삼방', 30000, '삼방삼방삼방', '창문을 닫아주세요');
SET @room_id_three = LAST_INSERT_ID();

--room end

--reservation start

INSERT INTO reservation (member_id, accommodation_id, room_id, status, start_date, end_date, request)
VALUES (@member_id_kim, @accommodation_id_seoul, @room_id_one, '대기', '2024-05-01', '2024-05-03', '공짜로 해주세요');
INSERT INTO reservation (member_id, accommodation_id, room_id, status, start_date, end_date, request)
VALUES (@member_id_lee, @accommodation_id_cheongju, @room_id_two, '대기', '2024-05-01', '2024-05-05', '이 방 제가 살게요');
INSERT INTO reservation (member_id, accommodation_id, room_id, status, start_date, end_date, request)
VALUES (@member_id_lee, @accommodation_id_daejeon, @room_id_three, '대기', '2024-05-04', '2024-05-05', '잠깐 다녀갈게요');
INSERT INTO reservation (member_id, accommodation_id, room_id, status, start_date, end_date, request)
VALUES (@member_id_jeong, @accommodation_id_daejeon, @room_id_three, '대기', '2024-05-05', '2024-05-06', '깨끗하게 해주세요');
--reservation end

--review start

INSERT INTO review (member_id, accommodation_id, content, score, is_deleted)
VALUES (@member_id_kim, @accommodation_id_seoul, '침대가 좋아요',5,0);
INSERT INTO review (member_id, accommodation_id, content, score, is_deleted)
VALUES (@member_id_lee, @accommodation_id_cheongju, '전체적으로 디자인이 좋았습니다',4,0);
INSERT INTO review (member_id, accommodation_id, content, score, is_deleted)
VALUES (@member_id_lee, @accommodation_id_daejeon, '이 방 다신 예약 안합니다',1,0);
INSERT INTO review (member_id, accommodation_id, content, score, is_deleted)
VALUES (@member_id_jeong, @accommodation_id_daejeon, '그냥 그랬습니다',3,0);

--review end


INSERT INTO member (email, name, password, role, birth_date, status, phone) VALUES
                                                                                ('user1@example.com', 'User 1', 'password1', '이용자', '1990-01-01', '일반', '010-1234-5678'),
                                                                                ('user2@example.com', 'User 2', 'password2', '이용자', '1995-05-15', '일반', '010-2345-6789');
--member start

-- Insert dummy data for accommodation
INSERT INTO accommodation (name, content, region, check_in, check_out, is_deleted)
VALUES ('숙소1', '숙소 설명 1', '서울', '08:00:00', '12:00:00', false);

INSERT INTO accommodation (name, content, region, check_in, check_out, is_deleted)
VALUES ('숙소3', '숙소 설명 3', '대전', '14:00:00', '18:00:00', false);

INSERT INTO room (name, cost, content, use_guide, accommodation_id) VALUES
                                                                        ('Room 1', 10, 'room 1', 'Usage guide for room 1', 1),
                                                                        ('Room 2', 15, 'room 2', 'Usage guide for room 2', 1),
                                                                        ('Room 3', 20, 'room 3', 'Usage guide for room 3', 2);

-- -- Insert dummy data for Reservation
-- INSERT INTO Reservation (member_id, accommodation_id, room_id, status, start_date, end_date, request) VALUES
--                                                                                                           (1, 1, 1, '대기', '2024-05-10', '2024-05-15', '특이사항 없음'),
--                                                                                                           (2, 1, 2, '완료', '2024-06-01', '2024-06-05', '조용한 방을 원합니다'),
--                                                                                                           (3, 2, 3, '대기', '2024-07-10', '2024-07-15', '친구들과 함께 예약했습니다'),
--                                                                                                           (1, 2, 1, '만료', '2024-08-20', '2024-08-25', '휴가 기간에 이용할 예정입니다'),
--                                                                                                           (4, 3, 2, '대기', '2024-09-05', '2024-09-10', '조식 포함 여부를 확인해주세요');