package com.example.restservice;

import java.util.BitSet;
import java.util.concurrent.atomic.AtomicLong;

import com.example.restservice.HTMLFactory.Floor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HomeController {
	
	@RequestMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String GroundFloor(@RequestParam(required = false) Integer flip) {
		if( flip != null)
			HTMLFactory.groundLights.flip(flip);
		return HTMLFactory.Generate(Floor.GROUND);
	}

	@GetMapping(value = "/first", produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String FirstFloor(@RequestParam(required = false) Integer flip) {
		if( flip != null)
			HTMLFactory.firstFloorLights.flip(flip);
		return HTMLFactory.Generate(Floor.FIRST);
	}
}
