package com.kenzie.appserver.service.model;

import java.util.Objects;

public class Location {
    private String originZipcode;
    private String destinationZipcode;

    public String getOriginZipcode() {
        return originZipcode;
    }

    public void setOriginZipcode(String originZipcode) {
        this.originZipcode = originZipcode;
    }

    public String getDestinationZipcode() {
        return destinationZipcode;
    }

    public void setDestinationZipcode(String destinationZipcode) {
        this.destinationZipcode = destinationZipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return originZipcode.equals(location.originZipcode) && destinationZipcode.equals(location.destinationZipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(originZipcode, destinationZipcode);
    }
}
