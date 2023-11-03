
import java.util.*;
import java.text.*;
import java.text.SimpleDateFormat;
class EmployeeDetails{
  private static int nextId=1;
  private int employeeId;
  private String name;
  private int age;
  private String gender;
  private double salary;
  private long aadharNumber;
  private long mobileNumber;
  private String address;
  private String city;
  private Date dateOfBirth;
  public EmployeeDetails(String name,int age,String gender,double salary,long aadharNumber,long mobileNumber,String address,String city,Date dateOfBirth){
    this.name=name;
    this.age=age;
    this.gender=gender;
    this.salary=salary;
    this.aadharNumber=aadharNumber;
    this.mobileNumber=mobileNumber;
    this.address=address;
    this.city=city;
    this.dateOfBirth=dateOfBirth;
    employeeId=nextId++;
  }
public int getEmployeeId() {
	return employeeId;
}
/*public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}*/
public String getName() {
	return name;
}
/*public void setName(String name) {
	this.name = name;
}*/
public int getAge() {
	return age;
}
/*public void setAge(int age) {
	this.age = age;
}*/
public String getGender() {
	return gender;
}
/*public void setGender(String gender) {
	this.gender = gender;
}*/
public double getSalary() {
	return salary;
}
/*public void setSalary(double salary) {
	this.salary = salary;
}*/
public long getAadharNumber() {
	return aadharNumber;
}
/*public void setAadharNumber(long aadharNumber) {
	this.aadharNumber = aadharNumber;
}*/
public long getMobileNumber() {
	return mobileNumber;
}
/*public void setMobileNumber(long mobileNumber) {
	this.mobileNumber = mobileNumber;
}*/
public String getAddress() {
	return address;
}
/*public void setAddress(String address) {
	this.address = address;
}*/
public String getCity() {
	return city;
}
/*public void setCity(String city) {
	this.city = city;
}*/
public Date getDateOfBirth() {
	return dateOfBirth;
}
/*public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}*/
  
}
class CompanyManagementSystem{
  HashMap<Integer,EmployeeDetails> employees=new HashMap<Integer,EmployeeDetails>();
  public void display(EmployeeDetails emp){
    System.out.println();
    System.out.println("Employee Id: "+emp.getEmployeeId());
    System.out.println("Employee Name: "+emp.getName());
    System.out.println("Employee Age: "+emp.getAge());
    System.out.println("Employee gender: "+emp.getGender());
    System.out.println("Employee Salary: "+emp.getSalary());
    System.out.println("Employee Aadhar Number: "+emp.getAadharNumber());
    System.out.println("Employee Mobile Number: "+emp.getMobileNumber());
    System.out.println("Employee Address: "+emp.getAddress());
    System.out.println("Employee City: "+emp.getCity());
    System.out.println("Employee Date Of Birth: "+emp.getDateOfBirth());
  }
  public void addEmployee(EmployeeDetails emp){
    employees.put(emp.getEmployeeId(), emp);
    System.out.println("Added New Employee SucessFully");
  }
  public void allEmployeeDetails(){
    for(EmployeeDetails emp:employees.values()){
      display(emp);
    }
  }
  public void getDetailsWithId(int id){
    int c=0;
    if(employees.isEmpty()){
      System.out.println("Employee Data Base is Empty");
    }
    else{
      for(EmployeeDetails emp:employees.values()){
        if(emp.getEmployeeId()==id){
          c++;
          display(emp);
        }
      }
      if(c==0){
        System.out.println("Employee Id Not Found");
      }
    }
  }
  public void getDetailsWithName(String name){
    int c=0;
    if(employees.isEmpty()){
      System.out.println("Employee Data Base is Empty");
    }
    else{
      for(EmployeeDetails emp:employees.values()){
        if(emp.getName().equalsIgnoreCase(name)){
          c++;
          display(emp);
        }
      }
      if(c==0){
        System.out.println("Employee Name Not Found");
      }
    }
  }
  public void getDetailsWithCity(String city){
    int c=0;
    if(employees.isEmpty()){
      System.out.println("Employee Data Base is Empty");
    }
    else{
      for(EmployeeDetails emp:employees.values()){
        if(emp.getCity().equalsIgnoreCase(city)){
          c++;
          display(emp);
        }
      }
      if(c==0){
        System.out.println("No Employees With This City");
      }
    }
  }
  public void getDetailsWithSalary(double min,double max){
    int c=0;
    if(employees.isEmpty()){
      System.out.println("Employee Data Base is Empty");
    }
    else{
      for(EmployeeDetails emp:employees.values()){
        if(emp.getSalary()>=min && emp.getSalary()<=max){
          c++;
          display(emp);
        }
      }
      if(c==0){
        System.out.println("With This salary range there is No employees");
      }
    }
  }
  public void getDetailsWithAge(int minAge,int maxAge){
    int c=0;
    if(employees.isEmpty()){
      System.out.println("Employee Data Base is Empty");
    }
    else{
      for(EmployeeDetails emp:employees.values()){
        if(emp.getAge()>=minAge && emp.getAge()<=maxAge){
          c++;
          display(emp);
        }
      }
      if(c==0){
        System.out.println("No Employees with this age range");
      }
    }
  }
  public void deleteEmployeeWithId(int id){
    int c=0;
    if(employees.isEmpty()){
      System.out.println("Employee Data Base is Empty");
    }
    else{
      for(EmployeeDetails emp:employees.values()){
        if(emp.getEmployeeId()==id){
          c++;
          display(emp);
          employees.remove(emp.getEmployeeId(), emp);
          System.out.println("Deleted Employee Sucessfully");
        }
      }
      if(c==0){
        System.out.println("Employee id Not Found");
      }
    }
  }
}
class InvalidAgeValue extends Exception{
  public InvalidAgeValue(String str){
    super(str);
  }
}
class InvalidAadharNumber extends Exception{
  public InvalidAadharNumber(String str){
    super(str);
  }
}
class InvalidMobileNumber extends Exception{
  public InvalidMobileNumber(String str){
    super(str);
  }
}
class InvalidOptionSelected extends Exception{
  public InvalidOptionSelected(String str){
    super(str);
  }
}
public class EmployeeDataManagement{
  public static void main(String[] args) throws Exception{
    Scanner sc=new Scanner(System.in);
    CompanyManagementSystem cm=new CompanyManagementSystem();
    while(true){
      System.out.println();
      System.out.println("========Employee Management System========\n1.Add Employee\n2.Display All Employee Details\n3.Get Employee With Id\n4.Get Employee With Name\n5.Get Employees With City\n6.Get Employees with Salary Range\n7.Get Employees With Age\n8.Delete Employee By ID\n9.Quit\nSelect One Option\n============================================");
      try{
        int option1=sc.nextInt();
        if(option1>0&&option1<=9){
          
        }
        else{
          try{
          throw new InvalidOptionSelected("InvalidOptionSelected");
          }
          catch(InvalidOptionSelected e){
            System.out.println("Exception: "+e.getMessage());
          }
        }
      switch(option1){
        case 1:
          sc.nextLine();
          System.out.print("Entre Name: ");
          String name=sc.nextLine();
          
          System.out.print("Enter Age: ");
          int age=sc.nextInt();
          try{
            if(age<0)
              throw new InvalidAgeValue("For Age Negative Value is Not Valid");
          }
          catch(InvalidAgeValue e){
            System.out.println("Exception: "+e.getMessage());
          }
          sc.nextLine();
          System.out.print("Enter Gender: ");
          String gender=sc.nextLine();
          
          System.out.print("Enter Slaray: ");
          double salary=sc.nextDouble();
          System.out.print("Enter aadhar Number: ");
          long aadharNumber=sc.nextLong();
          if(100000000000l <=aadharNumber && 999999999999l>=aadharNumber){
            aadharNumber=aadharNumber;
          }
          else{
            try{
              throw new InvalidAadharNumber("Invalid Aadhar Number");
            }
            catch(InvalidAadharNumber e){
              System.out.println("Exception: "+e.getMessage());
            }
          }
          System.out.print("Enter Mobile Number: ");
          long mobileNumber=sc.nextLong();
          if(1000000000l<=mobileNumber && 9999999999l>=mobileNumber){
            mobileNumber=mobileNumber;
          }
          else{
            try{
              throw new InvalidMobileNumber("InvalidMobileNumber");
            }
            catch(InvalidMobileNumber e){
              System.out.print("Exception: "+e.getMessage());
            }
          }
          sc.nextLine();
          System.out.print("Enter Address: ");
          String address=sc.nextLine();
          System.out.print("Enter City: ");
          String city=sc.nextLine();
          System.out.print("Enter the Date Of Birth: ");
          String str=sc.nextLine();
          DateFormat df=new SimpleDateFormat("DD-MM-YYYY");
          Date dateOfBirth=df.parse(str);
          EmployeeDetails emp=new EmployeeDetails(name,age,gender,salary,aadharNumber,mobileNumber,address,city,dateOfBirth);
          cm.addEmployee(emp);
          break;
        case 2:
          cm.allEmployeeDetails();
          break;
        case 3:
          System.out.print("Enter Id: ");
          int id=sc.nextInt();
          cm.getDetailsWithId(id);
          break;
        case 4:
          sc.nextLine();
          System.out.print("Enter Name: ");
          String name1=sc.nextLine();
          cm.getDetailsWithName(name1);
          break;
        case 5:
          sc.nextLine();
          System.out.print("Enter City: ");
          String city1=sc.nextLine();
          cm.getDetailsWithCity(city1);
          break;
        case 6:
          System.out.print("Enter Min Salary: ");
          double minSalary=sc.nextDouble();
          System.out.print("Enter Max Salary: ");
          double maxSalary=sc.nextDouble();
          cm.getDetailsWithSalary(minSalary, maxSalary);
          break;
        case 7:
          System.out.print("Enter Min Age: ");
          int minAge=sc.nextInt();
          System.out.print("Enter MAx Age: ");
          int maxAge=sc.nextInt();
          break;
        case 8:
          System.out.print("Enter Id: ");
          int id1=sc.nextInt();
          cm.deleteEmployeeWithId(id1);
          break;
        case 9:
          System.out.println("Shut Down......");
          System.exit(0);
      }
      }
      catch(InputMismatchException e){
        System.out.println("Exception: "+e.getMessage());
        System.exit(0);
      }
    }
  }
}