package org.example.entities;


import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Data
public class Item implements IItem {

    int id;
    int storagePeriod;
    int deliveryVolume;
    int salesVolume;
    float price;
    String name;
    String packageType;
    Date deliveryDate;

    /**
     * Represents an object into JSON
     */
    @Override
    public void toJson() {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapFromItem();

        try {
            mapper.writeValue(Paths.get("data/"+ id + ".json").toFile(), map);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private Map<String, Object> mapFromItem() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("storagePeriod", storagePeriod);
        map.put("deliveryVolume", deliveryVolume);
        map.put("salesVolume", salesVolume);
        map.put("price", price);
        map.put("name", name);
        map.put("packageType", packageType);
        map.put("deliveryDate", deliveryDate);
        return map;
    }


    @Override
    public boolean isExpired() {
        return false;
    }
}
