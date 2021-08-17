package com.login.helper;

public class HelperUserDetail {
    private String label;
    private String data;

    public HelperUserDetail()
    {
       setLabel("No Label");
       setData("No Date");
    }

    public HelperUserDetail(String label, String data)
    {
        setLabel(label);
        setData(data);
    }
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
