package minor;
import java.io.FileInputStream;
import java.io.File;

/**
 *
 * @author happy_skd
 */

public interface FileWork {
    String d = PDdetect.driveLetter;
    public static File in = new File(d+"input-file.txt");
    public static File out_aes = new File(d+"output-aes.txt");
    public static File out_aes_dec = new File(d+"output-aes-dec.txt");
    public static File out_des = new File(d+"output-des.txt");
    public static File out_des_dec = new File(d+"output-des-dec.txt");
    public static File privateKeyFile = new File("d:\\private.der");
    public static File publicKeyFile = new File("d:\\public.der");
    public static String key = "happyskd";
}
