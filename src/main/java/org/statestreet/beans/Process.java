package org.statestreet.beans;

public class Process {
     private int id;
     private String processName;

     public Process(Builder builder){
         id = builder.id;
         processName = builder.processName;
     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    @Override
    public String toString() {
        return "Process{" +
                "id=" + id +
                ", processName='" + processName + '\'' +
                '}';
    }

    public static final class Builder{
        private int id;
        private String processName;

        public Builder(){

        }

        public Builder id(int id){
            this.id=id;
            return this;
        }

        public Builder processName(String processName){
            this.processName=processName;
            return this;
        }

        public Process build(){
            return new Process(this);
        }
    }

}
