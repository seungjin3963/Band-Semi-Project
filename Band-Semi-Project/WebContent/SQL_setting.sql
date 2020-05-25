
/* Drop Tables */

DROP TABLE BandList CASCADE CONSTRAINTS;
DROP TABLE comments CASCADE CONSTRAINTS;
DROP TABLE imgBoard CASCADE CONSTRAINTS;
DROP TABLE tagindex CASCADE CONSTRAINTS;
DROP TABLE board CASCADE CONSTRAINTS;
DROP TABLE band_userinfo CASCADE CONSTRAINTS;
DROP TABLE calendar CASCADE CONSTRAINTS;
DROP TABLE Band CASCADE CONSTRAINTS;
DROP TABLE bandimg CASCADE CONSTRAINTS;
DROP TABLE scategory CASCADE CONSTRAINTS;
DROP TABLE bcategory CASCADE CONSTRAINTS;
DROP TABLE Profiledata CASCADE CONSTRAINTS;
DROP TABLE Userinfo CASCADE CONSTRAINTS;
DROP TABLE login CASCADE CONSTRAINTS;
DROP TABLE tag_name CASCADE CONSTRAINTS;

/*Create Sequence */
drop sequence seq_board;
drop sequence seq_comments;
drop sequence seq_imgboard;
drop sequence seq_tmpimg;
drop sequence seq_login;
drop sequence seq_calender;
drop sequence seq_band;
drop sequence seq_banduserinfo;
drop sequence seq_bandlist;
drop sequence seq_profile;

create sequence seq_board;
create sequence seq_comments;
create sequence seq_imgboard;
create sequence seq_tmpimg;
create sequence seq_login;
create sequence seq_calender;
create sequence seq_band;
create sequence seq_banduserinfo;
create sequence seq_bandlist;
create sequence seq_profile;



/* Create Tables */

CREATE TABLE Band
(
	band_num number(20) NOT NULL,
	scategoryNum number(5) NOT NULL,
	bandimgNum number(3) NOT NULL,
	band_name varchar2(60) NOT NULL,
	band_publicwhe number(1) NOT NULL,
	band_intoroductio varchar2(1000),
	band_date date NOT NULL,
	band_states number(3) NOT NULL,
	PRIMARY KEY (band_num)
);


CREATE TABLE bandimg
(
	bandimgNum number(3) NOT NULL,
	bandimg varchar2(1000) NOT NULL,
	PRIMARY KEY (bandimgNum)
);


CREATE TABLE BandList
(
	list_num number(20) NOT NULL,
	band_num number(20) NOT NULL,
	login_num number(20) NOT NULL,
	band_states number(3),
	band_signdate date,
	PRIMARY KEY (list_num)
);


CREATE TABLE band_userinfo
(
	userBand_num number(20) NOT NULL,
	band_num number(20) NOT NULL,
	login_num number(20) NOT NULL,
	band_nickname varchar2(40),
	band_approved number(3),
	band_redate date,
	PRIMARY KEY (userBand_num)
);


CREATE TABLE bcategory
(
	bcategoryNum number(3) NOT NULL,
	category_btitle varchar2(20) NOT NULL,
	categoryImg varchar2(1000) NOT NULL,
	PRIMARY KEY (bcategoryNum)
);


CREATE TABLE board
(
	board_num number(20) NOT NULL,
	band_num number(20) NOT NULL,
	userBand_num number(20) NOT NULL UNIQUE,
	board_content varchar2(1000) NOT NULL,
	board_redate date NOT NULL,
	board_states number(3) NOT NULL,
	PRIMARY KEY (board_num)
);


CREATE TABLE calendar
(
	calendarNum number(20) NOT NULL,
	band_num number(20) NOT NULL,
	calendartitle varchar2(30) NOT NULL,
	calendarDate date NOT NULL,
	calendarcontent varchar2(100) NOT NULL,
	addDate date NOT NULL,
	PRIMARY KEY (calendarNum)
);


