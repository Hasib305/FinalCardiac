package com.example.cardiacrecord;

import java.util.ArrayList;
import java.util.List;

/**
 * The MeasurementData class represents a collection of UserRVModal measurements.
 * It provides methods to add, delete, edit, and retrieve measurements.
 */
public class MeasurementData {
    private List<UserRVModal> mList = new ArrayList<>();

    /**
     * Adds a UserRVModal measurement to the collection.
     *
     * @param measure The UserRVModal measurement to add.
     * @throws IllegalArgumentException if the measurement already exists in the collection.
     */
    public void add(UserRVModal measure) {
        if (mList.contains(measure)) {
            throw new IllegalArgumentException("Measurement already exists");
        }
        mList.add(measure);
    }

    /**
     * Deletes a UserRVModal measurement from the collection.
     *
     * @param measurement The UserRVModal measurement to delete.
     * @throws IllegalArgumentException if the measurement does not exist in the collection.
     */
    public void delete(UserRVModal measurement) {
        if (mList.contains(measurement)) {
            mList.remove(measurement);
        } else {
            throw new IllegalArgumentException("Measurement does not exist");
        }
    }

    /**
     * Edits a UserRVModal measurement in the collection at the specified position.
     *
     * @param pos         The position of the measurement to edit.
     * @param measurement The updated UserRVModal measurement.
     */
    public void edit(int pos, UserRVModal measurement) {
        mList.set(pos, measurement);
    }

    /**
     * Returns the count of measurements in the collection.
     *
     * @return The count of measurements.
     */
    public int count() {
        return mList.size();
    }

    /**
     * Retrieves all the UserRVModal measurements in the collection.
     *
     * @return A List of UserRVModal measurements.
     */
    public List<UserRVModal> getMeasure() {
        return mList;
    }
}
