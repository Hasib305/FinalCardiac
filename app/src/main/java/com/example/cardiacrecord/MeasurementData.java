package com.example.cardiacrecord;



import java.util.ArrayList;
import java.util.List;

public class MeasurementData {
    List<UserRVModal> mList=new ArrayList<>();


    public void add(UserRVModal measure)
    {
        if(mList.contains(measure))
        {
            throw new IllegalArgumentException();
        }
        mList.add(measure);
    }

    /**
     * This deletes a measure from the list
     * @param measurement
     *      This is the measure to delete
     */

    public void delete(UserRVModal measurement)
    {
        if(mList.contains(measurement))
        {
            mList.remove(measurement);
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This is edits a measure in given position
     * @param pos
     *      the position where we will edit
     * @param measurement
     *      the measure which will update the values
     */

    public void edit(int pos, UserRVModal measurement)
    {
        mList.set(pos,measurement);
    }

    /**
     * This returns the list
     * @return
     *      return the list
     */

    public int count() {
        return mList.size();
    }

    public List<UserRVModal>getMeasure()
    {
        return mList;
    }
}