CREATE TABLE comments
(
	comments_Num number(20) NOT NULL,
	userBand_num number(20) NOT NULL,
	board_num number(20) NOT NULL,
	comments_cotent varchar2(100) NOT NULL,
	ref number(20) NOT NULL,
	lev number(5) NOT NULL,
	step number(5) NOT NULL,
	comments_date date NOT NULL,
	PRIMARY KEY (comments_Num)
);


CREATE TABLE imgBoard
(
	img_num number(20) NOT NULL,
	band_num number(20) NOT NULL,
	board_num number(20) NOT NULL,
	img_url varchar2(50) NOT NULL,
	img_regdate date NOT NULL,
	img_states number(3) NOT NULL,
	PRIMARY KEY (img_num)
);


CREATE TABLE login
(
	login_num number(20) NOT NULL,
	login_id varchar2(50) NOT NULL UNIQUE,
	login_pwd varchar2(30) NOT NULL,
	login_date date NOT NULL,
	login_state number(3) NOT NULL,
	PRIMARY KEY (login_num)
);


CREATE TABLE Profiledata
(
	profile_num number(20) NOT NULL,
	login_num number(20) NOT NULL,
	User_imgdata blob,
	PRIMARY KEY (profile_num)
);


CREATE TABLE scategory
(
	scategoryNum number(5) NOT NULL,
	bcategoryNum number(3) NOT NULL,
	category_stitle varchar2(1000) NOT NULL,
	PRIMARY KEY (scategoryNum)
);


CREATE TABLE tagindex
(
	tagindexnum number(20) NOT NULL,
	tag_num number(20) NOT NULL,
	board_num number(20) NOT NULL UNIQUE,
	band_num number(20) NOT NULL,
	PRIMARY KEY (tagindexnum)
);


CREATE TABLE tag_name
(
	tag_num number(20) NOT NULL,
	tag_contnet varchar2(40) NOT NULL,
	tag_represent number(3),
	PRIMARY KEY (tag_num)
);


CREATE TABLE Userinfo
(
	login_num number(20) NOT NULL,
	user_name varchar2(20) NOT NULL,
	user_phone varchar2(12),
	user_email varchar2(50),
	user_gender varchar2(3) NOT NULL,
	user_quiz varchar2(60) NOT NULL,
	user_answer varchar2(60) NOT NULL,
	user_img varchar2(50),
	user_birth date NOT NULL,
	PRIMARY KEY (login_num)
);

insert into login values(9999,'null','null',sysdate,0);
insert into userinfo values(9999,'null',null,null,'n','null','null',null,sysdate);
insert into profiledata values(9999,9999,null);

insert into bcategory values(1,'친목/모임','MakingBand/category/1.png');
insert into bcategory values(2,'취미','MakingBand/category/2.png');
insert into bcategory values(3,'반려동물/동물','MakingBand/category/3.png');
insert into bcategory values(4,'패션/뷰티','MakingBand/category/4.png');
insert into bcategory values(5,'생화정보','MakingBand/category/5.png');
insert into bcategory values(6,'음악','MakingBand/category/6.png');
insert into bcategory values(7,'취업/자격증','MakingBand/category/7.png');
insert into bcategory values(8,'종교/봉사','MakingBand/category/8.png');
insert into bcategory values(9,'문화/예술','MakingBand/category/9.png');
insert into bcategory values(10,'맛집/요리','MakingBand/category/10.png');
insert into bcategory values(11,'자연/귀농','MakingBand/category/11.png');
insert into bcategory values(12,'나이/또래모임','MakingBand/category/12.png');
insert into bcategory values(13,'스포츠/레저','MakingBand/category/13.png');
insert into bcategory values(14,'방송/연예','MakingBand/category/14.png');
insert into bcategory values(15,'게임','MakingBand/category/15.png');
insert into bcategory values(16,'교육/공부','MakingBand/category/16.png');
insert into bcategory values(17,'건강/다이어트','MakingBand/category/17.png');
insert into bcategory values(18,'애니메이션','MakingBand/category/18.png');
insert into bcategory values(19,'정치/사회','MakingBand/category/19.png');
insert into bcategory values(20,'인문/과학','MakingBand/category/20.png');
insert into bcategory values(21,'일상/이야기','MakingBand/category/21.png');
insert into bcategory values(22,'경제/재테그','MakingBand/category/22.png');
insert into bcategory values(23,'팬클럽','MakingBand/category/23.png');
insert into bcategory values(24,'어학/외국어','MakingBand/category/24.png');
insert into bcategory values(25,'IT/컴퓨터','MakingBand/category/25.png');
insert into bcategory values(26,'여행/캠핑','MakingBand/category/26.png');

