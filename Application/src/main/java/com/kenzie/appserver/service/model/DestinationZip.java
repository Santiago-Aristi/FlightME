package com.kenzie.appserver.service.model;

import java.util.Objects;

public class DestinationZip {
    public String destinationZipcode;

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
        DestinationZip that = (DestinationZip) o;
        return destinationZipcode.equals(that.destinationZipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinationZipcode);
    }
}
