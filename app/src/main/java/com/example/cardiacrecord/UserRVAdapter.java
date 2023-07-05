package com.example.cardiacrecord;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * The UserRVAdapter class is a RecyclerView adapter that is responsible for binding user data to the RecyclerView items.
 */
public class UserRVAdapter extends RecyclerView.Adapter<UserRVAdapter.ViewHolder> {
    private ArrayList<UserRVModal> userRVModalArrayList;
    private Context context;
    private UserClickInterface userClickInterface;
    int lastPos = -1;

    /**
     * Constructs a UserRVAdapter instance with the provided data.
     *
     * @param userRVModalArrayList The list of UserRVModal objects representing user data.
     * @param context              The context of the adapter.
     * @param userClickInterface   The interface to handle user item click events.
     */
    public UserRVAdapter(ArrayList<UserRVModal> userRVModalArrayList, Context context, UserClickInterface userClickInterface) {
        this.userRVModalArrayList = userRVModalArrayList;
        this.context = context;
        this.userClickInterface = userClickInterface;
    }

    @NonNull
    @Override
    public UserRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the user_rv_item layout and create a ViewHolder
        View view = LayoutInflater.from(context).inflate(R.layout.user_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserRVAdapter.ViewHolder holder, int position) {

        UserRVModal userRVModal = userRVModalArrayList.get(position);
        holder.userNameTV.setText("Name: " + userRVModal.getUserName());


        int heartRate = Integer.parseInt(userRVModal.getUserheart());
        if (heartRate < 60 || heartRate > 100) {
            holder.heartTV.setTextColor(Color.RED);
        } else {
            holder.heartTV.setTextColor(Color.WHITE);
        }
        holder.heartTV.setText("Heart Rate: " + heartRate + " (bpm)");


        int diastolicPressure = Integer.parseInt(userRVModal.getUserdio());
        if (diastolicPressure < 60 || diastolicPressure > 90) {
            holder.diostolicTV.setTextColor(Color.RED);
        } else {
            holder.diostolicTV.setTextColor(Color.WHITE);
        }
        holder.diostolicTV.setText(diastolicPressure + " mm(Hg)");


        int systolicPressure = Integer.parseInt(userRVModal.getUsersys());
        if (systolicPressure < 90 || systolicPressure > 140) {
            holder.systolicTV.setTextColor(Color.RED);
        } else {
            holder.systolicTV.setTextColor(Color.WHITE);
        }
        holder.systolicTV.setText(systolicPressure + " mm (Hg)");

        holder.time.setText("Time: " + userRVModal.getUsertime());
        holder.date.setText("Date: " + userRVModal.getUserdate());
        holder.cmnt.setText("Comment: " + userRVModal.getUserDesc());

        setAnimation(holder.itemView, position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle user item click event
                int clickedPosition = holder.getAdapterPosition();
                if (clickedPosition != RecyclerView.NO_POSITION) {
                    userClickInterface.onUserClick(clickedPosition);
                }
            }
        });
    }

    /**
     * Sets an animation for the item view at the specified position.
     *
     * @param itemView The item view to animate.
     * @param position The position of the item view in the RecyclerView.
     */
    private void setAnimation(View itemView, int position) {
        if (position > lastPos) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            itemView.setAnimation(animation);
            lastPos = position;
        }
    }

    @Override
    public int getItemCount() {
        if (userRVModalArrayList != null) {
            return userRVModalArrayList.size();
        } else {
            return 0;
        }
    }

    /**
     * Adds a new item to the adapter.
     *
     * @param item The UserRVModal object representing the new item.
     */
    public void addItem(UserRVModal item) {
        if (userRVModalArrayList == null) {
            userRVModalArrayList = new ArrayList<>();
        }
        userRVModalArrayList.add(item);
        notifyDataSetChanged();
    }

    /**
     * Deletes an item at the specified position from the adapter.
     *
     * @param position The position of the item to delete.
     */
    public void deleteItem(int position) {
        if (userRVModalArrayList != null && position >= 0 && position < userRVModalArrayList.size()) {
            userRVModalArrayList.remove(position);
            notifyDataSetChanged();
        }
    }

    /**
     * The ViewHolder class represents an item view in the RecyclerView.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView userNameTV, cmnt, systolicTV, diostolicTV, heartTV, time, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize the views in the ViewHolder
            userNameTV = itemView.findViewById(R.id.cardName);
            systolicTV = itemView.findViewById(R.id.cardSystolicPressure);
            diostolicTV = itemView.findViewById(R.id.cardDiastolicPressure);
            heartTV = itemView.findViewById(R.id.cardHeartRate);
            cmnt = itemView.findViewById(R.id.cardComment);
            date = itemView.findViewById(R.id.textDate);
            time = itemView.findViewById(R.id.textTime);
        }
    }

    /**
     * The UserClickInterface is an interface to handle user item click events in the RecyclerView.
     */
    public interface UserClickInterface {
        /**
         * Called when a user item is clicked.
         *
         * @param position The position of the clicked item in the RecyclerView.
         */
        void onUserClick(int position);
    }
}
