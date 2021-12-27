package lesson3;

import java.util.*;

public class Directory {

    private Map<String, List<String>> catalog = new HashMap<>();
    private List<String> phone_number_list;


    void add(String surname, String phoneNumber){
        if(catalog.containsKey(surname)){
            phone_number_list = catalog.get(surname);
        }else {
            phone_number_list = new ArrayList<>();
        }
        phone_number_list.add(phoneNumber);
        catalog.put(surname, phone_number_list);
    }

    public List<String> get(String surname){
        return catalog.get(surname);
    }


}