INSERT INTO SCATEGORY VALUES(1,3,'고양이');
INSERT INTO SCATEGORY VALUES(2,3,'강아지');
INSERT INTO SCATEGORY VALUES(3,3,'이색동물');
INSERT INTO SCATEGORY VALUES(4,3,'동물보호');

INSERT INTO SCATEGORY VALUES(5,17,'다이어트');
INSERT INTO SCATEGORY VALUES(6,17,'건강정보');
INSERT INTO SCATEGORY VALUES(7,17,'피트니스');
INSERT INTO SCATEGORY VALUES(8,17,'환우모임');

INSERT INTO SCATEGORY VALUES(9,25,'개발/프로그래밍');
INSERT INTO SCATEGORY VALUES(10,25,'컴퓨터소프트웨어');
INSERT INTO SCATEGORY VALUES(11,25,'엑셀/PPT/포토샵');
INSERT INTO SCATEGORY VALUES(12,25,'IT사용자');

INSERT INTO SCATEGORY VALUES(13,16,'진로/입시');
INSERT INTO SCATEGORY VALUES(14,16,'초등학교 교육');
INSERT INTO SCATEGORY VALUES(15,16,'중학교 교육');
INSERT INTO SCATEGORY VALUES(16,16,'고등학교 교육');

INSERT INTO SCATEGORY VALUES(17,1,'학부모');
INSERT INTO SCATEGORY VALUES(18,1,'군대/정우회');
INSERT INTO SCATEGORY VALUES(19,1,'친목');
INSERT INTO SCATEGORY VALUES(20,1,'싱글/솔로');

INSERT INTO SCATEGORY VALUES(21,12,'20대');
INSERT INTO SCATEGORY VALUES(22,12,'30대');
INSERT INTO SCATEGORY VALUES(23,12,'40대');
INSERT INTO SCATEGORY VALUES(24,12,'50대');

INSERT INTO SCATEGORY VALUES(25,21,'좋은글/명언');
INSERT INTO SCATEGORY VALUES(26,21,'일상');
INSERT INTO SCATEGORY VALUES(27,21,'운세/사주/타로');
INSERT INTO SCATEGORY VALUES(28,21,'유머/짤');

INSERT INTO SCATEGORY VALUES(29,2,'독서');
INSERT INTO SCATEGORY VALUES(30,2,'드론/액션캠/RC');
INSERT INTO SCATEGORY VALUES(31,2,'DRY/공예');
INSERT INTO SCATEGORY VALUES(32,2,'보정/배경화면');

INSERT INTO SCATEGORY VALUES(33,13,'자동차');
INSERT INTO SCATEGORY VALUES(34,13,'바이크/스쿠터');
INSERT INTO SCATEGORY VALUES(35,13,'전동휠/킥보드');
INSERT INTO SCATEGORY VALUES(36,13,'축구/풋살');

INSERT INTO SCATEGORY VALUES(37,14,'인터넷방송');
INSERT INTO SCATEGORY VALUES(38,14,'드라마');
INSERT INTO SCATEGORY VALUES(39,14,'예능');
INSERT INTO SCATEGORY VALUES(40,14,'교양/다큐');

INSERT INTO SCATEGORY VALUES(41,23,'유튜버/BJ');
INSERT INTO SCATEGORY VALUES(42,23,'가수/뮤지션');
INSERT INTO SCATEGORY VALUES(43,23,'배우');
INSERT INTO SCATEGORY VALUES(44,23,'아이돌');

