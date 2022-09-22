package com.kenzie.appserver.service.model;

import java.util.Objects;

public class OriginZip {
    private String originZipcode;

    public String getOriginZipcode() {
        return originZipcode;
    }

    public void setOriginZipcode(String originZipcode) {
        this.originZipcode = originZipcode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OriginZip location = (OriginZip) o;
        return originZipcode.equals(location.originZipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(originZipcode);
    }
}
