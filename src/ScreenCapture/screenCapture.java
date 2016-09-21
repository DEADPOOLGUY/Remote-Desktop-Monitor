package ScreenCapture;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import ConnectServer.ConnectServer;

public class screenCapture implements Runnable{

	//���췽��
	public screenCapture() {}
	//���ؽص���ͼƬ
	@Override
	public void run() {
		// TODO Auto-generated method stub
		screenCapture sc = new screenCapture();
		//ConnectServer cs = new ConnectServer();
		Socket cs = null;
		try {
			cs = new Socket("localhost", 8090);
		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Robot r = null;
		BufferedImage picture;
		while(true){
			try {
				r = new Robot();
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//toolkit ����Եõ���Ļ��size
			Toolkit tk = Toolkit.getDefaultToolkit();
			picture = r.createScreenCapture(new Rectangle(tk.getScreenSize()));
			//RenderedImage rdImg = (RenderedImage)(picture);
			byte[] imageData = null;
			//ByteArrayOutputStream baos = new ByteArrayOutputStream();    //�ֽ����������                                     
			try {
				OutputStream os = cs.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				ImageIO.write(picture, "JPEG", dos);
				dos.write(imageData);
				os.write(imageData);
				//os.write(-224);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
		/*if(cs.isConnected()){
			while(true){
				BufferedImage picture = null;
				//robot����Խ�ͼ
				Robot r;
				try {
					                         //��������������д������
					}catch (IOException e) {
						// TODO Auto-generated catch block
						imageData = null;
						e.printStackTrace();
					}
					/*if(imageData != null){
						try {
							SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
							File file = new File("C:/Users/yunda/Desktop/"+df.format(System.currentTimeMillis()));
							OutputStream out = new OutputStream(file);//cs.getSocket().getOutputStream();  //����׽��ֺ������
							out.write(imageData);                                 //����׽��ֵ��������ͼ������д��
							out.flush();                                          //ˢ��
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
	}
}
}*/
