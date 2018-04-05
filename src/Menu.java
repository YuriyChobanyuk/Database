import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	private File file;
	
	public Menu(){
		file = new File ("MyDatabase.txt");
	}

	public Menu(String filename) {
		this.file = new File(filename);
	}

	public void StartMenu(){
		int var;
		Scanner scan = new Scanner(System.in);
		do{
			System.out.println("------- MENU -------");
			System.out.println("1. Add person");
			System.out.println("2. Show person");
			System.out.println("3. Edit person");
			System.out.println("4. Delete person");
			System.out.println("0. Exit");
			var = scan.nextInt();
			switch (var){
			case 1:
				Add();
				break;
			case 2:
				Show();
				break;
			case 3:
				Edit();
				break;
			case 4:
				Delete();
				break;
			}
		}while(var != 0);
		scan.close();
	}
	
	public String[] SelectPers() {                                    // Функція вибору працівника
		String[] field_mass = new String[13];                         // Маасив полів обєкта
		ArrayList<String> var_list = new ArrayList<String>();         // Скорочений список працівників
		try (FileReader fr = new FileReader(file); BufferedReader bufferedreader = new BufferedReader(fr);) {

			while (bufferedreader.ready()) {
				String temp = bufferedreader.readLine();
				field_mass = temp.split("; ");
				var_list.add(field_mass[0] + field_mass[1] + field_mass[2]);
			}
			System.out.println("Select member id");
			for (int i = 0; i < var_list.size(); i++) {
				System.out.println(var_list.get(i));
			}
			Scanner sc = new Scanner(System.in);
			int inid = sc.nextInt();
			sc.close();
			int temp_id;
			do {
				String temp = bufferedreader.readLine();
				field_mass = temp.split("; ");
				temp_id = Integer.parseInt(field_mass[0]);
			} while (inid != temp_id);
		} catch (IOException e) {
			System.out.println("Selection problem");
		}

		return field_mass;                  // Повертає массив полів вибраного працівника(String[])
	}

	public void InitiateFromFile(String[] field_mass, Person pers) {  //Ініціалізує обєкт даними з файлу
		pers.setId(Integer.parseInt(field_mass[0]));
		pers.setName(field_mass[1]);
		pers.setSurname(field_mass[2]);
		pers.setSec_name(field_mass[3]);
		pers.setBirth_date(field_mass[4]);
		pers.setJob(field_mass[5]);
		pers.setFilia(field_mass[6]);
		pers.setRoom(Integer.parseInt(field_mass[7]));
		pers.setPhone(Integer.parseInt(field_mass[8]));
		pers.setE_mail(field_mass[9]);
		pers.setSalary(Double.parseDouble(field_mass[10]));
		pers.setAcception(field_mass[11]);
		pers.setAdds(field_mass[12]);
	}

	public void Add() {
		Person pers = new Person();
		pers.Initiate();
		try(FileWriter fw = new FileWriter(file);
				BufferedWriter bufferwriter = new BufferedWriter(fw)){
			bufferwriter.write(pers.getFullInfo());
		}catch (IOException e) {
			System.out.println("Addiction problem");
		}
	}

	public void Show() {
		String[] field_mass = SelectPers();
		Person pers = new Person();
		InitiateFromFile(field_mass, pers);
		System.out.println(pers.getFullInfo());
	}

	public void Fields(){
		System.out.println("1. Id");
		System.out.println("2. Name");
		System.out.println("3. Surname");
		System.out.println("4. Second name");
		System.out.println("5. Birthday");
		System.out.println("6. Job");
		System.out.println("7. Filia");
		System.out.println("8. Room");
		System.out.println("9. Phone");
		System.out.println("10. E-mail");
		System.out.println("11. Salary");
		System.out.println("12. Acception date");
		System.out.println("13. Addictions");
	}
	
	public void Edit() {
		System.out.println("Edit");
		String[] field_mass = SelectPers();
		Person pers = new Person();
		InitiateFromFile(field_mass, pers);
		Scanner scan = new Scanner(System.in);
		int var;
		do {
			System.out.println("Select number of field to edit");
			Fields();
			System.out.println("Press 0 to exit");
			var = scan.nextInt();
			switch (var) {
			case 1:
				System.out.println("Enter new id");
				pers.setId(scan.nextInt());
				break;

			case 2:
				System.out.println("Enter new name");
				pers.setName(scan.nextLine());
				break;

			case 3:
				System.out.println("Enter new surname");
				pers.setSurname(scan.nextLine());
				break;
			case 4:
				System.out.println("Enter new second name");
				pers.setSec_name(scan.nextLine());
				break;
			case 5:
				System.out.println("Enter new date of birth");
				pers.setBirth_date(scan.nextLine());
				break;
			case 6:
				System.out.println("Enter new Job");
				pers.setJob(scan.nextLine());
				break;
			case 7:
				System.out.println("Enter new filia");
				pers.setFilia(scan.nextLine());
				break;
			case 8:
				System.out.println("Enter new room");
				pers.setRoom(scan.nextInt());
				break;
			case 9:
				System.out.println("Enter new phone");
				pers.setPhone(scan.nextInt());
				break;
			case 10:
				System.out.println("Enter new e-mail");
				pers.setE_mail(scan.nextLine());
				break;
			case 11:
				System.out.println("Enter new salary");
				pers.setSalary(scan.nextDouble());
				break;
			case 12:
				System.out.println("Enter new date of acception");
				pers.setAcception(scan.nextLine());
				break;
			case 13:
				System.out.println("Enter new addictions");
				pers.setAdds(scan.nextLine());
				break;
			}
		} while (var != 0);
		scan.close();
		Deletation(Integer.parseInt(field_mass[0])); // Видаляємо старий запис
		try (FileWriter fileWriter = new FileWriter(file); // Додаємо новий(в
															// кінець)
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
			bufferedWriter.write(pers.getFullInfo());
		}catch (IOException e) {
			System.out.println("Editation problem");
		}
	}

	public void Deletation(int id) {                                  //Безросереднє видалення працівника
		ArrayList<String> base = new ArrayList<String>();
		try (FileReader filereader = new FileReader(file);
				BufferedReader bufferedreader = new BufferedReader(filereader);) {
			while (bufferedreader.ready()) {
				base.add(bufferedreader.readLine());
			}
		} catch (IOException e) {
			System.out.println("Input-outout exception");
		}
		for (int i = 0; i < base.size(); i++) {
			String[] temp_array = base.get(i).split("; ");
			if (Integer.parseInt(temp_array[0]) == id) {
				base.remove(i);
			}
		}
		try (FileWriter filewriter = new FileWriter(file); BufferedWriter bf = new BufferedWriter(filewriter)) {
			if (file.exists()) { // Перезапис файлу ?????????????
				file.delete();
				file.createNewFile();
				for (int i = 0; i < base.size(); i++) {
					bf.write(base.get(i));
				}
			}
		} catch (IOException e) {
			System.out.println("Deletation problems");
		}

	}

	public void Delete() {
		System.out.println("Delete");
		String field_mass[] = SelectPers();
		Deletation(Integer.parseInt(field_mass[0]));
	}

	/*public void Report(){
		int var;
		String field;
		ArrayList<String> base = new ArrayList<>();
		ArrayList<String> confirmed = new ArrayList<>();
		try(FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader)){
			while(bufferedReader.ready()){
				base.add(bufferedReader.readLine());
			}
		}
		System.out.println("Enter field for reporting");
		Fields();
		Scanner scan = new Scanner(System.in);
		var = scan.nextInt();
		switch (var) {
		case 1:
			System.out.println("Enter field to seek");
			field = scan.nextLine();
			for (int i = 0; i < base.size(); i++) {
				if(Integer.parseInt(base.get(i).split("; ")[0]) == Integer.parseInt(field)){
					confirmed.add(base.get(i));
				}
			}
			break;

		case 2:
			System.out.println("Enter field to seek");
			field = scan.nextLine();
			for (int i = 0; i < base.size(); i++) {
				if(base.get(i).split("; ")[1].equals(field)){
					confirmed.add(base.get(i));
				}
			}
			break;

		case 3:
			System.out.println("Enter field to seek");
			field = scan.nextLine();
			for (int i = 0; i < base.size(); i++) {
				if(base.get(i).split("; ")[2].equals(field)){
					confirmed.add(base.get(i));
				}
			}
			break;
		case 4:
			System.out.println("Enter field to seek");
			field = scan.nextLine();
			for (int i = 0; i < base.size(); i++) {
				if(base.get(i).split("; ")[3].equals(field)){
					confirmed.add(base.get(i));
				}
			}
			break;
		case 5:
			System.out.println("Enter field to seek");
			field = scan.nextLine();
			for (int i = 0; i < base.size(); i++) {
				if(base.get(i).split("; ")[4].equals(field)){
					confirmed.add(base.get(i));
				}
			}
			break;
		case 6:
			System.out.println("Enter field to seek");
			field = scan.nextLine();
			for (int i = 0; i < base.size(); i++) {
				if(base.get(i).split("; ")[5].equals(field)){
					confirmed.add(base.get(i));
				}
			}
			break;
		case 7:
			System.out.println("Enter new filia");
			pers.setFilia(scan.nextLine());
			break;
		case 8:
			System.out.println("Enter new room");
			pers.setRoom(scan.nextInt());
			break;
		case 9:
			System.out.println("Enter new phone");
			pers.setPhone(scan.nextInt());
			break;
		case 10:
			System.out.println("Enter new e-mail");
			pers.setE_mail(scan.nextLine());
			break;
		case 11:
			System.out.println("Enter new salary");
			pers.setSalary(scan.nextDouble());
			break;
		case 12:
			System.out.println("Enter new date of acception");
			pers.setAcception(scan.nextLine());
			break;
		case 13:
			System.out.println("Enter new addictions");
			pers.setAdds(scan.nextLine());
			break;
		}
	} while (var != 0);
	scan.close();
	}*/
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}
