package ch.bfh;

import java.util.Collection;

public interface IList {

    void add(Person p);
    Collection<Person> searchByName(String searchArg);

}