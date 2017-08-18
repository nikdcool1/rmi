import java.rmi.*;
import java.rmi.server.*;
interface Student extends Remote
{
public void addStudent(int rollNumber,String name) throws RemoteException;
public int getStudentCount() throws RemoteException;
}
class XServer extends UnicastRemoteObject implements Student
{
XServer() throws RemoteException
{
System.out.println("Server object instantiated");
}
public void addStudent(int rollNumber,String name)
{
System.out.println("Roll Number : "+rollNumber);
System.out.println("Name : "+name);
System.out.println("Student added");
}
public int getStudentCount()
{
return 2;
}
public static void main(String gg[]) throws Exception
{
XServer x=new XServer();
Naming.bind("XServer",x);
}
}
class XClient 
{
public static void main(String gg[]) throws Exception
{
Student x;
x=(Student)Naming.lookup("rmi://localhost/XServer");
x.addStudent(101,"Ramesh");
System.out.println(x.getStudentCount());
}
} //dsadsdda