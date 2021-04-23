package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReorderDataInLogFiles {
    // I solved it myself, See other solution below too, separating letter log and digit log is more efficient because sorting involves only letter log. where as in second solution, entire log needs to be sorted
    public String[] reorderLogFiles(String[] logs) {
        List<Log> digitLogs = new ArrayList<>();
        List<Log> letterLogs = new ArrayList<>();
        for (String log : logs) {
            int index = log.indexOf(" ");
            String identifier = log.substring(0, index);
            String rest = log.substring(index + 1);
            Log l = new Log(identifier, rest, log);
            if (isLetterLog(l))
                letterLogs.add(l);
            else
                digitLogs.add(l);
        }

        Collections.sort(letterLogs);

        String[] res = new String[logs.length];
        int i = 0;
        while (i < letterLogs.size()) {
            res[i] = letterLogs.get(i).original;
            i++;
        }
        int j = 0;
        while (j < digitLogs.size()) {
            res[i] = digitLogs.get(j).original;
            i++;
            j++;
        }
        return res;
    }

    private boolean isLetterLog(Log log) {
        for (char c : log.rest.toCharArray()) {
            if (Character.isDigit(c))
                return false;
        }
        return true;
    }

    class Log implements Comparable<Log> {
        String identifier;
        String rest;
        String original;

        Log(String identifier, String rest, String original) {
            this.identifier = identifier;
            this.rest = rest;
            this.original = original;
        }

        @Override
        public int compareTo(Log other) {
            if (this.rest.equals(other.rest)) {
                return this.identifier.compareTo(other.identifier);
            }
            return this.rest.compareTo(other.rest);
        }
    }

    public String[] reorderLogFilesII(String[] logs) {
        List<LogII> logList = new ArrayList<>();
        for (String log : logs) {
            logList.add(getLog(log));
        }

        Collections.sort(logList);

        String[] res = new String[logs.length];
        int i = 0;
        while (i < logList.size()) {
            res[i] = logList.get(i).original;
            i++;
        }
        return res;
    }

    private boolean isLetterLog(String rest) {
        for (char c : rest.toCharArray()) {
            if (Character.isDigit(c))
                return false;
        }
        return true;
    }

    private LogII getLog(String log) {
        int index = log.indexOf(" ");
        String identifier = log.substring(0, index);
        String rest = log.substring(index + 1);
        boolean isLetterLog = isLetterLog(rest);
        LogII l = new LogII(identifier, rest, log, isLetterLog);
        return l;
    }

    class LogII implements Comparable<LogII> {
        String identifier;
        String rest;
        String original;
        boolean isLetterLog;

        LogII(String identifier, String rest, String original, boolean isLetterLog) {
            this.identifier = identifier;
            this.rest = rest;
            this.original = original;
            this.isLetterLog = isLetterLog;
        }

        @Override
        public int compareTo(LogII other) {
            if (this.isLetterLog && other.isLetterLog) {
                if (this.rest.equals(other.rest)) {
                    return this.identifier.compareTo(other.identifier);
                }
                return this.rest.compareTo(other.rest);
            }
            //LetterLog should come first, so current object can be considered as smaller
            if (this.isLetterLog && !other.isLetterLog)
                return -1;
            else if (!this.isLetterLog && other.isLetterLog)
                return 1;
                // both are digit logs. maintain order
            else
                return 0;
        }
    }
}
