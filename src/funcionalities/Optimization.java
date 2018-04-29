package funcionalities;

import java.io.File;
import java.io.FilenameFilter;

public class Optimization {

	public File[] searchFiles() {
		
		File f = new File("C:\\Users\\Ricardo\\Desktop\\ES");
		File[] matchingFiles = f.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.endsWith("xml");
		    }
		});
		
		return matchingFiles;		
	}

}
