
package at.jugendhackt.soundsnett.soundsnett.views;


import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import at.jugendhackt.soundsnett.soundsnett.R;
import at.jugendhackt.soundsnett.soundsnett.model.Contact;
import at.jugendhackt.soundsnett.soundsnett.model.Message;


public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {


    private List<Message> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView mImageView;
        public TextView mTextView;

        public ViewHolder(LinearLayout l) {
            super(l);
            mTextView = l.findViewById(R.id.contact_text);
            mImageView = l.findViewById(R.id.contact_image);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MsgAdapter() {
        mDataset = new ArrayList<Message>();

    }
    public void addMessage(Message m) {
        mDataset.add(m);
        notifyDataSetChanged();
    }
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_cell, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset.get(position).getMessage());
        holder.mImageView.setImageResource(R.drawable.ic_play);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        MediaPlayer player = MediaPlayer.create(holder.itemView.getContext(),mDataset.get(position).getSound());
        player.start();
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

