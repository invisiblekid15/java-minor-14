package minor;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import javax.swing.JOptionPane;
/**
 *
 * @author happy_skd
 */
public class PDdetect {
    
    public static String driveLetter;
    public static void main(String[] args)
    {
        
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File[] f = File.listRoots();
        for (int i = 0; i < f.length; i++) {
          String drive = f[i].getPath();
          String displayName = fsv.getSystemDisplayName(f[i]);
          String type = fsv.getSystemTypeDescription(f[i]);
          boolean isDrive = fsv.isDrive(f[i]);
          boolean isFloppy = fsv.isFloppyDrive(f[i]);
          boolean canRead = f[i].canRead();
          boolean canWrite = f[i].canWrite();
					
        if (canRead && canWrite && !isFloppy && isDrive && (type.toLowerCase().contains("removable") || type.toLowerCase().contains("rimovibile"))) {
          //log.info("Detected PEN Drive: " + drive + " - "+ displayName);
          driveLetter = drive;
          break;
        }						
}
				
if (driveLetter.equals("")) {
  // USB Drive not found
  // ....		
    System.out.println("nothing found");
    JOptionPane.showMessageDialog(null,"No Pen Drive Detected");
    } else {
  // USB drive found: driveLetter
  // ...
    System.out.println("successfully detected: " +driveLetter);
    JOptionPane.showMessageDialog(null,"Pen Drive Detected");
    //MinorApp.main(args);
    }   

    }
    
}
