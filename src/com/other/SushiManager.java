package com.other;

import java.util.*;


class SushiOrderManager {
    private int currentSeat;
    private int prevSeat;
    private int totalSeats;
    private ArrayList<Queue<SushiItem>> seats;

    public SushiOrderManager() {
        currentSeat = 0;
        totalSeats = 16;
        seats = new ArrayList<>();

        for (int i = 0; i < totalSeats; i++) {
            seats.add(new LinkedList<SushiItem>());
        }
    }

    public void addOrder(ArrayList<SushiOrder> request) {
        for (SushiOrder order : request) {
            for (String roll : order.getMenuItemIds()) {
                seats.get(order.getSeatId() - 1).offer(
                        new SushiItem(order.getSeatId(), roll)
                );
            }
        }
    }

    public SushiItem nextItem() {
        int start = currentSeat;
        boolean roundFinished = false;
        do {
            SushiItem item = seats.get(currentSeat).poll();
            System.out.println(currentSeat + " " + item);

            ++currentSeat;

            if (currentSeat >= 16 && !roundFinished) {
                roundFinished = true;
                currentSeat = prevSeat;
                System.out.println("Setting prevSeat Id" + prevSeat);
            } else if (roundFinished) {
                currentSeat = 0;
                roundFinished = false;
            }
            if (item != null) {
                System.out.println(">>>>>>" + item.getSeatId() + "round" + roundFinished + " Cuurent" + currentSeat);
                prevSeat = item.getSeatId();
                return item;
            }
        } while (currentSeat != start || roundFinished);

        return null;
    }

    public static void main(String[] args) {
        SushiOrderManager manager = new SushiOrderManager();

        ArrayList<SushiOrder> request = new ArrayList<>(
                Arrays.asList(
                        new SushiOrder(13,
                                new ArrayList<>(Arrays.asList(
                                        new String[]{"rainbow", "\"tuna\""}
                                ))
                        )
                )
        );

        manager.addOrder(request);

        manager.nextItem();

        request = new ArrayList<>(
                Arrays.asList(
                        new SushiOrder(1,
                                new ArrayList<>(Arrays.asList(
                                        new String[]{"cucumber"}
                                ))
                        )
                )
        );

        manager.addOrder(request);

        manager.nextItem();
        manager.nextItem();
    }
}


class SushiItem {
    int seatId;
    String menuItemId;

    public SushiItem(int seatId, String menuItemId) {
        this.seatId = seatId;
        this.menuItemId = menuItemId;
    }

    public int getSeatId() {
        return seatId;
    }

    public String getMenuItemId() {
        return menuItemId;
    }
}

class SushiOrder {
    int seatId;
    List<String> menuItemIds;

    public SushiOrder(int seatId, List<String> menuItemIds) {
        this.seatId = seatId;
        this.menuItemIds = menuItemIds;
    }

    public int getSeatId() {
        return seatId;
    }

    public List<String> getMenuItemIds() {
        return menuItemIds;
    }
}