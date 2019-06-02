package com.example.android.yoruba;

/**
 * {@lINK word} represents a vocabulary that the user wants to learn
 * It contains a default translation and a yoruba translation for the word.
 */

public class Word {

    /**
     * Default translation for the word
     */
    private String mDefaultTranslation;

    /**
     * yoruba translation for the word
     */
    private String mYorubaTranslation;

    /**
     * Image resource ID for the word
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Constant value that represents no image was provided for this word
     */
    private static final int NO_IMAGE_PROVIDED = 0;

    /** Audio resource ID for the word */
    private int mAudioResourceId;


    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param yorubaTranslation  is the word in the Yoruba language
     */
    // constructor for the new word object
    public Word (String defaultTranslation, String yorubaTranslation, int audioResourceId){
            mDefaultTranslation = defaultTranslation;
            mYorubaTranslation = yorubaTranslation;
            mAudioResourceId = audioResourceId;
        }


    /**
     @@ public Word(String defaultTranslation, String miwokTranslation) {
      *                           (such as English)
      * @param yorubaTranslation is the word in the Miwok language
     * @param imageResourceId is the drawable resource ID for the image associated with the word
     *
     * @param audioResourceId is the resource ID for the audio file associated with this word
     */

    public Word (String defaultTranslation, String yorubaTranslation, int imageResourceId,int audioResourceId){
                mDefaultTranslation = defaultTranslation;
                mYorubaTranslation = yorubaTranslation;
                mImageResourceId = imageResourceId;
                mAudioResourceId = audioResourceId;
            }


            /**
             * Get the default translation of the word
             */
            public String getDefaultTranslation () {
                return mDefaultTranslation;
            }

            /**
             * Get the yoruba translation of the word
             */
            public String getYorubaTranslation () {
                return mYorubaTranslation;
            }

            /**
             * Return the image resource ID of the word.
             */
            public int getImageResourceId () {
                return mImageResourceId;
            }

            /**
             * Returns whether or not there is an image for this word.
             */
            public boolean hasImage () {
                return mImageResourceId != NO_IMAGE_PROVIDED;
            }
                /**
                 * Return the audio resource ID of the word.
                 */
                public int getAudioResourceId () {
                    return mAudioResourceId;

                }
            }



