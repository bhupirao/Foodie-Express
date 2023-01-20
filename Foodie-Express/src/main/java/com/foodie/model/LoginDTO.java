package com.foodie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
	
	 private String mobileNo;
	    private String password;
	    
	    public LoginDTO() {
			// TODO Auto-generated constructor stub
		}
		public LoginDTO(String mobileNo, String password) {
			super();
			this.mobileNo = mobileNo;
			this.password = password;
		}
		public String getMobileNo() {
			return mobileNo;
		}
		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		
	    
	    

}
