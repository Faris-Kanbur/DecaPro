package com.decapro.utilities;


	import java.io.File;
	import java.io.FileInputStream;
	import java.util.Properties;

	public class ReadConfig {

		Properties pro;
		
		 public ReadConfig()
		{
		   File src = new File("Configration/config.properties");

			try {
				FileInputStream fis = new FileInputStream(src);
				pro = new Properties();
				pro.load(fis);
			} catch (Exception e) {
				System.out.println("Exception is " + e.getMessage());
			}
		}
		
		public String getApplicationURL()
		{
			String url=pro.getProperty("baseURL");
			return url;
		}
		
		public String getUserMail()
		{
		String usermail=pro.getProperty("usermail");
		return usermail;
		}
		
		public String getPassword()
		{
		String password=pro.getProperty("password");
		return password;
		}
		
		public String getFirstName()
		{
		String firstName=pro.getProperty("firstName");
		return firstName;
		}
		
		public String getLastName()
		{
		String lastName=pro.getProperty("lastName");
		return lastName;
		}
		
		public String getChromePath()
		{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
		}
		
		public String getIEPath()
		{
		String iepath=pro.getProperty("iepath");
		return iepath;
		}
		
		public String getFirefoxPath()
		{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
		}

		
	}

