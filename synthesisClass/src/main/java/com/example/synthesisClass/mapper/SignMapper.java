package com.example.synthesisClass.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SignMapper {
	// 사인 정보 저장
    int insertSignature(@Param("docNo") int docNo,
                        @Param("userId") String userId,
                        @Param("fileName") String fileName,
                        @Param("signImg") String signImg);

    // 관리자 서명 여부 업데이트
    int updateAdminSigned(@Param("docNo") int docNo);

    // 대표 서명 여부 업데이트
    int updateOwnerSigned(@Param("docNo") int docNo);

    // 관리자 서명 상태 가져오기
    String getAdminSignStatus(@Param("docNo") int docNo);

    // 둘 다 서명했는지 확인
    boolean isBothSigned(@Param("docNo") int docNo);

    // 상태를 '완결'로 변경
    int updateStatusToCompleted(@Param("docNo") int docNo);
}
