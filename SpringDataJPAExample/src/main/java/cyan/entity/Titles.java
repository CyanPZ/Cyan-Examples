package cyan.entity;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by CPZ on 2017/7/2.
 */
@Entity
@Table(name="titles")

public class Titles {

    @Id
    private Integer empNo;

    private String title;
    private Date fromDate;

    private Date toDate;

    @Override
    public String toString() {
        return "Titles{" +
                "title='" + title + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }
}
