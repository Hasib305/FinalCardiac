/**
 * This class contains unit tests for the MeasurementData class.
 */
package com.example.cardiacrecord;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MeasurementDataTest {
    /**
     * Creates a mock MeasurementData object with a single measurement.
     *
     * @return The mock MeasurementData object.
     */
    private MeasurementData mockList() {
        MeasurementData dataList = new MeasurementData();
        dataList.add(mockMeasure());
        return dataList;
    }

    /**
     * Creates a mock UserRVModal object representing a measurement.
     *
     * @return The mock UserRVModal object.
     */
    private UserRVModal mockMeasure() {
        return new UserRVModal(
                "Jane Smith",
                "Test description 2",
                "130",
                "90",
                "75",
                "456",
                "2023-06-28",
                "10:00 AM"
        );
    }

    /**
     * Tests the add() method of MeasurementData.
     */
    @Test
    public void testAdd() {
        MeasurementData dataList = mockList();
        assertEquals(1, dataList.getMeasure().size());

        UserRVModal m = new UserRVModal(
                "Jane Smith",
                "Test description 2",
                "130",
                "90",
                "75",
                "456",
                "2023-06-28",
                "10:00 AM"
        );
        dataList.add(m);

        assertEquals(2, dataList.getMeasure().size());
        assertTrue(dataList.getMeasure().contains(m));
    }

    /**
     * Tests the getMeasure() method of MeasurementData.
     */
    @Test
    public void testGetMeasure() {
        MeasurementData dataList = mockList();
        assertEquals(0, mockMeasure().compareTo(dataList.getMeasure().get(0)));

        UserRVModal measure = new UserRVModal(
                "Jane Smith",
                "Test description 2",
                "130",
                "90",
                "75",
                "456",
                "2023-06-28",
                "10:00 AM"
        );
        dataList.add(measure);

        assertEquals(0, measure.compareTo(dataList.getMeasure().get(1)));
        assertEquals(0, mockMeasure().compareTo(dataList.getMeasure().get(0)));
    }

    /**
     * Tests the delete() method of MeasurementData.
     */
    @Test
    public void testDelete() {
        MeasurementData mList = mockList();
        UserRVModal measure = new UserRVModal(
                "Jane Smith",
                "Test description 2",
                "130",
                "90",
                "75",
                "456",
                "2023-06-28",
                "10:00 AM"
        );
        mList.add(measure);
        assertTrue(mList.getMeasure().contains(measure));
        mList.delete(measure);
        assertFalse(mList.getMeasure().contains(measure));
    }

    /**
     * Tests the delete() method of MeasurementData when deleting a non-existent measurement.
     */
    @Test
    public void testDeleteException() {
        MeasurementData mList = mockList();
        UserRVModal measure = new UserRVModal(
                "Jane Smith",
                "Test description 2",
                "130",
                "90",
                "75",
                "456",
                "2023-06-28",
                "10:00 AM"
        );
        assertThrows(IllegalArgumentException.class, () -> {
            mList.delete(measure);
        });
    }

    /**
     * Tests the edit() method of MeasurementData.
     */
    @Test
    public void testEdit() {
        MeasurementData dataList = mockList();
        UserRVModal measure = new UserRVModal(
                "Jane Smith",
                "Test description 2",
                "130",
                "90",
                "75",
                "456",
                "2023-06-28",
                "10:00 AM"
        );
        dataList.add(measure);
        assertTrue(dataList.getMeasure().contains(measure));
        UserRVModal another = new UserRVModal(
                "Jane ",
                "Test description 5",
                "120",
                "60",
                "75",
                "456",
                "2023-06-28",
                "10:00 AM"
        );
        dataList.edit(1, another);
        assertFalse(dataList.getMeasure().contains(measure));
        assertTrue(dataList.getMeasure().contains(another));
    }

    /**
     * Tests the count() method of MeasurementData.
     */
    @Test
    public void testCount() {
        MeasurementData dataList = mockList();
        assertEquals(1, dataList.count());

        UserRVModal measure = new UserRVModal(
                "Jane Smith",
                "Test description 2",
                "130",
                "90",
                "75",
                "456",
                "2023-06-28",
                "10:00 AM"
        );
        dataList.add(measure);

        assertEquals(2, dataList.count());
    }
}
