package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(of="attNo")
@NoArgsConstructor
public class AttatchVO implements Serializable{
	@ToString.Exclude
	@JsonIgnore
	private transient MultipartFile boFile;
	
	public AttatchVO(MultipartFile boFile) {
		super();
		this.boFile = boFile;
		attFilename = boFile.getOriginalFilename();
		attSavename = UUID.randomUUID().toString();
		attMime = boFile.getContentType();
		attFilesize = boFile.getSize();
		attFancysize = FileUtils.byteCountToDisplaySize(attFilesize);
	}
	
	private Integer attNo;
	private Integer boNo;
	private String attFilename;
	private String attSavename;
	private String attMime;
	private long attFilesize;
	private String attFancysize;
	private Integer attDownload;
}

















