package PatternsJava;

class employee{
    int salary;
    String name;
    public int getSalary(){
        return salary;
    }
    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }
}
public class Main {
    public static void main(String[] args) {
        employee harry = new employee();
        harry.setName("Coder");
        System.out.println(harry.getName());
    }
}
