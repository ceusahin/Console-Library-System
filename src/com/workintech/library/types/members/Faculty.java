package com.workintech.library.types.members;

import com.workintech.library.entities.Member;

public class Faculty extends Member {
    public Faculty(long id, String name, int MAX_BOOKS){
        super(id, name, 5);
    }
}
