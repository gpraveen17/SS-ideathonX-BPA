package org.statestreet.beans;

public class DataExtract {

    private int id;
    private int processId;
    private String columnData;
    private String valueData;

    public DataExtract(Builder builder) {
        this.id = builder.id;
        this.processId = builder.processId;
        this.columnData = builder.columnData;
        this.valueData = builder.valueData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public String getColumnData() {
        return columnData;
    }

    public void setColumnData(String columnData) {
        this.columnData = columnData;
    }

    public String getValueData() {
        return valueData;
    }

    public void setValueData(String valueData) {
        this.valueData = valueData;
    }

    @Override
    public String toString() {
        return "DataExtract{" +
                "id=" + id +
                ", processId=" + processId +
                ", columnData='" + columnData + '\'' +
                ", valueData='" + valueData + '\'' +
                '}';
    }

    public static final class Builder {
        private int id;
        private int processId;
        private String columnData;
        private String valueData;

        public Builder() {

        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder processId(int processId) {
            this.processId = processId;
            return this;
        }

        public Builder columnData(String columnData) {
            this.columnData = columnData;
            return this;
        }

        public Builder valueData(String valueData) {
            this.valueData = valueData;
            return this;
        }

        public DataExtract build(){
            return new DataExtract(this);
        }
    }
}
