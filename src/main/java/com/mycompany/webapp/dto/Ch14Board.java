package com.mycompany.webapp.dto;

import java.util.Date;
import org.springframework.web.multipart.MultipartFile;
import lombok.Data;

@Data
public class Ch14Board {
	private int bno;
	private String btitle;
	private String bcontent;
	private Date bdate;				// 기본값
	private String mid;
	/* battach로 아래 4개를 얻음 */
	private String bhitcount;
	private String battachoname;
	private String battachsname;
	private String battachtype;
	private MultipartFile battach;	// 실제 넘어오는 파일
}
