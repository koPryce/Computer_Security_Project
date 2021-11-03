package project.QRCode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

//import project.QRCode.WebcamQR;
//import project.QRCode.SendEmail;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRcodeGenerator {
	static String PATH;	
	public static void generateQRcode(String credentials,String recipient)  
	{  
		MakeDirectory();
		try {
			int WIDTH = 200;
			int HEIGHT = 200;
			Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();  
			//generates QR code with Low level(L) error correction capability  
			hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L); 
			//path where we want to get QR Code  
			String path = PATH+"\\Quote.png";  
			//Encoding charset to be used  
			String charset = "UTF-8";  
			
			
		//the BitMatrix class represents the 2D matrix of bits  
		//MultiFormatWriter is a factory class that finds the appropriate Writer subclass for the BarcodeFormat requested and encodes the barcode with the supplied contents.  
		BitMatrix matrix = new MultiFormatWriter().encode(new String(Security.Encrypt(credentials).getBytes(charset), charset), BarcodeFormat.QR_CODE, WIDTH,HEIGHT);
		
		MatrixToImageWriter.writeToPath(matrix, path.substring(path.lastIndexOf('.') + 1), new File(path).toPath()); 
		SendEmail.sendMail(recipient);
		File currentFile = new File(path);
	    currentFile.delete();
	    //Write to QR code to database (exceeds 255 characters).
	    //Add the information to relationship table between QR code and users table
		}
		catch(WriterException | IOException exception) {
			exception.printStackTrace();
			
		}
		 
	}  
	
	public String[] readQRcode()  
	{  
		String [] arr = {""};
		try {
			JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			int r = j.showOpenDialog(null);
			
			if (r == JFileChooser.APPROVE_OPTION)

			{
				BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(j.getSelectedFile().getAbsolutePath())))));  
				Result rslt = new MultiFormatReader().decode(binaryBitmap);
				arr = Security.Decrypt(rslt.getText()).split("%");
				for(String errorString: arr) {
					System.out.println(errorString);
				}
			}
			return arr;  
		}
		catch(IOException | NotFoundException ex) {
			ex.printStackTrace();
		} 
		return arr;

	} 
	public String[] readByCamera() {

		WebcamQR qr =  new WebcamQR();
		return qr.startScan();
			
	}
	
	private static void MakeDirectory() {
		PATH = System.getProperty("user.home")+"\\QRcode";
		System.out.println(System.getProperty("user.home"));
		File file = new File(PATH);
	      //Creating the directory
	      boolean bool = file.mkdir();
	      if(bool){
	         System.out.println("Directory created successfully");
	      }else{
	         System.out.println("Sorry couldn’t create specified directory");
	      }
	}
}
