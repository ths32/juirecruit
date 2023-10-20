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

import kr.happyjob.study.statistics.model.StatsModel;
import kr.happyjob.study.statistics.service.StatsService;

@Controller
@RequestMapping("/statistics/")
public class StatsController {

	@Autowired
	StatsService statsService;
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	// 기업 통계 페이지(메인)
	@RequestMapping("statisticsMgt.do")
	public String stats(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		model.addAttribute("loginId", (String) session.getAttribute("loginId"));
		model.addAttribute("userNm", (String) session.getAttribute("userNm"));
		return "statistics/stats/statsMgt";
	}
	// 기업 통계 페이지 (메인) 페이징
	@RequestMapping("statslist.do")
	public String statslist(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		logger.info("   - paramMap : " + paramMap);
		int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
		int cpage = Integer.parseInt((String) paramMap.get("cpage"));
		int pageindex = (cpage - 1) * pageSize;
		paramMap.put("pageindex", pageindex);
		paramMap.put("pageSize", pageSize);
		List<StatsModel> statslist = statsService.statslist(paramMap);
		int countstatslist = statsService.countstatslist(paramMap);
		model.addAttribute("statslist", statslist);
		model.addAttribute("countstatslist", countstatslist);
		return "statistics/stats/statsList";
	}
	// ==================================
	// 박람회 통계 페이지
	@RequestMapping("statslist2.do")
	public String statslist2(Model model2, @RequestParam Map<String, Object> paramMap2, HttpServletRequest request2,
			HttpServletResponse response2, HttpSession session2) throws Exception {
		logger.info("   - paramMap2 : " + paramMap2);
		int pageSize = Integer.parseInt((String) paramMap2.get("pageSize"));
		int cpage = Integer.parseInt((String) paramMap2.get("cpage2"));
		int pageindex = (cpage - 1) * pageSize;
		paramMap2.put("pageindex", pageindex);
		paramMap2.put("pageSize", pageSize);
		List<StatsModel> statslist2 = statsService.statslist2(paramMap2);
		int countstatslist2 = statsService.countstatslist2(paramMap2);
		model2.addAttribute("statslist2", statslist2);
		model2.addAttribute("countstatslist2", countstatslist2);
		return "statistics/stats/statsList";
	}
	// 기업별 선호도
	@RequestMapping("statscol.do")
	public String statscol(Model model3, @RequestParam Map<String, Object> paramMap3, HttpServletRequest request3,
			HttpServletResponse response3, HttpSession session3) throws Exception {
		//logger.info("   - paramMap3 : " + paramMap3);
		List<StatsModel> statscol = statsService.statscol(paramMap3);
		model3.addAttribute("statscol", statscol);
		return "statistics/stats/statsCol";
	}
	// 기업별 성별 연령&성별
	@RequestMapping("statsbar.do")
	public String statsbar(Model model4, @RequestParam Map<String, Object> paramMap4, HttpServletRequest request4,
			HttpServletResponse response4, HttpSession session4) throws Exception {
		//logger.info("   - paramMap4 : " + paramMap4);
		List<StatsModel> statsbar = statsService.statsbar(paramMap4);
		model4.addAttribute("statsbar", statsbar);
		return "statistics/stats/statsBar";
	}
	// ---------------------------------------------------
	// 기업별 성별 연령&성별 상세
		@RequestMapping("statsbar2.do")
		public String statsbar2(Model model7, @RequestParam Map<String, Object> paramMap7, HttpServletRequest request7,
				HttpServletResponse response7, HttpSession session7) throws Exception {
			logger.info("   - paramMap7 : " + paramMap7);
			List<StatsModel> statsbar2 = statsService.statsbar2(paramMap7);
			model7.addAttribute("statsbar2", statsbar2);
			
			/*StatsModel detail = statsService.statsbar2(paramMap7);
			model7.addAttribute("detail", detail);*/
			
			return "statistics/stats/statsBar";
		}
	// ---------------------------------------------------
	// 박람회별 개인 성별
	@RequestMapping("statspie1.do")
	public String statspie1(Model model5, @RequestParam Map<String, Object> paramMap5, HttpServletRequest request5,
			HttpServletResponse response5, HttpSession session5) throws Exception {
		//logger.info("   - paramMap5 : " + paramMap5);
		List<StatsModel> statspie1 = statsService.statspie1(paramMap5);
		model5.addAttribute("statspie1", statspie1);
		return "statistics/stats/statsPie1";
	}
	// 박람회별 개인 성별 상세
		@RequestMapping("statspie1_2.do")
		public String statspie1_2(Model model8, @RequestParam Map<String, Object> paramMap8, HttpServletRequest request8,
				HttpServletResponse response8, HttpSession session8) throws Exception {
			logger.info("   - paramMap8 : " + paramMap8);
			List<StatsModel> statspie1_2 = statsService.statspie1_2(paramMap8);
			model8.addAttribute("statspie1_2", statspie1_2);
			return "statistics/stats/statsPie1";
		}
	// 박람회별 기업 규모
	@RequestMapping("statspie2.do")
	public String statspie2(Model model6, @RequestParam Map<String, Object> paramMap6, HttpServletRequest request6,
			HttpServletResponse response6, HttpSession session6) throws Exception {
		//logger.info("   - paramMap6 : " + paramMap6);
		List<StatsModel> statspie2 = statsService.statspie2(paramMap6);
		model6.addAttribute("statspie2", statspie2);
		return "statistics/stats/statsPie2";
	}
	// 박람회별 기업 규모 상세
	@RequestMapping("statspie2_2.do")
	public String statspie2_2(Model model9, @RequestParam Map<String, Object> paramMap9, HttpServletRequest request9,
			HttpServletResponse response9, HttpSession session9) throws Exception {
		logger.info("   - paramMap9 : " + paramMap9);
		List<StatsModel> statspie2_2 = statsService.statspie2_2(paramMap9);
		model9.addAttribute("statspie2_2", statspie2_2);
		return "statistics/stats/statsPie2";
	}
}
