AndroidDirectoryChooserExample
==============================

This Example uses the android-dirchoose library.

In this example it creates a dialog if the device has SDcard shows the SDcard button or else only list the internal storage files and it also detects if the device has more than one SDcard and list all sdcards.

Part of the code when Sdcard tab is clicked


 mSdcardLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String sdCardPath;
                /***
                 * Null check because user may click on already selected buton before selecting the folder
                 * And mSelectedDir may contain some wrong path like when user confirm dialog and swith back again
                 */

                if (mSelectedDir != null && !mSelectedDir.getAbsolutePath().contains(System.getenv("SECONDARY_STORAGE"))) {
                    mCurrentInternalPath = mSelectedDir.getAbsolutePath();
                } else {
                    mCurrentInternalPath = getInternalDirectoryPath();
                }
                if (mCurrentSDcardPath != null) {
                    sdCardPath = mCurrentSDcardPath;
                } else {
                    sdCardPath = getSDcardDirectoryPath();
                }
                //When there is only one SDcard
                if (sdCardPath != null) {
                    if (!sdCardPath.contains(":")) {
                        updateButtonColor(STORAGE_EXTERNAL);
                        File dir = new File(sdCardPath);
                        changeDirectory(dir);
                    } else if (sdCardPath.contains(":")) {
                        //Multiple Sdcards show root folder and remove the Internal storage from that.
                        updateButtonColor(STORAGE_EXTERNAL);
                        File dir = new File("/storage");
                        changeDirectory(dir);
                    }
                } else {
                    //In some unknown scenario at least we can list the root folder
                    updateButtonColor(STORAGE_EXTERNAL);
                    File dir = new File("/storage");
                    changeDirectory(dir);
                }


            }
        });