INSERT INTO SCATEGORY VALUES(45,15,'비디오/콘솔게임');
INSERT INTO SCATEGORY VALUES(46,15,'카드/보드게임');
INSERT INTO SCATEGORY VALUES(47,15,'모바일게임');
INSERT INTO SCATEGORY VALUES(48,15,'PC게임');

INSERT INTO SCATEGORY VALUES(49,18,'웹툰');
INSERT INTO SCATEGORY VALUES(50,18,'코믹스');
INSERT INTO SCATEGORY VALUES(51,18,'애니메이션');
INSERT INTO SCATEGORY VALUES(52,18,'만화책');

INSERT INTO SCATEGORY VALUES(53,10,'맛집');
INSERT INTO SCATEGORY VALUES(54,10,'요리/레시피');
INSERT INTO SCATEGORY VALUES(55,10,'커피/차');
INSERT INTO SCATEGORY VALUES(56,10,'홈베이킹');

INSERT INTO SCATEGORY VALUES(57,4,'뷰티');
INSERT INTO SCATEGORY VALUES(58,4,'메이크업');
INSERT INTO SCATEGORY VALUES(59,4,'헤어');
INSERT INTO SCATEGORY VALUES(60,4,'네일');

INSERT INTO SCATEGORY VALUES(61,26,'국내여행');
INSERT INTO SCATEGORY VALUES(62,26,'해외여행');
INSERT INTO SCATEGORY VALUES(63,26,'배낭여행');
INSERT INTO SCATEGORY VALUES(64,26,'캠핑/백패킹');

INSERT INTO SCATEGORY VALUES(65,9,'영화');
INSERT INTO SCATEGORY VALUES(66,9,'공연/뮤지컬');
INSERT INTO SCATEGORY VALUES(67,9,'미술/전시');
INSERT INTO SCATEGORY VALUES(68,9,'그림/일러스트');

INSERT INTO SCATEGORY VALUES(69,6,'팝/R&B');
INSERT INTO SCATEGORY VALUES(70,6,'힙합');
INSERT INTO SCATEGORY VALUES(71,6,'클래식/재즈음악');
INSERT INTO SCATEGORY VALUES(72,6,'트로트');

INSERT INTO SCATEGORY VALUES(73,24,'영어');
INSERT INTO SCATEGORY VALUES(74,24,'일본어');
INSERT INTO SCATEGORY VALUES(75,24,'중국어');
INSERT INTO SCATEGORY VALUES(76,24,'통역/번역');

INSERT INTO SCATEGORY VALUES(77,7,'시험/자격증');
INSERT INTO SCATEGORY VALUES(78,7,'직업교육');
INSERT INTO SCATEGORY VALUES(79,7,'지업별모임');
INSERT INTO SCATEGORY VALUES(80,7,'창업');

INSERT INTO SCATEGORY VALUES(81,20,'역사');
INSERT INTO SCATEGORY VALUES(82,20,'심리학');
INSERT INTO SCATEGORY VALUES(83,20,'생물학/생명공학');
INSERT INTO SCATEGORY VALUES(84,20,'인문/철학');

INSERT INTO SCATEGORY VALUES(85,22,'주식');
INSERT INTO SCATEGORY VALUES(86,22,'부동산');
INSERT INTO SCATEGORY VALUES(87,22,'세금/세무');
INSERT INTO SCATEGORY VALUES(88,22,'보험');

INSERT INTO SCATEGORY VALUES(89,19,'시사/토론');
INSERT INTO SCATEGORY VALUES(90,19,'뉴스');
INSERT INTO SCATEGORY VALUES(91,19,'시민행동모임');
INSERT INTO SCATEGORY VALUES(92,19,'정당/정치인');

INSERT INTO SCATEGORY VALUES(93,8,'봉사/자선');
INSERT INTO SCATEGORY VALUES(94,8,'카톨릭');
INSERT INTO SCATEGORY VALUES(95,8,'불교');
INSERT INTO SCATEGORY VALUES(96,8,'천주교');

INSERT INTO SCATEGORY VALUES(97,5,'생활정보');
INSERT INTO SCATEGORY VALUES(98,5,'인테리어/건축');
INSERT INTO SCATEGORY VALUES(99,5,'중고/나눔');
INSERT INTO SCATEGORY VALUES(100,5,'살림');

