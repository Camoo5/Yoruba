package com.example.android.yoruba;

/**
 * {@lINK word} represents a vocabulary that the user wants to learn
 * It contains a default translation and a Yoruba translation for the word.
 */

public class Word {

    /**Default translation for the word */
    private String mDefaultTranslation;

    /**Yoruba translation for the word */
    private String mYorubaTranslation;

    /**
     * Create a new word object.
     *
     * @param defaultTranslation is a word in a language that the user is already familiar with
     *                           (such as English)
     * @param yorubaTranslation is a word that the user is not familiar with
     */
    public Word(String defaultTranslation, String yorubaTranslation) {
        mDefaultTranslation = defaultTranslation;
        mYorubaTranslation = yorubaTranslation;
    }
/**
 * Get the default translation of the word
 */
        public String getDefaultTranslation () {
            return mDefaultTranslation;
        }
/**
 * Get the Yoruba translation of the word
 */
        public String getYorubaTranslation () {
            return mYorubaTranslation;
        }
    }







