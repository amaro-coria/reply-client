package com.teknei.service.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teknei.dto.ResponseDTO;
import com.teknei.dto.SbopAcceSaliDTO;
import com.teknei.dto.SbopAsgnTurnDTO;
import com.teknei.dto.SbopTurnDTO;

@FeignClient(url = "${tkn.api.url}", name = "apiClient", fallback = ApiClientFailureHandler.class)
public interface ApiClient {

	@RequestMapping(method = RequestMethod.POST, value = "turn/save")
	ResponseDTO sendTurnRecords(@RequestBody List<SbopTurnDTO> list);

	@RequestMapping(method = RequestMethod.POST, value = "acce/save")
	ResponseDTO sendAcceRecords(@RequestBody List<SbopAcceSaliDTO> list);

	@RequestMapping(method = RequestMethod.POST, value = "asgn/save")
	ResponseDTO sendAsgnTurnRecords(@RequestBody List<SbopAsgnTurnDTO> list);

}
