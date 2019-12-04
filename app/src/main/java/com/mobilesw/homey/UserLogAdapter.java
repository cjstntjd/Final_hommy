package com.mobilesw.homey;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserLogAdapter extends FirestoreRecyclerAdapter<UserLog, UserLogAdapter.UserLogHolder> {

    final FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ; //Get the current user logged in
    private String modelUserID;


    public UserLogAdapter(@NonNull FirestoreRecyclerOptions<UserLog> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull UserLogHolder holder, int position, @NonNull UserLog model) {

        modelUserID = model.getUserID();

            holder.tvTitle.setText(model.getDate());
            holder.tvDescription.setText(model.getLogDesc());


          if (!(modelUserID.equals(currentFirebaseUser.getUid()))) {
               holder.itemView.setVisibility(View.GONE);

              LinearLayout.LayoutParams params = new
                      LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                      ViewGroup.LayoutParams.WRAP_CONTENT);
              // Set the height by params
              params.height=0;
              params.width=0;
              // set height of RecyclerView
              holder.itemView.setLayoutParams(params);

           }

    }

    @NonNull
    @Override
    public UserLogHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_log_screen, parent, false);

        return new UserLogHolder(v);
    }

    class UserLogHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvDescription;


        public UserLogHolder(View itemView) {
            super(itemView);
                tvTitle = itemView.findViewById(R.id.text_view_title);
                tvDescription = itemView.findViewById(R.id.text_view_description);

//            if (!(modelUserID.equals(currentFirebaseUser.getUid()))) {
//                itemView.setVisibility(View.GONE);
//            }
        }

    }
}
