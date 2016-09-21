package Tray;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;

import ClientFrame.ClientFrame;
import ClientFrame.FileChooser;

public class Tray {
	public Tray(){
		//�ж��Ƿ�֧��ϵͳ����
		if(SystemTray.isSupported()){
			//��õ�ǰϵͳ��ϵͳ����
			SystemTray tray = SystemTray.getSystemTray();       
			//ͼ��͹�����
			Image img = Toolkit.getDefaultToolkit().getImage("image/tray.png");
			PopupMenu menu = new PopupMenu();//popupmenu:ͼƬ����ʽ�˵�
			//�˵�����
			MenuItem helpdoc = new MenuItem("�����ĵ�");
			MenuItem open = new MenuItem("��Ӧ��");     
			MenuItem exit = new MenuItem("�˳�");
			MenuItem sendFile = new MenuItem("�����ļ�");
			//
			helpdoc.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ClientFrame.HelpDoc();
				}
				
			});
			/*open.addActionListener(new ActionListener(){         //����������¼�

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						ClientFrame cf = new ClientFrame();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}); */
			exit.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.exit(-1);
				}
				
			});
			sendFile.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					FileChooser fc = new FileChooser();
				}
				
			});
			//
			menu.add(helpdoc);
			menu.add(sendFile);
			menu.add(open);
			menu.add(exit);
			TrayIcon trayIcon = new TrayIcon(img, "Զ��������ϵͳ", menu);
			try {
				tray.add(trayIcon);
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
