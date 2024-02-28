package fit.Entity;

import java.time.LocalDate;

public class Tests {
    private LocalDate date;
    private String result;
    private String testid;
    private String testtype;
    private Double cost;

    public LocalDate getDate() {
        return date;
    }

    public String getResult() {
        return result;
    }

    public String getTestid() {
        return testid;
    }

    public String getTesttype() {
        return testtype;
    }

    public Double getCost() {
        return cost;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setTestid(String testid) {
        this.testid = testid;
    }

    public void setTesttype(String testtype) {
        this.testtype = testtype;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Tests(LocalDate date, String result, String testid, String testtype, Double cost) {
        this.date = date;
        this.result = result;
        this.testid = testid;
        this.testtype = testtype;
        this.cost = cost;
    }

    public Tests() {
    }


    @Override
    public String toString() {
        return "Tests{" +
                "date=" + date +
                ", result='" + result + '\'' +
                ", testid='" + testid + '\'' +
                ", testtype='" + testtype + '\'' +
                ", cost=" + cost +
                '}';
    }

}
