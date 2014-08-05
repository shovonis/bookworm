package net.therap.domain;

import javax.persistence.*;

/**
 * @author rifatul.islam
 * @since 8/4/14.
 */

@Entity
@Table(name = "area")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "area_code")
    private int areaCode;

    @Column(name = "area_name")
    private String areaName;


    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Override
    public String toString() {
        return "Area{" +
                "areaCode=" + areaCode +
                ", areaName='" + areaName + '\'' +
                '}';
    }
}
