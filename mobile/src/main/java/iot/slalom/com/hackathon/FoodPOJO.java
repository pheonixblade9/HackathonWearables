package iot.slalom.com.hackathon;

import java.util.List;

/**
 * Created by fernandog on 3/6/2015.
 */
public class FoodPOJO {


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    private String label;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    private List<String> options;
}

