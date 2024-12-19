package com.smhrd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor // 기본 생성자 : 아무것도 초기화하지 않음. 기본생성자는 필수 ****
@RequiredArgsConstructor //Nonnull이 걸린 필드만 초기화
@AllArgsConstructor // 모든 필드를 초기화하는 생성자 
@Data //getter/setter 등 기본메소드 생성(lombok)
public class Member {
	
	//계층간 데이터 전송을 위해 사용되는 객체 (DTO)
	// 여러 데이터를 담을 바구니
	@NonNull
	private String email;
	
	private String pw;
	private String tel;
	private String address;
	
	
	}
	
	

