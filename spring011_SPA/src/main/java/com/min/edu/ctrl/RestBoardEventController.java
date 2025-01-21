package com.min.edu.ctrl;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.min.edu.service.IBoardService;
import com.min.edu.vo.BoardVo;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RestBoardEventController {
	
	@Autowired
	private IBoardService boardService;
	// TODO 013 Rest 수정,답글
	@PostMapping(path = { "/modifyForm.do", "replyForm.do" }, produces = "application/text;charset=UTF-8;")
	public String modify(String seq) {
		BoardVo vo = boardService.getOneBoard(seq);
		// SimpleJson 사용방법
//		JSONObject obj = new JSONObject();
//		obj.put("a","가");
//		obj.toJSONString();

		// Gson 사용방법
//		Gson gson = new Gson();
//		JsonObject gJsonObject = new JsonObject();
//		gJsonObject.addProperty("a", "가");
//		String gsonToString = gson.toJson(gJsonObject);

		Gson gson = new Gson();
		String voToString = gson.toJson(vo);

		return voToString;
	}

	@PostMapping(value = "/modify.do")
	public Map<String, Object> modify(@RequestParam Map<String, Object> map) {
		log.info("\n\nParam 정보 : {}\n\n",map.toString());
		System.out.println(map);
		int row = boardService.setBoardUpdate(map);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("isc", (row>0)?true:false);
		return resMap;
	}

}
