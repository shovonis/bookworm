package net.therap.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author rifatul.islam
 * @since 8/4/14.
 */

@Entity
@Table(name = "area")
public class Area implements Serializable {
    public static final int DEFAULT_AREA_CODE = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "area_code")
    private int areaCode;

    @Column(name = "area_name")
    private String areaName;

    @OneToMany(mappedBy = "area", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> user;

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

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Area{" +
                "areaCode=" + areaCode +
                ", areaName='" + areaName + '\'' +
                '}';
    }
}
