package com.example.rcvm.models;
import java.util.List;

public class ResponseModal {
    List<DataModel> data;

    public ResponseModal(List<DataModel> data) {
        this.data = data;
    }

    public List<DataModel> getData() {
        return data;
    }

    public void setData(List<DataModel> data) {
        this.data = data;
    }
}
