package kr.happyjob.study.statistics.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.community.model.NoticeModel;
import kr.happyjob.study.statistics.model.PrsnlModel;

public interface PrsnlDao {
	
	/*public int noticenewsave(Map<String, Object> paramMap) throws Exception;
	public int noticeupdate(Map<String, Object> paramMap) throws Exception;
	public int noticedelete(Map<String, Object> paramMap) throws Exception;
*/
	// 개인
	public List<PrsnlModel> prsnllist(Map<String, Object> paramMap) throws Exception;
	public int countmemberlist(Map<String, Object> paramMap) throws Exception;
	public PrsnlModel prsnldetail(Map<String, Object> paramMap) throws Exception;
	// 기업
	public List<PrsnlModel> prsnllist2(Map<String, Object> paramMap2) throws Exception;
	public int countmemberlist2(Map<String, Object> paramMap2) throws Exception;
	
	
	//public int pluswatch(Map<String, Object> paramMap) throws Exception;

	/** 공지사항 파일 저장 */
	//public int noticefilenewsave(Map<String, Object> paramMap) throws Exception;

	/* 곻지사항 수정 */
	//public int noticenewupdatefile(Map<String, Object> paramMap) throws Exception;

	/** 파일 코드 체크 */
	//public int filecdcheck(Map<String, Object> paramMap) throws Exception;

	/** 파일 저장 */
	//public void filenewsave(Map<String, Object> paramMap) throws Exception;

	/** 파일 수정 */
	//public void fileupdate(Map<String, Object> paramMap) throws Exception;

}
