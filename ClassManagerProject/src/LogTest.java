import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class LogFile {
	
	BufferedWriter bw;
	BufferedReader br;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	static final String ROOT_DIR = "C:\\";
	
	
	public void writeLog(char type, String dir, String str) {
				
		File directory = new File(ROOT_DIR, dir);
		if(!directory.exists())
			directory.mkdirs();
		
		String today = sdf.format( new Date(System.currentTimeMillis() ));
		String typeName = null;
		switch (type) {
			/* TYPE 추가 할 것 */
			case 'A': typeName = "Server";
			case 'B': typeName = "Chatting";
			case 'C': typeName = "Client";
		}
		String logDir = String.format("%s%s\\%s_%s.log", ROOT_DIR, dir, today.substring(0, 10), typeName );
		
		
		try {
			bw = new BufferedWriter( new FileWriter(logDir, true) );
			bw.write(str);
			bw.append("\r\n");
			bw.flush();
			
		} catch (IOException e) {
			System.out.println("[!] 파일이 존재하지 않습니다. (경로: " + logDir + "_writeLog");
		}
		finally {
			try {
				if (bw != null) {
					bw.close();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String readLog(char type, String dir) {
		
		File directory = new File(ROOT_DIR, dir);
		if(!directory.exists())
			directory.mkdirs();
		
		String today = sdf.format( new Date(System.currentTimeMillis() ));
		String typeName = null;
		switch (type) {
			/* TYPE 추가 할 것 */
			case 'A': typeName = "Server";
			case 'B': typeName = "Chatting";
			case 'C': typeName = "Client";
		}
		String logDir = String.format("%s%s\\%s_%s.log", ROOT_DIR, dir, today.substring(0, 10), typeName );		
		StringBuilder sb = new StringBuilder();
		
		try {
			br = new BufferedReader( new FileReader(logDir) );
			String text = null;
			
			while( (text = br.readLine()) != null) {
				sb.append(text).append("\r\n");
			}
			
		} catch (IOException e) {
			System.out.println("[!] 파일이 존재하지 않습니다. (경로: " + logDir + "readerLog");
		}
		finally {
			try {
				if (br != null) {
					br.close();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
public class LogTest {
	
	public static void main(String[] args) {
		
//		LogFile lf = new LogFile();		
//		for(int i=0; i<10; i++) {
//			System.out.println(lf.readLog('A', "김현우/천재"));
//		}
		//System.out.println( lf.readerLog("123") );
		
	}
}
