package com.spring.glider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.glider.dto.EmpDTO;
import com.spring.glider.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	RestTemplate restTemplate;

	@Value("${linklyra.url}")
	String linklyraUrl;

	@Override
	public EmpDTO getEmpInfo(int eid) {
//		RestTemplate restTemplate=new RestTemplate();
//		String url="http://localhost:8081/find?"+"eid="+eid;

		HttpHeaders headers = new HttpHeaders();
		HttpEntity entity = new HttpEntity(headers);

	/*	we cannot consume POST/PUT like services using getForObject to solve this problem we use 
		exchange method in which we can easily change with HttpMethod.POST/PUT method.
 	*/
//		EmpDTO response = restTemplate.getForObject(linklyraUrl + "eid=" + eid, EmpDTO.class);

		ResponseEntity<EmpDTO> res = restTemplate.exchange(linklyraUrl + "eid=" + eid, HttpMethod.GET, entity,
				EmpDTO.class);
		return res.getBody();
	}

}
