
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Person {
	private int id;
	private String surname;
	private String name;
	private String sec_name;
	private Date birth_date;
	private String job;
	private String filia;
	private int room;
	private int phone;
	private String e_mail;
	private double salary;
	private Date acception;
	private String adds;

	public Person(int id, String surname, String name, String sec_name, Date birth_date, String job, String filia,
			int room, int phone, String e_mail, double salary, Date acception, String adds) {
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.sec_name = sec_name;
		this.birth_date = birth_date;
		this.job = job;
		this.filia = filia;
		this.room = room;
		this.phone = phone;
		this.e_mail = e_mail;
		this.salary = salary;
		this.acception = acception;
		this.adds = adds;
	}

	public Person() {

	}

	public void Initiate() {
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Enter id");
		setId(scan1.nextInt());
		System.out.println("Enter name");
		setName(scan1.nextLine());
		System.out.println("Enter surname");
		setSurname(scan1.nextLine());	
		System.out.println("Enter second name");
		setSec_name(scan1.nextLine());
		System.out.println("Enter date of birth");
		setBirth_date(scan1.nextLine());
		System.out.println("Enter job");
		setJob(scan1.nextLine());
		System.out.println("Enter filia");
		setFilia(scan1.nextLine());
		System.out.println("Enter room");
		setRoom(scan1.nextInt());
		System.out.println("Enter phone");
		setPhone(scan1.nextInt());
		System.out.println("Enter e-mail");
		setE_mail(scan1.nextLine());
		System.out.println("Enter salary");
		setSalary(scan1.nextDouble());
		System.out.println("Enter acception date");
		setAcception(scan1.nextLine());
		System.out.println("Enter addictions");
		setAdds(scan1.nextLine());
		scan1.close();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSec_name() {
		return sec_name;
	}

	public void setSec_name(String sec_name) {
		this.sec_name = sec_name;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		GregorianCalendar greg = new GregorianCalendar();
		String [] dat = new String [3];
		dat = birth_date.split(".");
		greg.set(Integer.parseInt(dat[2]), Integer.parseInt(dat[1]), Integer.parseInt(dat[0]));
		this.birth_date = greg.getTime();
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getFilia() {
		return filia;
	}

	public void setFilia(String filia) {
		this.filia = filia;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getAcception() {
		return acception;
	}

	public void setAcception(String acception) {
		GregorianCalendar greg = new GregorianCalendar();
		String [] dat = new String [3];
		dat = acception.split(".");
		greg.set(Integer.parseInt(dat[2]), Integer.parseInt(dat[1]), Integer.parseInt(dat[0]));
		this.acception = greg.getTime();
	}

	public String getAdds() {
		return adds;
	}

	public void setAdds(String adds) {
		this.adds = adds;
	}
	
	public String getFullInfo(){
		return id + "; " + surname + "; " + name + "; " + sec_name + "; " + birth_date + "; " + job + "; " + filia
				+ "; " + room + "; " + phone + "; " + e_mail + "; " + salary + "; " + acception + "; " + adds;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", surname=" + surname + ", name=" + name + ", sec_name=" + sec_name
				+ ", birth_date=" + birth_date + ", job=" + job + ", filia=" + filia + ", room=" + room + ", phone="
				+ phone + ", e_mail=" + e_mail + ", salary=" + salary + ", acception=" + acception + ", adds=" + adds
				+ "]";
	}

	

}
