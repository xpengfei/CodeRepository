package xpffly.socket;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author szfh-xingpf
 * @create-time 2019年4月12日 上午10:22:53
 * @description：Socket工具类，用于向接口发送报文，接收返回数据
 */
public class SocketUtil {
	private static final int BUFFER_SIZE = 1024*1024;
	
	/*
	 * url:请求地址
	 * port：请求端口号
	 * reqXML：请求报文
	 */
	public static String getRespXML2(String url,int port,String reqXML) {
		byte[] res =null;
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
	
		try {
			socket = new Socket(url,port);
			socket.setSoTimeout(10000);
			is  = socket.getInputStream();
			os = socket.getOutputStream();
			os.write(reqXML.getBytes("UTF-8"));
			os.flush();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buffer =new byte[8192];
			int count;
			while((count = is.read(buffer)) != -1) {
				bos.write(buffer,0,count);
			}
			res = bos.toByteArray();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(os != null) {
					os.close();
				}
				if(is != null) {
					is.close();
				}
				if(socket != null) {
					socket.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return new String(res);
	}

}
