package minor;
import java.io.FileInputStream;
import java.io.File;

/**
 *
 * @author happy_skd
 */

public interface FileWork {
    public static File in = new File(PDdetect.driveLetter+":\\input-file.txt");
    public static File out_aes = new File(PDdetect.driveLetter+":\\output-aes.txt");
    public static File out_aes_dec = new File(PDdetect.driveLetter+":\\output-aes-dec.txt");
    public static File out_des = new File(PDdetect.driveLetter+":\\output-des.txt");
    public static File out_des_dec = new File(PDdetect.driveLetter+":\\output-des-dec.txt");
    public static File privateKeyFile = new File("d:\\private.der");
    public static File publicKeyFile = new File("d:\\public.der");
    public static String key = "blackbeard93";
}
