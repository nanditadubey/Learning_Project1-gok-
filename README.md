
1)Problem Statement
comparator library that can be used to compare 2 API responses (HTTP/HTTPS).
2)Input-
The input is two files containg the http/https urls

3)DesignPattern followed is-
public interface IComparator <X, Y> {
public boolean compare(X x, Y y) ;
public Wrapper<X, Y> getData(File file1, File file2);
}

4)comparator library desined is capable of below things-
1)it can compare to json objects;
2)it can validate the json structure;
3)It can compare the nested json objects containig list and object 
4)It can compare the values in the json object.

5)It prints the response in following ways-
https://reqres.in/api/users/3 not equals https://reqres.in/api/users/1
https://reqres.in/api/users/2 equals https://reqres.in/api/users/2
https://reqres.in/api/users?page=1 equals https://reqres.in/api/users?page=1


6)softwares and technolog used
java 8,TestNg,maven build,Restassured,maven

7)Steps to run the application
i)download the project.
ii)extract it in any location
iii)open cmd
iv)go to project location 
v)run mvn clean install
vi) it will run the test cases.





