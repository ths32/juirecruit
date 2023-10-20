package kr.happyjob.study.statistics.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import kr.happyjob.study.community.model.NoticeModel;
import kr.happyjob.study.statistics.model.PrsnlModel;

public interface PrsnlService {
	// 개인 게시판
	public List<PrsnlModel> prsnllist(Map<String, Object> paramMap) throws Exception;
	public int countmemberlist(Map<String, Object> paramMap) throws Exception;
	public PrsnlModel prsnldetail(Map<String, Object> paramMap) throws Exception;
	// 기업 게시판
	public List<PrsnlModel> prsnllist2(Map<String, Object> paramMap) throws Exception;
	public int countmemberlist2(Map<String, Object> paramMap) throws Exception;
	
	
	
	//public int noticenewsave(Map<String, Object> paramMap) throws Exception;
	/* 곻지사항 저장 파일  */
	//public int noticenewsavefile(Map<String, Object> paramMap, HttpServletRequest request, List<MultipartFile> multiFile) throws Exception;

	
	//public int noticeupdate(Map<String, Object> paramMap) throws Exception;
	
	//public int noticedelete(Map<String, Object> paramMap) throws Exception;
	
	
	
	//public int pluswatch(Map<String, Object> paramMap) throws Exception;
	
	/* 곻지사항 수정 파일  */
	//public int noticenewupdatefile(Map<String, Object> paramMap, HttpServletRequest request, List<MultipartFile> multiFile) throws Exception;
	
}
