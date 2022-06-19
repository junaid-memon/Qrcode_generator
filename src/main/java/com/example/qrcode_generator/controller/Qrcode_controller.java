package com.example.qrcode_generator.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.qrcode_generator.model.Qrcode_model;
/**
 * 
 * @author memon
 * Controller Class
 */

@Controller
public class Qrcode_controller {
	
	private Logger logger = LogManager.getFormatterLogger(Qrcode_controller.class);
	private Qrcode_model model = new Qrcode_model();
	private String Qrcode_api = 
			"https://api.qrserver.com/v1/create-qr-code/?data={data}&size={size}";
	
	@PostMapping("/generate")
	public String QrCode_generate(@RequestParam("qrtext") final String qrtext) {
		try {
			this.model.setQrText(qrtext);
			
			//Binding the parameters with the API
			final Map<String, String> urlParams = new HashMap<>();
			urlParams.put("data", qrtext);
			urlParams.put("size", "100x100");
		
			final UriComponentsBuilder builder = UriComponentsBuilder
					.fromUriString(this.Qrcode_api);
			final String uri = builder.buildAndExpand(urlParams).toUriString();
			this.model.setQrUrl(new URL(uri));
			
			return "redirect:/showImage";
		}
		
		catch(Exception ex) {
			return ex.getMessage();
		}
	}
	
	@GetMapping("/showImage")
	public String showQrCode(final Model model) throws FileNotFoundException, 
			IOException, InterruptedException, ExecutionException {
		
		if(!this.model.getQrText().equals("")) {
			model.addAttribute("url", this.model.getQrUrl());
		
		return "index.html";
		}
		else {
			this.logger.error("No text found for the Qr code!!");
			return "index.html";
		}
	}
}