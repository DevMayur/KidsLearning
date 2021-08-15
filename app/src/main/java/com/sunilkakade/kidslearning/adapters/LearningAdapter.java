package com.sunilkakade.kidslearning.adapters;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.sunilkakade.kidslearning.LearnActivity;
import com.sunilkakade.kidslearning.R;
import com.sunilkakade.kidslearning.models.LearningModel;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class LearningAdapter extends RecyclerView.Adapter<LearningAdapter.ViewHolder> {
    private final Context context;
    private final List<LearningModel> learningList;
    private final int group;

    public LearningAdapter(Context context, List<LearningModel> learningList, int group) {
        this.context = context;
        this.learningList = learningList;
        this.group = group;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.single_learning_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull LearningAdapter.ViewHolder holder, int position) {

        switch (group) {
            case 0:

                break;

            case 1:
                holder.tv_letter.setTextColor(context.getResources().getColor(R.color.cardColor));
                break;

            case 2:
                holder.tv_letter.setTextSize(150);
                holder.card_tv_letter_phonetic.setVisibility(View.VISIBLE);
                holder.tv_letter_phonetic.setText(learningList.get(position).getLetter_phonetic());
                holder.tv_letter_phonetic.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((LearnActivity)context).playSound(learningList.get(position).getPhonetic_voice_asset_name(), position, holder.tv_letter_phonetic, group);
                    }
                });

        }

        holder.tv_letter.setText(learningList.get(position).getLetter());
        try
        {
            InputStream ims = context.getAssets().open(learningList.get(position).getImage_asset_name());
            Drawable d = Drawable.createFromStream(ims, null);
            holder.iv_image.setImageDrawable(d);
            ims .close();
        }
        catch(IOException ignored)
        {}


        holder.iv_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((LearnActivity)context).playSound(learningList.get(position).getImage_voice_asset_name(), position, holder.iv_image, group);
            }
        });

        holder.tv_letter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((LearnActivity)context).playSound(learningList.get(position).getVoice_asset_name(), position, holder.tv_letter, group);
            }
        });

    }

    @Override
    public int getItemCount() {
        return learningList.size();
    }
    

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_image;
        public TextView tv_letter,tv_letter_phonetic;
        public CardView card_tv_letter,card_iv_image,card_tv_letter_phonetic;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            iv_image = itemView.findViewById(R.id.iv_image);
            tv_letter = itemView.findViewById(R.id.tv_letter);
            tv_letter_phonetic = itemView.findViewById(R.id.tv_letter_phonetic);

            card_iv_image = itemView.findViewById(R.id.card_iv_image);
            card_tv_letter = itemView.findViewById(R.id.card_tv_letter);
            card_tv_letter_phonetic = itemView.findViewById(R.id.card_tv_letter_phonetic);
        }
    }
}
