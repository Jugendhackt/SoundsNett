
package at.jugendhackt.soundsnett.soundsnett.views;


import android.content.Intent;
import android.os.Bundle;
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


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {


    private List<Contact> mDataset;

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
    public ContactAdapter() {
        mDataset = new ArrayList<Contact>();

    }
    public void addContact(Contact c) {
        mDataset.add(c);
        notifyDataSetChanged();
    }
    public void clearContacts() {
        mDataset.clear();
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
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset.get(position).getName());
        holder.mImageView.setImageResource(R.drawable.rudi);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),ChatActivity.class);
                i.putExtra("name",mDataset.get(position).getName());
                view.getContext().startActivity(i);
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

