package minor;
import java.io.FileInputStream;
import java.io.File;

/**
 *
 * @author happy_skd
 */
public interface FileWork {
       
    public static File in = new File("d:\\input-file.txt");
    public static File out_aes = new File("d:\\output-aes.txt");
    public static File out_des = new File("d:\\output-des.txt");
    public static File privateKeyFile = new File("d:\\privateKey.txt");
    public static File publicKeyFile = new File("d:\\publicKey.txt");
    public static String key = "blackbeard93";
    
    
}
