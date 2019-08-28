package ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.HashMap;




public class ReadImgDemo {

	/**
	 * 得到正式服务器配置信息
	 *
	 * @return
	 */
	public static HashMap<String, String> getFTPZSConfig() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ftpZSHost", "172.16.21.27");// 服务器ip
		map.put("ftpZSPort", "21");// 服务器端口
		map.put("ftpZSUserName", "administrator");// 服务器用户名
		map.put("ftpZSPassword", "Hdyyerp2018$");// 服务器密码
		map.put("ftpZSPath", "/bind/0000000065.jpg");// 服务器存放路径
		return map;
	}

	/**
	 * 获取FTPClient对象
	 *
	 * @param ftpHost
	 *            FTP主机服务器
	 * @param ftpPassword
	 *            FTP 登录密码
	 * @param ftpUserName
	 *            FTP登录用户名
	 * @param ftpPort
	 *            FTP端口 默认为21
	 * @return
	 */
	public static FTPClient getFTPClient(String ftpHost, String ftpPassword,
										 String ftpUserName, int ftpPort) {
		FTPClient ftpClient = null;
		try {
			ftpClient = new FTPClient();
			ftpClient.enterLocalPassiveMode();
			ftpClient.setDefaultTimeout(10 * 1000);
		//	ftpClient.setConnectTimeout(10 * 1000);
			ftpClient.setDataTimeout(10 * 1000);
			ftpClient.connect(ftpHost, ftpPort);// 连接FTP服务器
			ftpClient.login(ftpUserName, ftpPassword);// 登陆FTP服务器
			if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
//				logger.info("未连接到FTP，用户名或密码错误。");
				ftpClient.disconnect();
			} else {
//				logger.info("FTP连接成功。");
			}
		} catch (SocketException e) {
			e.printStackTrace();
//			logger.info("FTP的IP地址可能错误，请正确配置。");
		} catch (IOException e) {
			e.printStackTrace();
//			logger.info("FTP的端口错误,请正确配置。");
		}
		return ftpClient;
	}

	/**
	 * 连接正式服务器
	 *
	 * @return
	 * @throws IOException
	 */
	public static FTPClient getFTPZSConn(HashMap<String, String> ftpzsconfig)
			throws IOException {
		FTPClient ftpZSClient = null;
		try {
			ftpZSClient = getFTPClient(ftpzsconfig.get("ftpZSHost"),
					ftpzsconfig.get("ftpZSPassword"),
					ftpzsconfig.get("ftpZSUserName"),
					Integer.valueOf(ftpzsconfig.get("ftpZSPort")).intValue());
			ftpZSClient.setControlEncoding("UTF-8"); // 中文支持
			ftpZSClient.setFileType(FTPClient.BINARY_FILE_TYPE);// 二进制传输
			ftpZSClient.enterLocalPassiveMode();
			ftpZSClient.changeWorkingDirectory(ftpzsconfig.get("ftpZSPath"));
		} catch (SocketException e) {
			// logger.append("连接FTP失败.");
			System.err.println("连接FTP失败！" + e.getMessage());
		} catch (IOException e) {
			// logger.append("文件读取错误！");
			System.err.println("文件读取错误！" + e.getMessage());
		}
		return ftpZSClient;
	}


	/**
	 * 将InputStream写入本地文件
	 * @param destination 写入本地目录
	 * @param input	输入流
	 * @throws IOException
	 */
	private static void writeToLocal(String destination, InputStream input)
			throws IOException {
		int index;
		byte[] bytes = new byte[1024];
		FileOutputStream downloadFile = new FileOutputStream(destination);
		while ((index = input.read(bytes)) != -1) {
			downloadFile.write(bytes, 0, index);
			downloadFile.flush();
		}
		downloadFile.close();
		input.close();
	}

	public static void main(String[] args) {
		// 得到正式文件服务器配置信息
		HashMap<String, String> ftpzsconfig = getFTPZSConfig();
		// 连接正式文件服务器
		FTPClient ftpZSClient;
		InputStream in = null;
		String url = ""; // 该URL就是传递给商务网的资料路径 ,里面包含中文路径，故需要字符集转换
		try {
			ftpZSClient = getFTPZSConn(ftpzsconfig);
			String ftpZSPath = ftpzsconfig.get("ftpZSPath");
			String remote = "/" + ftpZSPath + url;
			remote = new String(remote.getBytes("GBK"), "iso-8859-1");
			in = ftpZSClient.retrieveFileStream(remote);  // 拿到InputStream应该就可以了
			// TODO:
			writeToLocal("C:/Users/Administrator/Desktop/pic/"+System.currentTimeMillis()+".jpg",in);
		} catch (IOException e1) {
			System.err.println(e1);
			System.err.println(e1.getMessage());
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
	}

}
