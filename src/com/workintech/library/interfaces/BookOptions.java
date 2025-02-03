package com.workintech.library.interfaces;

import com.workintech.library.models.Author;
import com.workintech.library.models.Member;

public interface BookOptions {
    void borrowItem(Member user);
    void returnItem();
}
