package com.sunilkakade.kidslearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.sunilkakade.kidslearning.adapters.LearningAdapter;
import com.sunilkakade.kidslearning.models.LearningModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LearnActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LearningAdapter adapter;
    List<LearningModel> learningList;

    ImageView iv_voice_over;
    Button bt_next, bt_previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        recyclerView = findViewById(R.id.recyclerView);
        learningList = new ArrayList<>();
        adapter = new LearningAdapter(this,learningList, getIntent().getIntExtra("group", -1));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);


        SnapHelperOneByOne helper = new SnapHelperOneByOne();
        helper.attachToRecyclerView(recyclerView);

        iv_voice_over = findViewById(R.id.iv_voice_over);
        bt_next = findViewById(R.id.bt_next);
        bt_previous = findViewById(R.id.bt_previous);

        iv_voice_over.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = ((LinearLayoutManager) Objects.requireNonNull(recyclerView.getLayoutManager())).findFirstCompletelyVisibleItemPosition();
                LearningAdapter.ViewHolder holder = (LearningAdapter.ViewHolder)recyclerView.findViewHolderForAdapterPosition(position);
                if (holder != null) {
                    playSound(learningList.get(position).getVoice_asset_name(), position, holder.tv_letter, getIntent().getIntExtra("group", -1));
                }
            }
        });

        bt_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = ((LinearLayoutManager) Objects.requireNonNull(recyclerView.getLayoutManager())).findFirstCompletelyVisibleItemPosition();
                if (position != 0)
                    recyclerView.getLayoutManager().scrollToPosition(position-1);

            }
        });

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = ((LinearLayoutManager) Objects.requireNonNull(recyclerView.getLayoutManager())).findFirstCompletelyVisibleItemPosition();
                if (position != 48)
                    recyclerView.getLayoutManager().scrollToPosition(position+1);
            }
        });

        switch (getIntent().getIntExtra("group", -1)) {
            case 0:
                getMarathiAlphabets();
                break;
            case 1:
                getMarathiNumbers();
                break;
            case 2:

                getEnglishAlphabets();
                break;
            default:
        }

    }

    public static final String TAG = "soundPlayTag";
    public void playSound(String filename, int position, View holder, int group) {
        AssetFileDescriptor afd = null;
        try {
            afd = getResources().getAssets().openFd(filename);
        } catch (IOException e) {
            Log.d(TAG, "1 playSound: " + e.getLocalizedMessage());
        }
        MediaPlayer player = new MediaPlayer();
        try {
            assert afd != null;
            player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
        } catch (IOException e) {
            Log.d(TAG, "2 playSound: " + e.getLocalizedMessage());
        }
        try {
            player.prepare();
        } catch (IOException e) {
            Log.d(TAG, "3 playSound: " + e.getLocalizedMessage());
        }
        player.start();
        final Animation animShake = AnimationUtils.loadAnimation(LearnActivity.this, R.anim.letter_shaking_res);
        assert holder != null;
        holder.startAnimation(animShake);
    }

    private void getMarathiAlphabets() {
        for (int i = 0; i <= 48; i++) {
            String image_asset_name = ("0_1_" + i + ".png");
            String voice_asset_name = ("0_2_" + i +".mp3");
            String phonetic_voice_asset_name = ("0_2_" + i +".mp3");
            String image_voice_asset_name = ("0_1_" + i + "_sd.mp3");
            String letter = getResources().getStringArray(R.array.marathi_letters)[i];
            String letter_phonetic = getResources().getStringArray(R.array.marathi_letters)[i];
            learningList.add(new LearningModel(image_asset_name,voice_asset_name,phonetic_voice_asset_name,image_voice_asset_name,letter,letter_phonetic));
        }
        adapter.notifyDataSetChanged();
    }

    private void getMarathiNumbers() {
        for (int i = 0; i <= 9; i++) {
            String image_asset_name = ("1_1_" + i + ".png");
            String voice_asset_name = ("1_2_" + i +".mp3");
            String phonetic_voice_asset_name = ("1_2_" + i +".mp3");
            String image_voice_asset_name = ("1_2_" + i +".mp3");
            String letter =  getResources().getStringArray(R.array.marathi_numbers)[i];
            String letter_phonetic = getResources().getStringArray(R.array.marathi_numbers)[i];
            learningList.add(new LearningModel(image_asset_name,voice_asset_name,phonetic_voice_asset_name,image_voice_asset_name,letter,letter_phonetic));
        }
        adapter.notifyDataSetChanged();
    }

    private void getEnglishAlphabets() {
        for (int i=0; i<26; i++) {
            String image_asset_name = ("2_1_" + i + ".png");
            String voice_asset_name = ("2_2_" + i +".mp3");
            String phonetic_voice_asset_name = ("2_2_" + i +"_ph.mp3");
            String image_voice_asset_name = ("2_1_" + i + "_sd.mp3");
            String letter =  getResources().getStringArray(R.array.english_alphabets)[i];
            String letter_phonetic = getResources().getStringArray(R.array.english_phonetic)[i];
            learningList.add(new LearningModel(image_asset_name,voice_asset_name,phonetic_voice_asset_name,image_voice_asset_name,letter,letter_phonetic));
        }
        adapter.notifyDataSetChanged();
    }
}