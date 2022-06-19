package com.example.qrcode_generator.model;

import java.net.URL;


/**
 * 
 * @author memon
 * Model Class
 */

public class Qrcode_model {
	private String qr_text;
	private URL url;
	
	public String getQrText() {
		return this.qr_text;
	}
	
	public void setQrText(String qr_text) {
		this.qr_text = qr_text;
	}

	public URL getQrUrl() {
		return this.url;
	}

	public void setQrUrl(URL url) {
		this.url = url;
	}
}
