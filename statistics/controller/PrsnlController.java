package kr.happyjob.study.statistics.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.happyjob.study.community.model.NoticeModel;
import kr.happyjob.study.statistics.model.PrsnlModel;
import kr.happyjob.study.statistics.service.PrsnlService;

@Controller
@RequestMapping("/statistics/")
public class PrsnlController {

	@Autowired
	PrsnlService prsnlService;
	
	//@Autowired
	//PrsnlService prsnlService2;

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	// private final String className = this.getClass().toString();

	// 통계 메인 페이지
	@RequestMapping("memberMgt.do")
	public String prsnl(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		model.addAttribute("loginId", (String) session.getAttribute("loginId"));
		model.addAttribute("userNm", (String) session.getAttribute("userNm"));

		return "statistics/userinfo/memberMgt";
	}

	@RequestMapping("prsnllist.do")
	public String prsnllist(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		logger.info("   - paramMap : " + paramMap);

		int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
		int cpage = Integer.parseInt((String) paramMap.get("cpage"));
		int pageindex = (cpage - 1) * pageSize;

		paramMap.put("pageindex", pageindex);
		paramMap.put("pageSize", pageSize);

		List<PrsnlModel> prsnllist = prsnlService.prsnllist(paramMap);

		int countmemberlist = prsnlService.countmemberlist(paramMap);

		model.addAttribute("prsnllist", prsnllist);
		model.addAttribute("countmemberlist", countmemberlist);

		return "statistics/userinfo/memberList";
	}
	// ==================================
	@RequestMapping("prsnllist2.do")
	public String prsnllist2(Model model2, @RequestParam Map<String, Object> paramMap2, HttpServletRequest request2,
			HttpServletResponse response2, HttpSession session2) throws Exception {
		logger.info("   - paramMap2 : " + paramMap2);

		int pageSize = Integer.parseInt((String) paramMap2.get("pageSize"));
		int cpage = Integer.parseInt((String) paramMap2.get("cpage2"));
		int pageindex = (cpage - 1) * pageSize;

		paramMap2.put("pageindex", pageindex);
		paramMap2.put("pageSize", pageSize);

		List<PrsnlModel> prsnllist2 = prsnlService.prsnllist2(paramMap2);

		int countmemberlist2 = prsnlService.countmemberlist2(paramMap2);

		model2.addAttribute("prsnllist2", prsnllist2);
		model2.addAttribute("countmemberlist2", countmemberlist2);

		return "statistics/userinfo/memberList";
	}
	
	// 개인 회원 상세보기
	/*@RequestMapping("prsnldetail.do")
	@ResponseBody 
	public Map<String, Object> prsnldetail(Model model3, @RequestParam Map<String, Object> paramMap3, 
			HttpServletRequest request3, HttpServletResponse response3, HttpSession session3) throws Exception {
		logger.info("   - paramMap3 : " + paramMap3);
		PrsnlModel detail = prsnlService.prsnldetail(paramMap3);
		Map<String, Object> returnMap3 = new HashMap<String, Object>();
		returnMap3.put("detail", detail);
		logger.info("   - returnMap3 : " + returnMap3);
		return returnMap3; 
	}*/
	


	// 파일 저장 필요없음
	/*
	 * @RequestMapping("noticesavefile.do")
	 * 
	 * @ResponseBody public Map<String, Object> noticesave(Model
	 * model, @RequestParam Map<String, Object> paramMap,
	 * 
	 * @RequestParam("addfile") List<MultipartFile> multiFile,
	 * HttpServletRequest request, HttpServletResponse response, HttpSession
	 * session) throws Exception { logger.info("   - paramMap : " + paramMap);
	 * logger.info("   - request : " + request);
	 * 
	 * paramMap.put("loginId", session.getAttribute("loginId"));
	 * 
	 * String action = (String) paramMap.get("action");
	 * 
	 * if ("I".equals(action)) { // noticeService.noticenewsave(paramMap);
	 * noticeService.noticenewsavefile(paramMap, request, multiFile); } else
	 * if("U".equals(action)){ // noticeService.noticeupdate(paramMap);
	 * noticeService.noticenewupdatefile(paramMap, request, multiFile); } else
	 * if("D".equals(action)) { noticeService.noticedelete(paramMap); }
	 * 
	 * Map<String, Object> returnMap = new HashMap<String, Object>();
	 * 
	 * returnMap.put("result", "SUCCESS");
	 * 
	 * return returnMap; }
	 */


}
