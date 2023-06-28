package com.example.cardiacrecord;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserRVAdapter extends RecyclerView.Adapter<UserRVAdapter.ViewHolder> {
    private ArrayList<UserRVModal> userRVModalArrayList;
    private Context context;
    private UserClickInterface userClickInterface;
    int lastPos = -1;

    public UserRVAdapter(ArrayList<UserRVModal> userRVModalArrayList, Context context, UserClickInterface userClickInterface) {
        this.userRVModalArrayList = userRVModalArrayList;
        this.context = context;
        this.userClickInterface = userClickInterface;
    }

    @NonNull
    @Override
    public UserRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserRVAdapter.ViewHolder holder, int position) {
        UserRVModal userRVModal = userRVModalArrayList.get(position);
        holder.userNameTV.setText("Name: " + userRVModal.getUserName());
        holder.heartTV.setText("Heart Rate: " + userRVModal.getUserheart() + " (bpm)");
        holder.diostolicTV.setText(userRVModal.getUserdio() + " mm(Hg)");
        holder.systolicTV.setText(userRVModal.getUsersys() + " mm (Hg)");
        holder.time.setText("Time: " + userRVModal.getUsertime());
        holder.date.setText("Date: " + userRVModal.getUserdate());
        holder.cmnt.setText("Comment: " + userRVModal.getUserDesc());

        setAnimation(holder.itemView, position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int clickedPosition = holder.getAdapterPosition();
                if (clickedPosition != RecyclerView.NO_POSITION) {
                    userClickInterface.onUserClick(clickedPosition);
                }
            }
        });
    }

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

    public void addItem(UserRVModal item) {
        if (userRVModalArrayList == null) {
            userRVModalArrayList = new ArrayList<>();
        }
        userRVModalArrayList.add(item);
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        if (userRVModalArrayList != null && position >= 0 && position < userRVModalArrayList.size()) {
            userRVModalArrayList.remove(position);
            notifyDataSetChanged();
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView userNameTV, cmnt, systolicTV, diostolicTV, heartTV, time, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userNameTV = itemView.findViewById(R.id.cardName);
            systolicTV = itemView.findViewById(R.id.cardSystolicPressure);
            diostolicTV = itemView.findViewById(R.id.cardDiastolicPressure);
            heartTV = itemView.findViewById(R.id.cardHeartRate);
            cmnt = itemView.findViewById(R.id.cardComment);
            date = itemView.findViewById(R.id.textDate);
            time = itemView.findViewById(R.id.textTime);
        }
    }

    public interface UserClickInterface {
        void onUserClick(int position);
    }
}
