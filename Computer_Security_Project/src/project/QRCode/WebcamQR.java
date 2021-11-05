package project.QRCode;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import java.awt.*;

public class WebcamQR extends JFrame  {

	private static final long serialVersionUID = 6441489157408381878L;
	

	private Webcam webcam = null;
	private WebcamPanel panel = null;
	private boolean trun = true;
	private String [] arr = null;
	

	public WebcamQR() {
		super();

		setLayout(new FlowLayout());
		setTitle("Read QR With Webcam");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Dimension size = WebcamResolution.QVGA.getSize();

		webcam = Webcam.getWebcams().get(0);
		webcam.setViewSize(size);

		panel = new WebcamPanel(webcam);
		panel.setPreferredSize(size);
		((WebcamPanel) panel).setFPSDisplayed(true);
		panel.setMirrored(true);
		
		add(panel);

		pack();
		setResizable(false);
		setVisible(true);
	}
	
	
	public String[] startScan() {
		do {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Result result = null;
			BufferedImage image = null;

			if (webcam.isOpen()) {

				if ((image = webcam.getImage()) == null) {
					continue;
				}

				LuminanceSource source = new BufferedImageLuminanceSource(image);
				BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
				
				try {
					result = new MultiFormatReader().decode(bitmap);
				} catch (NotFoundException e) {
					
				}
				
			}

			if (result != null) {
				arr =  Security.Decrypt(result.getText()).split("%");
				trun = false;
				webcam.close();
			}

		} while (trun);
		dispose();
		return arr;
	}
}