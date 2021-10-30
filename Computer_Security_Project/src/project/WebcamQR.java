package project;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamPanel.Painter;
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
	

	//private Executor executor = Executors.newSingleThreadExecutor(this);

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
		//executor.execute(this);
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
					// fall thru, it means there is no QR code in image
				}
				
			}

			if (result != null) {
				arr = result.getText().split("%");
				trun = false;
				webcam.close();
			}

		} while (trun);
		dispose();
		return arr;
	}

	/*@Override
	public void run() {
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
					// fall thru, it means there is no QR code in image
				}
				
			}

			if (result != null) {
				arr = result.getText().split("%");
				email.setText(arr[0]);
				password.setText(arr[1]);
				trun = false;
				webcam.close();
			}

		} while (trun);
		dispose();
	}

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r, "example-runner");
		t.setDaemon(true);
		return t;
	}*/
	
	/*Graphics2D g2d = (Graphics2D) arg1;
			    g2d.setColor(Color.RED);
			    g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
			    g2d.drawRect(30, 50, 420, 120);
			    g2d.dispose();
	    // code to draw rectangles goes here...
	 
	}*/

	
}