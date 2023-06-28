package com.example.cardiacrecord;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements UserRVAdapter.UserClickInterface {

    private FloatingActionButton addUserFAB;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private RecyclerView userRV;
    private FirebaseAuth mAuth;
    private ProgressBar loadingPB;
    private ArrayList<UserRVModal> userRVModalArrayList;
    private UserRVAdapter userRVAdapter;
    private RelativeLayout homeRl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userRV = findViewById(R.id.idRVUser);

        loadingPB = findViewById(R.id.idPBLoading);
        addUserFAB = findViewById(R.id.idFABAddUser);
        firebaseDatabase = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        userRVModalArrayList = new ArrayList<>();
        databaseReference = firebaseDatabase.getReference("Users");

        addUserFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EditUserActivity.class);
                startActivity(i);
            }
        });

        userRVAdapter = new UserRVAdapter(userRVModalArrayList, this, this);
        userRV.setLayoutManager(new LinearLayoutManager(this));
        userRV.setAdapter(userRVAdapter);

        getUsers();
    }

    private void getUsers() {
        userRVModalArrayList.clear();
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                loadingPB.setVisibility(View.GONE);
                userRVModalArrayList.add(snapshot.getValue(UserRVModal.class));
                userRVAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                loadingPB.setVisibility(View.GONE);
                userRVAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                userRVAdapter.notifyDataSetChanged();
                loadingPB.setVisibility(View.GONE);
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                userRVAdapter.notifyDataSetChanged();
                loadingPB.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onUserClick(int position) {
        displayBottomSheet(userRVModalArrayList.get(position));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.idLogOut:
                Toast.makeText(getApplicationContext(), "User Logged Out", Toast.LENGTH_LONG).show();
                mAuth.signOut();
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void displayBottomSheet(UserRVModal modal) {
        final BottomSheetDialog bottomSheetTeachersDialog = new BottomSheetDialog(this);
        View layout = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_sheet_dialog, (RelativeLayout)findViewById(R.id.idRLBSheet));
        bottomSheetTeachersDialog.setContentView(layout);
        bottomSheetTeachersDialog.setCancelable(false);
        bottomSheetTeachersDialog.setCanceledOnTouchOutside(true);
        bottomSheetTeachersDialog.show();

        TextView userNameEdt, cmnt, systolic, diostolic, heart;

        userNameEdt = layout.findViewById(R.id.BName);
        cmnt = layout.findViewById(R.id.BComment);
        systolic = layout.findViewById(R.id.BSystolicPressure);
        diostolic = layout.findViewById(R.id.BDiastolicPressure);
        heart = layout.findViewById(R.id.BHeartRate);

        userNameEdt.setText("Name : "+modal.getUserName());
        cmnt.setText("Comment : "+modal.getUserDesc());
        systolic.setText("Systolic: : "+modal.getUsersys());
        diostolic.setText("Diastolic : "+modal.getUserdio());
        heart.setText("HeartRate : "+modal.getUserheart());

        Button editBtn = layout.findViewById(R.id.idBtnUpdate);

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EditUserActivity.class);
                i.putExtra("user", modal);
                startActivity(i);
            }
        });
    }
}
