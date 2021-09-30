package project;

import java.util.Random;

public class OTPGenerator {

	public static void main(String[] args) {
		String oneTimePassword = generateOTP(5); //Call to the generateOTP method.
		System.out.println("Generated One Time Password: "+ oneTimePassword); //Displays the OTP.
	}

	public static String generateOTP(int length) {
		Random random = new Random(); //Generates a random number greater than or equal to 0.0 and less than 1.0.
		StringBuilder stringBuilder = new StringBuilder(); //Creates a string object to temporarily store the OTP.
		
		for (int i = 0; i < length; i++) {
			stringBuilder.append(random.nextInt(10));
		} //Loop used to generate a random number between 0 and 10 and appends it to the stringBuilder object.
		
		String OTP = stringBuilder.toString(); //Converts the object of random numbers to string.
		
		return OTP; //Returns the OTP string.
	}
}
