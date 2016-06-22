import java.io.File;  
import java.net.URL;  
import java.security.ProtectionDomain;  
  
import org.eclipse.jetty.server.Server;  
import org.eclipse.jetty.webapp.WebAppContext;  
  
public class CompareLuncher {  
    public static void main(String[] args) throws Exception {  
        String currentPath=new File("").getAbsolutePath();  
        //如果没有work目录，则创建,jetty默认解压路径  
        File work=new File(currentPath+"\\work");  
        if(!work.exists()){  
            work.mkdir();  
        }  
        Server server =null;  
        Integer port=8090;  
        server=new Server(port);  
        ProtectionDomain domain = CompareLuncher.class.getProtectionDomain();  
        URL location = domain.getCodeSource().getLocation();  
        WebAppContext webapp = new WebAppContext();  
        webapp.setContextPath("/");  
        webapp.setWar(location.toExternalForm());  
        server.setHandler(webapp);  
        server.start();  
        server.join();  
  
    }  
  
    private static WebAppContext getWebAppContext() {  
  
        String path = CompareLuncher.class.getResource("/").getFile()  
                .replaceAll("/target/(.*)", "")  
                + "/src/main/webapp";  
//      System.out.println(path);  
        String path2 = new File("").getAbsolutePath() + "\\src\\main\\webapp";  
        // System.out.println();  
  
        return new WebAppContext(path2, "/");  
    }  
}  