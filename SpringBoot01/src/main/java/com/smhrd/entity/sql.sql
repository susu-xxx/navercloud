-- 회원정보(email, pw, tel, address)
--를 저장하는 테이블 생성하기
create table Member
(
	email varchar(100), 
	pw varchar(100) not null,
	tel varchar(100),
	address varchar(200),

	constraint member_email_pk primary key(email)
	

	
	
	
);
	--블록 지정 후 alt + x 로 실행 : 주석 괄호 안에 넣으면 코드로 인식하니 넣지 말기!!

select*from Member;

--게시글
--제목, 작성자, 작성일, 내용, 고유번호, 조회수 이미지....
--date = datetime, now()= sysdate
--타이틀분터 카운트까지는 얼마든지 중복 가능해서 pk 불가! so 인덱스 걸어주기
--오토 인크리먼트 = 시퀀스(1씩 증가)
--작성자가 멤버의 이메일과 같도록 참조키 걸어주기(fk)

create table Board
(
	title varchar(100) not null,
	writer varchar(100) not null,
	content varchar(1000),
	img varchar(200),
	indate datetime default now(),
	count int default 0,
	idx int auto_increment,
	
	constraint board_idx_pk primary key(idx),
	constraint board_writer_fk foreign key(writer)
	references Member(email)


); 

insert into Board(title, writer, content)
values(
	'DCX기반 빅데이터 분석 서비스 개발자과정(1)',
	'smart2',
	'게시판 만들기'
	
	select*from Board;
	
	update Board
	set count = 35
	where writer = 'smart2'
	
);
