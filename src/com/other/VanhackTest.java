package com.other;

import java.util.*;

public class VanhackTest {
    public static boolean schedulable(
            HashMap<String, ArrayList<String>> requests
    ) {
        String[] days = {"mon", "tue", "wed", "thu", "fri", "sat", "sun"};
        List<Map.Entry<String, ArrayList<String>>> list = new LinkedList<>(requests.entrySet());
        List<List<String>> resList = new ArrayList<>();

        list.sort((a, b) -> b.getValue().size() - a.getValue().size());
        Map<String, Set<String>> sortedMap = new LinkedHashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        for (Map.Entry<String, ArrayList<String>> entry : list) {
            sortedMap.put(entry.getKey(), new HashSet<>(entry.getValue()));
            countMap.put(entry.getKey(), 0);
        }
        for (int i = 0; i < 7; i++) {
            resList.add(new ArrayList<>());
            String day = days[i];
            int dayCount = 0;
            for (Map.Entry<String, Set<String>> entry : sortedMap.entrySet()) {
                if (!entry.getValue().contains(day) && countMap.get(entry.getKey()) < 5) {
                    dayCount++;
                    countMap.put(entry.getKey(), countMap.get(entry.getKey()) + 1);
                    resList.get(i).add(entry.getKey());
                    if (dayCount == 2)
                        break;
                }
            }
            if (dayCount < 2) return false;
        }

        resList.forEach(res -> System.out.println(Arrays.toString(res.toArray())));
        return true;
    }

    private Map<String, Set<String>> getSortedMap(HashMap<String, ArrayList<String>> requests) {
        List<Map.Entry<String, ArrayList<String>>> list = new LinkedList<>(requests.entrySet());

        list.sort((a, b) -> b.getValue().size() - a.getValue().size());
        Map<String, Set<String>> sortedMap = new LinkedHashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        for (Map.Entry<String, ArrayList<String>> entry : list) {
            sortedMap.put(entry.getKey(), new HashSet<>(entry.getValue()));
            countMap.put(entry.getKey(), 0);
        }
        return sortedMap;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> requests = new HashMap<>();
        requests.put(
                "ada", new ArrayList<>(Arrays.asList(
                        new String[]{"mon", "tue", "wed", "thu", "fri", "sat"}
                ))
        );
        requests.put(
                "emma", new ArrayList<>(Arrays.asList(
                        new String[]{"tue", "wed", "thu", "sun"}
                ))
        );
        requests.put(
                "remy", new ArrayList<>(Arrays.asList(
                        new String[]{"mon", "fri", "sun"}
                ))
        );
        requests.put(
                "zach", new ArrayList<>(Arrays.asList(new String[]{}))
        );

        System.out.println(schedulable(requests));
    }
}
