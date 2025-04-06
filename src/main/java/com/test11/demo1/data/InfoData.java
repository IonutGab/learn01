package com.test11.demo1.data;

public class InfoData {
    private String first;
    private String name;
    private String another;
    public InfoData(){};

    public InfoData(String first, String name, String another) {
        this.first = first;
        this.name = name;
        this.another = another;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnother() {
        return another;
    }

    public void setAnother(String another) {
        this.another = another;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InfoData{");
        sb.append("first='").append(first).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", another='").append(another).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
