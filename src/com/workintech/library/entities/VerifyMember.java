package com.workintech.library.entities;

import java.util.Set;

public class VerifyMember {
    Set<Member> members;

    public VerifyMember(Set<Member> members) {
        this.members = members;
    }

    public Member verifyById(long id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        System.out.println("No member found with this ID.");
        return null;
    }

    public boolean verifyIdAndPassword(long id, String password) {
        Member member = verifyById(id);
        if (member != null && member.getPassword().equals(password)) {
            return true;
        } else {
            System.out.println("Invalid ID or password.");
            return false;
        }
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void displayMembers() {
        if (members.isEmpty()) {
            System.out.println("No registered members.");
            return;
        }

        System.out.println("Registered Members:");
        for (Member member : members) {
            System.out.println("ID: " + member.getId() + ", Name: " + member.getName() + ", Type: " + member.getClass().getSimpleName());
        }
    }
}
