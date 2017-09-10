package org.parami.ygds.entity;

import javax.persistence.*;

@Entity
@Table(name = "error_log", schema = "ygds", catalog = "")
public class ErrorLogEntity {
    private int errorLogId;
    private String errorTxt;
    private String rightTxt;

    @Id
    @Column(name = "error_log_id")
    public int getErrorLogId() {
        return errorLogId;
    }

    public void setErrorLogId(int errorLogId) {
        this.errorLogId = errorLogId;
    }

    @Basic
    @Column(name = "error_txt")
    public String getErrorTxt() {
        return errorTxt;
    }

    public void setErrorTxt(String errorTxt) {
        this.errorTxt = errorTxt;
    }

    @Basic
    @Column(name = "right_txt")
    public String getRightTxt() {
        return rightTxt;
    }

    public void setRightTxt(String rightTxt) {
        this.rightTxt = rightTxt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ErrorLogEntity that = (ErrorLogEntity) o;

        if (errorLogId != that.errorLogId) return false;
        if (errorTxt != null ? !errorTxt.equals(that.errorTxt) : that.errorTxt != null) return false;
        if (rightTxt != null ? !rightTxt.equals(that.rightTxt) : that.rightTxt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = errorLogId;
        result = 31 * result + (errorTxt != null ? errorTxt.hashCode() : 0);
        result = 31 * result + (rightTxt != null ? rightTxt.hashCode() : 0);
        return result;
    }
}
