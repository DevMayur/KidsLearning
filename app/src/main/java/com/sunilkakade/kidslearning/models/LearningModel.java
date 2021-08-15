package com.sunilkakade.kidslearning.models;

public class LearningModel {

    String image_asset_name;
    String voice_asset_name;
    String phonetic_voice_asset_name;
    String image_voice_asset_name;
    String letter;
    String letter_phonetic;

    public LearningModel(String image_asset_name, String voice_asset_name, String phonetic_voice_asset_name, String image_voice_asset_name, String letter, String letter_phonetic) {
        this.image_asset_name = image_asset_name;
        this.voice_asset_name = voice_asset_name;
        this.phonetic_voice_asset_name = phonetic_voice_asset_name;
        this.image_voice_asset_name = image_voice_asset_name;
        this.letter = letter;
        this.letter_phonetic = letter_phonetic;
    }

    public LearningModel() {

    }

    public String getLetter_phonetic() {
        return letter_phonetic;
    }

    public void setLetter_phonetic(String letter_phonetic) {
        this.letter_phonetic = letter_phonetic;
    }

    public String getImage_voice_asset_name() {
        return image_voice_asset_name;
    }

    public void setImage_voice_asset_name(String image_voice_asset_name) {
        this.image_voice_asset_name = image_voice_asset_name;
    }

    public String getPhonetic_voice_asset_name() {
        return this.phonetic_voice_asset_name;
    }

    public void setPhonetic_voice_asset_name(String phonetic_voice_asset_name) {
        this.phonetic_voice_asset_name = phonetic_voice_asset_name;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getImage_asset_name() {
        return image_asset_name;
    }

    public void setImage_asset_name(String image_asset_name) {
        this.image_asset_name = image_asset_name;
    }

    public String getVoice_asset_name() {
        return voice_asset_name;
    }

    public void setVoice_asset_name(String voice_asset_name) {
        this.voice_asset_name = voice_asset_name;
    }

}
