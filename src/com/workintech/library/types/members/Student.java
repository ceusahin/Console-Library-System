package com.workintech.library.types.members;

import com.workintech.library.entities.Member;

public class Student extends Member {

    public Student(long id, String name, int MAX_BOOKS) {
        super(id, name, 5);
    }
}
