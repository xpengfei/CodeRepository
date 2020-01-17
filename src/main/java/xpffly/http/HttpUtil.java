package xpffly.http;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

/**
 * @author szfh-xingpf
 * @create-time 2019年4月15日 下午4:04:07
 * @description：发送http请求工具类
 */
public class HttpUtil {

	/*
	public static String post(String url, String params) {
		Map<String,String> headers = new HashMap<String,String>();
		headers.put("Content-Type", "application/x-www-form-urlencoded");
		HttpURLConnection con = null;
		try {
			URL u = new URL(url);
			con = (HttpURLConnection) u.openConnection();
			con.setRequestMethod("POST");
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setUseCaches(false);
			for (String key : headers.keySet()) {
				con.setRequestProperty(key, headers.get(key));
			}
			DataOutputStream osw = new DataOutputStream(con.getOutputStream());
			osw.write(params.getBytes());
			osw.flush();
			osw.close();
		} catch (Exception e) {		
			if (con != null) {
				con.disconnect();
			}
		}	
		try {
			StringBuffer sb = new StringBuffer();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					con.getInputStream(), "UTF-8"));
			int byteRead = 0;
			char[] buffer = new char[8192];
			while ((byteRead = br.read(buffer, 0, 8192)) != -1) {
				sb.append(buffer, 0, byteRead);
			}
			String result = sb.toString();			
			return result;		
		} catch (Exception e) {
		
		} finally {
			if (con != null) {
				con.disconnect();
			}
		}
		return null;
	}
*/

	public static String post(String url,String params) {
		StringBuffer sb = new StringBuffer();
		HttpURLConnection con = null;
		DataOutputStream out = null;
		BufferedReader in = null;

		try {
			URL conUrl = new URL(url);
			con = (HttpURLConnection) conUrl.openConnection();
			con.setDoOutput(true);	//设置连接输出流为true，默认为false
			con.setDoInput(true);	//设置连接输入流为true
			con.setRequestMethod("POST");
			con.setUseCaches(false);
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			con.connect();

			out = new DataOutputStream(con.getOutputStream());
			out.write(params.getBytes());
			out.flush();

			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			int byteRead = 0;
			char[] buffer = new char[8192];
			while ((byteRead = in.read(buffer, 0, 8192)) != -1) {
				sb.append(buffer, 0, byteRead);
			}
			return sb.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				con.disconnect();
			}
		}
		return null;
	}


    //对方返回数据后，如果关闭了socket：
    public static byte[] sendMessage(String url, int port, byte[] request) {
        byte[] res = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            socket = new Socket(url, port);
            os = socket.getOutputStream();
            os.write(request);
            os.flush();
            is = socket.getInputStream();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int count = 0;
            do {
                count = is.read(buffer);
                bos.write(buffer, 0, count);
            } while (is.available() != 0);
            res = bos.toByteArray();
            os.close();
            is.close();
            socket.close();
        } catch (Exception ex) {
            try {
                if (is != null) {
                    is.close();
                }
                if (socket != null)
                    socket.close();
            } catch (Exception e) {
            }
        }
        return res;
    }
}
