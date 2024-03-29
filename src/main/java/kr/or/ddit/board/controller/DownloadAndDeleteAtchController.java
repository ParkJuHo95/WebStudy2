package kr.or.ddit.board.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.vo.AttatchVO;

@Controller
public class DownloadAndDeleteAtchController {
	@Inject
	private BoardService service;
	@Value("#{appInfo.boPath}")
	private Resource boPath;
	
	@GetMapping("/board/download/{attNo}")
	public ResponseEntity<Resource> download(@PathVariable int attNo) throws IOException {
		AttatchVO atch = service.downloadAttatch(attNo);
		String saveName = atch.getAttSavename(); 
		Resource saveFile = boPath.createRelative(saveName);
		
		if(!saveFile.exists())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("%s 파일을 찾을 수 없음.", atch.getAttFilename()));
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentLength(atch.getAttFilesize());
//		Content-Disposition: attachment; filename="filename.jpg"
		ContentDisposition disposition = ContentDisposition.attachment()
											.filename(atch.getAttFilename(), Charset.forName("UTF-8"))
											.build();
		headers.setContentDisposition(disposition);
		return  ResponseEntity.ok()
						.headers(headers)
						.body(saveFile);
	}
	
	@DeleteMapping("/board/atch/{attNo}")
	@ResponseBody
	public Map<String, Object> deleteAttatch(@PathVariable int attNo) {
		service.removeAttatch(attNo);
		return Collections.singletonMap("success", true);
	}
	
	
	@GetMapping("/board/downloads")
	public ResponseEntity<MultiValueMap<String, HttpEntity<?>>> downloadMultipart() throws IOException {
		MultiValueMap<String, HttpEntity<?>> mixData = new LinkedMultiValueMap<>();
		HttpHeaders headers1 = new HttpHeaders();
		headers1.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		ContentDisposition disposition1 = ContentDisposition.attachment()
											.filename("ala.jpg", Charset.forName("UTF-8"))
											.build();
		headers1.setContentDisposition(disposition1);
		HttpEntity<Resource> entity1 = new HttpEntity<>(new FileSystemResource("D:\\01.medias\\images\\ala.jpg"), headers1);
		mixData.add("downfile1", entity1);
		
		HttpHeaders headers2 = new HttpHeaders();
		headers2.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		ContentDisposition disposition2 = ContentDisposition.attachment()
				.filename("bara2.jpg", Charset.forName("UTF-8"))
				.build();
		headers1.setContentDisposition(disposition2);
		HttpEntity<Resource> entity2 = new HttpEntity<>(new FileSystemResource("D:\\01.medias\\images\\bara2.jpg"), headers2);
		mixData.add("downfile2", entity2);
		
		HttpHeaders headers3 = new HttpHeaders();
		headers3.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> entity3 = new HttpEntity<>("{\"test\":342}", headers3);
		mixData.add("json", entity3);
		
		
		return  ResponseEntity.ok()
						.contentType(MediaType.MULTIPART_MIXED)
						.body(mixData);
	}
}
















