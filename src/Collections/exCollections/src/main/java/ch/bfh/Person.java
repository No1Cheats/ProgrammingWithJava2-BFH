package ch.bfh;

public class Person {

    int id;
    String name;
    String firstname;
    String zip;
    String city;

    public Person(String line) {
        String[] s = line.split(",");
        id = Integer.parseInt(s[0]);
        name = s[1];
        firstname = s[2];
        zip = s[3];
        city = s[4];
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getFirstname() { return firstname; }
    public String getZIP() { return zip; }
    public String getCity() { return city; }
}