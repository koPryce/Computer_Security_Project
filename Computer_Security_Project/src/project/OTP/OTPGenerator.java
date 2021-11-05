package project.OTP;

import java.time.LocalDate;
import java.util.Random;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import project.Database.DBConnection;

public class OTPGenerator {

	 public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
	 public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

	public void sendOTP(String email) {
		String phoneNumber = DBConnection.getPhoneNumber(email);
		LocalDate date = LocalDate.now();
		String oneTimePassword = generateOTP(); //Call to the generateOTP method.
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message.creator(
	    		 new com.twilio.type.PhoneNumber("+1"+phoneNumber),
	             new com.twilio.type.PhoneNumber("+17408471870"),
	             "This is your One Time Password:" + oneTimePassword)
	         .create();
	     DBConnection.addOTP(oneTimePassword, date.toString(), "Unused");
	     message.getSid();
	}

	public static String generateOTP() {
		int length = 6;
		Random random = new Random(); //Generates a random number greater than or equal to 0.0 and less than 1.0.
		StringBuilder stringBuilder = new StringBuilder(); //Creates a string object to temporarily store the OTP.
		
		for (int i = 0; i < length; i++) {
			stringBuilder.append(random.nextInt(10));
		} //Loop used to generate a random number between 0 and 10 and appends it to the stringBuilder object.
		
		String OTP = stringBuilder.toString(); //Converts the object of random numbers to string.
		
		return OTP; //Returns the OTP string.
	}
}