package kr.or.ddit.vo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = "boNo")
public class BoardVO implements Serializable{
	private int rnum;
	private int boNo;
	private String boTitle;
	private String boWriter;
	private String boIp;
	private String boMail;
	private String boPass;
	@ToString.Exclude
	private String boContent;
	private LocalDateTime boDate;
	private int boHit;
	private Integer boParent;
	
	private int level;
	
	private List<AttatchVO> attatchList;
	
	@ToString.Exclude
	@JsonIgnore
	private transient MultipartFile[] boFiles;
}














