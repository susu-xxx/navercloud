package com.smhrd.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.smhrd.entity.Board;
import com.smhrd.mapper.BoardMapper;

@Controller
public class BoardController {
	@Autowired
	private BoardMapper mapper;
	
	@RequestMapping("/list")
	public String list(Model model) {
		//1. 데이터 수집
		//2. 기능 실행
		List<Board> list = mapper.list();
		
		//Scope :정보 저장(유지)4개의 내장객체
		//page : 하나의 jsp 안에서만 사용가능
		//request**** :한번의 요청- 응답 동안만 유지  //알아서 사라지기 때문에 단순히 정보를 넘기는 데 많이 쓴다. 우리가 가장 많이 쓸 거
		// jsp로 포워딩이동할 때 용이해서 젤 자주 씀
		//	>>	리퀘스트 몸떙이 커서 정보 저장 외에는 싹 다이어트시킨 것 = Model 객체. 그래서 List<Board> list = mapper.list(); 이렇게 써줌.

		//session : 하나의 브라우저 내에서 사용 가능
		//application : 서버 종료시까지, 공용 공간
		model.addAttribute("list",list);  //setAttribute랑 똑같은 일을 함.
		
		//3. View 이동
		return "boardMain"; ///WEB-INF/view/boardMain.jsp
	}
	@RequestMapping("/writerBoard")
	public void writerboard() {
		//1. 데이터 수집
		//2. 기능 실행
		//3. View 선택
		//return "writerBoard";
		//리턴 타입이 void인 경우>> url맵핑을 jsp 이름이라 간주하고 자동으로 포워드.
	}
	//@value를 이용해서 변수 값을 채울 수 있다.
	//어노테이션 안에서 ${프로퍼티 이름}을 사용해서 application.properties에 정의해둔 데이터를 가져올 수 있다.
	
	@Value("${save.path}")
	private String savePath; 
	
	@RequestMapping("/write")
	public String write(Board board, MultipartFile file) {
		//1. 데이터 수집
		//file을 수집하는 방법
		//(1) 전송된 파일을 수집할 때, multipartfile자료형으로 선언
		//(2) 파일을 저장할 폴더(경로에 한글x)
		//(3) 폴더 경로 저장
		//(4)파일로 변환해서 저장
		if(file == null) {
			board.setImg("none");
		}else {
			try {
				//1)사진 파일명 중복 가능,, 그래서 파일명 앞에 랜덤한 문자열을 붙여서 파일 이름 중복 방지
				String uuid = UUID.randomUUID().toString(); //uuid 랜덤문자열 
				
				String filename = uuid + file.getOriginalFilename();
				
				
				//2) 전체 경로(폴더 경로+ 파일 이름)
				Path path = Paths.get(savePath + filename);
				
				//3) 저장 
				file.transferTo( path );
				
				board.setImg(filename);
				
			} catch (Exception e) {
				e.printStackTrace();// 오류 메세지 출력
			}
		}
		
		
		//2. 기능 실행
		mapper.write(board);

		//3. view 이동
		return "redirect:/list";
	}
	
	@RequestMapping("/view")
	public String view(int idx, Model model ){
		//1. 데이터 수집
		
		//2. 기능 실행
		Board board = mapper.view(idx);
		model.addAttribute("board", board);
		
		//3. View 이동
		return "viewBoard";
	
	}
	
	@RequestMapping("/delete/{idx}")
	public String delete(@PathVariable("idx")int idx) {
		//1. 데이터 수집
		
		//2. 기능 실행
		mapper.delete(idx);
		
		//3.view 이동
		return "redirect:/list";
	}
	
	
	@RequestMapping("/axios")
	public void axios() {}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	


