package com.leetcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UniqueEmailAddress {
    public int numUniqueEmails(String[] emails) {
        Set<Email> set = new HashSet<>();
        for (String email : emails) {
            Email cur = getEmail(email);
            set.add(cur);
        }
        return set.size();
    }

    private Email getEmail(String email) {
        String[] strArr = email.split("@");
        Email obj = new Email(modify(strArr[0]), strArr[1]);
        return obj;
    }

    private String modify(String str) {
        StringBuilder modified = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '+') break;
            else if (c == '.') continue;
            else modified.append(c);
        }
        return modified.toString();
    }

    class Email {
        String local, domain;

        Email(String local, String domain) {
            this.local = local;
            this.domain = domain;
        }

        @Override
        public boolean equals(Object other) {
            Email other_obj = (Email) other;
            return other_obj.local.equals(this.local) && other_obj.domain.equals(this.domain);
        }

        @Override
        public int hashCode() {
            return Objects.hash(local, domain);
        }
    }
}
