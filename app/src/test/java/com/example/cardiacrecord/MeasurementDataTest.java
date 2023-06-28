package com.example.cardiacrecord;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MeasurementDataTest {
    private MeasurementData mockList() {
        MeasurementData DataList = new MeasurementData();
        DataList.add(mockMeasure());
        return DataList;
    }

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

    @Test
    public void testAdd() {
        MeasurementData DataList = mockList();
        assertEquals(1, DataList.getMeasure().size());

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
        DataList.add(m);

        assertEquals(2, DataList.getMeasure().size());
        assertTrue(DataList.getMeasure().contains(m));
    }

    @Test
    public void testGetMeasure() {
        MeasurementData DataList = mockList();
        assertEquals(0, mockMeasure().compareTo(DataList.getMeasure().get(0)));

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
        DataList.add(measure);

        assertEquals(0, measure.compareTo(DataList.getMeasure().get(1)));
        assertEquals(0, mockMeasure().compareTo(DataList.getMeasure().get(0)));
    }

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

    @Test
    public void testEdit() {
        MeasurementData DataList = mockList();
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
        DataList.add(measure);
        assertTrue(DataList.getMeasure().contains(measure));
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
        DataList.edit(1, another);
        assertFalse(DataList.getMeasure().contains(measure));
        assertTrue(DataList.getMeasure().contains(another));
    }

    @Test
    public void testCount() {
        MeasurementData DataList = mockList();
        assertEquals(1, DataList.count());

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
        DataList.add(measure);

        assertEquals(2, DataList.count());
    }
}
