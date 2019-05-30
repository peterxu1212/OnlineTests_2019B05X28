package com.acquisio.basic.java.question04;


import java.util.ArrayList;
import java.util.List;

class Inventory<ItemType extends Item> {
	
    private List<ItemType> items = new ArrayList<ItemType>();


    public void add(ItemType item) {
        items.add(item);
    }

    public ItemType getFirst() {
	
		if (items.size() > 0) {
            return items.get(0);
        }
        return null;
    }

    public ItemType getLast() {
        int size = items.size();
        if (size > 0) {
            return items.get(size - 1);
        }
        return null;
    }

    public boolean remove(ItemType item) {
        return items.remove(item);
    }

    public ItemType findFirst(String name) {		

		for (ItemType item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;

    }
}
