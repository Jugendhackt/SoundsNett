package at.jugendhackt.soundsnett.soundsnett.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import at.jugendhackt.soundsnett.soundsnett.R;
import at.jugendhackt.soundsnett.soundsnett.model.Message;

public class ChatActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    MsgAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Bundle b = getIntent().getExtras();
        toolbar.setTitle(b.getString("name"));
        setSupportActionBar(toolbar);

        mRecyclerView = findViewById(R.id.recyclerview);
        //mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)

        mAdapter = new MsgAdapter();
        mAdapter.addMessage(new Message(1,"rudi","ich","Hi"));

        mRecyclerView.setAdapter(mAdapter);
    }

}
