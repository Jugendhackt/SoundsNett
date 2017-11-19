package at.jugendhackt.soundsnett.soundsnett.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import at.jugendhackt.soundsnett.soundsnett.R;
import at.jugendhackt.soundsnett.soundsnett.model.Message;

public class ChatActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    MsgAdapter mAdapter;
    EditText mEdittext;
    Spinner mSpinner;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Bundle b = getIntent().getExtras();
        toolbar.setTitle(b.getString("name"));
        setSupportActionBar(toolbar);

        mRecyclerView = findViewById(R.id.recyclerview);
        mEdittext = findViewById(R.id.userInput);
        mButton = findViewById(R.id.sendButton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              int sound = R.raw.ding_dong;
                switch(mSpinner.getSelectedItemPosition()){
                    case 0 :
                        sound = R.raw.ding_dong;
                        break;
                    case 1 :
                        sound = R.raw.ao;
                        break;
                    case 2 :
                        sound = R.raw.pfeifen;
                        break;
                    case 3 :
                        sound = R.raw.pfeifen1;
                        break;
                    case 4 :
                        sound = R.raw.weinen;
                        break;


                }
                mAdapter.addMessage(new Message(sound, "ich","", mEdittext.getText().toString()));
                mEdittext.setText("");
            }
        });
        mSpinner = findViewById(R.id.soundSpinner);
        //mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)

        mAdapter = new MsgAdapter();
        mAdapter.addMessage(new Message(R.raw.pfeifen,"rudi","ich","Hi"));
        mAdapter.addMessage(new Message(R.raw.ding_dong,"rudi","ich","Bist du da?"));
        mRecyclerView.setAdapter(mAdapter);
    }

}
