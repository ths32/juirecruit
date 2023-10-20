package kr.happyjob.study.statistics.service;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.happyjob.study.common.comnUtils.FileUtilCho;
import kr.happyjob.study.community.model.NoticeModel;
import kr.happyjob.study.statistics.dao.PrsnlDao;
import kr.happyjob.study.statistics.model.PrsnlModel;

@Service
public class PrsnlServiceImpl implements PrsnlService {
	
	@Autowired
	PrsnlDao prsnlDao;
	/*@Autowired
	PrsnlDao prsnlDao2;*/
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	@Value("${fileUpload.noticePath}")
	private String noticePath;
	
	@Value("${fileUpload.rootPath}")
	private String rootPath;
	
	@Value("${fileUpload.logicalrootPath}")
	private String logicalrootPath;
	// -----------------------------------------------------------------------------------------------------------------
	@Override
	public List<PrsnlModel> prsnllist(Map<String, Object> paramMap) throws Exception {
		return prsnlDao.prsnllist(paramMap);                       
	}
	@Override
	public int countmemberlist(Map<String, Object> paramMap) throws Exception {
		return prsnlDao.countmemberlist(paramMap);
	}	
	@Override
	public PrsnlModel prsnldetail(Map<String, Object> paramMap) throws Exception {
		return prsnlDao.prsnldetail(paramMap);
	}
	
	// ----------------------------------------------------------------------------------------------------------------------
	@Override
	public List<PrsnlModel> prsnllist2(Map<String, Object> paramMap2) throws Exception {
		return prsnlDao.prsnllist2(paramMap2);                       
	}
	@Override
	public int countmemberlist2(Map<String, Object> paramMap2) throws Exception {
		return prsnlDao.countmemberlist2(paramMap2);
	}

	// ---------------------------------------------------------------------------------------------------------------------
	
	
	// ---------------------------------------------------------------------------------------------------------
	/*@Override
	public int noticenewsave(Map<String, Object> paramMap) throws Exception {
		
		return noticeDao.noticenewsave(paramMap);
	}
	
	@Override
	public int noticeupdate(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return noticeDao.noticeupdate(paramMap);
	}*/

	/*@Override
	public int noticenewsavefile(Map<String, Object> paramMap, HttpServletRequest request, List<MultipartFile> multiFile) 
			throws Exception {
		// 파일저장
				String itemFilePath = noticePath + File.separator; // 업로드 실제 경로 조립
																	// (무나열생성)
				// 실제 업로드 처리

				
				logger.info("   - multiFile.size() : " + multiFile.get(0).getOriginalFilename());
				// 파일 유무에 따라 파일 저장 작업을 나눔
				if (multiFile.get(0).getOriginalFilename() == null || multiFile.get(0).getOriginalFilename() == "") {
					return noticeDao.noticenewsave(paramMap);
				} else {
					int filec = noticeDao.filecdcheck(paramMap);
					paramMap.put("filec", filec);
					paramMap.put("filecd", filec);

					for (int i = 0; i < multiFile.size(); i++) {
						
						String savefilename = this.uploadFile(rootPath + File.separator + itemFilePath,  multiFile.get(i).getOriginalFilename(), multiFile.get(i).getBytes());

						paramMap.put("file_name", multiFile.get(i).getOriginalFilename());
						paramMap.put("file_size", multiFile.get(i).getSize());
						paramMap.put("file_madd",
								rootPath + File.separator + itemFilePath + savefilename);
						paramMap.put("file_type", multiFile.get(i).getOriginalFilename()
								.substring(multiFile.get(i).getOriginalFilename().lastIndexOf(".") + 1));

						if (multiFile.get(i).getOriginalFilename() != null
								|| !multiFile.get(i).getOriginalFilename().equals("")) {
							paramMap.put("file_nadd",
									logicalrootPath + File.separator + itemFilePath + savefilename);
						} else {
							paramMap.put("file_nadd", null);
						}

						logger.info("   - paramMapImpl : " + paramMap);

						File finalsave = new File((String) paramMap.get("file_madd"));
						multiFile.get(i).transferTo(finalsave);

						noticeDao.filenewsave(paramMap);

					}

					logger.info("   - Dao paramMap : " + paramMap);

					return noticeDao.noticefilenewsave(paramMap);
				}
		
	}*/
	// edit later
	/*@Override
	public StatsModel statsdetail(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return statsDao.statsdetail(paramMap);
	}*/

