package funcionalities;

import java.io.File;
import java.io.FilenameFilter;

public class Optimization {
	
	/**
	 * Method to get all XML Files in specified folder
	 * @param diretory XML Files path
	 * @return XML Files
	 */
	
	public File[] searchFiles(String diretory) {
		
		File f = new File(diretory);
		File[] matchingFiles = f.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.endsWith("xml");
		    }
		});
		
		return matchingFiles;		
	}

}
