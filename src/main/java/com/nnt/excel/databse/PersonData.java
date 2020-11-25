package com.nnt.excel.databse;

import com.nnt.excel.model.Person;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author soulmate
 */
@Data
public class PersonData {
    /**
     *  人员数据
     */
    public static final List<Person> personList = new ArrayList<>(3600);

    public static void clean() {
        personList.clear();
    }
}