	/*@Override
	public int statsdelete(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return statsDao.statsdelete(paramMap);
	}*/


	/*@Override
	public int pluswatch(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return noticeDao.pluswatch(paramMap);
	}*/

	/*@Override
	public int noticenewupdatefile(Map<String, Object> paramMap, HttpServletRequest request, List<MultipartFile> multiFile) throws Exception {
		
		// 파일저장
		String itemFilePath = noticePath + File.separator; // 업로드 실제 경로 조립
															// (무나열생성)
		// 실제 업로드 처리
		logger.info("   - multiFile.getOriginalFilename() : " + multiFile.get(0).getOriginalFilename());
		
		// 파일 유무에 따라 파일 저장 작업을 나눔
		if (multiFile.get(0).getOriginalFilename() == null || multiFile.get(0).getOriginalFilename() == "") {
			return noticeDao.noticeupdate(paramMap);
		} else {
			
			// 파일을 가지고 있는지 확인
			String filecd = (String) paramMap.get("filecd");
			
			logger.info("filecd: "+ filecd);
			if(!"0".equals(filecd)){
				
				// 기존에 파일이 있었고, 새로운 파일로 update를 할 때
				NoticeModel noticeDetail = noticeDao.noticedetail(paramMap);
				File exitfiel = new File(noticeDetail.getFile_madd());
				exitfiel.delete();
				
			} else {
				
				// 기존에 파일이 없었고, 새로운 파일을 추가할 때
				int filec = noticeDao.filecdcheck(paramMap);
				paramMap.put("filecd", filec);
			}
			
			// tb_file에 넣을 파라미터 추가
			for (int i = 0; i < multiFile.size(); i++) {
				
				String savefilename = this.uploadFile(rootPath + File.separator + itemFilePath,  multiFile.get(i).getOriginalFilename(), multiFile.get(i).getBytes());

				paramMap.put("file_name", multiFile.get(i).getOriginalFilename());
				paramMap.put("file_size", multiFile.get(i).getSize());
				paramMap.put("file_madd",
						rootPath + File.separator + itemFilePath + savefilename);
				paramMap.put("file_type", multiFile.get(i).getOriginalFilename()
						.substring(multiFile.get(i).getOriginalFilename().lastIndexOf(".") + 1));

				if (multiFile.get(i).getOriginalFilename() != null
						|| !multiFile.get(i).getOriginalFilename().equals("")) {
					paramMap.put("file_nadd",
							logicalrootPath + File.separator + itemFilePath + savefilename);
				} else {
					paramMap.put("file_nadd", null);
				}

				logger.info("   - paramMapImpl : " + paramMap);

				File finalsave = new File((String) paramMap.get("file_madd"));
				multiFile.get(i).transferTo(finalsave);
				
				
				if(!"0".equals(filecd)){
					// 기존에 파일이 있었고, 새로운 파일로 update를 할 때
					noticeDao.fileupdate(paramMap);
				} else {
					// 기존에 파일이 없었고, 새로운 파일을 추가할 때
					noticeDao.filenewsave(paramMap);
				}
			}

			logger.info("   - Dao paramMap : " + paramMap);
			return noticeDao.noticeupdate(paramMap);
		}
	}*/
	
	/** 파일 중복명 제거 */
	/*private String uploadFile(String fullpath, String originalName, byte[] fileData) throws Exception{
		UUID uuid = UUID.randomUUID();
		String savedName = uuid.toString()+"_"+originalName;
		
		File target = new File(fullpath, savedName);
		
		FileCopyUtils.copy(fileData, target);
		
		return savedName;
	}*/

	
	
}
