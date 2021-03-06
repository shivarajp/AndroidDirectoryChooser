AndroidDirectoryChooserExample
==============================

This Example uses the android-dirchoose library.

In this example it creates a dialog if the device has SDcard shows the SDcard button or else only list the internal storage files and it also detects if the device has more than one SDcard and list all sdcards.

Part of the code when Sdcard tab is clicked


 

                if (mSelectedDir != null && !mSelectedDir.getAbsolutePath().contains(System.getenv("SECONDARY_STORAGE")))                 {
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
        
        
        
Helper Methods


     /**
     * Return's the Internal or SDCard based on user's previously selected path.
     * Based on this button color's are updated.
     *
     * @param path
     * @return
     */
    private int rootOfThePath(String path) {
        if (path.contains("" + getInternalDirectoryPath())) {
            return STORAGE_INTERNAL;
        } else if (path.contains("" + getSDcardDirectoryPath())) {
            return STORAGE_EXTERNAL;
        }
        return STORAGE_INTERNAL;
    }

    /**
     * Returns the path to internal storage ex:- /storage/emulated/0
     *
     * @return
     */
    private String getInternalDirectoryPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    /**
     * Returns the SDcard storage path for samsung ex:- /storage/extSdCard
     *
     * @return
     */
    private String getSDcardDirectoryPath() {
        return System.getenv("SECONDARY_STORAGE");
    }

