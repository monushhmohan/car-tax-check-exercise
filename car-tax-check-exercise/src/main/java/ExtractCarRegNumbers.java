import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class ExtractCarRegNumbers {

	public static void main(String[] args) throws IOException {
		String sourcefile = "src/test/resources/car_input.txt";
		String targetfile = "src/test/resources/car_registration_numbers.csv";
		extractRegNoFromSrctoTrg(sourcefile,targetfile);
	}

	private static void extractRegNoFromSrctoTrg(String sourcefile, String targetfile) throws IOException {
		int count =0;
		File file = new File(sourcefile);
		FileInputStream fis = new FileInputStream(file);
		byte[] bytesArray = new byte[(int)file.length()];
		fis.read(bytesArray);
		String s = new String(bytesArray);
		FileWriter myWriter = new FileWriter(targetfile);
		String[] data =s.split(" ");
		for (int i=0;i<data.length-1;i++) 
		{
			String con=data[i].concat(data[i+1]);
			if(data[i].contains(".")||data[i+1].contains(".")||con.contains(".")) 
			{
				data[i]=data[i].replace(".","");
				data[i+1]=data[i+1].replace(".", "");
				con=con.replace(".","");
			}
			if (data[i].matches("\\b[A-Z][A-Z0-9]+\\b")) 
			{
				System.out.println("i value"+ data[i]);
				if((data[i].length()==7 || data[i].length()==8) && i!=data.length-2)
				{
					myWriter.write(data[i]);
					myWriter.write(",");
				}
				else if ((data[i].length()==7|| data[i].length()==8) && (i!=data.length-2))
				{
					myWriter.write(data[i]);
				}
				System.out.println("concat value "+con);
				if(con.matches("\\b[A-Z][A-Z0-9]+\\b") && (con.length()==7 || con.length()==8)&& i!=data.length-2) 
				{
					myWriter.write(con);
					myWriter.write(",");
				}
				else if(con.matches("\\b[A-Z][A-Z0-9]+\\b") && (con.length()==7 || con.length()==8) && i==data.length-2) 
				{
					myWriter.write(con);
				}
				count++;
			}
		}
		myWriter.close();
	}
}
