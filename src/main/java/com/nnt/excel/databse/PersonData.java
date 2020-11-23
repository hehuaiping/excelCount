package com.nnt.excel.databse;

import com.nnt.excel.model.Person;
import lombok.Data;

import java.util.List;

/**
 * @author soulmate
 */
@Data
public class PersonData {
    private List<Person> personList;
}
