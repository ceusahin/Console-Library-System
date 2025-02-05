package com.workintech.library.interfaces;

import com.workintech.library.entities.Member;

public interface BookOptions {
    void borrowBook(Member user);
    void returnBook();
}