INSERT INTO SCATEGORY VALUES(101,11,'꽃/식물');
INSERT INTO SCATEGORY VALUES(102,11,'농사/텃밭가꾸기');
INSERT INTO SCATEGORY VALUES(103,11,'가축');
INSERT INTO SCATEGORY VALUES(104,11,'귀농모임');

insert into bandimg values(1,'MakingBand/bandcover/1.jpg');
insert into bandimg values(2,'MakingBand/bandcover/2.jpg');
insert into bandimg values(3,'MakingBand/bandcover/3.jpg');
insert into bandimg values(4,'MakingBand/bandcover/4.jpg');
insert into bandimg values(5,'MakingBand/bandcover/5.jpg');
insert into bandimg values(6,'MakingBand/bandcover/6.jpg');
insert into bandimg values(7,'MakingBand/bandcover/7.jpg');
insert into bandimg values(8,'MakingBand/bandcover/8.jpg');
insert into bandimg values(9,'MakingBand/bandcover/9.jpg');
insert into bandimg values(10,'MakingBand/bandcover/10.jpg');
insert into bandimg values(11,'MakingBand/bandcover/11.jpg');
insert into bandimg values(12,'MakingBand/bandcover/12.jpg');
insert into bandimg values(13,'MakingBand/bandcover/13.jpg');
insert into bandimg values(14,'MakingBand/bandcover/14.jpg');
insert into bandimg values(15,'MakingBand/bandcover/15.jpg');
insert into bandimg values(16,'MakingBand/bandcover/16.jpg');

commit;



/* Create Foreign Keys */

ALTER TABLE BandList
	ADD FOREIGN KEY (band_num)
	REFERENCES Band (band_num)
;


ALTER TABLE band_userinfo
	ADD FOREIGN KEY (band_num)
	REFERENCES Band (band_num)
;


ALTER TABLE board
	ADD FOREIGN KEY (band_num)
	REFERENCES Band (band_num)
;


ALTER TABLE calendar
	ADD FOREIGN KEY (band_num)
	REFERENCES Band (band_num)
;


ALTER TABLE imgBoard
	ADD FOREIGN KEY (band_num)
	REFERENCES Band (band_num)
;


ALTER TABLE tagindex
	ADD FOREIGN KEY (band_num)
	REFERENCES Band (band_num)
;


ALTER TABLE Band
	ADD FOREIGN KEY (bandimgNum)
	REFERENCES bandimg (bandimgNum)
;


ALTER TABLE board
	ADD FOREIGN KEY (userBand_num)
	REFERENCES band_userinfo (userBand_num)
;


ALTER TABLE comments
	ADD FOREIGN KEY (userBand_num)
	REFERENCES band_userinfo (userBand_num)
;


ALTER TABLE scategory
	ADD FOREIGN KEY (bcategoryNum)
	REFERENCES bcategory (bcategoryNum)
;


ALTER TABLE comments
	ADD FOREIGN KEY (board_num)
	REFERENCES board (board_num)
;


ALTER TABLE imgBoard
	ADD FOREIGN KEY (board_num)
	REFERENCES board (board_num)
;


ALTER TABLE tagindex
	ADD FOREIGN KEY (board_num)
	REFERENCES board (board_num)
;


ALTER TABLE BandList
	ADD FOREIGN KEY (login_num)
	REFERENCES login (login_num)
;


ALTER TABLE band_userinfo
	ADD FOREIGN KEY (login_num)
	REFERENCES login (login_num)
;


ALTER TABLE Userinfo
	ADD FOREIGN KEY (login_num)
	REFERENCES login (login_num)
;


ALTER TABLE Band
	ADD FOREIGN KEY (scategoryNum)
	REFERENCES scategory (scategoryNum)
;


ALTER TABLE tagindex
	ADD FOREIGN KEY (tag_num)
	REFERENCES tag_name (tag_num)
;


ALTER TABLE Profiledata
	ADD FOREIGN KEY (login_num)
	REFERENCES Userinfo (login_num)
;



