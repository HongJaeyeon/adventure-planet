package com.ssafy.util;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class Crypt {

	private static Crypt crypt = null;
	
	private Crypt() {}
	
	public static Crypt getInstance() {
		if (crypt == null) crypt = new Crypt();
		return crypt;
	}
	
	public String encryptPw(String plainText) {
		return BCrypt.hashpw(plainText, BCrypt.gensalt());
	}
	
	public boolean checkPw(String loginPw, String confirmPw) {
		return BCrypt.checkpw(loginPw, confirmPw);
	}
	
}
