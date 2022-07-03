package org.example.entities;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@Data
public class Item implements IItem {

    int id;
    int storagePeriod;
    int deliveryVolume;
    int salesVolume;
    float price;
    String name;
    String packageType;
    Calendar deliveryDate;
    Calendar manufactureDate;


    /**
     * Represents an object into JSON
     */
    @Override
    public void toJson() {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapFromFields();

        try {
            mapper.writeValue(Paths.get("data/"+ id + ".json").toFile(), map);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private Map<String, Object> mapFromFields() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("storagePeriod", storagePeriod);
        map.put("deliveryVolume", deliveryVolume);
        map.put("salesVolume", salesVolume);
        map.put("price", price);
        map.put("name", name);
        map.put("packageType", packageType);
        map.put("deliveryDate", deliveryDate);
        map.put("manufactureDate", manufactureDate);
        return map;
    }


    @Override
    public boolean isExpired() {
        Calendar nowDate = new GregorianCalendar();

        int diffInDays = getDiffInDays(nowDate);

        return diffInDays > storagePeriod;
    }

    private int getDiffInDays(Calendar nowDate) {
        long diffDate = nowDate.getTime().getTime() - manufactureDate.getTime().getTime();
        return Integer.parseInt(String.valueOf(TimeUnit.DAYS.convert(diffDate, TimeUnit.MILLISECONDS)));
    }
}
