	import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Comparator;
	import java.util.List;
	import java.util.Scanner;
	
	public class ReaderMain {
	
	public static void main(String[] args) throws IOException {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter a file destination: EX. C:\\Users\\qbnsi\\Desktop\\NanCSV.csv");
	String csv = scanner.nextLine();
	scanner.close();
	
	List<Insurance> outPut = read(csv);
		outPut.sort(Comparator.comparing(Insurance::getLastName));
		write(outPut); 
	}
	
	public static void write(List<Insurance> ins) throws IOException {
		FileWriter csvWriter = null;
		StringBuilder build = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		
		for (Insurance a: ins) {
			  build.append(a.getId());
			  build.append(", ");
			  build.append(a.getFullName());
			  build.append(", ");
			  build.append(a.getVersion());
			  build.append(", ");
			  build.append(a.getInsurance());
			  build.append(";");
			}
		String lines = build.toString();
		String splittingLines[] = lines.split(";");
		
		//puts the insurance column into a list
		for (Insurance a: ins) {
		  sb.append(a.getInsurance());
		  sb.append(", ");
		}
	
		//insurance list is put into a 1d array
		String insur = sb.toString();
		String splittingIns[] = insur.split(", ");
		
		String unique[] = Arrays.stream(splittingIns).distinct().toArray(String[]::new);
		
		for(int j = 0; j <unique.length;j++) {
			File temp = File.createTempFile(ins.get(j).getInsurance(), ".csv"); 
			csvWriter = new FileWriter(temp.getAbsolutePath());
			System.out.println(temp);
			for(int i = 0; i < splittingLines.length;i++) {
				if(unique[j].equals(ins.get(i).getInsurance())) {
					csvWriter.append(splittingLines[i]);
					csvWriter.append("\n");
					csvWriter.flush(); 
				} 
			}
			csvWriter.close();
		}
	}
	
	public static List<Insurance> read (String csvFile) throws IOException  {
	BufferedReader reader = new BufferedReader(new FileReader(csvFile));
	
	// read file line by line
	String line = null;
	int index = 0;
	List<Insurance> insuranceList = new ArrayList<>();
	
	while ((line = reader.readLine()) != null) {
	Insurance emp = new Insurance();
	Scanner scanner = new Scanner(line);
	scanner.useDelimiter(",");
	
	while (scanner.hasNext()) {
		String data = scanner.next();
		if (index == 0)
			emp.setId(data);
		else if (index == 1) {
			emp.setFullName(data);
			emp.setFirstName(data.split(" ")[0]);
			emp.setLastName(data.split(" ")[1]);
		}
		else if (index == 2)
			emp.setVersion(Integer.parseInt(data));
		else if (index == 3)
			emp.setInsurance(data);
		else
			System.out.println("invalid data::" + data);
		index++;
		}
	
	index = 0;
	if (UserIdExists(insuranceList, emp) == false) {
		insuranceList.add(emp);
	}
	else {
		
		insuranceList = UpdateUserId(insuranceList, emp);
	}
	}
	
	//close reader
	reader.close();
	
	return insuranceList;
	
	}
	
	private static boolean UserIdExists(List<Insurance> insuranceList, Insurance userToAdd) {
		for(Insurance insurance : insuranceList){
			if (insurance.getId().equals(userToAdd.getId()) && insurance.getInsurance().equals(userToAdd.getInsurance())){
					return true;
			}
		}
		return false;
		}
	
	public static List<Insurance> UpdateUserId(List<Insurance> insuranceList, Insurance userToAdd) {	
		for(Insurance insurance : insuranceList){
			
			if (insurance.getInsurance().equals(userToAdd.getInsurance()) && insurance.getId().equals(userToAdd.getId()) && insurance.getVersion() < userToAdd.getVersion()){
				insurance.UpdateUserInformation(userToAdd);
			}
			else {
				continue;
			}
		}
		return insuranceList;
	}
	}
